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
                                <img style="text-align: center;width: 100px;height: 100px"src="imagenes/reconocimientos.png">
                            </div>
                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 ">
                                <h1 style="margin-left: -30px;color: #2a6155;width:300px">Distinciones o Reconocimientos</h1>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
                                <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
                                    <table rules="all" class="table table-striped table-bordered tabla_verde" style="width: 600px; margin-left: -100px">
                                        <thead>
                                            <tr>
                                                <th>Tipo</th>
                                                <th>Clase</th>
                                                <th>Entidad Otorgante</th>
                                                <th>Ciudad</th>
                                                <th>Fecha</th>
                                                <th>Accion</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <s:hidden name="cantidadObjetos"></s:hidden>
                                            <s:iterator value="listaObjetos" status="contacto">
                                                <tr>
                                                    <td><s:property value="idTipoReconocimiento.nombre"></s:property><br>
                                                        </td>
                                                        <td><s:property value="idClaseReconocimiento.nombre"></s:property><br>
                                                        </td>
                                                        <td><s:property value="entidadOtorgante"></s:property><br>
                                                        </td>
                                                        <td><s:property value="idCiudad.nombre"></s:property><br>
                                                        </td>
                                                        <td><s:property value="fechaReconocimiento"></s:property><br>
                                                        </td>
                                                        <td>
                                                            <div class="fuentetabla2">
                                                            <s:url id="editarURL" action="editarReconocimiento.action">
                                                                <s:param name="idObjeto" value="%{idReconocimiento}" ></s:param>
                                                            </s:url>
                                                            <s:a href="%{editarURL}">
                                                                <img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/editar-icono-8419-16.png" align="top">
                                                            </s:a>
                                                            <s:url id="borrarURL" action="borrarReconocimiento.action">
                                                                <s:param name="idObjeto" value="%{idReconocimiento}"></s:param>
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
                                    <div class="fromtables" style="margin-left: 100px; width: 200px">
                                        <a href="crearReconocimiento.action" target="contenido">
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
                                    <div class="fromtables" id="contenido1">
                                        <s:if test="editar">
                                            <h3 style="margin-left: 35px;width: 400px">Agregar un Nuevo Reconocimiento</h3>
                                            <s:form action="guardarReconocimiento.action" id="formDistinciones">
                                                <s:url id="ciudadURL" action="SelectCiudad"/>
                                                <s:push value="objeto">
                                                    <s:hidden name="idReconocimiento"></s:hidden>
                                                        <table style="margin-left: -15px;width: 450px">
                                                            <tr>
                                                                <td><s:select label="Tipo Reconocimiento" errorPosition="bottom" name="tipoReconocimiento" list="listaTiposReconocimiento" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:select label="Clase Reconocimiento" errorPosition="bottom" name="claseReconocimiento" list="listaClasesReconocimiento" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:textfield label="Descripción" errorPosition="bottom" name="descripcion"></s:textfield></td>
                                                            </tr>
                                                            <tr>
                                                                <td><jq:select href="%{ciudadURL}" onChangeTopics="reloadsecondlist" name="pais" id="pais"
                                                                       list="listaPaises" listKey="id" listValue="nombre" onCompleteTopics="reloadsecondlist"
                                                                       headerKey="-1" headerValue="- Seleccione -" label="País" errorPosition="bottom"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><jq:select href="%{ciudadURL}" onChangeTopics="reloadThirdlist" onCompleteTopics="reloadThirdlist"
                                                                       formIds="formDistinciones" reloadTopics="reloadsecondlist" name="departamento" id="departamento"
                                                                       list="listaDepartamentos" listKey="id" listValue="nombre" headerKey="-1"
                                                                       headerValue="- Seleccione -" label="Departamento" errorPosition="bottom"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><jq:select href="%{ciudadURL}" formIds="formDistinciones" reloadTopics="reloadThirdlist"
                                                                       name="ciudad" list="listaCiudades" listKey="id" listValue="nombre" headerKey="-1"
                                                                       headerValue="- Seleccione -" id="ciudad" label="Ciudad" errorPosition="bottom"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><s:textfield name="entidadOtorgante" label="Entidad Otorgante" errorPosition="bottom"></s:textfield></td>
                                                            </tr>
                                                            <tr>
                                                                <td><jq:datepicker label="Fecha" errorPosition="bottom" name="fechaReconocimiento" displayFormat="dd/mm/yy" changeMonth="true" changeYear="true" showButtonPanel="true"></jq:datepicker></td>
                                                            </tr>
                                                            <tr>
                                                                <td></td>
                                                                <td><s:actionerror></s:actionerror></td>
                                                            </tr>
                                                            <tr>
                                                                <td></td>
                                                                <td><s:submit cssClass="boton_auxiliar boton guardar" cssStyle="width:auto;" value="Guardar"></s:submit></td>
                                                            </tr>
                                                        </table>
                                                </s:push>
                                            </s:form>
                                        </s:if>
                                    </div>
                                    <div class="enlaces">
                                        <div class="tdsiguiente"><a href="siguienteReconocimiento.action"><img src="imagenes/next.png" width="24" height="24"></a></div>
                                        <div class="tdatras"><a href="anteriorReconocimiento.action" class="tdatras"><img src="imagenes/atras.jpg" width="24" height="24"></a></div>
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