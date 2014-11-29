<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq"%>
<html lang="es">
    <head><title>Registro Sistema</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="estilo2.css">
        <jq:head></jq:head>
        </head>
        <body>
            <div class="TituloPrincipal" style="/* [disabled]margin-left:10px; */ font-size: 20px">
                <div align="center">Portal Egresados  Universidad Central</div>
            </div>
            <div class="titu">
                <p align="left"><img src="imagenes/document-open.png" width="107" height="94"><img src="imagenes/logosimbolo-ucentral-v1-medium.png" width="248" height="57">Asociaciones a Redes Profesionales</p>
            </div>
            <!--<div id="default-example" data-collapse>
                <h3>Informacion</h3>-->
            <div align="center" class="tabla" id="Tabla">
                <table rules="all" class="table2" >
                    <caption>&nbsp;</caption>
                    <tr>
                        <td class="texfield"><div align="center" class="fuentetabla">>Tipo Asociacion<br>
                            </div></td>
                        <td class="texfield"><div align="center" class="fuentetabla">Descripcion<br>
                            </div></td>
                        <td class="texfield"><div align="center" class="fuentetabla">Fecha vinculacion<br>
                            </div></td>
                        <td class="texfield"><div align="center" class="fuentetabla">Pais<br>
                            </div></td>
                        <td class="texfield"><div align="center" class="fuentetabla">Accion<br>
                            </div></td>                            
                    </tr>

                <s:hidden name="cantidadObjetos"></s:hidden>
                <s:iterator value="listaObjetos">
                    <tr>
                        <td class="texfield"><s:property value="idTipoAsociacion.nombre"></s:property><br>
                            </td>
                            <td class="texfield"><s:property value="descripcion"></s:property><br>
                            </td>
                            <td class="texfield"><s:property value="fechaVinculacion"></s:property><br>
                            </td>
                            <td class="texfield"><s:property value="idPais.nombre"></s:property><br>
                            </td>
                            <td class="texfield">
                            <div class="fuentetabla2">
                            <s:url id="editarURL" action="editarAsociacion.action">
                                <s:param name="idObjeto" value="%{idAsociacion}" ></s:param>
                            </s:url>
                            <s:a href="%{editarURL}">
                                <img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/editar-icono-8419-16.png" align="top">
                                </s:a>
                                <s:url id="borrarURL" action="borrarAsociacion.action">
                                    <s:param name="idObjeto" value="%{idAsociacion}"></s:param>
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
                <a href="desplegarAsociacion.action" target="contenido">
                    <button type="submit" class="positive" name="nuevo">
                        <img src="imagenes/btnGuardar.png" alt=""/>
                        Nuevo
                    </button>
                </a><br>
            </div>
            <div class="fromtables" id="contenido1">
                <s:if test="editar">
                    <s:form action="guardarAsociacion.action">
                        <s:push value="objeto">
                            <s:hidden name="idAsociacion"></s:hidden>
                                   <div class="fuente2">
                                        <p align="center">Agregar un Nueva Asociaciones o Red profesional</p>
                          </div>
                                    <div align="center"><br>
                                    </div>
                                <table>
                                    <tr>
                                        <td>
                                        <s:select label="Tipo Asociacion" cssClass="texfield" name="tipoAsociacion" list="listaTiposAsociaciones" listKey="idTipoAsociacion" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:textfield label="Descripcion" cssClass="texfield" name="descripcion"></s:textfield>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <jq:datepicker label="Fecha vinculacion" name="fechaVinculacion" changeMonth="true" changeYear="true" showButtonPanel="true"></jq:datepicker>   
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <s:select label="Pais" cssClass="texfield" name="pais" list="listaPaises" listKey="idPais" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        </td>
                                    </tr>
                                    <tr>
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
            <div class="tdsiguiente"><a href="siguienteAsociacion.action"><img src="imagenes/next.png" width="24" height="24"></a></div>
            <div class="tdatras"><a href="anteriorAsociacion.action" class="tdatras"><img src="imagenes/atras.jpg" width="24" height="24"></a></div>
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