<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
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
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/111.0/jquery.min.js"></script>
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
                    <div style="width: 750px;" class="componente col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">
                        <jq:accordion id="accordion" animate="true" collapsible="true">
                            <jq:accordionItem title="Criterios de búsqueda">
                                <div class="row" class="col-lg-11 col-md-11 col-sm-11 col-xs-11">
                                    <s:form action="buscarBusquedaAvanzada.action" id="formCorreo">
                                        <s:url id="programaURL" action="SelectPrograma"/>    
                                        <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
                                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                                <jq:select href="%{programaURL}" name="seleccionNivelEstudios" id="seleccionNivelEstudios"
                                                           list="listaNivelesEstudios" listKey="id" listValue="nombre" multiple="true"
                                                           label="Nivel de estudios" errorPosition="bottom" labelposition="top" onCompleteTopics="reloadThirdlist,reloadCriteria"
                                                           onChangeTopics="reloadThirdlist,reloadCriteria" name="seleccionNivelEstudios" id="seleccionNivelEstudios"/>
                                                <s:select label="Año Finalización" errorPosition="bottom" name="seleccionAnios" list="listaAnios" multiple="true"></s:select>
                                                <s:select label="Género" errorPosition="bottom" name="seleccionGeneros" list="listaGeneros" listKey="id" listValue="nombre" multiple="true"></s:select>
                                                </div>
                                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                                <jq:select href="%{programaURL}" onChangeTopics="reloadThirdlist,reloadCriteria" name="seleccionFacultades" id="seleccionFacultades"
                                                           formIds="formCorreo" list="listaFacultades" listKey="id" listValue="nombre" multiple="true"
                                                           onCompleteTopics="reloadThirdlist,reloadCriteria" label="Facultad" errorPosition="bottom"/>
                                                <jq:select href="%{programaURL}" reloadTopics="reloadThirdlist" label="Programa" errorPosition="bottom"
                                                           name="seleccionProgramas" list="listaProgramas" listKey="id" listValue="nombre" id="seleccionProgramas" 
                                                           formIds="formCorreo" multiple="true" onCompleteTopics="reloadCriteria" onChangeTopics="reloadCriteria"/>
                                                <s:select label="Estado Civil" errorPosition="bottom" name="seleccionEstadosCiviles" list="listaEstadosCiviles" 
                                                          listKey="id" listValue="nombre" labelposition="top" multiple="true"></s:select>
                                                </div>
                                            <s:if test="hasActionErrors()">
                                                <s:actionerror/>
                                            </s:if>

                                            <s:if test="hasActionMessages()">
                                                <s:actionmessage/>
                                            </s:if>
                                        </div>
                                        <div style="margin-left: -35px" class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
                                            <jq:textarea href="%{programaURL}" label="Criterios Seleccionados" readonly="true" resizable="false" formIds="formCorreo" dataType="json"
                                                         cssStyle="height:330px;width: 200px;" rows="5" selectable="false" reloadTopics="reloadCriteria" name="criterioSeleccionado" id="criterioSeleccionado"></jq:textarea>
                                                <div class="row" style="margin-left: -35px" class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
                                                    <div  class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
                                                    <s:submit  cssClass="boton_auxiliar boton"  cssStyle="width:auto;" value="Limpar"></s:submit>
                                                    </div>
                                                    <div style="margin-left: 65px" class="col-lg-1 col-md-1 col-sm-1 col-xs-1">
                                                        <s:submit  cssClass="boton_auxiliar boton "  cssStyle="width:auto;" value="Buscar"></s:submit>
                                                    </div>
                                                </div>
                                            </div>
                                    </s:form>
                                </div>
                            </jq:accordionItem>
                            <jq:accordionItem title="Resultados">
                                <div class="row" class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
                                    <display:table class="tableFiltro table-striped table-bordered tabla_verde " id="egresados" name="listaEgresados" pagesize="5" cellpadding="5px;"
                                                   cellspacing="5px;" style="margin-left:50px;margin-top:20px;" requestURI="" >
                                        <display:column property="nombres" title="Nombres"/>
                                        <display:column property="primerApellido" title="Primer apellido"/>
                                        <display:column property="segundoApellido" title="Segundo apellido"/>
                                        <display:column property="numeroDocumento" title="Documento"/>
                                    </display:table>
                                </div>
                            </jq:accordionItem>
                        </jq:accordion>
                    </div>    
                </div> 
            </div>          
    </body>
</html>