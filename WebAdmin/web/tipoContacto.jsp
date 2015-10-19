<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
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
                        <div class="row" style="margin-left: 150px">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                <img src="imagenes/logosimbolo-ucentral-v1-medium.png">
                            </div>
                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 ">
                                <h1 style="margin-left: 70px;color: #2a6155;width:300px">Tipo de <br>Contacto</h1>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">
                                <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
                                <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
                                    <div id="div6" >
                                        <s:form cssStyle="margin-left: 100px">
                                            <display:table class="table table-striped table-bordered tabla_verde" style="width: 400px"
                                                           name="listaObjetos" pagesize="5" cellspacing="5px;"  cellpadding="5px;" uid="row" requestURI="/obtenerListaTipoContacto.action">
                                                <display:column property="nombre" title="Nombre" sortable="true"/>
                                                <display:column title="Acción">
                                                    <s:url id="editarURL" action="editarTipoContacto.action">
                                                        <s:param name="idObjeto" value="%{#attr.row.idTipoContacto}" ></s:param>
                                                    </s:url>
                                                    <s:a href="%{editarURL}">
                                                        <img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/editar-icono-8419-16.png" align="top">
                                                    </s:a>
                                                    <s:if test="!#attr.row.soloLectura">
                                                        <s:url id="borrarURL" action="borrarTipoContacto.action">
                                                            <s:param name="idObjeto" value="%{#attr.row.idTipoContacto}"></s:param>
                                                        </s:url>
                                                        <s:a href="%{borrarURL}">
                                                            <img style="width: 20px; height: 19px;" title="Borrar" alt="Borrar" src="imagenes/eliminar.png" align="top">
                                                        </s:a>
                                                    </s:if>
                                                </display:column>
                                            </display:table>
                                        </s:form>
                                    </div>    
                                    <div class="fromtables" style="margin-left: 200px; width: 200px">
                                        <a href="crearTipoContacto.action" target="contenido">
                                            <button style="alignment-adjust: central" type="submit" class="boton_auxiliar boton" name="nuevo">
                                                Nuevo Registro
                                            </button>
                                        </a>
                                    </div>
                                    <s:if test="hasActionErrors()">
                                        <div class="errors">
                                            <s:actionerror/>
                                        </div>
                                    </s:if>
                                    <div class="fromtables" id="contenido1" style="margin-left: 130px">
                                        <s:if test="editar">
                                            <h3 style="margin-left: 50px;width: 400px">Generar Nuevo Registro</h3>
                                            <s:form action="guardarTipoContacto.action">
                                                <s:push value="objeto">
                                                    <s:hidden name="idTipoContacto"></s:hidden>
                                                    <s:hidden name="soloLectura"></s:hidden>
                                                        <table style="width: 300px">
                                                            <tr>
                                                            <s:if test="soloLectura">
                                                                <td><s:textfield label="Nombre"  name="nombre" disabled="true"></s:textfield></td>
                                                            </s:if><s:else>
                                                                <td><s:textfield label="Nombre"  name="nombre"></s:textfield></td>
                                                            </s:else>
                                                            </tr>
                                                            <tr>
                                                                <s:if test="soloLectura">
                                                                    <td><s:checkbox label="Obligatorio" name="obligatorio" disabled="true"></s:checkbox></td>
                                                            </s:if><s:else>
                                                                <td><s:checkbox label="Obligatorio" name="obligatorio"></s:checkbox></td>
                                                            </s:else>
                                                            </tr>
                                                            <tr>
                                                                <s:if test="soloLectura">
                                                                    <td><s:select label="Tipo campo"  name="tipoCampo" list="listaTiposCampos" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -" disabled="true"></s:select></td>
                                                            </s:if><s:else>
                                                                <td><s:select label="Tipo campo"  name="tipoCampo" list="listaTiposCampos" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                                                            </s:else>
                                                            </tr>
                                                            <tr>
                                                                <td><s:textfield label="Longitud" type="number" name="longitud"></s:textfield></td>
                                                            </tr>
                                                            <tr>
                                                                <td></td>
                                                                <td><s:submit cssClass="boton_auxiliar" cssStyle="width:auto;" value="Guardar"></s:submit></td>
                                                            </tr>
                                                        </table>
                                                </s:push>
                                            </s:form>
                                        </s:if>
                                        <s:if test="crear">
                                            <h3 style="margin-left: 50px;width: 400px">Generar Nuevo Registro</h3>
                                            <s:form action="guardarTipoContacto.action">
                                                <s:push value="objeto">
                                                    <s:hidden name="idTipoContacto"></s:hidden>
                                                    <s:hidden name="soloLectura"></s:hidden>
                                                        <table style="width: 300px">
                                                            <tr>
                                                                <td><s:textfield label="Nombre"  name="nombre"></s:textfield></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:checkbox label="Obligatorio" name="obligatorio"></s:checkbox></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:select label="Tipo campo"  name="tipoCampo" list="listaTiposCampos" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:textfield label="Longitud" type="number" name="longitud"></s:textfield></td>
                                                            </tr>
                                                            <tr>
                                                                <td></td>
                                                                <td><s:submit cssClass="boton_auxiliar" cssStyle="width:auto;" value="Guardar"></s:submit></td>
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