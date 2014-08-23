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
                                        <div class="tduno">Ciudad Residencia </div>
                                    </td>
                                    <td>
                                    <s:select name="ciudad" list="listaCiudades" listKey="idCiudad" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Tipo Vivienda </div>
                                    </td>
                                    <td>
                                    <s:select name="tipoVivienda" list="listaTiposVivienda" listKey="idTipoVivienda" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno">Tipo Tenencia Vivienda </div>
                                    </td>
                                    <td>
                                    <s:select name="tipoTenenciaVivienda" list="listaTiposTenenciaVivienda" listKey="idTipoTenenciaVivienda" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Dirección </div>
                                    </td>
                                    <td>
                                    <s:textfield name="direccion"></s:textfield>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Estrato </div>
                                    </td>
                                    <td>
                                    <s:select name="estrato" list="listaEstratos" listKey="idEstrato" listValue="estratoLetras"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Tiene computador </div>
                                    </td>
                                    <td>
                                    <s:checkbox name="computador"></s:checkbox>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Tiene acceso a internet </div>
                                    </td>
                                    <td>
                                    <s:checkbox name="conexionInternet"></s:checkbox>
                                    </td>
                                </tr>
                                <tr>
                                <s:submit cssClass="positive" value="Guardar">
                            </s:submit>
                            </tr>
                        </table>
                    </s:push>
                </s:form>
            </s:if>
        </div>
    </body>
</html>