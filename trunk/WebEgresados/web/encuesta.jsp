<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<html lang="es">
    <head>
        <title>Encuesta</title>
        <meta charset="utf-8"/>
        <link rel="stylesheet" href="estilo2.css">
        <script type="text/javascript">
            function otraRespuesta(checked, otro, idSelect, idTexfield)
            {
                if (checked) {
                    idSelect.disabled = true;
                    idTexfield.disabled = false;
                    otro.value = true;
                }
                else{
                    idSelect.disabled = false;
                    idTexfield.disabled = true;
                    otro.value = false;
                }
            }
        </script>
    </head>
    <body>
    <div class="TituloPrincipal" style="/* [disabled]margin-left:10px; */ font-size: 20px">
                <div align="center">Portal Egresados  Universidad Central</div>
            </div>
            <div class="titu">
                <p align="left"><img src="imagenes/document-open.png" width="107" height="94">		      <span class="titu2">a a a</span><img src="imagenes/logosimbolo-ucentral-v1-medium.png" width="273" height="62">  <span class="titu2">a asda </span>Encuesta</p>
            </div>
        <div class="encuesta" id="contenido1">
            <s:form action="guardarEncuesta.action" method="post">
                <s:hidden name="idEncuesta"></s:hidden>
                <s:hidden name="anterior"></s:hidden>
                <s:hidden name="siguiente"></s:hidden>
                <div class="fuente2"></div>
                <br>
                <table >
                    <s:iterator value="listaPreguntasEncuesta">
                        <tr>
                            <td>
                                <div>
                                <s:set name="tipoRespuesta" value="idTipoRespuesta.idTipoRespuesta"/>
                                <s:set name="idPregunta" value="idPreguntaEncuesta"/>
                                <s:set name="pregunta" value="pregunta"/>
                                
                                <s:if test="listaRespuestasEncuesta.size > 0 && listaRespuestasEncuesta[0].idEgresadoRespuesta > 0">
                                    <s:set name="nombre" value="idPreguntaEncuesta + '-' + listaRespuestasEncuesta[0].idEgresadoRespuesta"></s:set>
                                </s:if>
                                <s:else>
                                    <s:set name="nombre" value="idPreguntaEncuesta"></s:set>
                                </s:else>
                                </div>
                                <s:if test="%{#tipoRespuesta==1}">
                                    <s:if test="listaRespuestasEncuesta.size > 0">
                                        <s:set name="respuesta" value="listaRespuestasEncuesta[0].otra"/>
                                    </s:if>
                                    <s:textfield label="%{#pregunta}" name="%{#nombre}" cssClass="texfield" value="%{#respuesta}"></s:textfield>
                                </s:if>
                                <s:elseif test="%{#tipoRespuesta==2}">
                                    <s:if test="listaRespuestasEncuesta.size > 0">
                                        <s:set name="respuesta" value="listaRespuestasEncuesta[0].idRespuestaEncuesta.idRespuestaEncuesta"/>
                                    </s:if>
                                    <s:select cssClass="texfield" label="%{#pregunta}" name="%{#nombre}" list="listaPosiblesRespuestasEncuesta" listKey="idRespuestaEncuesta" listValue="respuesta" value="%{#respuesta}"></s:select>
                                </s:elseif>
                                <s:elseif test="%{#tipoRespuesta==3}">
                                    <s:if test="listaRespuestasEncuesta.size > 0">
                                        <s:set name="respuesta" value="listaRespuestasEncuesta[0].otra"/>
                                    </s:if>
                                    <s:if test="%{#respuesta == null}">
                                        <s:select cssClass="texfield" label="%{#pregunta}" name="%{#nombre}" id="%{'pregunta' + #idPregunta}" list="listaPosiblesRespuestasEncuesta" listKey="idRespuestaEncuesta" listValue="respuesta" value="%{#respuesta}"></s:select>
                                        <s:checkbox cssClass="texfield" name="%{'otroPregunta' + #idPregunta}" id="%{'otroPregunta' + #idPregunta}" onchange="otraRespuesta(this.checked, %{'otroPregunta' + #idPregunta}, %{'pregunta' + #idPregunta}, %{'otraRespuesta' + #idPregunta});" label="Otro" value="false"></s:checkbox>
                                        <s:textfield cssClass="texfield" name="%{#nombre}" value="" id="%{'otraRespuesta' + #idPregunta}" disabled="true"></s:textfield>
                                    <s:else>
                                        <s:if test="listaRespuestasEncuesta.size > 0">
                                            <s:set name="respuesta" value="listaRespuestasEncuesta[0].idRespuestaEncuesta.idRespuestaEncuesta"/>
                                        </s:if>
                                        <s:select cssClass="texfield" label="%{#pregunta}" name="%{#nombre}" id="%{'pregunta' + #idPregunta}" list="listaPosiblesRespuestasEncuesta" listKey="idRespuestaEncuesta" listValue="respuesta"></s:select>
                                        <s:checkbox cssClass="texfield" name="%{'otroPregunta' + #idPregunta}" id="%{'otroPregunta' + #idPregunta}" onchange="otraRespuesta(this.checked, %{'otroPregunta' + #idPregunta}, %{'pregunta' + #idPregunta}, %{'otraRespuesta' + #idPregunta});" label="Otro" value="true"></s:checkbox>
                                        <s:textfield cssClass="texfield" name="%{#nombre}" value="" id="%{'otraRespuesta' + #idPregunta}" disabled="true" value="%{#respuesta}"></s:textfield>
                                    </s:else>
                                    </s:if>
                                </s:elseif>
                                <s:elseif test="%{#tipoRespuesta==4}">
                                    <s:if test="listaRespuestasEncuesta.size > 0">
                                        <s:set name="respuesta" value="listaRespuestasEncuesta[0].otra"/>
                                    </s:if>
                                    <div align="left">
                                        <s:radio cssClass="texfield" label="%{#pregunta}" name="%{#nombre}" list="{'Si','No'}" value="%{#respuesta}"/>
                                    </div>
                                </s:elseif>
                                <s:elseif test="%{#tipoRespuesta==5}">
                                    <s:if test="listaRespuestasEncuesta.size > 0">
                                        <s:set name="respuesta" value="listaRespuestasEncuesta"/>
                                    </s:if>
                                    <div align="left">
                                        <s:checkboxlist cssClass="texfield" label="%{#pregunta}" name="%{#nombre}" list="listaPosiblesRespuestasEncuesta" listKey="idRespuestaEncuesta" listValue="respuesta" value="%{#respuesta}"/>
                                    </div>
                                </s:elseif>
                            </td>
                        </tr>
                    </s:iterator>
                    <tr>
                    <s:submit cssClass="center1" value="Guardar"></s:submit>
                    </tr>
                </table>
            </s:form>
        </div>
    </body>
</html>