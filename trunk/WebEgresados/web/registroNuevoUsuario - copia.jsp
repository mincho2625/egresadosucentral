<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<html lang="es">
    <head>
        <title>Formulario Principal Nuevos</title>
        <meta charset="utf-8"/>
        <link rel="stylesheet" href="estilo.css">
        <jq:head></jq:head>
        </head>

        <body>
            <div id="cabecera"><img src="imagenes/logosimbolo-ucentral-v1-large.png">
            </div>

            <div id="Tabla" align="center">
            <s:form action="guardarRegistro.action" id="formRegistro"> <br>

                <table cellpadding="2" cellspacing="12">
                    <caption>REGISTRO EN EL SISTEMA</caption>
                    <tr>
                        <td><s:textfield name="primerApellido" label="Primer Apellido:"/></td>
                        <td><s:textfield name="segundoApellido" label="Segundo Apellido:"/></td>
                        <td colspan="2"><s:textfield name="nombres" label="Nombres:"/></td>
                    </tr>
                    <tr>
                        <td>
                            <jq:datepicker name="fechaNacimiento" label="Fecha Nacimiento:" changeMonth="true" changeYear="true" showButtonPanel="true"></jq:datepicker>
                                <br>
                            </td>
                            <td>
                            <s:textfield name="numeroDocumento" label="Numero Documento:"></s:textfield>
                                <br>
                            </td>
                            <td>
                            <jq:datepicker name="fechaExpedicion" label="Fecha Expedicion:" changeMonth="true" changeYear="true" showButtonPanel="true"></jq:datepicker>
                                <br>
                            </td>
                            <td>
                            <s:url var="refrescarPaisesURL" action="refrescarPaises"></s:url>
                            
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
                                label="Ciudad Expedicion:"
                                list="listaCiudades"
                                listKey="idCiudad"
                                listValue="nombre"
                                headerKey="-1"
                                headerValue="- Seleccione - "/>
                            <br>
                        </td>
                        <td>
                            <s:select name="tipoDocumento" label="Tipo Documento:" list="listaTiposDocumento" listKey="idTipoDocumento" listValue="nombre" headerKey="-1" headerValue="- Seleccione - "/>
                            <br>
                        </td>
                        <td>
                            <s:select name="grupoSanguineo" label="Grupo Sanguineo:" list="listaGruposSanguineos" listKey="idGrupoSanguineo" listValue="grupoSanguineo" headerKey="-1" headerValue="- Seleccione - "/>
                            <br>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <s:select
                                id="ciudadNacimiento"
                                name="ciudadNacimiento"
                                label="Ciudad Nacimiento:"
                                list="listaCiudades"
                                listKey="idCiudad"
                                listValue="nombre"
                                headerKey="-1"
                                headerValue="- Seleccione - "/>
                        </td>
                        <td>
                            <s:select name="genero" label="Genero:" list="listaGeneros" listKey="idGenero" listValue="nombre" headerKey="-1" headerValue="- Seleccione - "/>
                            <br>
                        </td>
                        <td>
                            <s:select name="estadoCivil" label="Estado Civil:" list="listaEstadosCiviles" listKey="idEstadoCivil" listValue="estadoCivil" headerKey="-1" headerValue="- Seleccione - "/>
                            <br>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><s:textfield name="nombre" label="Usuario:"></s:textfield><br>
                            </td>
                            <td colspan="2"><s:textfield name="correoInstitucional" label="Correo Institucional:"></s:textfield><br>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2"><s:password name="contrasenia" label="Contraseña:"></s:password><br>
                            </td>
                            <td colspan="2"><s:password name="confirmacionClave" label="Confirmar contraseña:"></s:password><br>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2"><s:select name="preguntaSeguridad" label="Pregunta Seguridad:" list="listaPreguntas" listKey="idPreguntaSeguridad" listValue="pregunta" headerKey="-1" headerValue="- Seleccione - "/><br>
                        </td>
                        <td colspan="2"><s:password name="respuestaSeguridad" label="Respuesta Secreta:"></s:password><br>
                            </td>
                        </tr>
                        <tr>
                            <td>
                            <s:checkbox cssClass="checkbox" name="terminos" label="Terminos y Condiciones."></s:checkbox>
                            </td>

                            <td>
                            <s:actionerror />
                        </td>
                        <td>
                            <div class="buttons">
                                <s:submit cssClass="positive" src="imagenes/btnGuardar.png"></s:submit>
                                </div>
                            </td>
                            <td><br>
                    </table>
            </s:form>
        </div>
        <br>
        <br>
    </body>
</html>