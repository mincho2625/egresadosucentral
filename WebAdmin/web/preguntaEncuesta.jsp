<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<html lang="es">
    <head><title>Pregunta Encuesta</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="estilo.css">
        <link rel="stylesheet" type="text/css" href="normalize.min.css">
        <link rel="stylesheet" type="text/css" href="bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="bootstrap-table.css">
        <link rel="stylesheet" type="text/css" href="font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="styles.css">
        <link rel="stylesheet" type="text/css" href="jce.css">

        <s:head />
        <jq:head jqueryui="true" />
        <script src="jquery.min.js"></script>
        <script src="bootstrap.min.js"></script>
        <script src="bootstrap-table.js"></script>
        <script src="jquery.dataTables.min.js"></script>

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
                                <h1 style="margin-left: 70px;color: #2a6155;width:300px" >Preguntas Encuesta</h1>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">
                                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                    <s:if test="buscar">
                                        <s:form action="buscarPreguntasEncuestas.action" enctype="multipart/form-data" method="POST">
                                            <h3 style="margin-left:280px;color: #2a6155;width:300px" >ID Encuesta a buscar</h3>    
                                            <table style="margin-left: 200px;width: 300px; page: 5">
                                                <tr>
                                                    <td><td><s:textfield type="number" label="ID encuesta" name="numEncuesta"></s:textfield></td></td>
                                                        <td></td>
                                                    </tr>
                                                </table>
                                            <s:submit cssClass="boton_auxiliar" cssStyle="width:100px;margin-left: 330px;" value="Buscar"></s:submit>
                                        </s:form>
                                        <br>
                                    </s:if>    
                                    <s:if test="buscar">
                                        <div id="div1">
                                            <s:if test="hasActionErrors()">
                                                <div class="errors">
                                                    <s:actionerror/>
                                                </div>
                                            </s:if>
                                            <s:form>
                                                <display:table class="table table-striped table-bordered tabla_verde" style="width: 700px;"
                                                               name="listaObjetos" pagesize="5" cellspacing="5px;"  cellpadding="5px;" uid="row" requestURI="/obtenerListaPreguntaEncuestaPreguntasEncuestas.action">
                                                    <display:column property="idPreguntaEncuesta" title="Id pregunta" sortable="true"/>
                                                    <display:column property="idEncuesta.idEncuesta" title="Id Encuesta" sortable="true"/>
                                                    <display:column style="width: 200px;" property="pregunta" title="Pregunta" sortable="true"/>
                                                    <display:column property="estado" title="Estado" sortable="true"/>
                                                    <display:column property="orden" title="Orden" sortable="true"/>
                                                    <display:column title="Acción">
                                                        <s:url id="editarURL" action="editarPreguntaPreguntasEncuestas.action">
                                                            <s:param name="idObjeto" value="%{#attr.row.idPreguntaEncuesta}" ></s:param>
                                                        </s:url>
                                                        <s:a href="%{editarURL}">
                                                            <img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/editar-icono-8419-16.png" align="top">
                                                        </s:a>
                                                        <s:url id="borrarURL" action="cambiarEstadoPreguntasEncuestas.action">
                                                            <s:param name="idObjeto" value="%{#attr.row.idPreguntaEncuesta}"></s:param>
                                                            <s:param name="idObjeto1" value="%{#attr.row.estado}"></s:param>
                                                        </s:url>
                                                        <s:a href="%{borrarURL}">
                                                            <img style="width: 20px; height: 19px;" title="Activar o Inabihilar" alt="Activar o Inabihilar" src="imagenes/activar.png" align="top">
                                                        </s:a>
                                                        <s:url id="consultarURL" action="cargarRespuestaRespuestasEncu.action">
                                                            <s:param name="idObjeto" value="%{#attr.row.idPreguntaEncuesta}"></s:param>
                                                        </s:url>
                                                        <s:a href="%{consultarURL}">
                                                            <img style="width: 20px; height: 19px;" title="Consultar preguntas" alt="Consultar preguntas" src="imagenes/activar.png" align="top">
                                                        </s:a> 
                                                    </display:column>
                                                </display:table>
                                            </s:form>
                                        </div>        
                                        <div class="fromtables" style="margin-left: 250px; width: 220px">
                                            <a href="crearPreguntaPreguntasEncuestas.action" target="contenido">
                                                <button style="alignment-adjust: central" type="submit" class="boton_auxiliar boton" name="nuevo">
                                                    Ingresar pregunta
                                                </button>
                                            </a>
                                        </div>
                                    </s:if>          
                                    <div class="fromtables" id="contenido1" >
                                        <s:if test="editar">
                                            <h3 style="margin-left: 250px;width: 600px">Generar Nuevo Registro</h3>
                                            <s:form action="guardarPreguntaPreguntasEncuestas.action"  enctype="multipart/form-data" method="POST">
                                                <s:push value="objeto">
                                                    <s:hidden name="idPreguntaEncuesta"></s:hidden>
                                                        <table style="margin-left: 200px;width: 300px">
                                                            <tr>
                                                                <td><s:textfield label="Pregunta" name="pregunta" disabled="true"></s:textfield></td>
                                                            </tr>
                                                            <tr>    
                                                                <td><s:checkbox label="Obligatoria" name="obligatoria"></s:checkbox></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:textfield type="number" label="orden" name="orden"></s:textfield></td>
                                                            </tr>
                                                            <tr>
                                                                <td></td>
                                                                <td><s:actionerror></s:actionerror></td>
                                                            </tr>
                                                            <tr>
                                                                <td></td>
                                                                <td><s:submit  cssClass="boton_auxiliar" cssStyle="width:auto;" value="Guardar"></s:submit></td>
                                                            </tr>
                                                        </table>
                                                </s:push>
                                            </s:form>
                                        </s:if>
                                        <s:if test="crear">
                                            <h3 style="margin-left: 250px;width: 600px">Generar Nuevo Registro</h3>
                                            <s:form action="llenarPreguntasEncuestas.action" enctype="multipart/form-data" method="POST">
                                                <s:push value="objeto">
                                                    <s:hidden name="idPreguntaEncuesta"></s:hidden>
                                                        <table style="margin-left: 200px;width: 300px">
                                                            <tr>
                                                                <td><s:textfield label="Pregunta" name="pregunta"></s:textfield></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:select label="Tipo pregunta" errorPosition="bottom" name="respuesta" list="listaTipoPregunta" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione - "/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><s:checkbox label="Obligatoria" name="obligatoria"></s:checkbox></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:textfield type="number" label="orden" name="orden"></s:textfield></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:select label="Encuesta" errorPosition="bottom" name="encuesta" list="ListaIdEncuesta" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione - "/></td>
                                                        </tr>
                                                        <tr>
                                                            <td></td>
                                                            <td><s:actionerror></s:actionerror></td>
                                                            </tr>
                                                            <tr>
                                                                <td></td>
                                                                <td><s:submit  cssClass="boton_auxiliar" cssStyle="width:auto;" value="Guardar"></s:submit></td>
                                                            </tr>
                                                        </table>
                                                </s:push>
                                            </s:form>
                                        </s:if>
                                        <s:if test="consultar1">
                                            <div id="div1">
                                                <s:form cssStyle="margin-left: 100px">
                                                    <display:table class="table table-striped table-bordered tabla_verde" style="width: 500px"
                                                                   name="listaObjetos" pagesize="5" cellspacing="5px;"  cellpadding="5px;" uid="row" requestURI="/cargarRespuestaRespuestasEncu.action">
                                                        <display:column property="idRespuestaEncuesta" title="Id Respuesta" sortable="true"/>
                                                        <display:column property="respuesta" title="Respuesta" sortable="true"/>
                                                        <display:column property="estado" title="Estado" sortable="true"/>
                                                        <display:column property="orden" title="Orden" sortable="true"/>
                                                    </display:table>
                                                </s:form>
                                            </div>            
                                            <br>
                                            <a href="obtenerListaPreguntaEncuestaPreguntasEncuestas.action" target="contenido"><button Style="margin-left:320px; width: auto" Class="boton_auxiliar">Volver</button></a>            
                                        </div>
                                    </s:if>
                                </div>
                            </div>
                            <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
        <script>
            var $table = $('#table');
            $(function () {
            });
        </script>
    </body>
</html>