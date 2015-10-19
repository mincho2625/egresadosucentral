<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<html lang="es">
    <head><title>aa</title>
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
                        <div class="row" style="margin-left: 100px">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                <img src="imagenes/logosimbolo-ucentral-v1-medium.png">
                            </div>
                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 ">
                                <h1 style="margin-left: 70px;color: #2a6155;width:300px">Consulta Educacion Formal Otras <br> Institución</h1>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block"> 
                                <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5"> 
                                    <div id="div6" style="margin-left: 40px">
                                        <s:form>
                                            <display:table class="table table-striped table-bordered tabla_verde " style="width: 600px;height: auto" export="true"
                                                           name="listaObjetos" pagesize="5" cellspacing="5px;"  cellpadding="5px;" uid="row" requestURI="/generarListaEducacionFormalOtrasInsti.action">
                                                <display:column property="idCiudad.nombre" title="Ciudad" sortable="true"/>
                                                <display:column property="idInstitucion.nombre" title="Institucion" sortable="true"/>
                                                <display:column property="anioFinalizacion" sortable="true" title="Año Finalizacion"/>
                                                <display:column property="idEstadoEducacion.nombre" title="Estado" sortable="true"/>
                                                <display:column property="numeroDocumento" title="Documento Egresado" sortable="true"/>

                                                <display:setProperty name="export.csv.filename" value="EducacionFormalOtrasInstitucion.csv" />
                                                <display:setProperty name="export.excel.filename" value="EducacionFormalOtrasInstitucion.xlsx" />
                                                <display:setProperty name="export.xml.filename" value="EducacionFormalOtrasInstitucion.xml" />
                                                <display:setProperty name="export.pdf.filename" value="EducacionFormalOtrasInstitucion.pdf" />
                                            </display:table>
                                        </s:form>
                                    </div>          
                                    <br>            
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