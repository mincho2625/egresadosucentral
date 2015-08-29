<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
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
                            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
                                <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
                                    <div class="fromtables" id="contenido1">
                                        <h3 style="margin-left: 50px;width: 400px">Carge masivo de Egresados</h3>
                                        <s:form action="ejecutarCargueMasivo.action" enctype="multipart/form-data" method="POST">
                                            <table style="margin-left: -50px;width: 300px; page: 5">
                                                <tr>
                                                    <td><s:file errorPosition="bottom" name="fileUpload" id="fileUpload" label="Archivo" cssStyle="width:auto;"></s:file></td>
                                                        <td></td>
                                                    </tr>
                                                </table>
                                            <s:submit cssClass="boton_auxiliar" cssStyle="width:100px;margin-left: 120px;" value="Enviar"></s:submit>
                                        </s:form>
                                        <br>
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
                                        <table class="table table-striped table-bordered tabla_verde" style="width: 690px">
                                            <thead>
                                                <tr>
                                                    <th style="width: 100px">Id Proceso</th>
                                                    <th style="width: 100px">Fecha Inicio</th>
                                                    <th style="width: 100px">Fecha Fin</th>
                                                    <th style="width: 150px">Estado</th>
                                                    <th>Error</th>
                                                    <th></th>
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
                                                        <td>
                                                                <s:url id="export" action="exportarCargueMasivo.action">
                                                                    <s:param name="idObjeto" value="%{idProcesoCargue}"></s:param>
                                                                </s:url>
                                                                <s:a href="%{export}">
                                                                    <img style="width: 20px; height: 19px;" title="Exportar" alt="Exportar" src="imagenes/excel.png" align="top">
                                                                </s:a>
                                                        </td>         
                                                    </tr>
                                                </s:iterator>
                                            </tbody>
                                        </table>
                                    </div>
                                    <br>
                                    <a href="desplegarCargueMasivo.action" target="contenido"><li Style="margin-left: 80px; width: 150px" Class="boton_auxiliar">Actualizar Pagina</li></a>
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