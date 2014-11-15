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
                <p align="left"><img src="imagenes/document-open.png" width="107" height="94">		      <span class="titu2">a</span><img src="imagenes/logosimbolo-ucentral-v1-medium.png" width="273" height="62">Reconocimientos y Distinciones</p>
            </div>
            <!--<div id="default-example" data-collapse>
                <h3>Informacion</h3>-->
                <div align="center" class="tabla" id="Tabla">
                    <table rules="all" class="table2" >
                <caption>&nbsp;</caption>
                <tr>
                    <td class="texfield"><div align="center" class="fuentetabla">Tipo<br>
                    </div></td>
                    <td class="texfield"><div align="center" class="fuentetabla">Clase<br>
                    </div></td>
                    <td class="texfield"><div align="center" class="fuentetabla">Entidad Otorgante<br>
                    </div></td>
                    <td class="texfield"><div align="center" class="fuentetabla">Ciudad<br>
                    </div></td>
                    <td class="texfield"><div align="center" class="fuentetabla">Fecha<br>
                    </div></td>
                    <td class="texfield"><div align="center" class="fuentetabla">Accion<br>
                    </div></td>
                </tr>

                    <s:hidden name="cantidadObjetos"></s:hidden>
                <s:iterator value="listaObjetos" status="contacto">
                    <tr>
                        <td class="texfield"><s:property value="idTipoReconocimiento.nombre"></s:property><br>
                            </td>
                            <td class="texfield"><s:property value="idClaseReconocimiento.nombre"></s:property><br>
                            </td>
                            <td class="texfield"><s:property value="entidadOtorgante"></s:property><br>
                            </td>
                            <td class="texfield"><s:property value="idCiudad.nombre"></s:property><br>
                            </td>
                            <td class="texfield"><s:property value="fechaReconocimiento"></s:property><br>
                            </td>
                            <td class="texfield">
                            <s:url id="editarURL" action="editarReconocimiento.action">
                                <s:param name="idObjeto" value="%{idReconocimiento}"></s:param>
                            </s:url>
                            <s:a href="%{editarURL}">
                                <div class="fuentetabla2"><img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/Icono_de_editar.png" align="top">Editar</div><br>
                            </s:a>
                            <s:url id="borrarURL" action="borrarReconocimiento.action">
                                <s:param name="idObjeto" value="%{idReconocimiento}"></s:param>
                            </s:url>
                            <s:a href="%{borrarURL}">
                                <div class="fuentetabla2"><img style="width: 20px; height: 19px;" title="Borrar" alt="Borrar" src="imagenes/Icono_de_editar.png" align="top">Borrar</div><br>
                            </s:a>
                        </td>
                    </tr>
                </s:iterator>
            </table>
                <br>
            <div class="buttons">
                <a href="desplegarReconocimiento.action" target="contenido">
                    <button type="submit" class="positive" name="nuevo">
                        <img src="imagenes/btnGuardar.png" alt=""/>
                        Nuevo
                    </button>
                </a><br>
            </div>
            <br>
                <div class="fromtables" id="contenido1">
                    <s:if test="editar">
                <s:form action="guardarReconocimiento.action">
                    <s:push value="objeto">
                      <s:hidden name="idReconocimiento"></s:hidden>
                        <div class="fuente2">Generar Nuevo Registro</div>
                        <br>
                            <table>
                                <tr>
                                    <td>
                                        <br>
                                    <s:select label="Tipo Reconocimiento" cssClass="texfield" name="tipoReconocimiento" list="listaTiposReconocimiento" listKey="idTipoReconocimiento" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <s:select label="Clase Reconocimiento" cssClass="texfield" name="claseReconocimiento" list="listaClasesReconocimiento" listKey="idClaseReconocimiento" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <s:textfield label="Descripci�n" cssClass="texfield" name="descripcion"></s:textfield>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <s:select label="Ciudad" cssClass="texfield" name="ciudad" list="listaCiudades" listKey="idCiudad" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <s:textfield label="Entidad Otorgante" cssClass="texfield" name="entidadOtorgante"></s:textfield>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <jq:datepicker label="Fecha" name="fechaReconocimiento" changeMonth="true" changeYear="true" showButtonPanel="true"></jq:datepicker>
                                    </td>
                                </tr>
                                <tr>
                                    <s:actionerror></s:actionerror>
                                    <s:submit cssClass="center1" value="Guardar"></s:submit>
                            </tr>
                        </table>
                    </s:push>
                </s:form>
            </s:if>
                </div>
</div>
        <!--</div>-->
        <p></p>
        <p><br>
        </p>
        <a href="siguienteReconocimiento.action"><div class="tdsiguiente"><img src="imagenes/button_next_89675.jpg" width="21" height="21"></div></a>
        <br>
<a href="anteriorReconocimiento.action" class="tdatras"><div class="tdatras"><img src="imagenes/boton_atras.png" width="24" height="24"></div></a>
        <br>
        <br>
        <br>
        <s:if test="hasActionErrors()">
            <div class="errors">
               <s:actionerror/>
            </div>
        </s:if>
        <br>
        <br>
    </body>
</html>