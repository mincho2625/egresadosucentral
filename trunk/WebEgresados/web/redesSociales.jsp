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
                        <br>
                        <div class="row" style="margin-left: 130px">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                <img style="text-align: center;width: 130px;height: 100px;margin-left: 25px"src="imagenes/sociales.jpg">
                            </div>
                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 ">
                                <h1 style="color: #2a6155;width:300px" >Redes Sociales</h1>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
                                <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
                                    <table rules="all" class="table table-striped table-bordered tabla_verde" style="width: 400px">
                                        <thead>
                                            <tr>
                                                <th>Red Social</th>
                                                <th>URL</th>
                                                <th>Acción</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <s:hidden name="cantidadObjetos"></s:hidden>
                                            <s:iterator value="listaObjetos">
                                                <tr>
                                                    <td><s:property value="idRedSocial.nombre"></s:property></td>
                                                    <td><s:property value="url"></s:property></td>
                                                        <td>
                                                        <s:url id="editarURL" action="editarEgresadoRedSocial.action">
                                                            <s:param name="idObjeto" value="%{idEgresadoRedSocial}" ></s:param>
                                                        </s:url>
                                                        <s:a href="%{editarURL}">
                                                            <img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/editar-icono-8419-16.png" align="top">
                                                        </s:a>
                                                        <s:url id="borrarURL" action="borrarEgresadoRedSocial.action">
                                                            <s:param name="idObjeto" value="%{idEgresadoRedSocial}"></s:param>
                                                        </s:url>
                                                        <s:a href="%{borrarURL}">
                                                            <img style="width: 20px; height: 19px;" title="Borrar" alt="Borrar" src="imagenes/eliminar.png" align="top">
                                                        </s:a>
                                                    </td>
                                                </tr>
                                            </s:iterator>
                                        </tbody>
                                    </table>
                                    <div class="buttons" style="margin-left: 75px; width: 250px">
                                        <a href="crearEgresadoRedSocial.action" target="contenido">
                                            <button type="submit" class="boton_descargar boton guardar" style="width: auto" name="nuevo">
                                                Registro Nuevo
                                            </button>
                                        </a><br>
                                    </div>
                                    <s:if test="hasActionErrors()">
                                        <div style="width: auto">
                                            <s:actionerror cssClass="alert alert-danger"/>
                                        </div>
                                    </s:if>
                                    <div id="contenido1">
                                        <s:if test="editar">
                                            <h3 style="margin-left: 75px;width: 300px">Agregar Nueva Red Social</h3>
                                            <s:form action="guardarEgresadoRedSocial.action">
                                                <s:push value="objeto">
                                                    <s:hidden name="idEgresadoRedSocial"></s:hidden>
                                                        <table  style="width: 300px">
                                                            <tr>
                                                                <td>
                                                                    <s:select label="Red Social" errorPosition="bottom" cssClass="center" name="redSocial" list="listaRedesSociales" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>
                                                                    <s:textfield label="URL" errorPosition="bottom" name="url" cssClass="center"></s:textfield>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                            <s:actionerror></s:actionerror>
                                                        </tr>
                                                        <tr>
                                                            <td></td>
                                                            <td><s:submit cssClass="boton_descargar boton guardar" cssStyle="width:auto;" value="Guardar">
                                                            </s:submit></td>
                                                        </tr>

                                                    </table>
                                                </s:push>
                                            </s:form>
                                        </s:if>
                                    </div>
                                    <div class="enlaces">
                                        <div class="tdsiguiente"><a href="siguienteEgresadoRedSocial.action"><img src="imagenes/next.png" width="21" height="21"></a></div>
                                        <div class="tdatras"><a href="anteriorEgresadoRedSocial.action" class="tdatras"><img src="imagenes/atras.jpg" width="24" height="24"></a></div>
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