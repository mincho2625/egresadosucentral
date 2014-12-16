<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<html lang="es">
    <head><title>Registro Sistema</title>
        <meta charset="utf-8">
        <link href="estilo2.css" rel="stylesheet" type="text/css">
        <s:head />
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <jq:head jqueryui="true" />
        </head>
        <body>
            <div class="TituloPrincipal" style="/* [disabled]margin-left:10px; */ font-size: 20px">
                <div align="center">Portal Egresados  Universidad Central</div>
            </div>
            <div class="titu">
                <p align="left"><img src="imagenes/document-open.png" width="107" height="94">		      <span class="titu2">a a a</span><img src="imagenes/logosimbolo-ucentral-v1-medium.png" width="273" height="62">  <span class="titu2">a asda </span>Educacion Formal</p>
            </div>
            <!--<div id="default-example" data-collapse>
                <h3>Informacion</h3>-->
            <div align="center" class="tabla" id="Tabla">
                <table rules="all" class="table2" >
                    <caption>&nbsp;</caption>
                    <tr>
                        <td class="texfield"><div align="center" class="fuentetabla">Programa<br>
                            </div></td>
                        <td class="texfield"><div align="center" class="fuentetabla">Jornada<br>
                            </div></td>
                        <td class="texfield"><div align="center" class="fuentetabla">Ano Finalizacion<br>
                            </div></td>
                        <td class="texfield"><div align="center" class="fuentetabla">Estado<br>
                            </div></td>
                        <td class="texfield"><div align="center" class="fuentetabla">Accion<br>
                            </div></td>
                    </tr>

                <s:hidden name="listaObjetos"></s:hidden>
                <s:iterator value="listaObjetos">
                    <tr>
                        <td class="texfield"><s:property value="idPrograma.nombre"></s:property><br>
                            </td>
                            <td class="texfield"><s:property value="idJornada.nombre"></s:property><br>
                            </td>
                            <td class="texfield"><s:property value="anioFinalizacion"></s:property><br>
                            </td>
                            <td class="texfield"><s:property value="idEstadoEducacion.nombre"></s:property><br>
                            </td>
                            <td class="texfield">
                            <s:url id="editarURL" action="editarEducacionFormalUCentral.action">
                                <s:param name="idObjeto" value="%{idEducacion}" ></s:param>
                            </s:url>
                            <s:a href="%{editarURL}">
                                <div class="fuentetabla2"><img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/editar-icono-8419-16.png" align="top">
                                </s:a>
                                <s:url id="borrarURL" action="borrarEducacionFormalUCentral.action">
                                    <s:param name="idObjeto" value="%{idEducacion}"></s:param>
                                </s:url>
                                <s:a href="%{borrarURL}">
                                    <img style="width: 20px; height: 19px;" title="Borrar" alt="Borrar" src="imagenes/eliminar.png" align="top"></div>
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
            <div class="fromtables" id="contenido1">
                <s:if test="editar">
                    <s:form action="guardarEducacionFormalUCentral.action" id="formEducacion">
                        <s:url id="programaURL" action="SelectPrograma"/>
                        <s:push value="objeto">
                            <s:hidden name="idEducacion"></s:hidden>
                                <div class="fuente2">Generar Nuevo Registro</div>
                                <table>
                                    <tr>
                                        <td>
                                        <jq:select href="%{programaURL}" onChangeTopics="reloadThirdlist" name="nivelEstudios" id="nivelEstudios"
                                                   list="listaNivelesEstudios" listKey="id" listValue="nombre" onCompleteTopics="reloadThirdlist"
                                                   headerKey="-1" headerValue="- Seleccione -" label="Nivel de estudios"/>
                                    </td>
                                    <td>
                                        <jq:select href="%{programaURL}" onChangeTopics="reloadThirdlist" name="facultad" id="facultad"
                                                   formIds="formEducacion" list="listaFacultades" listKey="id" listValue="nombre"
                                                   headerKey="-1" headerValue="- Seleccione -" label="Facultad" onCompleteTopics="reloadThirdlist"/>
                                    </td>
                                    <td>
                                        <jq:select href="%{programaURL}" reloadTopics="reloadThirdlist"
                                                   name="programa" list="listaProgramas" listKey="id" listValue="nombre" headerKey="-1"
                                                   headerValue="- Seleccione -" id="programa" formIds="formEducacion" label="Programa"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <s:select label="Jornada" cssClass="texfield" name="jornada" list="listaJornadas" listKey="idJornada" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:select label="Ano Inicio" cssClass="texfield" name="anioInicio" list="listaAnios" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:select label="Mes Inicio" cssClass="texfield" name="mesInicio" list="listaMeses" listKey="idMes" listValue="mes" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:select label="Ano Finalizacion" cssClass="texfield" name="anioFinalizacion" list="listaAnios" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:select label="Mes Finalizacion" cssClass="texfield" name="mesFinalizacion" list="listaMeses" listKey="idMes" listValue="mes" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:select label="Estado" cssClass="texfield" name="estadoEducacion" list="listaEstadosEducacion" listKey="idEstadoEducacion" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        </td>
                                    </tr>
                                <s:actionerror></s:actionerror>
                                <s:submit cssClass="center1" value="Guardar">
                                    <br>
                                </s:submit>
                            </table>
                        </s:push>
                    </s:form>
                </s:if>
            </div>
        </div>
        <div class="enlaces">
            <div class="tdsiguiente"><a href="siguienteEducacionFormalUCentral.action"><img src="imagenes/next.png" width="24" height="24"></a></div>
            <div class="tdatras"><a href="anteriorEducacionFormalUCentral.action" class="tdatras"><img src="imagenes/atras.jpg" width="24" height="24"></a></div>
        </div>
        <s:if test="hasActionErrors()">
            <div class="errors">
                <s:actionerror/>
            </div>
        </s:if>
        <br>
        <br>
    </body>
</html>