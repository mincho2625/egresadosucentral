<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<html lang="es">
    <head><title>Educacion Formal</title>
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
    <body class="default" >
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
                                <img style="text-align: center; width: 130px; height: 100px"src="imagenes/formal.jpg">
                            </div>
                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 ">
                                <h1 style="margin-left: -30px;color: #2a6155;width:300px">Educación Formal</h1>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
                                <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
                                    <table rules="all" class="table table-striped table-bordered tabla_verde" style="width: 600px;margin-left: -100px ">
                                        <thead>
                                            <tr>
                                                <th>Programa</th>
                                                <th>Jornada</th>
                                                <th>Año Finalización</th>
                                                <th>Estado</th>
                                                <th>Acción</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <s:hidden name="listaObjetos"></s:hidden>
                                            <s:iterator value="listaObjetos">
                                                <tr>
                                                    <td><s:property value="idPrograma.nombre"></s:property></td>
                                                    <td><s:property value="idJornada.nombre"></s:property></td>
                                                    <td><s:property value="anioFinalizacion"></s:property></td>
                                                    <td><s:property value="idEstadoEducacion.nombre"></s:property></td>
                                                        <td>
                                                        <s:url id="editarURL" action="editarEducacionFormalUCentral.action">
                                                            <s:param name="idObjeto" value="%{idEducacion}" ></s:param>
                                                        </s:url>
                                                        <s:a href="%{editarURL}">
                                                            <div class="fuentetabla2"><img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/editar-icono-8419-16.png" align="top">
                                                            </s:a>
                                                            <s:url id="borrarURL" action="borrarEducacionFormalUCentral.action">
                                                                <s:param name="idObjeto" value="%{idEducacion}"></s:param>
                                                            </s:url>
                                                            <s:a href="%{borrarURL}">
                                                                <img style="width: 20px; height: 19px;" title="Borrar" alt="Borrar" src="imagenes/eliminar.png" align="top"></div>
                                                            </s:a>
                                                    </td>
                                                </tr>
                                            </s:iterator>
                                        </tbody>        
                                    </table>
                                    <div class="fromtables" style="margin-left: 100px; width: 200px">
                                        <a href="crearEducacionFormalUCentral.action" target="contenido">
                                            <button type="submit" class="boton_descargar boton guardar" name="nuevo">
                                                Registro Nuevo
                                            </button>
                                        </a><br>
                                    </div>
                                    <s:if test="hasActionErrors()">
                                        <div style="width: auto">
                                            <s:actionerror cssClass="alert alert-danger"/>
                                        </div>
                                    </s:if>  
                                    <div class="fromtables" id="contenido1">
                                        <s:if test="editar">
                                            <h3 style="margin-left: 50px;width: 400px">Agregar nueva Educacion Formal</h3>
                                            <s:form action="guardarEducacionFormalUCentral.action" id="formEducacion">
                                                <s:url id="programaURL" action="SelectPrograma"/>
                                                <s:push value="objeto">
                                                    <s:hidden name="idEducacion"></s:hidden>
                                                        <table style="margin-left: -50px;width: 470px">
                                                            <tr>
                                                                <td><jq:select href="%{programaURL}" onChangeTopics="reloadThirdlist" name="nivelEstudios" id="nivelEstudios"
                                                                       list="listaNivelesEstudios" listKey="id" listValue="nombre" onCompleteTopics="reloadThirdlist"
                                                                       headerKey="-1" headerValue="- Seleccione -" label="Nivel de estudios" errorPosition="bottom"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><jq:select href="%{programaURL}" onChangeTopics="reloadThirdlist" name="facultad" id="facultad"
                                                                       formIds="formEducacion" list="listaFacultades" listKey="id" listValue="nombre"
                                                                       headerKey="-1" headerValue="- Seleccione -" onCompleteTopics="reloadThirdlist"
                                                                       label="Facultad" errorPosition="bottom"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><jq:select href="%{programaURL}" reloadTopics="reloadThirdlist" label="Programa" errorPosition="bottom"
                                                                       name="programa" list="listaProgramas" listKey="id" listValue="nombre" headerKey="-1"
                                                                       headerValue="- Seleccione -" id="programa" formIds="formEducacion"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><s:select label="Jornada" errorPosition="bottom" name="jornada" list="listaJornadas" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:select label="Año Inicio" errorPosition="bottom" name="anioInicio" list="listaAnios" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:select label="Mes Inicio" errorPosition="bottom" name="mesInicio" list="listaMeses" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:select label="Año Finalización" errorPosition="bottom" name="anioFinalizacion" list="listaAnios" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:select label="Mes Finalización" errorPosition="bottom" name="mesFinalizacion" list="listaMeses" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:select label="Estado" errorPosition="bottom" name="estadoEducacion" list="listaEstadosEducacion" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
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
                                        <div class="tdsiguiente"><a href="siguienteEducacionFormalUCentral.action"><img src="imagenes/next.png" width="24" height="24"></a></div>
                                        <div class="tdatras"><a href="anteriorEducacionFormalUCentral.action" class="tdatras"><img src="imagenes/atras.jpg" width="24" height="24"></a></div>
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