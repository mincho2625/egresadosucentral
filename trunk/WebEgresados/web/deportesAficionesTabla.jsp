<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<html lang="es">
    <head>
        <title>Reconocimientos y distinciones</title>
        <meta charset="utf-8"/>
        <link rel="stylesheet" href="estilo.css">
        <jq:head></jq:head>
    </head>
    <body>
        <div id="Tabla" align="center">
            <table rules="all" >
                <caption>Aficiones y Deportes </caption>
                <tr>
                    <td class="tddos">Tipo Actividad<br>
                    </td>
                    <td class="tddos">Lista de Actividades<br>
                    </td>
                    <td class="tddos">Fecha<br>
                    </td>
                </tr>

                <s:iterator value="listaObjetos" status="contacto">
                    <tr>
                        <td class="tdtres"><s:property value="idTipoActividad.nombre"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="listaActividades"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="fechaRegistro"></s:property><br>
                            </td>
                            <td class="tdtres">
                            <s:url id="editarURL" action="editarA.action">
                                <s:param name="idObjeto" value="%{idAficion}"></s:param>
                            </s:url>
                            <s:a href="%{editarURL}">
                                <img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/Icono_de_editar.png" align="top"><br>
                            </s:a>
                            <s:url id="borrarURL" action="borrarAficiones.action">
                                <s:param name="idObjeto" value="%{idAficion}"></s:param>
                            </s:url>
                            <s:a href="%{borrarURL}">
                                <img style="width: 20px; height: 19px;" title="Borrar" alt="Borrar" src="imagenes/Icono_de_editar.png" align="top"><br>
                            </s:a>
                        </td>
                    </tr>
                </s:iterator>
            </table>
            <br>
            <div class="buttons">
                <a href="desplegarAficiones.action" target="contenido">
                    <button type="submit" class="positive" name="nuevo">
                        <img src="imagenes/btnGuardar.png" alt=""/>
                        Nuevo
                    </button>
                </a><br>
            </div>
            <br>
            <br>

        </div>

        <div id="contenido1">
            <s:if test="editar">
                <s:form action="guardarAficiones.action">
                    <s:push value="objeto">
                        <s:hidden name="idAficion"></s:hidden>
                        <div class="tdun">Generar Nuevo Registro</div>
                            <table>
                                <tr>
                                    <td>
                                        <div class="tduno"> Tipo Actividad </div>
                                    </td>
                                    <td>
                                    <s:select name="listaActividad" list="listaActividad" listKey="idTipoActividad" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Nombre </div> 
                                    </td>
                                    <td>
                                    <jq:datepicker name="listaActividades" changeMonth="true" changeYear="true" showButtonPanel="true"></jq:datepicker>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Fecha </div>
                                    </td>
                                    <td>
                                    <jq:datepicker name="fechaRegistro" changeMonth="true" changeYear="true" showButtonPanel="true"></jq:datepicker>
                                    </td>
                                </tr>
                                <tr>
                                <s:submit cssClass="positive" value="Guardar">
                            </s:submit>
                            </tr>
                        </table>
                    </s:push>
                </s:form>
            </s:if>
        </div>
    </body>
</html>