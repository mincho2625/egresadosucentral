<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<html lang="es">
    <head><title>Datos de Ubicacion</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="estilo.css">
        <link rel="stylesheet" type="text/css" href="normalize.min.css">
        <link rel="stylesheet" type="text/css" href="bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="styles.css">
        <link rel="stylesheet" type="text/css" href="jce.css">
        <s:head />
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <jq:head jqueryui="true" />
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
                    <div class="componente col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">
                        <div class="row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                <img src="imagenes/logosimbolo-ucentral-v1-medium.png">
                            </div>
                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 ">
                                <h1 style="margin-left: 70px;color: #2a6155;width:300px" >Cargue Masivo de Estudiantes</h1>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
                                <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
                                    <div class="fromtables" id="contenido1">
                                        <h3 style="margin-left: 50px;width: 400px">Generar Nuevo Registro</h3>
                                        <s:form action="ejecutarCargueMasivo.action" enctype="multipart/form-data" method="POST">
                                            <table style="margin-left: -50px;width: 500px">
                                                <tr>
                                                    <td><s:file errorPosition="bottom" name="fileUpload" id="fileUpload" label="Archivo"></s:file></td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                    <s:submit cssClass="boton_auxiliar boton guardar" cssStyle="width:auto;" value="Enviar"></s:submit>
                                                    </td>
                                                </tr>
                                                </table>
                                        </s:form>
                                    </div>
                                    <s:if test="hasActionErrors()">
                                        <div class="errors">
                                            <s:actionerror/>
                                        </div>
                                    </s:if>
                                    <s:if test="hasActionMessages()">
                                        <div class="errors">
                                            <s:actionmessage/>
                                        </div>
                                    </s:if>
                                    <div id="div5" style="margin-left: -150px">
                                        <table rules="all" class="table table-striped table-bordered tabla_verde" style="width: 690px">
                                            <thead>
                                                <tr>
                                                    <th style="width: 100px">Id Proceso</th>
                                                    <th style="width: 100px">Fecha Inicio</th>
                                                    <th style="width: 100px">Fecha Fin</th>
                                                    <th style="width: 150px">Estado</th>
                                                    <th>Error</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <s:iterator value="listaProcesos">
                                                    <tr>
                                                        <td><s:property value="idProcesoCargue"></s:property></td>
                                                        <td><s:property value="fechaInicio"></s:property></td>
                                                        <td><s:property value="fechaFin"></s:property></td>
                                                        <td><s:property value="idEstadoProceso.nombre"></s:property></td>
                                                        <td><s:property value="error"></s:property></td>
                                                        </tr>
                                                </s:iterator>
                                            </tbody>
                                        </table>
                                    </div>
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