<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<html lang="es">
    <head><title>Registro Sistema</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="estilo.css">
        <link rel="stylesheet" type="text/css" href="normalize.min.css">
        <link rel="stylesheet" type="text/css" href="bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="styles.css">
        <link rel="stylesheet" type="text/css" href="jce.css">
        <s:head />
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <jq:head jqueryui="true" jquerytheme="simple"/>
        <script type="text/javascript">
            function mostrarImagen(event) {
                var selectedFile = event.target.files[0];
                var reader = new FileReader();

                var imgtag = document.getElementById("vistaPrevia");
                imgtag.title = selectedFile.name;

                reader.onload = function(event) {
                    imgtag.src = event.target.result;
                };

                reader.readAsDataURL(selectedFile);
            }
        </script>
    </head>
    <body class="default" ontouchstart="">
        <div id="main" class="container" role="main">
            <div class="row">
                <aside>
                    <div id="system-message-container">
                    </div>
                </aside>
            </div>
            <div id="main-cuerpo">
                <div class="row contenido show">
                    <div class="componente col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block" style="margin-left: -50px">
                        <div class="row" style="margin-left: 158px;">
                            <br>
                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
                                <s:if test="%{foto != null && foto != ''}">
                                    <s:url id="vistaPreviaURL" action="VistaPrevia">
                                        <s:set name="imagen" value="rutaEgresados + foto"></s:set>
                                        <s:param name="imagen" value="%{#imagen}" ></s:param>
                                    </s:url>
                                    <img id="vistaPrevia" src="<s:url value="%{vistaPreviaURL}" />" width="100" height="100">
                                </s:if>
                                <s:else>
                                    <img id="vistaPrevia" src="imagenes/no-photo.png" width="100" height="100"/>
                                </s:else>
                            </div>
                            <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5 " style="margin-left: -30px">
                                <h1 style="margin-left: 100px; color: #2a6155; width: 400px" >Actualizar Información</h1>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
                                <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
                                    <s:form action="Egresado" id="formRegistro" enctype="multipart/form-data" method="POST">
                                        <s:url id="ciudadURL" action="SelectDobleCiudad"/>
                                        <s:push value="egresado">
                                            <s:hidden name="idUsuario"></s:hidden>
                                                <div class="item-page">
                                                    <br>
                                                    <table style="alignment-adjust: central; width: 550px;margin-left: -40px">
                                                        <tbody>
                                                            <tr>
                                                                <td><s:file errorPosition="bottom" name="fileUpload" id="fileUpload" label="Foto" onchange="mostrarImagen(event);"></s:file></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:textfield name="primerApellido" label="Primer Apellido" errorPosition="bottom"/></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:textfield name="segundoApellido" label="Segundo Apellido" errorPosition="bottom"/></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:textfield name="nombres" label="Nombres" errorPosition="bottom"/></td>
                                                            </tr>
                                                            <tr>
                                                                <td><jq:datepicker label="Fecha Nacimiento" errorPosition="bottom" name="fechaNacimiento" displayFormat="dd/mm/yy" changeMonth="true" changeYear="true" showButtonPanel="true"></jq:datepicker></td>
                                                            </tr>
                                                            <tr>
                                                                <td><jq:select href="%{ciudadURL}" onChangeTopics="reloadsecondlist" name="pais" id="pais"
                                                                       list="listaPaises" listKey="id" listValue="nombre" onCompleteTopics="reloadsecondlist"
                                                                       headerKey="-1" headerValue="- Seleccione -" label="País Nacimiento" errorPosition="bottom"/></td>
                                                            </tr>
                                                            <tr>
                                                                <td><jq:select href="%{ciudadURL}" onChangeTopics="reloadThirdlist" onCompleteTopics="reloadThirdlist"
                                                                       formIds="formRegistro" reloadTopics="reloadsecondlist" name="departamento" id="departamento"
                                                                       list="listaDepartamentos" listKey="id" listValue="nombre" headerKey="-1"
                                                                       headerValue="- Seleccione -" label="Departamento Nacimiento" errorPosition="bottom"/></td>
                                                            </tr>
                                                            <tr>
                                                                <td><jq:select href="%{ciudadURL}" formIds="formRegistro" reloadTopics="reloadThirdlist"
                                                                       name="ciudad" list="listaCiudades" listKey="id" listValue="nombre" headerKey="-1"
                                                                       headerValue="- Seleccione -" id="ciudad" label="Ciudad Nacimiento" errorPosition="bottom"/></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:select label="Tipo Documento" errorPosition="bottom" name="tipoDocumento" list="listaTiposDocumento" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione - "/></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:textfield name="numeroDocumento" cssClass="texfield" label="Numero Documento" errorPosition="bottom"></s:textfield></td>
                                                            </tr>
                                                            <tr>
                                                                <td><jq:datepicker label="Fecha Expedición" errorPosition="bottom" name="fechaExpedicion" displayFormat="dd/mm/yy" changeMonth="true" changeYear="true" showButtonPanel="true"></jq:datepicker></td>
                                                            </tr>
                                                            <tr>
                                                                <td><jq:select href="%{ciudadURL}" onChangeTopics="reloadsecondlist2" name="pais2" id="pais2"
                                                                   list="listaPaises2" listKey="id" listValue="nombre" onCompleteTopics="reloadsecondlist2"
                                                                   headerKey="-1" headerValue="- Seleccione -" label="País Expedición" errorPosition="bottom"/></td>
                                                            </tr>
                                                            <tr>
                                                                <td><jq:select href="%{ciudadURL}" onChangeTopics="reloadThirdlist2" onCompleteTopics="reloadThirdlist2"
                                                                       formIds="formRegistro" reloadTopics="reloadsecondlist2" name="departamento2" id="departamento2"
                                                                       list="listaDepartamentos2" listKey="id" listValue="nombre" headerKey="-1"
                                                                       headerValue="- Seleccione -" label="Departamento Expedición" errorPosition="bottom"/></td>
                                                            </tr>
                                                            <tr>
                                                                <td><jq:select href="%{ciudadURL}" reloadTopics="reloadThirdlist2" label="Ciudad Expedición" errorPosition="bottom"
                                                                       name="ciudad2" list="listaCiudades2" listKey="id" listValue="nombre" headerKey="-1"
                                                                       headerValue="- Seleccione -" id="ciudad2" formIds="formRegistro"/></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:select label="Grupo Sanguineo" errorPosition="bottom" name="grupoSanguineo" list="listaGruposSanguineos" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione - "/></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:select label="Género" errorPosition="bottom" name="genero" list="listaGeneros" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione - "/></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:select label="Estado Civil" errorPosition="bottom" name="estadoCivil" list="listaEstadosCiviles" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione - "/></td>
                                                            </tr>
                                                            <tr>
                                                                <s:actionerror/>
                                                            </tr>
                                                            <tr>
                                                                <td></td>
                                                                <td><s:submit  cssClass="boton_auxiliar boton guardar" cssStyle="width:auto;" value="Guardar"></s:submit></td>
                                                            </tr>
                                                        </tbody>  
                                                    </table>
                                                    <div class="row">
                                                        <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
                                                            <div class="enlaces">
                                                                <div class="tdsiguiente"><a href="siguienteEgresado.action"><img src="imagenes/next.png" width="21" height="21"></a></div>
                                                            </div>
                                                        </div>        
                                                    </div>       
                                                </div>
                                        </s:push>    
                                    </s:form>
                                </div>
                                <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div> 
        </div>          
    </body>
</html>