<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<html lang="es">
    <head>
        <title>Educación Formal</title>
        <meta charset="utf-8"/>
        <link rel="stylesheet" href="estilo.css">
    </head>
    <body>
        <div id="Tabla" align="center">
            <table rules="all" >
                <caption>EDUCACIÓN FORMAL</caption>
                <tr>
                    <td class="tddos">Programa<br>
                    </td>
                    <td class="tddos">Año Inicio<br>
                    </td>
                    <td class="tddos">Año Finalización<br>
                    </td>
                    <td class="tddos">Estado<br>
                    </td>
                    <td class="tddos">Acción<br>
                    </td>
                </tr>

                <s:iterator value="listaObjetos">
                    <tr>
                        <td class="tdtres"><s:property value="idPrograma"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="anioInicio"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="anioFinalizacion"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="idEstadoEducacion"></s:property><br>
                            </td>
                            <td class="tdtres">
                            <s:url id="editarURL" action="editarEducacionFormal.action">
                                <s:param name="idObjeto" value="%{idEducacion}"></s:param>
                            </s:url>
                            <s:a href="%{editarURL}">
                                <img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/Icono_de_editar.png" align="top"><br>
                            </s:a>
                            <s:url id="borrarURL" action="borrarEducacionFormal.action">
                                <s:param name="idObjeto" value="%{idEducacion}"></s:param>
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
                <a href="desplegarEducacionFormal.action" target="contenido">
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
                <s:form action="guardarEducacionFormal.action">
                    <s:push value="objeto">
                        <s:hidden name="idEducacion"></s:hidden>
                            <table>
                                <tr>
                                    <td>
                                        Programa
                                    </td>
                                    <td>
                                    <s:select name="idPrograma" list="listaProgramas" listKey="idPrograma" listValue="nombre"></s:select>
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        Jornada
                                    </td>
                                    <td>
                                    <s:select name="idJornada" list="listaJornadas" listKey="idJornada" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Nivel Estudios
                                    </td>
                                    <td>
                                    <s:select name="idNivelEstudios" list="listaNivelesEstudios" listKey="idNivelEstudios" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Año Inicio
                                    </td>
                                    <td>
                                    <s:select name="anioInicio" list="listaAnios"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Mes Inicio
                                    </td>
                                    <td>
                                    <s:select name="idMesInicio" list="listaMeses" listKey="idMesInicio" listValue="mes"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Año Finalización
                                    </td>
                                    <td>
                                    <s:select name="anioFinalizacion" list="listaAnios"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Mes Finalización
                                    </td>
                                    <td>
                                    <s:select name="idMesFinalizacion" list="listaMeses" listKey="idMesFinalizacion" listValue="mes"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Estado
                                    </td>
                                    <td>
                                    <s:select name="idEstadoEducacion" list="listaEstadosEducacion" listKey="idEstadoEducacion" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                            <s:submit cssClass="positive">
                                <img src="imagenes/btnGuardar.png" alt=""/>Guardar<br>
                            </s:submit>
                            </tr>
                        </table>
                    </s:push>
                </s:form>
            </s:if>
        </div>
    </body>
</html>