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
                        <div class="row" style="margin-left: 150px">
                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 ">
                                <h1 style="margin-left: 70px;color: #2a6155;width:300px">Egresados</h1>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">
                                <div class="col-lg-11 col-md-11 col-sm-11 col-xs-11">
                                    <div id="div4">
                                        <table rules="all" class="table table-striped table-bordered tabla_verde" style="width: 690px;">
                                            <thead>
                                                <tr>
                                                    <th>Nombres</th>
                                                    <th>Primer<br> Apellido</th>
                                                    <th>Segundo<br> Apellido</th>
                                                    <th>Género</th>
                                                    <th>Tipo<br> Documento</th>
                                                    <th>Número <br>Documento</th>
                                                    <th>Estado</th>
                                                    <th>Acción</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <s:iterator value="listaEgresados">
                                                    <tr>
                                                        <td><s:property value="nombres"></s:property></td>
                                                        <td><s:property value="primerApellido"></s:property></td>
                                                        <td><s:property value="segundoApellido"></s:property></td>
                                                        <td><s:property value="idGenero.nombre"></s:property></td>
                                                        <td><s:property value="idTipoDocumento.nombre"></s:property></td>
                                                        <td><s:property value="numeroDocumento"></s:property></td>
                                                        <td><s:property value="estado"></s:property></td>
                                                        <td>
                                                        <s:if test="estado">
                                                            <s:url id="inactivarURL" action="inactivarEgresados.action">
                                                                <s:param name="idEgresado" value="%{idUsuario}" ></s:param>
                                                            </s:url>
                                                            <s:a href="%{inactivarURL}">Inactivar</s:a>
                                                        </s:if>
                                                        <s:else>
                                                            <s:url id="activarURL" action="activarEgresados.action">
                                                                <s:param name="idEgresado" value="%{idUsuario}" ></s:param>
                                                            </s:url>
                                                            <s:a href="%{activarURL}">Activar</s:a>
                                                        </s:else>
                                                        </td>
                                                        </tr>
                                                </s:iterator>
                                            </tbody>
                                        </table>
                                    </div>
                                    <s:if test="hasActionErrors()">
                                        <div class="errors">
                                            <s:actionerror/>
                                        </div>
                                    </s:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div> 
        </div>          
    </body>
</html>