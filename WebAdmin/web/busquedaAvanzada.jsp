
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
                                    <s:form action="buscarBusquedaAvanzada.action" id="formCorreo">

                                        <s:url id="programaURL" action="SelectPrograma"/>    
                                        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
                                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
                                                <br>

                                                <jq:select cssStyle="width: 100px;" href="%{programaURL}" name="seleccionNivelEstudios" id="seleccionNivelEstudios"
                                                           list="listaNivelesEstudios" multiple="true"
                                                           label="Nivel de estudios" errorPosition="bottom" labelposition="top" onCompleteTopics="reloadThirdlist,reloadCriteria"
                                                           onChangeTopics="reloadThirdlist,reloadCriteria"/>

                                                <jq:select cssStyle="width: 100px;" href="%{programaURL}" label="Año Finalización" errorPosition="bottom" name="seleccionAnios" list="listaAnios" 
                                                           multiple="true" id="seleccionAnios" onCompleteTopics="reloadCriteria" onChangeTopics="reloadCriteria" formIds="formCorreo"></jq:select>

                                                <jq:select cssStyle="width: 100px;" href="%{programaURL}" label="Género" errorPosition="bottom" name="seleccionGeneros" list="listaGeneros" multiple="true"
                                                           id="seleccionGeneros" onCompleteTopics="reloadCriteria" onChangeTopics="reloadCriteria" formIds="formCorreo"></jq:select>


                                                <jq:select cssStyle="width: 100px;" href="%{programaURL}" label="Columnas" errorPosition="bottom" name="seleccionIdColumnas" 
                                                           multiple="true" value="%{seleccionIdColumnasTemp}" dataType="json" list="listaColumnas" 
                                                           id="seleccionIdColumnas" onCompleteTopics="reloadColumns" onChangeTopics="reloadColumns" formIds="formCorreo" ></jq:select>

                                                </div>
                                                <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
                                                    <br>
                                                <jq:select href="%{programaURL}" onChangeTopics="reloadThirdlist,reloadCriteria" name="seleccionFacultades" id="seleccionFacultades"
                                                           formIds="formCorreo" list="listaFacultades" multiple="true"
                                                           onCompleteTopics="reloadThirdlist,reloadCriteria" label="Facultad" errorPosition="bottom"/>

                                                <jq:select href="%{programaURL}" reloadTopics="reloadThirdlist" label="Programa" errorPosition="bottom"
                                                           name="seleccionProgramas" list="listaProgramas" id="seleccionProgramas" 
                                                           formIds="formCorreo" multiple="true" onCompleteTopics="reloadCriteria" onChangeTopics="reloadCriteria"/>

                                                <jq:select href="%{programaURL}" label="Estado Civil" errorPosition="bottom" name="seleccionEstadosCiviles" list="listaEstadosCiviles" 
                                                           labelposition="top" multiple="true" id="seleccionEstadosCiviles" onCompleteTopics="reloadCriteria" onChangeTopics="reloadCriteria"
                                                           formIds="formCorreo"></jq:select>
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
                                            <jq:select href="%{programaURL}" label="Criterios Seleccionados" readonly="true" formIds="formCorreo" multiple="true" 
                                                       cssStyle="height:230px;width: 200px;" rows="5" name="criterioSeleccionado"
                                                       selectable="false" reloadTopics="reloadCriteria" list="criterioSeleccionado"></jq:select>

                                            <jq:select href="%{programaURL}" label="Columnas Seleccionadas" readonly="true" formIds="formCorreo" multiple="true" 
                                                       cssStyle="height:230px;width: 200px;" rows="5" 
                                                       selectable="false" reloadTopics="reloadColumns" list="seleccionColumnas"></jq:select>


                                                <div class="row" style="margin-left: -15px" class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
                                                    <div  class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
                                                    <s:submit  cssClass="boton_auxiliar boton" cssStyle="width:auto;" value="Limpiar"></s:submit>
                                                    </div>
                                                    <div style="margin-left: 75px" class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
                                                    <s:submit  cssClass="boton_auxiliar boton "  cssStyle="width:auto;" value="Buscar"></s:submit>
                                                    </div>
                                                </div>
                                            </div>

                                    </s:form>
                                </div>
                            </jq:accordionItem>
                            <jq:accordionItem title="Resultados">
                                <div class="row" class="col-lg-9 col-md-9 col-sm-9 col-xs-9">

                                    <display:table class="tableFiltro table-striped table-bordered tabla_verde " requestURI="/buscarBusquedaAvanzada.action"
                                                   name="listaEgresados" pagesize="5" cellpadding="5px;" export="true"
                                                   cellspacing="5px;" style="margin-left:10px;margin-top:20px;width: 700px;font-size: 9px;">

                                        <display:setProperty name="export.csv.filename" value="Egresados.csv" />
                                        <display:setProperty name="export.excel.filename" value="Egresados.xlsx" />
                                        <display:setProperty name="export.xml.filename" value="Egresados.xml" />
                                        <display:setProperty name="export.pdf.filename" value="Egresados.pdf" />

                                        <display:column title="Seleccionar">
                                            <s:checkbox name="seleccionEgresados" fieldValue="%{#attr.listaEgresados.egresado.idUsuario}" theme="simple"/>
                                        </display:column>
                                        
                                        <c:forEach items="${seleccionColumnas}" var="entry">
                                            <display:column title="${entry.value}" property="${entry.key}"></display:column>
                                        </c:forEach>
                                        
                                    </display:table>
                                    
                                    <div class="row" style="margin-left: -15px" class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
                                        <td><s:select label="Plantilla de correo" errorPosition="bottom" name="plantilla" list="listaPlantillas" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                                        <a href="enviarCorreoBusquedaAvanzada.action" target="contenido">
                                            <button style="alignment-adjust: central" type="submit" class="boton_auxiliar boton" name="nuevo">
                                                Enviar correo
                                            </button>
                                        </a>
                                    </div>
                                </div>
                            </jq:accordionItem>
                        </jq:accordion>
                    </div>    
                </div> 
            </div>          
    </body>
</html>