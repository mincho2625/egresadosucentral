<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<html lang="es">
    <head><title>Registro Sistema</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="estilo2.css">
        <s:head />
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <jq:head jqueryui="true" />
    </head>
    <body>
        <div class="TituloPrincipal" style="/* [disabled]margin-left:10px; */ font-size: 20px">
            <div align="center">Portal Egresados  Universidad Central</div>
        </div>
        <div class="titu">
            <p align="left"><img src="imagenes/document-open.png" width="107" height="94">
                <span class="titu2">a a a</span><img src="imagenes/logosimbolo-ucentral-v1-medium.png" width="273" height="62">  <span class="titu2">a </span> Actualizar Informacion</p>
        </div>
        <div align="center" class="tabla" id="Tabla">
            <s:form action="Egresado" id="formRegistro">
                <s:url id="ciudadURL" action="SelectDobleCiudad"/>
                <s:push value="egresado">
                    <s:hidden name="idEgresado"></s:hidden>
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
                                <td class="texfield"><div align="center"></div></td>
                                <td><div class="buttons">
                                        <button type="submit" class="texfield" name="cambioClave">
                                            <img src="imagenes/btnCambioClave.png" alt=""/>
                                            Cambio Clave
                                        </button><br>
                                    </div></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>
                                    <s:actionerror />
                                </td>
                                <td><div class="buttons">
                                        <s:submit cssClass="center1" value="Guardar">
                                        </s:submit>
                                    </div></td>
                                <td>

                                </td>   
                            </tr>
                        </table>

                    </div>

                    <div align="center">
                    </div>
                </s:push>    
            </s:form>
        </div>
        <div class="enlaces">
            <div class="tdsiguiente"><a href="siguienteEgresado.action"><img src="imagenes/next.png" width="21" height="21"></a></div>
        </div>
        <br>
        <br>
    </body>
</html>