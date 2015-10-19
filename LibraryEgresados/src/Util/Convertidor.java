/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Modelo.Equivalencia;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author YURY
 */
public class Convertidor {

    public Object convertirAModelo(Object origen, Object origenBase, String claseDestino) {

        Object destino = instanciar(claseDestino);

        Method[] metodos = destino.getClass().getDeclaredMethods();
        for (Method set : metodos) {
            destino = convertirAModelo(origen, origenBase, destino, set);
        }
        
        if (origenBase != null && destino.getClass().getSuperclass().getPackage().getName().equals("Modelo")) {
            metodos = destino.getClass().getSuperclass().getDeclaredMethods();
            for (Method set : metodos) {
                destino = convertirAModelo(origen, origenBase, destino, set);
            }
        }

        return destino;
    }

    private Object convertirAModelo(Object origen, Object origenBase, Object destino, Method set) {
        Class claseSet = null;
        Object valor = null;
        String metodoGet = null;

        try {
            if (esSetter(set.getName())) {
//                    
//                    if (set.equals("setIdEgresado"))
//                        metodoGet = "getIdUsuario";
//                    else
                metodoGet = obtenerMetodoGetPersistencia(set.getName());

                valor = invocar(origen, metodoGet);
                if (valor == null && origenBase != null) {
                    valor = invocar(origenBase, metodoGet);
                }

                if (valor != null) {
                    claseSet = set.getParameterTypes()[0];
                    if (esInstancia(valor.getClass())) {
                        if (!esInstancia(claseSet)) {
                            valor = obtenerId(valor, metodoGet);
                        } else {
                            valor = convertirAModelo(valor, null, claseSet.getName());
                        }
                    }

                    set.invoke(destino, valor);
                }
            }
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Convertidor.class.getName()).log(Level.SEVERE, null, ex + ". Valor: " + valor + ", Get: " + metodoGet + ", Set: " + claseSet);
            return null;
        }
        
        return destino;
    }

    public Object convertirAPersistencia(Object origen, String claseDestino, String idObjeto, EntityManager em) {
        Class claseSet;
        Object valor;
        String metodoGet;

        try {
            Object destino;
            Object object_id = invocar(origen, idObjeto);
            long id = (object_id != null ? (long)object_id : 0);
            if (id > 0) {
                destino = em.getReference(Class.forName(claseDestino), id);
            } else {
                destino = instanciar(claseDestino);
            }

            for (Method set : destino.getClass().getDeclaredMethods()) {
                try {
                    if (set.getName().equals("setIdEgresado")) {
                        valor = invocar(origen, "getIdEgresado");
                        valor = em.getReference(Persistencia.Egresado.class, valor);
                        set.invoke(destino, valor);
                    } else if (esSetter(set.getName()) && !set.getName().equals("setIdUsuario") && !set.getName().equals(idObjeto)) {
                        metodoGet = obtenerMetodoGetModelo(set);
                        valor = invocar(origen, metodoGet);

                        if (valor != null) {
                            claseSet = set.getParameterTypes()[0];
                            if (esInstancia(valor.getClass())) {
                                valor = obtenerId(valor, metodoGet);
                            }

                            if (esInstancia(claseSet)) {
                                valor = em.getReference(claseSet, valor);
                            }

                            set.invoke(destino, valor);
                        }

                    }
                } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    Logger.getLogger(Convertidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return destino;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Convertidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    private Object instanciar(String claseDestino) {
        try {
            Class<?> clase = Class.forName(claseDestino);
            if (clase == null) {
                return null;
            }
            return clase.newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            Logger.getLogger(Convertidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private boolean esSetter(String metodo) {
        return metodo.startsWith("set");
    }

    private boolean esInstancia(Class clase) {
        return clase.getPackage() != null && (clase.getPackage().getName().equals("Modelo")
                || clase.getPackage().getName().equals("Persistencia"));
    }

    private Object obtenerId(Object clase, String metodo) {
        try {
            if (clase.getClass().getDeclaredAnnotations().length > 0) {
                Annotation id = clase.getClass().getDeclaredAnnotation(Equivalencia.class);
                if (id != null) {
                    metodo = ((Equivalencia) id).nombre();
                }
            }

            Method get = clase.getClass().getDeclaredMethod(metodo);
            if (get != null) {
                Class<?> tipo = get.getReturnType();
                if (esInstancia(tipo.getClass())) {
                    return obtenerId(get.invoke(clase), metodo);
                }

                return get.invoke(clase);
            }
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Convertidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    private String obtenerMetodoGetPersistencia(String metodoSet) {
        return metodoSet.replaceFirst("set", "get");
    }

    private String obtenerMetodoGetModelo(Method metodoSet) {
        if (metodoSet.getParameterTypes()[0].equals(Boolean.TYPE)) {
            return metodoSet.getName().replaceFirst("set", "is");
        }

        return metodoSet.getName().replaceFirst("set", "get");
    }

    public Object invocar(Object objeto, String nombreMetodo) {
        Method metodo;
        try {
            metodo = objeto.getClass().getMethod(nombreMetodo);

            Object valor = metodo.invoke(objeto);
            if (valor == null && objeto.getClass().getSuperclass() != null
                    && objeto.getClass().getSuperclass().getPackage().getName().equals("Modelo")) {
                metodo = objeto.getClass().getSuperclass().getDeclaredMethod(nombreMetodo);
                valor = metodo.invoke(objeto);
            }
            return valor;
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Convertidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void invocarSet(Object objeto, String nombreMetodo, Object valor) {
        try {
            Method metodo = objeto.getClass().getMethod(nombreMetodo, valor.getClass());
            metodo.invoke(objeto);
            if (valor == null && objeto.getClass().getSuperclass() != null
                    && objeto.getClass().getSuperclass().getPackage().getName().equals("Modelo")) {
                metodo = objeto.getClass().getSuperclass().getDeclaredMethod(nombreMetodo);
                valor = metodo.invoke(objeto);
            }
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Convertidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}