<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<html lang="es">
    <head>
        <title>Datos Ubicacion Tabla</title>
        <meta charset="utf-8"/>
        <link rel="stylesheet" href="estilo.css">

    </head>
    <body>
        <div id="Tabla" align="center">

<s:form name="f1" method="post" action="DatosUbicacion">
 
        <table rules="all" >
           <caption>DATOS DE UBICACION</caption>
            <tr>
              <td class="tddos">Tipo Contacto<br>
              </td>
              <td class="tddos">Descripcion<br>
              </td>
              <td class="tddos">Fecha<br>
              </td>
              <td class="tddos">Accion<br>
              </td>
            </tr>
            <tr>
              <td class="tdtres">ESTO<br>
              </td>
              <td class="tdtres">Que esta qui<br>
              </td>
              <td class="tdtres">es un gran ejemplo<br>
              </td>
              <td class="tdtres"><img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/Icono_de_editar.png" align="top"><br>
              </td>
            </tr>
            <tr>
              <td class="tdtres"><br>
              </td>
              <td class="tdtres"><br>
              </td>
              <td class="tdtres"><br>
              </td>
              <td class="tdtres"><img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/Icono_de_editar.png" align="top"><br>
              </td>
            </tr>
            <tr>
              <td class="tdtres"><br>
              </td>
              <td class="tdtres"><br>
              </td>
              <td class="tdtres"><br>
              </td>
              <td class="tdtres"><img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/Icono_de_editar.png" align="top"><br>
              </td>
            </tr>
            <tr>
              <td class="tdtres"><br>
              </td>
              <td class="tdtres"><br>
              </td>
              <td class="tdtres"><br>
              </td>
              <td class="tdtres"><img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/Icono_de_editar.png" align="top"><br>
              </td>
            </tr>
        </table>
        <br>
        <div class="buttons">
            <a href="desplegarDatosUbicacion.action" target="contenido">
                <button type="submit" class="positive" name="nuevo">
                    <img src="imagenes/btnGuardar.png" alt=""/>
                    Nuevo
                </button></a><br>
        </div>
        <br>
        <br>        
</s:form>

                <table rules="all" >
                    <caption>DATOS DE UBICACION</caption>
                    <tr>
                        <td class="tddos">Tipo Contacto<br>
                        </td>
                        <td class="tddos">Descripcion<br>
                        </td>
                        <td class="tddos">Accion<br>
                        </td>
                    </tr>

                    <s:iterator value="listaContactos" status="contacto">
                        <tr>
                            <td class="tdtres"><s:property value="idTipoContacto"></s:property><br>
                                </td>
                                <td class="tdtres"><s:property value="descripcion"></s:property><br>
                                </td>
                                <td class="tdtres">
                                <s:url id="editar" action="editar">
                                    <s:param name="idContacto" value="%{idContacto}"></s:param>
                                </s:url>
                                <s:a href="%{editar}">
                                    <img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/Icono_de_editar.png" align="top"><br>
                                </s:a>
                            </td>
                        </tr>
                    </s:iterator>
                </table>
                <br>
                <div class="buttons">
                    <button type="submit" class="positive" name="nuevo">
                        <img src="imagenes/btnGuardar.png" alt=""/>
                        Nuevo
                    </button><br>
                </div>
                <br>
                <br>        
            </s:form>

        </div>	
    </body>
</html>
