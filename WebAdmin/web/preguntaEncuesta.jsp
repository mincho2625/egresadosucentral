<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<html lang="es">
    <head><title>Pregunta Encuesta</title>
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
                                <h1 style="margin-left: 70px;color: #2a6155;width:300px" >Preguntas Encuesta</h1>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">
                                <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
                                    <div id="div1">
                                       <table rules="all" class="table table-striped table-bordered tabla_verde" style="width: 1000px; margin-left: -300px">
                                            <thead>
                                                <tr>
                                                    <th style="width: auto">Id pregunta</th>
                                                    <th style="width: 90px">Id Encuesta</th>
                                                    <th style="width: 340px">Pregunta</th>
                                                    <th style="width: 60px">Estado </th>
                                                    <th style="width: 90px">Obligatorio</th>
                                                    <th style="width: 60px">Orden</th>
                                                    <th style="width: 60px">Opción</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <s:hidden name="cantidadObjetos"></s:hidden>
                                                <s:iterator value="listaObjetos">
                                                    <tr>
                                                        <td><s:property value="idPreguntaEncuesta"></s:property></td>
                                                        <td><s:property value="idEncuesta.idEncuesta"></s:property></td>
                                                        <td><s:property value="pregunta"></s:property></td>
                                                        <td><s:property value="estado == 1?activo:inactivo"></s:property></td>
                                                        <td><s:property value="obligatoria == 1?si:no"></s:property></td>
                                                        <td><s:property value="orden"></s:property></td>
                                                            <td>
                                                            <s:url id="editarURL" action="editarPreguntaPreguntasEncuestas.action">
                                                                <s:param name="idObjeto" value="%{idPreguntaEncuesta}" ></s:param>
                                                            </s:url>
                                                            <s:a href="%{editarURL}">
                                                                <img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/editar-icono-8419-16.png" align="top">
                                                            </s:a>
                                                            <s:url id="borrarURL" action="borrarPreguntasEncuestas.action">
                                                                <s:param name="idObjeto" value="%{idPreguntaEncuesta}"></s:param>
                                                            </s:url>
                                                            <s:a href="%{borrarURL}">
                                                                <img style="width: 20px; height: 19px;" title="Borrar" alt="Borrar" src="imagenes/activar.png" align="top">
                                                            </s:a>
                                                        </td>    
                                                    </tr>
                                                </s:iterator>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="fromtables" style="margin-left: 250px; width: 220px">
                                        <a href="crearPreguntaPreguntasEncuestas.action" target="contenido">
                                            <button style="alignment-adjust: central" type="submit" class="boton_auxiliar boton" name="nuevo">
                                                Ingresar pregunta
                                            </button>
                                        </a>
                                    </div>
                                    <s:if test="hasActionErrors()">
                                        <div class="errors">
                                            <s:actionerror/>
                                        </div>
                                    </s:if>
                                    <div class="fromtables" id="contenido1">
                                        <s:if test="editar">
                                            <h3 style="margin-left: 250px;width: 600px">Generar Nuevo Registro</h3>
                                            <s:form action="guardarPreguntaPreguntasEncuestas.action"  enctype="multipart/form-data" method="POST">
                                                <s:push value="objeto">
                                                    <s:hidden name="idEncuesta"></s:hidden>
                                                        <table style="margin-left: 200px;width: 300px">
                                                            <tr>
                                                                <td><s:textfield label="Pregunta" name="pregunta"></s:textfield></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:checkbox label="Estado" name="estado"></s:checkbox></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:select label="Tipo pregunta" errorPosition="bottom" name="idTipoRespuesta" list="listaTipoPregunta" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione - "/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><s:checkbox label="Obligatoria" name="obligatoria"></s:checkbox></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:textfield label="orden" name="orden"></s:textfield></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:textfield label="Posicion Formato" name="posicionFormato"></s:textfield></td>
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
                                                    <s:hidden name="idEncuesta"></s:hidden>
                                                        <table style="margin-left: 200px;width: 300px">
                                                            <tr>
                                                                <td><s:textfield label="Pregunta" name="pregunta"></s:textfield></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:checkbox label="Estado" name="estado"></s:checkbox></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:select label="Tipo pregunta" errorPosition="bottom" name="idTipoRespuesta" list="listaTipoPregunta" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione - "/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><s:checkbox label="Obligatoria" name="obligatoria"></s:checkbox></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:textfield label="orden" name="orden"></s:textfield></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:textfield label="Posicion Formato" name="posicionFormato"></s:textfield></td>
                                                            </tr>
                                                            <tr>
                                                                <td></td>
                                                                <td><s:submit  cssClass="boton_auxiliar" cssStyle="width:auto;" value="Guardar"></s:submit></td>
                                                            </tr>
                                                        </table>
                                                </s:push>
                                            </s:form>
                                        </s:if>   
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