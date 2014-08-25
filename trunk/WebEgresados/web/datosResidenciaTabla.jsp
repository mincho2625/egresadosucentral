<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<html lang="es">
    <head>
        <title>Datos Residencia</title>
        <meta charset="utf-8"/>
        <link rel="stylesheet" href="estilo.css">
    </head>
    <body>
        <div id="Tabla" align="center">
            <table rules="all" >
                <caption>DATOS DE RESIDENCIA</caption>
                <tr>
                    <td class="tddos">Tipo Vivienda<br>
                    </td>
                    <td class="tddos">Tenencia<br>
                    </td>
                    <td class="tddos">Ciudad<br>
                    </td>
                    <td class="tddos">Dirección<br>
                    </td>
                    <td class="tddos">Estrato<br>
                    </td>
                    <td class="tddos">Acción<br>
                    </td>
                </tr>

                <s:iterator value="listaObjetos">
                    <tr>
                        <td class="tdtres"><s:property value="idTipoVivienda.nombre"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="idTipoTenenciaVivienda.nombre"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="idCiudadResidencia.nombre"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="direccion"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="idEstrato.estratoLetras"></s:property><br>
                            </td>
                            <td class="tdtres">
                            <s:url id="editarURL" action="editarResidencia.action">
                                <s:param name="idObjeto" value="%{idResidencia}"></s:param>
                            </s:url>
                            <s:a href="%{editarURL}">
                                <img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/Icono_de_editar.png" align="top"><br>
                            </s:a>
                            <s:url id="borrarURL" action="borrarResidencia.action">
                                <s:param name="idObjeto" value="%{idResidencia}"></s:param>
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
                <a href="desplegarResidencia.action" target="contenido">
                    <button type="submit" class="positive" name="nuevo">
                        <img src="imagenes/btnGuardar.png" alt=""/>
                        Nuevo
                    </button>
                </a><br>
            </div>
            <br>
            <a href="obtenerListaExperienciaLaboral.action" class="tduno"><div>Siguiente</div></a>
            <br>
            <a href="obtenerListaEgresadoRedSocial.action" class="tdatras"><div>Anterior</div></a>
            <br>
            <br>

        </div>

        <div id="contenido">
            <s:if test="editar">
                <s:form action="guardarResidencia.action">
                    <s:push value="objeto">
                        <s:hidden name="idResidencia"></s:hidden>
                            <div class="tdun">Generar Nuevo Registro</div>
                            <br>
                            <table>
                                <tr>
                                    <td>
                                        <div class="tduno">Ciudad Residencia </div><s:select  cssClass="center" name="ciudad" list="listaCiudades" listKey="idCiudad" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Tipo Vivienda </div><s:select cssClass="center" name="tipoVivienda" list="listaTiposVivienda" listKey="idTipoVivienda" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno">Tipo Tenencia Vivienda </div><s:select cssClass="center" name="tipoTenenciaVivienda" list="listaTiposTenenciaVivienda" listKey="idTipoTenenciaVivienda" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Dirección </div><s:textfield cssClass="center" name="direccion"></s:textfield>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Estrato </div> <s:select cssClass="center" name="estrato" list="listaEstratos" listKey="idEstrato" listValue="estratoLetras"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Tiene computador </div><s:checkbox cssClass="center"name="computador"></s:checkbox>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Tiene acceso a internet </div><s:checkbox cssClass="center" name="conexionInternet"></s:checkbox>
                                    </td>
                                </tr>
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