<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<html lang="es">
    <head>
        <title>Educaci�n Formal</title>
        <meta charset="utf-8"/>
        <link rel="stylesheet" href="estilo.css">
    </head>
    <body>
        <div id="Tabla" align="center">
            <table rules="all" >
                <caption>EDUCACI�N FORMAL</caption>
                <tr>
                    <td class="tddos">Programa<br>
                    </td>
                    <td class="tddos">Jornada<br>
                    </td>
                    <td class="tddos">A�o Finalizaci�n<br>
                    </td>
                    <td class="tddos">Estado<br>
                    </td>
                    <td class="tddos">Acci�n<br>
                    </td>
                </tr>

                <s:iterator value="listaObjetos">
                    <tr>
                        <td class="tdtres"><s:property value="idPrograma.nombre"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="idJornada.nombre"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="anioFinalizacion"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="idEstadoEducacion.nombre"></s:property><br>
                            </td>
                            <td class="tdtres">
                            <s:url id="editarURL" action="editarEducacionFormalUCentral.action">
                                <s:param name="idObjeto" value="%{idEducacion}"></s:param>
                            </s:url>
                            <s:a href="%{editarURL}">
                                <img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/Icono_de_editar.png" align="top"><br>
                            </s:a>
                            <s:url id="borrarURL" action="borrarEducacionFormalUCentral.action">
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
                <a href="desplegarEducacionFormalUCentral.action" target="contenido">
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
                <s:form action="guardarEducacionFormalUCentral.action">
                    <s:push value="objeto">
                        <s:hidden name="idEducacion"></s:hidden>
                        <div class="tdun">Generar Nuevo Registro</div>
                            <table>
                                <tr>
                                    <td>
                                        <div class="tduno"> Programa </div>
                                    </td>
                                    <td>
                                    <s:select name="programa" list="listaProgramas" listKey="idPrograma" listValue="nombre"></s:select>
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <div class="tduno"> Jornada </div>
                                    </td>
                                    <td>
                                    <s:select name="jornada" list="listaJornadas" listKey="idJornada" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> A�o Inicio </div>
                                    </td>
                                    <td>
                                    <s:select name="anioInicio" list="listaAnios"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Mes Inicio </div>
                                    </td>
                                    <td>
                                    <s:select name="mesInicio" list="listaMeses" listKey="idMes" listValue="mes"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> A�o Finalizaci�n </div>
                                    </td>
                                    <td>
                                    <s:select name="anioFinalizacion" list="listaAnios"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Mes Finalizaci�n </div>
                                    </td>
                                    <td>
                                    <s:select name="mesFinalizacion" list="listaMeses" listKey="idMes" listValue="mes"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Estado </div>
                                    </td>
                                    <td>
                                    <s:select name="estadoEducacion" list="listaEstadosEducacion" listKey="idEstadoEducacion" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                            <s:submit cssClass="positive" value="Guardar">
                                <br>
                            </s:submit>
                            </tr>
                        </table>
                    </s:push>
                </s:form>
            </s:if>
        </div>
    </body>
</html>