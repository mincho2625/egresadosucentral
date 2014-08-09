<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>

<html lang="es">
    <head><title>Registro Sistema</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="estilo.css">
        <jq:head></jq:head>
        </head>
        <body>
            <div id="Tabla" align="center">
            <s:form action="actualizarEgresadoRegistro.action" id="formRegistro"> <br>
                <s:push value="egresado">
                    <s:hidden name="idEgresado"></s:hidden>
                        <table cellpadding="2" cellspacing="12">
                            <caption>REGISTRO EN EL SISTEMA</caption>
                            <tr>

                            </tr>
                            <tr>
                                <td class="tduno">Primer Apellido:
                                </td>
                                <td class="tduno">Segundo Apellido:
                                </td>
                                <td class="tduno" colspan="2">Nombres:</td>
                            </tr>
                            <tr>
                                <td><s:textfield name="primerApellido"/></td>
                            <td><s:textfield name="segundoApellido"/></td>
                            <td colspan="2"><s:textfield name="nombres"/></td>
                        </tr>
                        <tr>
                            <td class="tduno">Fecha Nacimiento:<br>
                            </td>
                            <td class="tduno">Numero Documento:<br>
                            </td>
                            <td class="tduno">Fecha Expedicion:<br>
                            </td>
                            <td class="tduno">Pais Expedicion:<br>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <jq:datepicker name="fechaNacimiento" changeMonth="true" changeYear="true" showButtonPanel="true"></jq:datepicker>
                                    <br>
                                </td>
                                <td>
                                <s:textfield name="numeroDocumento"></s:textfield>
                                    <br>
                                </td>
                                <td>
                                <jq:datepicker name="fechaExpedicion" changeMonth="true" changeYear="true" showButtonPanel="true"></jq:datepicker>
                                    <br>
                                </td>
                                <td>
                                <s:url var="refrescarPaisesURL" action="refrescarPaises"></s:url>

                                </td>
                            </tr>
                            <tr>
                                <td class="tduno">DepartamentoExpedicion:<br>
                                </td>
                                <td class="tduno">Ciudad Expedicion:<br>
                                </td>
                                <td class="tduno">Tipo Documento:<br>
                                </td>
                                <td class="tduno">Grupo Sanguineo:<br>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <br>
                                </td>
                                <td>
                                <s:select
                                    id="ciudadExpedicion"
                                    name="ciudadExpedicion"
                                    list="listaCiudades"
                                    listKey="idCiudad"
                                    listValue="nombre"
                                    headerKey="-1"
                                    headerValue="Seleccione Ciudad"/>
                                <br>
                            </td>
                            <td>
                                <s:select name="tipoDocumento" list="listaTiposDocumento" listKey="idTipoDocumento" listValue="nombre" headerValue="TipoDocumento"/>
                                <br>
                            </td>
                            <td>
                                <s:select name="grupoSanguineo" list="listaGruposSanguineos" listKey="idGrupoSanguineo" listValue="nombre" headerValue="GrupoSanguineo"/>
                                <br>
                            </td>
                        </tr>
                        <tr>
                            <td class="tduno">Departamento Nacimiento:<br>
                            </td>
                            <td class="tduno">Ciudad Nacimiento:<br>
                            </td>
                            <td class="tduno">Genero:<br>
                            </td>
                            <td class="tduno">Estado Civil:<br>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <s:select
                                    id="ciudadNacimiento"
                                    name="ciudadNacimiento"
                                    list="listaCiudades"
                                    listKey="idCiudad"
                                    listValue="nombre"
                                    headerKey="-1"
                                    headerValue="Seleccione Ciudad"/>
                            </td>
                            <td>
                                <s:select name="genero" list="listaGeneros" listKey="idGenero" listValue="nombre" headerValue="Genero"/>
                                <br>
                            </td>
                            <td>
                                <s:select name="estadoCivil" list="listaEstadosCiviles" listKey="idEstadoCivil" listValue="nombre" headerValue="EstadoCivil"/>
                                <br>
                            </td>
                        </tr>

                        <tr>
                            <td><div class="buttons">
                                    <button type="submit" class="positive" name="cambioClave">
                                        <img src="imagenes/btnCambioClave.png" alt=""/>
                                        Cambio Clave
                                    </button><br>
                                </div></td>
                            <td><br>
                            </td>
                            <td><br>
                            </td>
                            <td><br>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <s:checkbox cssClass="checkbox" name="terminos">Terminos y Condiciones.</s:checkbox>
                                </td>

                            <s:if test="hasActionErrors()">
                                <td>
                                    <s:actionerror />
                                </td>
                            </s:if>
                            <td><div class="buttons">
                                    <s:submit cssClass="positive">
                                        <img src="imagenes/btnGuardar.png" alt=""/>Guardar<br>
                                    </s:submit>

                                </div></td>
                            <td><br>

                    </table>
                </s:push>
            </s:form>
        </div>
        <br>
        <br>

    </body>
</html>