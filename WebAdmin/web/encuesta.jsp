<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<html lang="es">
    <head><title>Encuestas</title>
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
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                <img src="imagenes/logosimbolo-ucentral-v1-medium.png">
                            </div>
                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 ">
                                <h1 style="margin-left: 70px;color: #2a6155;width:300px" >Encuesta</h1>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">

                                <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
                                    <s:if test="buscar">
                                        <div id="div1">
                                            <table rules="all" class="table table-striped table-bordered tabla_verde" style="width: 900px; margin-left: -200px">
                                                <thead>
                                                    <tr>
                                                        <th style="width: auto">Id Encuesta</th>
                                                        <th style="width: auto">Nombre</th>
                                                        <th style="width: auto">Descripcion </th>
                                                        <th style="width: auto">Estado</th>
                                                        <th style="width: auto">Orden</th>
                                                        <th style="width: auto">Opción</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <s:hidden name="cantidadObjetos"></s:hidden>
                                                    <s:iterator value="listaObjetos">
                                                        <tr>
                                                            <td><s:property value="idEncuesta"></s:property></td>
                                                            <td><s:property value="nombre"></s:property></td>
                                                            <td><s:property value="descripcion"></s:property></td>
                                                            <td><s:property value="estado  == 1?activo:inactivo"></s:property></td>
                                                            <td><s:property value="orden"></s:property></td>
                                                                <td>
                                                                <s:url id="editarURL" action="editarEncuesta.action">
                                                                    <s:param name="idObjeto" value="%{idEncuesta}" ></s:param>
                                                                </s:url>
                                                                <s:a href="%{editarURL}">
                                                                    <img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/editar-icono-8419-16.png" align="top">
                                                                </s:a>
                                                                <s:url id="borrarURL" action="cambiarEstadoEncuesta.action">
                                                                    <s:param name="idObjeto" value="%{idEncuesta}"></s:param>
                                                                    <s:param name="idObjeto1" value="%{estado}"></s:param>
                                                                </s:url>
                                                                <s:a href="%{borrarURL}">
                                                                    <img style="width: 20px; height: 19px;" title="Activar" alt="Activar" src="imagenes/activar.png" align="top">
                                                                </s:a>
                                                                <s:url id="consultarURL" action="cargarvariablesPreguntasEncuestas.action">
                                                                    <s:param name="idObjeto" value="%{idEncuesta}"></s:param>
                                                                </s:url>
                                                                <s:a href="%{consultarURL}">
                                                                    <img style="width: 20px; height: 19px;" title="Consultar preguntas" alt="Consultar preguntas" src="imagenes/activar.png" align="top">
                                                                </s:a>    
                                                            </td>
                                                        </tr>
                                                    </s:iterator>
                                                </tbody>
                                            </table>
                                        </div>
                                        <div class="fromtables" style="margin-left: 250px; width: 220px">
                                            <a href="crearEncuesta.action" target="contenido">
                                                <button style="alignment-adjust: central" type="submit" class="boton_auxiliar boton" name="nuevo">
                                                    Ingresar encuesta
                                                </button>
                                            </a>
                                        </div>
                                    </s:if>            
                                    <s:if test="hasActionErrors()">
                                        <div class="errors">
                                            <s:actionerror/>
                                        </div>
                                    </s:if>
                                    <div class="fromtables" id="contenido1">
                                        <s:if test="editar">
                                            <h3 style="margin-left: 250px;width: 600px">Generar Nuevo Registro</h3>
                                            <s:form action="guardarEncuesta.action" enctype="multipart/form-data" method="POST">
                                                <s:push value="objeto">
                                                    <s:hidden name="idEncuesta"></s:hidden>
                                                        <table style="margin-left: 200px;width: 300px">
                                                            <tr>
                                                                <td><s:textfield label="Nombre" name="nombre"></s:textfield></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:textfield label="Descripcion" name="descripcion"></s:textfield></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:checkbox label="Graduando" name="graduando"></s:checkbox></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:checkbox label="Egresado" name="egresado"></s:checkbox></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:textfield label="Orden" name="orden"></s:textfield></td>
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
                                            <s:form action="llenarEncuesta.action" enctype="multipart/form-data" method="POST">
                                                <s:push value="objeto">
                                                    <s:hidden name="idEncuesta"></s:hidden>
                                                        <table style="margin-left: 200px;width: 300px">
                                                            <tr>
                                                                <td><s:textfield label="Nombre" name="nombre"></s:textfield></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:textfield label="Descripcion" name="descripcion"></s:textfield></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:checkbox label="Graduando" name="graduando"></s:checkbox></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:checkbox label="Egresado" name="egresado"></s:checkbox></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:textfield label="Orden" name="orden"></s:textfield></td>
                                                            </tr>
                                                            <tr>
                                                                <td></td>
                                                                <td><s:submit  cssClass="boton_auxiliar" cssStyle="width:auto;" value="Guardar"></s:submit></td>
                                                            </tr>
                                                        </table>
                                                </s:push>
                                            </s:form>
                                        </s:if>
                                        <s:if test="consultar">
                                            <div id="div1">
                                                <table rules="all" class="table table-striped table-bordered tabla_verde" style="width: 990px; margin-left: -320px">
                                                    <thead>
                                                        <tr>
                                                            <th style="width: auto">Id Encuesta</th>
                                                            <th style="width: auto">Id pregunta</th>
                                                            <th style="width: auto">Pregunta</th>
                                                            <th style="width: auto">Estado </th>
                                                            <th style="width: auto">Obligatorio</th>
                                                            <th style="width: auto">Orden</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <s:hidden name="cantidadObjetos"></s:hidden>
                                                        <s:iterator value="listaObjetos">
                                                            <tr>
                                                                <td><s:property value="idEncuesta"></s:property></td>
                                                                <td><s:property value="idPreguntaEncuesta"></s:property></td>
                                                                <td><s:property value="pregunta"></s:property></td>
                                                                <td><s:property value="estado  == 1?activo:inactivo"></s:property></td>
                                                                <td><s:property value="obligatoria  == 1?si:no"></s:property></td>
                                                                <td><s:property value="orden"></s:property></td>
                                                            </tr>
                                                        </s:iterator>
                                                    </tbody>
                                                </table>
                                            </div>          
                                            <a href="obtenerListaEncuesta.action" target="contenido"><button Style="margin-left:320px; width: auto" Class="boton_auxiliar">Volver</button></a>
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
        </div>          
    </body>
</html>