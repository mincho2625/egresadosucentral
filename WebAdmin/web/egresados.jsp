
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="/struts-json-tags" prefix="json" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="es">
    <head><title>Registro Sistema</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="estilo.css">
        <link rel="stylesheet" type="text/css" href="normalize.min.css">
        <link rel="stylesheet" type="text/css" href="bootstrap.min1.css">
        <link rel="stylesheet" type="text/css" href="font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="styles.css">
        <link rel="stylesheet" type="text/css" href="jce1.css">
        <s:head />
        <script type="text/javascript" src="jquery-ui.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/base.js"></script>
        <jq:head jqueryui="true"/>
        <script 
            language="JavaScript" 
            src="/struts2-jquery-showcase/struts/utils.js" 
            type="text/javascript">
        </script>
    </head>
    <body class="default">
        <div id="main" class="container" role="main">
            <div class="row">
                <aside>
                    <div id="system-message-container">
                    </div>
                </aside>
            </div>
            <div id="main-cuerpo">
                <div class="row contenido show">
                    <div style="width: 750px;margin-left: -15px" class="componente col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">
                        <s:set name="indice" value="indice"/>
                        <jq:accordion id="accordion" animate="true" collapsible="true" active="%{#indice}">
                            <jq:accordionItem title="Criterios de búsqueda">
                                <div class="row" class="col-lg-11 col-md-11 col-sm-11 col-xs-11">
                                    <s:form id="formCorreo">
                                        <s:url id="busquedaAvanzadaURL" action="BusquedaAvanzada"/>    
                                        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
                                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
                                                <br>

                                                <jq:checkboxlist cssStyle="width: 100px;" label="Nivel de estudios" errorPosition="bottom" name="seleccionNivelEstudios" 
                                                                 list="listaNivelesEstudios" onCompleteTopics="reloadThirdlist,reloadCriteria" buttonset="false"
                                                                 id="seleccionNivelEstudios" onChangeTopics="reloadThirdlist,reloadCriteria"></jq:checkboxlist>
                                                
                                                    A&ntilde;o Finalización:
                                                <jq:spinner cssStyle="width: 100px;" label="Desde" errorPosition="bottom" name="anioFinalizacionDesde"
                                                            onCompleteTopics="reloadCriteria" id="anioFinalizacionDesde" onChangeTopics="reloadCriteria"
                                                            min="1900" max="%{#actual}"></jq:spinner>

                                                <jq:spinner cssStyle="width: 100px;" label="Hasta" errorPosition="bottom" name="anioFinalizacionHasta"
                                                            onCompleteTopics="reloadCriteria" id="anioFinalizacionHasta" onChangeTopics="reloadCriteria"
                                                            min="1900" max="%{#actual}"></jq:spinner>

                                                <jq:checkboxlist cssStyle="width: 100px;" label="Género" errorPosition="bottom" name="seleccionGeneros" 
                                                                 list="listaGeneros" onCompleteTopics="reloadCriteria" buttonset="false"
                                                                 id="seleccionGeneros" onChangeTopics="reloadCriteria"></jq:checkboxlist>
                                                
                                                <jq:checkboxlist cssStyle="width: 100px;" label="Estado" errorPosition="bottom" name="seleccionEstados" 
                                                                 list="listaEstados" onCompleteTopics="reloadCriteria" buttonset="false"
                                                                 id="seleccionEstados" onChangeTopics="reloadCriteria"></jq:checkboxlist>

                                                </div>
                                                <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
                                                    <br>

                                                <jq:checkboxlist cssStyle="width: 100px;" label="Facultad" errorPosition="bottom" name="seleccionFacultades" 
                                                                 list="listaFacultades" onCompleteTopics="reloadThirdlist,reloadCriteria" buttonset="false"
                                                                 id="seleccionFacultades" onChangeTopics="reloadThirdlist,reloadCriteria"></jq:checkboxlist>

                                                <jq:checkboxlist cssStyle="width: 100px;" label="Programa" errorPosition="bottom" name="seleccionProgramas" buttonset="false"
                                                                 list="listaProgramas" onCompleteTopics="reloadCriteria" id="seleccionProgramas" onChangeTopics="reloadCriteria"
                                                                 href="%{busquedaAvanzadaURL}" formIds="formCorreo" reloadTopics="reloadThirdlist"></jq:checkboxlist>

                                                <jq:checkboxlist cssStyle="width: 100px;" label="Estado Civil" errorPosition="bottom" name="seleccionEstadosCiviles" 
                                                                 list="listaEstadosCiviles" onCompleteTopics="reloadCriteria" buttonset="false"
                                                                 id="seleccionEstadosCiviles" onChangeTopics="reloadCriteria"></jq:checkboxlist>

                                                </div>
                                            <s:if test="hasActionErrors()">
                                                <s:actionerror/>
                                            </s:if>

                                            <s:if test="hasActionMessages()">
                                                <s:actionmessage/>
                                            </s:if>
                                        </div>
                                        <div style="margin-left: -35px" class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
                                            <br>                                            
                                            <jq:select href="%{busquedaAvanzadaURL}" label="Criterios Seleccionados" readonly="true" formIds="formCorreo" multiple="true" 
                                                       cssStyle="height:230px;width: 200px;" rows="5"
                                                       selectable="false" reloadTopics="reloadCriteria" list="criterioSeleccionado"></jq:select>

                                                <div class="row" style="margin-left: -15px" class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
                                                    <div  class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
                                                        <jq:submit href="limpiarEgresados.action" cssClass="boton_auxiliar boton" cssStyle="width:auto;" value="Limpiar"></jq:submit>
                                                    </div>
                                                    <div style="margin-left: 75px" class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
                                                    <s:submit action="Egresados" method="buscar" cssClass="boton_auxiliar boton "  cssStyle="width:auto;" value="Buscar"></s:submit>
                                                    </div>

                                                <jq:dialog id="dialogColumnas" title="Seleccionar columnas" autoOpen="false" href="mostrarSelectorColumnas.action"
                                                           buttons="{ 'Guardar':function() { guardar(); },'Cancelar':function() { cerrar(); } }" modal="true">
                                                </jq:dialog>
                                                <jq:a openDialog="dialogColumnas">Columnas</jq:a>
                                                </div>
                                            </div>

                                    </s:form>
                                </div>
                            </jq:accordionItem>
                            <jq:accordionItem title="Resultados">
                                <div class="row" class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
                                    <s:form>
                                        <display:table class="tableFiltro table-striped table-bordered tabla_verde " requestURI="/buscarEgresados.action"
                                                       name="listaEgresados" pagesize="5" cellpadding="5px;" export="true" uid="row" 
                                                       cellspacing="5px;" style="margin-left:10px;margin-top:20px;width: 700px;font-size: 9px;">

                                            <display:setProperty name="export.csv.filename" value="Egresados.csv" />
                                            <display:setProperty name="export.excel.filename" value="Egresados.xlsx" />
                                            <display:setProperty name="export.xml.filename" value="Egresados.xml" />
                                            <display:setProperty name="export.pdf.filename" value="Egresados.pdf" />

                                            <display:column title="Seleccionar" media="html">
                                                <s:checkbox name="seleccionEgresados" fieldValue="%{#attr.row.egresado.idUsuario}" theme="simple"/>
                                            </display:column>
                                            
                                            <c:forEach items="${listaColumnas}" var="entry">
                                                <display:column title="${entry.value}" property="${entry.key}"></display:column>
                                            </c:forEach>

                                        </display:table>

                                        <div class="row" style="margin-left: -15px" class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
                                            <td><s:select label="Plantilla de correo" errorPosition="bottom" name="plantilla" list="listaPlantillas" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                                            <s:submit action="Egresados" method="enviarCorreo" cssClass="boton_auxiliar boton  guardar" cssStyle="width:auto;" value="Enviar correo"/>
                                        </div>

                                        <div class="row" style="margin-left: -15px" class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
                                            <s:submit action="Egresados" method="activar" cssClass="boton_auxiliar boton  guardar" cssStyle="width:auto;" value="Activar"/>
                                            <s:submit action="Egresados" method="inactivar" cssClass="boton_auxiliar boton  guardar" cssStyle="width:auto;" value="Inactivar"/>
                                        </div>

                                        <s:if test="hasActionErrors()">
                                            <div class="errors">
                                                <s:actionerror/>
                                            </div>
                                        </s:if>
                                    </s:form>
                                </div>
                            </jq:accordionItem>
                        </jq:accordion>
                    </div>    
                </div> 
            </div>          
    </body>
</html>