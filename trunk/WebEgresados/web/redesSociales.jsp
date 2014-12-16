<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<html lang="es">
    <head><title>Registro Sistema</title>
        <meta charset="utf-8">
        <link href="estilo2.css" rel="stylesheet" type="text/css">
        <jq:head></jq:head>
        </head>
        <body>
            <div class="TituloPrincipal" style="/* [disabled]margin-left:10px; */ font-size: 20px">
                <div align="center">Portal Egresados  Universidad Central</div>
            </div>
            <div class="titu">
                <p align="left"><img src="imagenes/document-open.png" width="107" height="94">		      <span class="titu2">a a a</span><img src="imagenes/logosimbolo-ucentral-v1-medium.png" width="273" height="62">  <span class="titu2">a asda </span>Redes Sociales</p>
            </div>
            <!--<div id="default-example" data-collapse>
                <h3>Informacion</h3>-->
            <div align="center" class="tabla" id="Tabla">
                <table rules="all" class="table2"  >
                    <caption>&nbsp;
                    </caption>
                    <tr>
                        <td class="texfield"><div align="center" class="fuentetabla">Red Social<br>
                            </div></td>
                        <td class="texfield"><div align="center" class="fuentetabla">URL<br>
                            </div></td>
                        <td class="texfield"><div align="center" class="fuentetabla">Accion<br>
                            </div></td>
                    </tr>

                <s:hidden name="cantidadObjetos"></s:hidden>
                <s:iterator value="listaObjetos">
                    <tr>
                        <td class="texfield"><s:property value="idRedSocial.nombre"></s:property><br>
                            </td>
                            <td class="texfield"><s:property value="url"></s:property><br>
                            </td>
                            <td class="texfield">
                            <s:url id="editarURL" action="editarEgresadoRedSocial.action">
                                <s:param name="idObjeto" value="%{idEgresadoRedSocial}" ></s:param>
                            </s:url>
                            <s:a href="%{editarURL}">
                                <div class="fuentetabla2"><img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/editar-icono-8419-16.png" align="top">
                                </s:a>
                                <s:url id="borrarURL" action="borrarEgresadoRedSocial.action">
                                    <s:param name="idObjeto" value="%{idEgresadoRedSocial}"></s:param>
                                </s:url>
                                <s:a href="%{borrarURL}">
                                    <img style="width: 20px; height: 19px;" title="Borrar" alt="Borrar" src="imagenes/eliminar.png" align="top">
                                </s:a></div>
                        </td>
                    </tr>
                </s:iterator>
            </table>
            <br>
            <div class="buttons">
                <a href="desplegarEgresadoRedSocial.action" target="contenido">
                    <button type="submit" class="positive" name="nuevo">
                        <img src="imagenes/btnGuardar.png" alt=""/>
                        Nuevo
                    </button>
                </a><br>
            </div>
            <div align="center" class="fuente2"><br>
            </div>
            <div id="contenido1">
                <span class="fuente2">
                </span>
                <s:if test="editar">
                    <s:form action="guardarEgresadoRedSocial.action">
                        <s:push value="objeto">
                            <s:hidden name="idEgresadoRedSocial"></s:hidden>
                                <div class="tdun">
                                    <div align="center" class="fuente2">Agregar Nueva Red Social</div>
                                </div>
                                <br>
                                <table>
                                    <tr>
                                        <td>
                                            <span class="texfield">
                                            <s:select  label="Red Social" cssClass="center" name="redSocial" list="listaRedesSociales" listKey="idRedSocial" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                            </span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <span class="texfield">
                                            <s:textfield label="URL" name="url" cssClass="center"></s:textfield>
                                            </span>
                                        </td>
                                    </tr>
                                    <tr>
                                    <s:actionerror></s:actionerror>
                                    <s:submit cssClass="center1" value="Guardar">
                                    </s:submit>
                                </tr>

                            </table>
                        </s:push>
                    </s:form>
                </s:if>
            </div>
            </div>
            <div class="enlaces">
                <div class="tdsiguiente"><a href="siguienteEgresadoRedSocial.action"><img src="imagenes/next.png" width="21" height="21"></a></div>
                <div class="tdatras"><a href="anteriorEgresadoRedSocial.action" class="tdatras"><img src="imagenes/atras.jpg" width="24" height="24"></a></div>
            </div>
            <s:if test="hasActionErrors()">
                <div class="errors">
                    <s:actionerror/>
                </div>
            </s:if>
    </body>
</html>