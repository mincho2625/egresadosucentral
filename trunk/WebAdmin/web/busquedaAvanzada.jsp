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
                    <jq:accordion id="accordion" heightStyle="componente col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block" animate="true" collapsible="true">
                        <jq:accordionItem title="Criterio de búsqueda">
                            <s:form action="buscarBusquedaAvanzada.action" id="formCorreo">
                                <s:url id="programaURL" action="SelectPrograma"/>
                                <div class="item-page">
                                    <br>
                                    <table style="alignment-adjust: central; width: 550px;margin-left: -40px">
                                        <tr>
                                            <td><jq:select href="%{programaURL}" name="seleccionNivelEstudios" id="seleccionNivelEstudios"
                                                       list="listaNivelesEstudios" listKey="id" listValue="nombre" multiple="true"
                                                       label="Nivel de estudios" errorPosition="bottom" labelposition="top" onCompleteTopics="reloadThirdlist,reloadCriteria"
                                                       onChangeTopics="reloadThirdlist,reloadCriteria" name="seleccionNivelEstudios" id="seleccionNivelEstudios"/></td>
                                        </tr>
                                        <tr>
                                            <td><jq:select href="%{programaURL}" onChangeTopics="reloadThirdlist,reloadCriteria" name="seleccionFacultades" id="seleccionFacultades"
                                                       formIds="formCorreo" list="listaFacultades" listKey="id" listValue="nombre" multiple="true"
                                                       onCompleteTopics="reloadThirdlist,reloadCriteria" label="Facultad" errorPosition="bottom"/></td>
                                        </tr>
                                        <tr>
                                            <td><jq:select href="%{programaURL}" reloadTopics="reloadThirdlist" label="Programa" errorPosition="bottom"
                                                       name="seleccionProgramas" list="listaProgramas" listKey="id" listValue="nombre" id="seleccionProgramas" 
                                                       formIds="formCorreo" multiple="true" onCompleteTopics="reloadCriteria" onChangeTopics="reloadCriteria"/></td>
                                            
                                            <td><s:select label="Estado Civil" errorPosition="bottom" name="seleccionEstadosCiviles" list="listaEstadosCiviles" 
                                                       listKey="id" listValue="nombre" labelposition="top" multiple="true"></s:select></td>
                                            </tr>
                                            <tr>
                                                <td><s:select label="Año Finalización" errorPosition="bottom" name="seleccionAnios" list="listaAnios" multiple="true"></s:select></td>
                                            </tr>
                                            <tr>
                                                <td><s:select label="Género" errorPosition="bottom" name="seleccionGeneros" list="listaGeneros" listKey="id" listValue="nombre" multiple="true"></s:select></td>
                                            </tr>
                                            <tr>
                                            <jq:textarea href="%{programaURL}" label="Criterio seleccionado" readonly="true" resizable="false" formIds="formCorreo" dataType="json"
                                                         rows="5" selectable="false" reloadTopics="reloadCriteria" name="criterioSeleccionado" id="criterioSeleccionado"></jq:textarea>
                                            </tr>
                                        <s:if test="hasActionErrors()">
                                            <tr>
                                                <s:actionerror/>
                                            </tr>
                                        </s:if>

                                        <s:if test="hasActionMessages()">
                                            <tr>
                                                <s:actionmessage/>
                                            </tr>
                                        </s:if>
                                        <tr>
                                            <td></td>
                                            <td><s:submit  cssClass="boton_auxiliar boton guardar" cssStyle="width:auto;" value="Buscar"></s:submit></td>
                                            </tr>
                                        </table>
                                    </div>
                            </s:form>
                        </jq:accordionItem>
                        <jq:accordionItem title="Resultados">
                            <display:table id="egresados" name="listaEgresados" pagesize="5" cellpadding="5px;"
                                cellspacing="5px;" style="margin-left:50px;margin-top:20px;" requestURI="">
                                <display:column property="nombres" title="Nombres"/>
                                <display:column property="primerApellido" title="Primer apellido"/>
                                <display:column property="segundoApellido" title="Segundo apellido"/>
                                <display:column property="numeroDocumento" title="Documento"/>
                            </display:table>
                        </jq:accordionItem>
                    </jq:accordion>
                </div> 
            </div>          
    </body>
</html>