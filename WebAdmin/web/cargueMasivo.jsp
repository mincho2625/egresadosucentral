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
                                        <s:form >
                                            <display:table class="table table-striped table-bordered tabla_verde" style="width: 690px" export="true"
                                                           name="listaProcesos" pagesize="5" cellspacing="5px;"  cellpadding="5px;" uid="row" requestURI="/desplegarCargueMasivo.action">
                                                
                                                <display:column property="idProcesoCargue" title="Id Proceso" sortable="true"/>
                                                <display:column property="fechaInicio" format="{0,date,dd-MM-yyyy}" title="Fecha Inicio" sortable="true"/>
                                                <display:column property="fechaFin" format="{0,date,dd-MM-yyyy}" title="Fecha Fin" sortable="true"/>
                                                <display:column property="idEstadoProceso.nombre" title="Estado" sortable="true"/>
                                                <display:column property="error" title="Error" sortable="true"/>
                                                <display:column title="Acción">
                                                    <s:url id="export" action="exportarCargueMasivo.action">
                                                        <s:param name="idObjeto" value="%{#attr.row.idProcesoCargue}"></s:param>
                                                    </s:url>
                                                    <s:a href="%{export}">
                                                        <img style="width: 20px; height: 19px;" title="Exportar log del cargue" alt="Exportar log del cargue" src="imagenes/excel.png" align="top">
                                                    </s:a>
                                                </display:column>
                                                        
                                                <display:setProperty name="export.csv.filename" value="CargueMasivo.csv" />
                                                <display:setProperty name="export.excel.filename" value="CargueMasivo.xlsx" />
                                                <display:setProperty name="export.xml.filename" value="CargueMasivo.xml" />
                                                <display:setProperty name="export.pdf.filename" value="CargueMasivo.pdf" />
                                                
                                            </display:table>
                                        </s:form>
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