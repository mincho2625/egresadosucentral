<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<html lang="es">
    <head>
        <title>Encuesta</title>
        <meta charset="utf-8"/>
        <link rel="stylesheet" href="estilo.css">
        <script type="text/javascript">
            function otraRespuesta(otro, idSelect, idTexfield)
            {
                if (otro) {
                    idSelect.disabled = true;
                    idTexfield.disabled = false;
                }
                else{
                    idSelect.disabled = false;
                    idTexfield.disabled = true;
                }
            }
        </script>
    </head>
    <body>
        <div id="contenido1">            
            <s:form action="guardarEncuesta.action"> 
                <div class="tdun">Generar Nuevo Registro</div>
                <br>
                <table >
                    <s:iterator value="listaPreguntasEncuesta">
                        <tr>
                            <td>
                                <div class="tduno"><s:property value="pregunta"></s:property></div>
                                <s:set name="tipoRespuesta" value="idTipoRespuesta.idTipoRespuesta"/>
                                <s:set name="idPregunta" value="idPreguntaEncuesta"/>
                                
                                <s:if test="%{#tipoRespuesta==1}">
                                    <s:textfield name="%{#idPregunta}" cssClass="center" value=""></s:textfield>
                                </s:if>
                                <s:elseif test="%{#tipoRespuesta==2}">
                                    <s:select name="%{#idPregunta}" list="listaRespuestasEncuesta" listKey="idRespuestaEncuesta" listValue="respuesta"></s:select>
                                </s:elseif>
                                <s:elseif test="%{#tipoRespuesta==3}">
                                    <s:select name="%{#idPregunta}" id="%{'pregunta' + #idPregunta}" list="listaRespuestasEncuesta" listKey="idRespuestaEncuesta" listValue="respuesta"></s:select>
                                    <s:checkbox name="%{'otroPregunta' + #idPregunta}"  onchange="otraRespuesta(this.checked, %{'pregunta' + #idPregunta}, %{'otraRespuesta' + #idPregunta});" label="Otro"></s:checkbox>
                                    <s:textfield name="%{#idPregunta}" id="%{'otraRespuesta' + #idPregunta}" disabled="true"></s:textfield>
                                </s:elseif>
                                <s:elseif test="%{#tipoRespuesta==4}">
                                    <s:radio name="%{#idPregunta}" list="{'Si','No'}" />
                                </s:elseif>
                                <s:elseif test="%{#tipoRespuesta==5}">
                                    <s:checkboxlist name="%{#idPregunta}" list="listaRespuestasEncuesta" listKey="idRespuestaEncuesta" listValue="respuesta"/>
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