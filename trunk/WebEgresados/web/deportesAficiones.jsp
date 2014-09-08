<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<html lang="es">
    <head>
        <title>Reconocimientos y distinciones</title>
        <meta charset="utf-8"/>
        <link rel="stylesheet" href="estilo.css">
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
                    <td class="tddos">Accion<br>
                    </td>
                </tr>

                <s:iterator value="listaObjetos">
                    <tr>
                        <td class="tdtres"><s:property value="idTipoActividad.nombre"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="listaActividades"></s:property><br>
                            </td>
                            <td class="tdtres">
                            <s:url id="editarURL" action="editarAficion.action">
                                <s:param name="idObjeto" value="%{idAficion}"></s:param>
                            </s:url>
                            <s:a href="%{editarURL}">
                                <img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/Icono_de_editar.png" align="top"><br>
                            </s:a>
                            <s:url id="borrarURL" action="borrarAficion.action">
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
                <a href="desplegarAficion.action" target="contenido">
                    <button type="submit" class="positive" name="nuevo">
                        <img src="imagenes/btnGuardar.png" alt=""/>
                        Nuevo
                    </button>
                </a><br>
            </div>
            <br>
            <a href="encuesta.jsp" class="tduno"><div>Siguiente</div></a>
            <br>
            <a href="obtenerListaAsociacion.action" class="tduno"><div>Anterior</div></a>
            <br>
            <br>

        </div>

        <div id="contenido1">
            <s:if test="editar">
                <s:form action="guardarAficion.action">
                    <s:push value="objeto">
                        <s:hidden name="idAficion"></s:hidden>
                            <div class="tdun">Generar Nuevo Registro</div>
                            <table>
                                <tr>
                                    <td>
                                        <div class="tduno"> Tipo Reconocimiento </div>
                                    </td>
                                    <td>
                                    <s:select name="tipoActividad" list="listaTiposActividades" listKey="idTipoActividad" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Lista Actividades </div>
                                    </td>
                                    <td>
                                    <s:property value="getFieldErros().get('lisacti'){0}"/>
                                    <s:textfield cssClass="center" name="listaActividades"></s:textfield>
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