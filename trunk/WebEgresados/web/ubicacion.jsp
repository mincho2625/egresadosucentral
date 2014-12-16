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
                <p align="left"><img src="imagenes/document-open.png" width="107" height="94">		      <span class="titu2">a a a</span><img src="imagenes/logosimbolo-ucentral-v1-medium.png" width="273" height="62">  <span class="titu2">a asda </span>Datos de Ubicacion</p>
            </div>
            <!--<div id="default-example" data-collapse>
                <h3>Informacion</h3>-->
            <div align="center" class="tabla" id="Tabla">
                <table rules="all" class="table2"  >
                    <caption>
                        <br>
                    </caption>
                    <tr>
                        <td class="texfield"><div align="center" class="fuentetabla">Tipo Contacto<br>
                            </div></td>
                        <td class="texfield"><div align="center" class="fuentetabla">Descripcion<br>
                            </div></td>
                        <td class="texfield"><div align="center" class="fuentetabla">Accion<br>
                            </div></td>
                    </tr>

                <s:hidden name="cantidadObjetos"></s:hidden>
                <s:iterator value="listaObjetos" status="contacto">
                    <tr>
                        <td class="texfield"><s:property value="idTipoContacto.nombre"></s:property>
                                <div align="center"><br>
                                </div></td>
                            <td class="texfield"><s:property value="descripcion"></s:property>
                                <div align="center"><br>
                                </div></td>
                            <td class="texfield">
                            <div class="fuentetabla2">
                            <s:url id="editarURL" action="editarUbicacion.action">
                                <s:param name="idObjeto" value="%{idContacto}" ></s:param>
                            </s:url>
                            <s:a href="%{editarURL}">
                                <img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/editar-icono-8419-16.png" align="top">
                            </s:a>
                            <s:url id="borrarURL" action="borrarUbicacion.action">
                                <s:param name="idObjeto" value="%{idContacto}"></s:param>
                            </s:url>
                            <s:a href="%{borrarURL}">
                                <img style="width: 20px; height: 19px;" title="Borrar" alt="Borrar" src="imagenes/eliminar.png" align="top">
                            </s:a></div>
                        </td>
                    </tr>
                </s:iterator>
            </table>
            <br>
            <div class="fromtables">
                <a href="desplegarUbicacion.action" target="contenido">
                    <button type="submit" class="positive" name="nuevo">
                        <img src="imagenes/btnGuardar.png" alt=""/>
                        Nuevo
                    </button>
                </a><br>
            </div>
            <div class="fromtables" id="contenido1">
                <s:if test="editar">
                    <s:form action="guardarUbicacion.action"> 
                        <s:push value="objeto">
                            <s:hidden name="idContacto"></s:hidden>
                                <div class="fuente2">
                                    <p align="center">Agregar un Nuevo Dato de Ubicacion</p>
                                </div>
                                <div align="center"><br>
                                </div>
                                <table >
                                    <tr>
                                        <td>
                                            <span class="texfield">
                                            <s:select  label="Tipo Contacto" cssClass="texfield" name="tipoContacto" list="listaTiposContacto" listKey="idTipoContacto" listValue="nombre" labelposition="right" requiredPosition="left" headerKey="-1" headerValue="- Seleccione -">                                          
                                            </s:select>                                          
                                        </span></td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="texfield">
                                            <s:textfield label="Descripcion" cssClass="texfield" name="descripcion"></s:textfield>
                                            </span></td>
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
        <div class="enlaces">
            <div class="tdsiguiente"><a href="siguienteUbicacion.action"><img src="imagenes/next.png" width="24" height="24"></a></div>
            <div class="tdatras"><a href="anteriorUbicacion.action" class="tdatras"><img src="imagenes/atras.jpg" width="24" height="24"></a></div>
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