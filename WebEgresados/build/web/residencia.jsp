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
        <jq:head jqueryui="true" jquerytheme="simple"/>
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
                                <img style="text-align: center;width: 100px;height: 100px"src="imagenes/residencia.png">
                            </div>
                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 ">
                                <h1 style="margin-left: -30px;color: #2a6155;width:300px" >Datos de Residencia</h1>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
                                <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
                                    <table rules="all" class="table table-striped table-bordered tabla_verde" style="width: 600px; margin-left: -100px">
                                        <thead>
                                            <tr>
                                                <th>Tipo Vivienda</th>
                                                <th>Ciudad</th>
                                                <th>Dirección</th>
                                                <th>Estrato</th>
                                                <th>Acción</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <s:hidden name="cantidadObjetos"></s:hidden>
                                            <s:iterator value="listaObjetos">
                                                <tr>
                                                    <td><s:property value="idTipoVivienda.nombre"></s:property></td>                                                    
                                                    <td><s:property value="idCiudad.nombre"></s:property></td>
                                                    <td><s:property value="direccion"></s:property></td>
                                                    <td><s:property value="idEstrato.nombre"></s:property></td>
                                                        <td>
                                                        <s:set name="idObjeto" value="idResidencia"/>
                                                            <s:url id="editarURL" action="editarResidencia.action">
                                                                <s:param name="idObjeto" value="%{#idObjeto}" ></s:param>
                                                            </s:url>
                                                            <s:a href="%{editarURL}">
                                                                <div class="fuentetabla2"><img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/editar-icono-8419-16.png" align="top">
                                                            </s:a>
                                                            <s:url id="borrarURL" action="borrarResidencia.action">
                                                                <s:param name="idObjeto" value="%{idResidencia}"></s:param>
                                                            </s:url>
                                                            <s:a href="%{borrarURL}">
                                                                <img style="width: 20px; height: 19px;" title="Borrar" alt="Borrar" src="imagenes/eliminar.png" align="top"></div>
                                                            </s:a>
                                                    </td>
                                                </tr>
                                            </s:iterator>
                                        </tbody>
                                    </table>
                                    
                                    <div class="buttons" style="margin-left: 110px; width: 250px">
                                        <a href="crearResidencia.action" target="contenido">
                                            <button type="submit" class="boton_auxiliar boton guardar" style="width: auto" name="nuevo">
                                                Registro Nuevo
                                            </button>
                                        </a>
                                    </div>
                                    <s:if test="hasActionErrors()">
                                        <div style="width: auto">
                                            <s:actionerror cssClass="alert alert-danger"/>
                                        </div>
                                    </s:if>
                                            
                                    <div id="contenido1">
                                        <s:if test="editar">
                                            <h3 style="margin-left: 75px;width: 300px">Agregar Nueva Red Social</h3>
                                            <s:form action="guardarResidencia.action" id="formResidencia">
                                                <s:url id="ciudadURL" action="SelectCiudad"/>
                                                <s:push value="objeto">
                                                    <s:hidden name="idResidencia"></s:hidden>
                                                        <table style="margin-left: -5px;width: 425px">
                                                            <tr>
                                                                <td><jq:select href="%{ciudadURL}" onChangeTopics="reloadsecondlist" name="pais" id="pais"
                                                                       list="listaPaises" listKey="id" listValue="nombre" cssClass="center" onCompleteTopics="reloadsecondlist"
                                                                       headerKey="-1" headerValue="- Seleccione -" label="País Residencia" errorPosition="bottom"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><jq:select href="%{ciudadURL}" onChangeTopics="reloadThirdlist" onCompleteTopics="reloadThirdlist"
                                                                       formIds="formResidencia" reloadTopics="reloadsecondlist" name="departamento" id="departamento"
                                                                       list="listaDepartamentos" listKey="id" listValue="nombre" headerKey="-1"
                                                                       headerValue="- Seleccione -" cssClass="center" label="Departamento Residencia" errorPosition="bottom"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><jq:select href="%{ciudadURL}" formIds="formResidencia" reloadTopics="reloadThirdlist"
                                                                       name="ciudad" list="listaCiudades" listKey="id" listValue="nombre" headerKey="-1"
                                                                       headerValue="- Seleccione -" id="ciudad" cssClass="center" label="Ciudad Residencia" errorPosition="bottom"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><s:select label="Tipo Vivienda" errorPosition="bottom" cssClass="center" name="tipoVivienda" list="listaTiposVivienda" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:select label="Tipo Tenencia Vivienda" errorPosition="bottom" cssClass="center" name="tipoTenenciaVivienda" list="listaTiposTenenciaVivienda" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:textfield label="Dirección" errorPosition="bottom" cssClass="center" name="direccion"></s:textfield></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:select label="Estrato" errorPosition="bottom" cssClass="center" name="estrato" list="listaEstratos" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:checkbox label="Tiene computador" errorPosition="bottom" cssClass="center" name="computador"></s:checkbox></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:checkbox label="Tiene acceso a internet" errorPosition="bottom" cssClass="center" name="conexionInternet"></s:checkbox></td>
                                                            </tr>
                                                            <tr> <s:actionerror></s:actionerror></tr>
                                                            <tr>
                                                                <td></td>
                                                                <td><s:submit cssClass="boton_auxiliar" cssStyle="width:auto;"value="Guardar"></s:submit></td>
                                                            </tr>    
                                                        </table>
                                                </s:push>
                                            </s:form>
                                        </s:if>
                                    </div>
                                            
                                    <div class="enlaces">
                                        <div class="tdsiguiente"><a href="siguienteResidencia.action"><img src="imagenes/next.png" width="21" height="21"></a></div>
                                        <div class="tdatras"><a href="anteriorResidencia.action" class="tdatras"><img src="imagenes/atras.jpg" width="24" height="24"></a></div>
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