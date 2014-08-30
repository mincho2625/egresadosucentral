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
                <caption>REDES SOCIALES</caption>
                <tr>
                    <td class="tddos">Red Social<br>
                    </td>
                    <td class="tddos">URL<br>
                    </td>
                    <td class="tddos">Acción<br>
                    </td>
                </tr>

                <s:iterator value="listaObjetos">
                    <tr>
                        <td class="tdtres"><s:property value="idRedSocial.nombre"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="url"></s:property><br>
                            </td>
                            <td class="tdtres">
                            <s:url id="editarURL" action="editarEgresadoRedSocial.action">
                                <s:param name="idObjeto" value="%{idEgresadoRedSocial}"></s:param>
                            </s:url>
                            <s:a href="%{editarURL}">
                                <img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/Icono_de_editar.png" align="top"><br>
                            </s:a>
                            <s:url id="borrarURL" action="borrarEgresadoRedSocial.action">
                                <s:param name="idObjeto" value="%{idEgresadoRedSocial}"></s:param>
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
                <a href="desplegarEgresadoRedSocial.action" target="contenido">
                    <button type="submit" class="positive" name="nuevo">
                        <img src="imagenes/btnGuardar.png" alt=""/>
                        Nuevo
                    </button>
                </a><br>
            </div>
            <br>
            <a href="obtenerListaResidencia.action" class="tduno"><div>Siguiente</div></a>
            <br>
            <a href="obtenerListaUbicacion.action"  class="tdatras"><div>Anterior</div></a>
            <br>
            <br>

        </div>

        <div id="contenido1">
            <s:if test="editar">
                <s:form action="guardarEgresadoRedSocial.action">
                    <s:push value="objeto">
                        <s:hidden name="idEgresadoRedSocial"></s:hidden>
                            <div class="tdun">Generar Nuevo Registro</div>
                            <br>
                            <table>
                                <tr>
                                    <td>
                                        <div class="tduno"> Red Social </div><s:select cssClass="center" name="redSocial" list="listaRedesSociales" listKey="idRedSocial" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> URL </div><s:textfield name="url" cssClass="center"></s:textfield>
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