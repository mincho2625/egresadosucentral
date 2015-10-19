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
                                <img style="text-align: center;width: 100px; height: 100px"src="imagenes/ubicacion.png">
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 ">
                                <h1 style="margin-left: -30px;color: #2a6155;width:300px">Datos de Ubicacion</h1>
                            </div>
                        </div>
                        <br>
                        <div class="row">
                            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
                                <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
                                    <table rules="all" class="table table-striped table-bordered tabla_verde" style="width: 400px">
                                        <thead>
                                            <tr>
                                                <th>Tipo Contacto</th>
                                                <th>Descripción</th>
                                                <th>Acción</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <s:hidden name="cantidadObjetos"></s:hidden>
                                            <s:hidden name="idEgresado"></s:hidden>
                                            <s:iterator value="listaObjetos" status="contacto">
                                                <tr>
                                                    <td><s:property value="idTipoContacto.nombre"></s:property></td>
                                                    <td><s:property value="descripcion"></s:property></td>
                                                        <td><div class="fuentetabla2">
                                                            <s:url id="editarURL" action="editarUbicacion.action">
                                                                <s:param name="idObjeto" value="%{idContacto}" ></s:param>
                                                            </s:url>
                                                            <s:a href="%{editarURL}">
                                                                <img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/editar-icono-8419-16.png" align="top">
                                                            </s:a>
                                                            <s:url id="borrarURL" action="borrarUbicacion.action">
                                                                <s:param name="idObjeto" value="%{idContacto}"></s:param>
                                                            </s:url>
                                                            <s:a href="%{borrarURL}">
                                                                <img style="width: 20px; height: 19px;" title="Borrar" alt="Borrar" src="imagenes/eliminar.png" align="top">
                                                            </s:a>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </s:iterator>
                                        </tbody>
                                    </table>
                                    <div class="fromtables" style="margin-left: 110px; width: 200px">
                                        <a href="crearUbicacion.action" target="contenido">
                                            <button  type="submit" class="boton_descargar boton guardar" name="nuevo">
                                                Nuevo Registro
                                            </button>
                                        </a>
                                    </div>       
                                    <s:if test="hasActionErrors()">
                                        <div style="width: 450px">
                                            <s:actionerror cssClass="alert alert-danger"/>
                                        </div>
                                    </s:if>
                                    <div class="fromtables" id="contenido1">
                                        <s:hidden name="editar"></s:hidden>
                                        <s:if test="editar">
                                            <h3 style="margin-left: 50px;width: 400px">Agregar un Nuevo Dato de Ubicacion</h3>
                                            <s:actionerror cssClass="alert alert-danger"></s:actionerror>
                                            <s:form action="guardarUbicacion.action"> 
                                                <s:push value="objeto">
                                                    <s:hidden name="idContacto"></s:hidden>
                                                        <table style="margin-left: 50px;width: 300px">
                                                            <tr>
                                                                <td>
                                                                <s:select label="Tipo Contacto" errorPosition="bottom" name="tipoContacto" list="listaTiposContacto" listKey="id" listValue="nombre" labelposition="right" requiredPosition="left" headerKey="-1" headerValue="- Seleccione -">                                          
                                                                </s:select>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <s:textfield name="descripcion" label="Descripción" errorPosition="bottom"></s:textfield>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td></td>
                                                                <td>
                                                                <s:submit cssClass="boton_auxiliar" cssStyle="width:auto;" value="Guardar"></s:submit>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                </s:push>
                                            </s:form>
                                        </s:if>
                                    </div>
                                    <div class="enlaces">
                                        <div class="tdsiguiente"><a href="siguienteUbicacion.action"><img src="imagenes/next.png" width="24" height="24"></a></div>
                                        <div class="tdatras"><a href="anteriorUbicacion.action" class="tdatras"><img src="imagenes/atras.jpg" width="24" height="24"></a></div>
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