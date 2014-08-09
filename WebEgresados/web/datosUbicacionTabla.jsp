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
                            <s:url id="editar" action="editarUbicacion.action">
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
                <a href="desplegarUbicacion.action" target="contenido">
                    <button type="submit" class="positive" name="nuevo">
                        <img src="imagenes/btnGuardar.png" alt=""/>
                        Nuevo
                    </button>
                </a><br>
            </div>
            <br>
            <br>

        </div>

        <div id="contenido">
            <s:if test="editar">
                <s:form action="guardarUbicacion.action">
                    <s:hidden name="idContacto"></s:hidden>
                    <table>
                        <tr>
                            <td>
                                Tipo Contacto
                            </td>
                            <td>
                                <s:select name="idTipoContacto" list="listaTiposContacto" listKey="idTipoContacto" listValue="nombre"></s:select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Descripción
                                </td>
                                <td>
                                <s:textfield name="descripcion"></s:textfield>
                                </td>
                            </tr>
                            <tr>
                            <s:submit cssClass="positive">
                            <img src="imagenes/btnGuardar.png" alt=""/>Guardar<br>
                        </s:submit>
                        </tr>
                    </table>
                </s:form>
            </s:if>
        </div>
    </body>
</html>