<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<html lang="es">
    <head><title>Registro Sistema</title>
        <meta charset="utf-8">
        <link href="estilo2.css" rel="stylesheet" type="text/css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <jq:head jqueryui="true" />
    </head>
    <body>
        <div class="from2">
            <div id="contenido">
                <div class="TituloPrincipal" style="/* [disabled]margin-left:10px; */ font-size: 20px">
                    <div align="center">Portal Egresados  Universidad Central</div>
                </div>
                <div class="titu">
                    <p align="left"><img src="imagenes/document-open.png" width="107" height="94">
                        <span class="titu2">a a a</span><img src="imagenes/logosimbolo-ucentral-v1-medium.png" width="273" height="62">  <span class="titu2">a asda sd</span> Registro Usuario </p>
                </div>
                <div align="center" class="tabla" id="Tabla">
                    <s:form action="guardarRegistro.action" id="formRegistro"> <br>
                        <s:url id="ciudadURL" action="SelectDobleCiudad"/>
                        <div align="center" class="tabla">
                            <table cellpadding="2" cellspacing="12">
                                <caption class="fuente2">
                                    REGISTRO EN EL SISTEMA</caption>
                                <tr>
                                    <td class="texfield"> <div align="center">
                                            <s:textfield name="primerApellido" cssClass="texfield" label="Primer Apellido"/>
                                        </div></td>
                                    <td> <s:textfield cssClass="texfield" name="segundoApellido" label=" Segundo Apellido"/></td>
                                    <td> <s:textfield name="nombres" cssClass="texfield" label="Nombres"/></td>
                                </tr>
                                <tr>
                                    <td > <jq:datepicker label="Fecha Nacimiento:" name="fechaNacimiento" changeMonth="true" changeYear="true" showButtonPanel="true"></jq:datepicker></td>

                                        <td class="tduno">
                                        <jq:select href="%{ciudadURL}" onChangeTopics="reloadsecondlist" name="pais" id="pais"
                                                   list="listaPaises" listKey="id" listValue="nombre"
                                                   headerKey="-1" headerValue="- Seleccione -" label="País Nacimiento:"/>
                                    </td>
                                    <td>
                                        <jq:select href="%{ciudadURL}" onChangeTopics="reloadThirdlist" onCompleteTopics="reloadThirdlist"
                                                   formIds="formRegistro" reloadTopics="reloadsecondlist" name="departamento" id="departamento"
                                                   list="listaDepartamentos" listKey="id" listValue="nombre" headerKey="-1"
                                                   headerValue="- Seleccione -" label="Departamento Nacimiento:"/>
                                    </td>
                                    <td>
                                        <jq:select href="%{ciudadURL}" formIds="formRegistro" reloadTopics="reloadThirdlist"
                                                   name="ciudadNacimiento" list="listaCiudades" listKey="id" listValue="nombre" headerKey="-1"
                                                   headerValue="- Seleccione -" id="ciudad" label="Ciudad Nacimiento:"/>
                                    </td>
                                    <td><s:select label="Tipo Documento:" name="tipoDocumento" list="listaTiposDocumento" listKey="idTipoDocumento" listValue="nombre" headerKey="-1" headerValue="- Seleccione - "/></td>
                                    <td> <s:textfield label="Numero Documento:" name="numeroDocumento" cssClass="texfield"></s:textfield></td>
                                    <td> <jq:datepicker label="Fecha Expedicion:" name="fechaExpedicion" changeMonth="true" changeYear="true" showButtonPanel="true"></jq:datepicker></td>

                                    </tr>
                                    <tr>
                                        <td>
                                        <jq:select href="%{ciudadURL}" onChangeTopics="reloadsecondlist2" name="pais2" id="pais2"
                                                   list="listaPaises2" listKey="id" listValue="nombre"
                                                   headerKey="-1" headerValue="- Seleccione -" label="País Expedición"/>
                                    </td>
                                    <td>
                                        <jq:select href="%{ciudadURL}" onChangeTopics="reloadThirdlist2" onCompleteTopics="reloadThirdlist2"
                                                   formIds="formRegistro" reloadTopics="reloadsecondlist2" name="departamento2" id="departamento2"
                                                   list="listaDepartamentos2" listKey="id" listValue="nombre" headerKey="-1"
                                                   headerValue="- Seleccione -" label="Departamento Expedición"/>
                                    </td>
                                    <td>
                                        <jq:select href="%{ciudadURL}" reloadTopics="reloadThirdlist2"
                                                   name="ciudadExpedicion" list="listaCiudades2" listKey="id" listValue="nombre" headerKey="-1"
                                                   headerValue="- Seleccione -" id="ciudad2" formIds="formRegistro" label="Ciudad Expedición"/>
                                    </td>


                                    <td><s:select label="Grupo Sanguineo:" name="grupoSanguineo" list="listaGruposSanguineos" listKey="idGrupoSanguineo" listValue="grupoSanguineo" headerKey="-1" headerValue="- Seleccione - "/></td>
                                </tr>
                                <tr>


                                    <td><s:select label="Genero:" name="genero" list="listaGeneros" listKey="idGenero" listValue="nombre" headerKey="-1" headerValue="- Seleccione - "/></td>
                                    <td> <s:select  label="Estado Civil:" name="estadoCivil" list="listaEstadosCiviles" listKey="idEstadoCivil" listValue="estadoCivil" headerKey="-1" headerValue="- Seleccione - "/></td>
                                </tr>

                                <tr>
                                    <td colspan="2"><s:textfield name="nombre" label="Usuario:"></s:textfield><br>
                                        </td>
                                        <td colspan="2"><s:textfield name="correoInstitucional" label="Correo Institucional:"></s:textfield><br>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2"><s:password name="contrasenia" label="Contraseï¿½a:"></s:password><br>
                                        </td>
                                        <td colspan="2"><s:password name="confirmacionClave" label="Confirmar contraseï¿½a:"></s:password><br>
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
                                            <s:submit value="Guardar" cssClass="positive" src="imagenes/btnGuardar.png"></s:submit>
                                            </div>
                                        </td>
                                        <td>
                                </table>

                            </div>

                            <div align="center">
                            </div>
                    </s:form>
                </div>
                <br>
                <br>
            </div>
            <p>&nbsp;</p>
        </div>
    </body>
</html>