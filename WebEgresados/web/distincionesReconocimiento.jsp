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
                <caption>Reconocimientos y distinciones</caption>
                <tr>
                    <td class="tddos">Tipo<br>
                    </td>
                    <td class="tddos">Clase<br>
                    </td>
                    <td class="tddos">Entidad Otorgante<br>
                    </td>
                    <td class="tddos">Ciudad<br>
                    </td>
                    <td class="tddos">Fecha<br>
                    </td>
                    <td class="tddos">Accion<br>
                    </td>
                </tr>

                <s:iterator value="listaObjetos" status="contacto">
                    <tr>
                        <td class="tdtres"><s:property value="idTipoReconocimiento.nombre"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="idClaseReconocimiento.nombre"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="entidadOtorgante"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="idCiudad.nombre"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="fechaReconocimiento"></s:property><br>
                            </td>
                            <td class="tdtres">
                            <s:url id="editarURL" action="editarReconocimiento.action">
                                <s:param name="idObjeto" value="%{idReconocimiento}"></s:param>
                            </s:url>
                            <s:a href="%{editarURL}">
                                <img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/Icono_de_editar.png" align="top"><br>
                            </s:a>
                            <s:url id="borrarURL" action="borrarReconocimiento.action">
                                <s:param name="idObjeto" value="%{idReconocimiento}"></s:param>
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
                <a href="desplegarReconocimiento.action" target="contenido">
                    <button type="submit" class="positive" name="nuevo">
                        <img src="imagenes/btnGuardar.png" alt=""/>
                        Nuevo
                    </button>
                </a><br>
            </div>
            <br>
            <a href="obtenerListaAsociacion.action" class="tduno"><div>Siguiente</Div></a>
            <br>
            <a href="lenguaExtranjeraTabla.jsp" class="tdatras"><div>Anterior</Div></a>
            <br>            
            <br>

        </div>
        
        <div id="contenido1">
            <s:if test="editar">
                <s:form action="guardarReconocimiento.action">
                    <s:push value="objeto">
                        <s:hidden name="idReconocimiento"></s:hidden>
                        <div class="tdun">Generar Nuevo Registro</div>
                        <br>
                            <table>
                                <tr>
                                    <td>
                                        <br>
                                        <div class="tduno">Tipo Reconocimiento</div><s:select cssClass="center" name="tipoReconocimiento" list="listaTiposReconocimiento" listKey="idTipoReconocimiento" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno">Clase Reconocimiento</div><s:select cssClass="center" name="claseReconocimiento" list="listaClasesReconocimiento" listKey="idClaseReconocimiento" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <s:property value="getFieldErros().get('descrip'){0}"/>
                                        <div class="tduno">Descripción</div><s:textfield cssClass="center" name="descripcion"></s:textfield>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno">Ciudad</div><s:select cssClass="center" name="ciudad" list="listaCiudades" listKey="idCiudad" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <s:property value="getFieldErros().get('entiotor'){0}"/>
                                        <div class="tduno">Entidad Otorgante</div><s:textfield  cssClass="center" name="entidadOtorgante"></s:textfield>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <s:property value="getFieldErros().get('fecharegistro'){0}"/>
                                        <div class="tduno">Fecha</div><jq:datepicker name="fechaReconocimiento" changeMonth="true" changeYear="true" showButtonPanel="true"></jq:datepicker>
                                    </td>
                                </tr>
                                <tr>
                                    <!<s:submit cssClass="center1" value="Guardar"></s:submit>
                            </tr>
                        </table>
                    </s:push>
                </s:form>
            </s:if>
        </div>
    </body>
</html>