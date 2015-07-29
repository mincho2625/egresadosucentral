<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<html lang="es">
    <head><title>Datos de Ubicacion</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="estilo.css">
        <link rel="stylesheet" type="text/css" href="normalize.min.css">
        <link rel="stylesheet" type="text/css" href="bootstrap1.min.css">
        <link rel="stylesheet" type="text/css" href="font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="styles.css">
        <link rel="stylesheet" type="text/css" href="jce.css">
        <s:head />
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <jq:head jqueryui="true" />
        <script type="text/javascript">
            function otraRespuesta(checked, otro, idSelect, idTexfield)
            {
                if (checked) {
                    idSelect.disabled = true;
                    idTexfield.disabled = false;
                    otro.value = true;
                }
                else {
                    idSelect.disabled = false;
                    idTexfield.disabled = true;
                    otro.value = false;
                }
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
                    <div class="componente col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">
                        <br>
                        <div class="row" style="margin-left: 150px">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                <img style="text-align: center;width: 100px; height: 100px"src="imagenes/encuesta.jpg">
                            </div>
                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 ">
                                <h1 style="margin-left: -30px;color: #2a6155;width:300px">Encuesta</h1>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
                                <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
                                    <div class="encuesta" id="contenido1">
                                        <s:form action="siguienteEncuesta" method="POST">
                                            <s:hidden name="orden"></s:hidden>
                                            <s:hidden name="ultima"></s:hidden>
                                                <table style="width: 300px; margin-left: -180px">
                                                <s:iterator value="listaPreguntasEncuesta">
                                                    <tr>
                                                        <s:set name="tipoRespuesta" value="idTipoRespuesta.idTipoRespuesta"/>
                                                        <s:set name="idPregunta" value="idPreguntaEncuesta"/>
                                                        <s:set name="pregunta" value="pregunta"/>

                                                        <s:if test="listaRespuestasEncuesta.size > 0 && listaRespuestasEncuesta[0].idEgresadoRespuesta > 0">
                                                            <s:set name="nombre" value="idPreguntaEncuesta + '-' + listaRespuestasEncuesta[0].idEgresadoRespuesta"></s:set>
                                                        </s:if>
                                                        <s:else>
                                                            <s:set name="nombre" value="idPreguntaEncuesta"></s:set>
                                                        </s:else>
                                                        <td>
                                                            <s:if test="%{#tipoRespuesta==1}">
                                                                <s:if test="listaRespuestasEncuesta.size > 0">
                                                                    <s:set name="respuesta" value="listaRespuestasEncuesta[0].otra"/>
                                                                </s:if>
                                                                <s:textfield label="%{#pregunta}" name="%{#nombre}"  value="%{#respuesta}"></s:textfield>
                                                            </s:if>
                                                            <s:elseif test="%{#tipoRespuesta==2}">
                                                                <s:if test="listaRespuestasEncuesta.size > 0">
                                                                    <s:set name="respuesta" value="listaRespuestasEncuesta[0].idRespuestaEncuesta.idRespuestaEncuesta"/>
                                                                </s:if>
                                                                <s:select label="%{#pregunta}" name="%{#nombre}" list="listaPosiblesRespuestasEncuesta" listKey="idRespuestaEncuesta" listValue="respuesta" value="%{#respuesta}"></s:select>
                                                            </s:elseif>
                                                            <s:elseif test="%{#tipoRespuesta==3}">
                                                                <s:if test="listaRespuestasEncuesta.size > 0">
                                                                    <s:set name="respuesta" value="listaRespuestasEncuesta[0].otra"/>
                                                                </s:if>
                                                                <s:if test="%{#respuesta == null}">
                                                                    <s:select  label="%{#pregunta}" name="%{#nombre}" id="%{'pregunta' + #idPregunta}" list="listaPosiblesRespuestasEncuesta" listKey="idRespuestaEncuesta" listValue="respuesta" value="%{#respuesta}"></s:select>
                                                                    <s:checkbox  name="%{'otroPregunta' + #idPregunta}" id="%{'otroPregunta' + #idPregunta}" onchange="otraRespuesta(this.checked, %{'otroPregunta' + #idPregunta}, %{'pregunta' + #idPregunta}, %{'otraRespuesta' + #idPregunta});" label="Otro" value="false"></s:checkbox>
                                                                    <s:textfield  name="%{#nombre}" value="" id="%{'otraRespuesta' + #idPregunta}" disabled="true"></s:textfield>
                                                                    <s:else>
                                                                        <s:if test="listaRespuestasEncuesta.size > 0">
                                                                            <s:set name="respuesta" value="listaRespuestasEncuesta[0].idRespuestaEncuesta.idRespuestaEncuesta"/>
                                                                        </s:if>
                                                                        <s:select  label="%{#pregunta}" name="%{#nombre}" id="%{'pregunta' + #idPregunta}" list="listaPosiblesRespuestasEncuesta" listKey="idRespuestaEncuesta" listValue="respuesta"></s:select>
                                                                        <s:checkbox  name="%{'otroPregunta' + #idPregunta}" id="%{'otroPregunta' + #idPregunta}" onchange="otraRespuesta(this.checked, %{'otroPregunta' + #idPregunta}, %{'pregunta' + #idPregunta}, %{'otraRespuesta' + #idPregunta});" label="Otro" value="true"></s:checkbox>
                                                                        <s:textfield  name="%{#nombre}" value="" id="%{'otraRespuesta' + #idPregunta}" disabled="true" value="%{#respuesta}"></s:textfield>
                                                                    </s:else>
                                                                </s:if>
                                                            </s:elseif>
                                                            <s:elseif test="%{#tipoRespuesta==4}">
                                                                <s:if test="listaRespuestasEncuesta.size > 0">
                                                                    <s:set name="respuesta" value="listaRespuestasEncuesta[0].otra"/>
                                                                </s:if>
                                                                <div align="left">
                                                                    <s:radio  label="%{#pregunta}" name="%{#nombre}" list="{'Si','No'}" value="%{#respuesta}"/>
                                                                </div>
                                                            </s:elseif>
                                                            <s:elseif test="%{#tipoRespuesta==5}">
                                                                <s:if test="listaRespuestasEncuesta.size > 0">
                                                                    <s:set name="respuesta" value="listaRespuestasEncuesta"/>
                                                                </s:if>
                                                                <div align="left">
                                                                    <s:checkboxlist  label="%{#pregunta}" name="%{#nombre}" list="listaPosiblesRespuestasEncuesta" listKey="idRespuestaEncuesta" listValue="respuesta" value="%{#respuesta}"/>
                                                                </div>
                                                            </s:elseif>
                                                        </td>
                                                    </tr>
                                                </s:iterator>
                                            </table>
                                            <br>
                                            <br>
                                            <br>
                                            <br>
                                            <div class="enlaces">
                                                <s:if test="orden > 1">
                                                    <div class="tdatrasEncuesta"><s:submit cssClass="boton_auxiliar boton tdatrasEncuesta" cssStyle="width:auto;" value="Anterior" action="anteriorEncuesta" src="imagenes/atras.jpg" width="24" height="24"></s:submit></div>
                                                </s:if>
                                                <s:if test="orden == ultima">
                                                    <div class="tdsiguienteEncuesta"><s:submit cssClass="boton_auxiliar boton" cssStyle="width:auto;" value="Terminar" action="terminarEncuesta" src="imagenes/next.png" width="24" height="24"></s:submit></div>
                                                </s:if>
                                                <s:else>
                                                    <div class="tdsiguienteEncuesta"><s:submit cssClass="boton_auxiliar boton" cssStyle="width:auto;" value="Siguiente" src="imagenes/next.png" width="24" height="24"></s:submit></div>
                                                </s:else>
                                            </div>
                                        </s:form>
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