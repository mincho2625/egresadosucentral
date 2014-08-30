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
                <caption>Asociaciones a Redes profesionales</caption>
                <tr>
                    <td class="tddos">Tipo Asociacion<br>
                    </td>
                    <td class="tddos">Descripción<br>
                    </td>
                    <td class="tddos">Fecha vinculación<br>
                    </td>
                    <td class="tddos">País<br>
                    </td>
                </tr>

                <s:iterator value="listaObjetos">
                    <tr>
                        <td class="tdtres"><s:property value="idTipoAsociacion.nombre"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="descripcion"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="fechaVinculacion"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="idPais.nombre"></s:property><br>
                            </td>
                            <td class="tdtres">
                            <s:url id="editarURL" action="editarAsociacion.action">
                                <s:param name="idObjeto" value="%{idAsociacion}"></s:param>
                            </s:url>
                            <s:a href="%{editarURL}">
                                <img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/Icono_de_editar.png" align="top"><br>
                            </s:a>
                            <s:url id="borrarURL" action="borrarAsociacion.action">
                                <s:param name="idObjeto" value="%{idAsociacion}"></s:param>
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
                <a href="desplegarAsociacion.action" target="contenido">
                    <button type="submit" class="positive" name="nuevo">
                        <img src="imagenes/btnGuardar.png" alt=""/>
                        Nuevo
                    </button>
                </a><br>
            </div>
            <br>
            <a href="obtenerListaAficion.action" class="tduno"><div>Siguiente</div></a>
            <br>
            <a href="obtenerListaReconocimiento.action" class="tduno"><div>Anterior</div></a>
            <br>
            <br>
        </div>

        <div id="contenido1">
            <s:if test="editar">
                <s:form action="guardarAsociacion.action">
                    <s:push value="objeto">
                        <s:hidden name="idAsociacion"></s:hidden>
                            <table>
                                <tr>
                                    <td>
                                        <div class="tduno"> Tipo Asociacion </div><s:select cssClass="center" name="tipoAsociacion" list="listaTiposAsociaciones" listKey="idTipoAsociacion" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Descripción </div><s:textfield cssClass="center" name="descripcion"></s:textfield>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Fecha vinculación </div><jq:datepicker name="fechaVinculacion" changeMonth="true" changeYear="true" showButtonPanel="true"></jq:datepicker>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> País </div><s:select cssClass="center" name="pais" list="listaPaises" listKey="idPais" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                <tr>
                                <s:submit cssClass="center1" value="Guardar">
                            </s:submit>
                            </tr>
                        </table>
                    </s:push>
                </s:form>
            </s:if>
        </div>
    </body>
</html>