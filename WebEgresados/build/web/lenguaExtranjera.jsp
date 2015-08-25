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
                        <div class="row" style="margin-left: 150px">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                <img style="text-align: center;width: 150px;height: 100px"src="imagenes/idioma.jpg">
                            </div>
                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 ">
                                <h1 style="margin-left: -30px;color: #2a6155;width:300px">Lengua Extranjera</h1>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
                                <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
                                    <table rules="all" class="table table-striped table-bordered tabla_verde" style="width: 400px">
                                        <thead>
                                            <tr>
                                                <th>Dominio</th>
                                                <th>Idioma</th>
                                                <th>Accion</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <s:hidden name="cantidadObjetos"></s:hidden>
                                            <s:iterator value="listaObjetos">
                                                <tr>
                                                    <td><s:property value="idDominio.dominioLenguaExt"></s:property><br>
                                                        </td>
                                                        <td><s:property value="idIdioma.nombre"></s:property><br>
                                                        </td>
                                                        <td>
                                                            <div class="fuentetabla2">
                                                            <s:url id="editarURL" action="editarLenguaExtranjera.action">
                                                                <s:param name="idObjeto" value="%{idLenguaExtranjera}" ></s:param>
                                                            </s:url>
                                                            <s:a href="%{editarURL}">
                                                                <img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/editar-icono-8419-16.png" align="top">
                                                            </s:a>
                                                            <s:url id="borrarURL" action="borrarLenguaExtranjera.action">
                                                                <s:param name="idObjeto" value="%{idLenguaExtranjera}"></s:param>
                                                            </s:url>
                                                            <s:a href="%{borrarURL}">
                                                                <img style="width: 20px; height: 19px;" title="Borrar" alt="Borrar" src="imagenes/eliminar.png" align="top">
                                                            </s:a></div>
                                                    </td>
                                                </tr>
                                            </s:iterator>
                                        </tbody>
                                    </table>
                                    <br>
                                    <div class="buttons"style="margin-left: 100px; width: 200px">
                                        <a href="crearLenguaExtranjera.action" target="contenido">
                                            <button type="submit" class="boton_descargar boton guardar" name="nuevo">
                                                Registro Nuevo
                                            </button>
                                        </a><br>
                                    </div>
                                    <s:if test="hasActionErrors()">
                                        <div style="width: 450px">
                                            <s:actionerror cssClass="alert alert-danger"/>
                                        </div>
                                    </s:if>
                                    <div id="contenido1">
                                        <s:if test="editar">
                                            <h3 style="margin-left: 50px;width: 400px">Agregar un Nueva lengua Extranjera</h3>
                                            <s:form action="guardarLenguaExtranjera.action">
                                                <s:push value="objeto">
                                                    <s:hidden name="idLenguaExtranjera"></s:hidden>
                                                        <table  style="margin-left: 50px;width: 300px">
                                                            <tr>
                                                                <td>
                                                                <s:select label="Dominio" errorPosition="bottom" name="dominio" list="listaDominioLenguaExt" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>
                                                                <s:select label="Idioma" errorPosition="bottom" name="idioma" list="listaIdiomas" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td></td>
                                                                <td><s:actionerror></s:actionerror></td>
                                                            </tr>
                                                            <tr>
                                                                <td></td>
                                                                <td><s:submit cssClass="boton_auxiliar boton guardar"  cssStyle="width:auto;"value="Guardar"></s:submit></td>
                                                            </tr>
                                                    </table>
                                                </s:push>
                                            </s:form>
                                        </s:if>
                                    </div>
                                    <div class="enlaces">
                                        <div class="tdsiguiente"><a href="siguienteLenguaExtranjera.action"><img src="imagenes/next.png" width="24" height="24"></a></div>
                                        <div class="tdatras"><a href="anteriorLenguaExtranjera.action" class="tdatras"><img src="imagenes/atras.jpg" width="24" height="24"></a></div>
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