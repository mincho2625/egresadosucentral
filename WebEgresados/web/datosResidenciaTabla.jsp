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
                <p align="left"><img src="imagenes/document-open.png" width="107" height="94">		      <span class="titu2">a a a</span><img src="imagenes/logosimbolo-ucentral-v1-medium.png" width="273" height="62">  <span class="titu2">a asd</span>Datos de Residencia</p>
            </div>
            <!--<div id="default-example" data-collapse>
                        <h3>Informacion</h3>-->
            <div align="center" class="tabla" id="Tabla">
                    <table rules="all" class="table2" >
                        <caption>&nbsp;</caption>
                        <tr>
                            <td class="texfield"><div align="center" class="fuentetabla">Tipo Vivienda<br>
                                </div></td>
                            <td class="texfield"><div align="center" class="fuentetabla">Tenencia<br>
                                </div></td>
                            <td class="texfield"><div align="center" class="fuentetabla">Ciudad<br>
                                </div></td>
                            <td class="texfield"><div align="center" class="fuentetabla">Direccion<br>
                                </div></td>
                            <td class="texfield"><div align="center" class="fuentetabla">Estrato<br>
                                </div></td>
                            <td class="texfield"><div align="center" class="fuentetabla">Accion<br>
                                </div></td>
                        </tr>

                    <s:hidden name="cantidadObjetos"></s:hidden>
                    <s:iterator value="listaObjetos">
                        <tr>
                            <td class="texfield"><s:property value="idTipoVivienda.nombre"></s:property><br>
                                </td>
                                <td class="texfield"><s:property value="idTipoTenenciaVivienda.nombre"></s:property><br>
                                </td>
                                <td class="texfield"><s:property value="idCiudadResidencia.nombre"></s:property><br>
                                </td>
                                <td class="texfield"><s:property value="direccion"></s:property><br>
                                </td>
                                <td class="texfield"><s:property value="idEstrato.estratoLetras"></s:property><br>
                                </td>
                                <td class="tdtres">
                                <s:url id="editarURL" action="editarUbicacion.action">
                                    <s:param name="idObjeto" value="%{idContacto}" ></s:param>
                                </s:url>
                                <s:a href="%{editarURL}">
                                    <div class="fuentetabla2"><img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/editar-icono-8419-16.png" align="top">
                                    </s:a>
                                    <s:url id="borrarURL" action="borrarUbicacion.action">
                                        <s:param name="idObjeto" value="%{idContacto}"></s:param>
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
                    <a href="desplegarResidencia.action" target="contenido">
                        <button type="submit" class="positive" name="nuevo">
                            <img src="imagenes/btnGuardar.png" alt=""/>
                            Nuevo
                        </button>
                    </a><br>
                </div>
                <br>
                <div id="contenido1">
                    <s:if test="editar">
                        <s:form action="guardarResidencia.action">
                            <s:push value="objeto">
                                <s:hidden name="idResidencia"></s:hidden>
                                    <div class="fuente2">Agregar Nueva Residencia</div>
                                    <br>
                                    <table>
                                        <tr>
                                            <td>
                                                <span class="tabla">
                                                <s:select label="Ciudad Residencia" cssClass="center" name="ciudad" list="listaCiudades" listKey="idCiudad" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                                </span></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <span class="tabla">
                                                <s:select label="Tipo Vivienda" cssClass="center" name="tipoVivienda" list="listaTiposVivienda" listKey="idTipoVivienda" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                                </span></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <span class="tabla">
                                                <s:select  label="Tipo Tenencia Vivienda" cssClass="center" name="tipoTenenciaVivienda" list="listaTiposTenenciaVivienda" listKey="idTipoTenenciaVivienda" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                                </span></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <span class="tabla">
                                                <s:textfield label="Direccion" cssClass="center" name="direccion"></s:textfield>
                                                </span></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <span class="tabla">
                                                <s:select  label="Estrato" cssClass="center" name="estrato" list="listaEstratos" listKey="idEstrato" listValue="estratoLetras" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                                </span></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <span class="tabla">
                                                <s:checkbox label="Tiene computador" cssClass="center" name="computador"></s:checkbox>
                                                </span></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <span class="tabla">
                                                <s:checkbox label="Tiene acceso a internet" cssClass="center" name="conexionInternet"></s:checkbox>
                                                </span></td>
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
                <div class="tdsiguiente"><a href="siguienteResidencia.action"><img src="imagenes/next.png" width="24" height="24"></a></div>
                <div class="tdatras"><a href="anteriorResidencia.action" class="tdatras"><img src="imagenes/atras.jpg" width="24" height="24"></a></div>
            </div>
            <s:if test="hasActionErrors()">
                <div class="errors">
                    <s:actionerror/>
                </div>
            </s:if>
    </body>
</html>