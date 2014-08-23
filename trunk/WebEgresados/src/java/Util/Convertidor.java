/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Util;

import Controlador.ControladorEgresado;
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
    public Object convertirAModelo(Object origen, String claseDestino) {
        Object destino = instanciar(claseDestino);
        Class claseSet;
        Object valor;
        String metodoGet;

        for (Method set : destino.getClass().getDeclaredMethods()) {
            try {
                if (esSetter(set.getName())) {
                    metodoGet = obtenerMetodoGet(set.getName());
                    valor = invocar(origen, metodoGet);
                    
                    if (valor != null)
                    {
                        claseSet = set.getParameterTypes()[0];
                        if (esInstancia(valor.getClass())) {
                            if (!esInstancia(claseSet))
                                valor = obtenerId(valor, metodoGet);
                            else
                                valor = convertirAModelo(valor, claseSet.getName());
                        }
                        
                        set.invoke(destino, valor);
                    }
                        
                }
            } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(Convertidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return destino;
    }
    
    public Object convertirAPersistencia(Object origen, String claseDestino, String idObjeto, EntityManager em)
    {
        Class claseSet;
        Object valor;
        String metodoGet;

        try {
            Object destino;
            long id = (long)invocar(origen, idObjeto);
            if (id > 0)
                destino = em.getReference(Class.forName(claseDestino), id);
            else
                destino = instanciar(claseDestino);
            
            for (Method set : destino.getClass().getDeclaredMethods()) {
                try {
                    if (esSetter(set.getName()) && !set.getName().equals("setIdEgresado")
                            && !set.getName().equals("setIdReconocimiento")) {
                        if (set.getName().equals("setEstado")) metodoGet = "isEstado";
                        else metodoGet = obtenerMetodoGet(set.getName());
                        valor = invocar(origen, metodoGet);
                        
                        if (valor != null)
                        {
                            claseSet = set.getParameterTypes()[0];
                            if (esInstancia(valor.getClass()))
                                valor = obtenerId(valor, metodoGet);
                            
                            if (esInstancia(claseSet))
                                valor = em.getReference(claseSet, valor);
                            
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
    
    private boolean esInstancia(Class clase)
    {
        return clase.getPackage() != null && (
                clase.getPackage().getName().equals("Modelo") ||
                clase.getPackage().getName().equals("Persistencia"));
    }
    
    private Object obtenerId(Object clase, String metodo) {
        try {
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
    
    private String obtenerMetodoGet(String metodoSet)
    {
        return metodoSet.replaceFirst("set", "get");
    }
    
    public Object invocar(Object objeto, String nombreMetodo)
    {
        try {
            Method metodo = objeto.getClass().getDeclaredMethod(nombreMetodo);
            return metodo.invoke(objeto);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(ControladorEgresado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
