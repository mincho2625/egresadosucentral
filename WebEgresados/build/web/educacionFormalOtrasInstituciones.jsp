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
        <script type="text/javascript">
            function fnOtraInstitucion(checked)
            {
                if (checked) {
                    institucion.disabled = true;
                    otraInstitucion.disabled = false;
                }
                else {
                    institucion.disabled = false;
                    otraInstitucion.disabled = true;
                }
            }
        </script>
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
                                <img style="text-align: center;width: 100px;height: 100px"src="imagenes/formalotras.jpg">
                            </div>
                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 ">
                                <h1 style="margin-left: -30px;color: #2a6155;width:300px">Educacion Formal Otras Instituciones</h1>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
                                <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
                                    <table rules="all" class="table table-striped table-bordered tabla_verde" style="width: 600px; margin-left: -100px">
                                        <thead>
                                            <tr>
                                                <th>Ciudad</th>
                                                <th>Institucion</th>
                                                <th>Ano Finalizacion</th>
                                                <th>Estado</th>
                                                <th>Accion</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <s:hidden name="cantidadObjetos"></s:hidden>
                                            <s:iterator value="listaObjetos">
                                                <tr>
                                                    <td><s:property value="idCiudad.nombre"></s:property><br>
                                                        </td>
                                                        <td><s:property value="idInstitucion.nombre"></s:property><br>
                                                        </td>
                                                        <td><s:property value="anioFinalizacion"></s:property><br>
                                                        </td>
                                                        <td><s:property value="idEstadoEducacion.nombre"></s:property><br>
                                                        </td>
                                                        <td>
                                                            <div class="fuentetabla2">
                                                            <s:url id="editarURL" action="editarEducacionFormalOtrasInstituciones.action">
                                                                <s:param name="idObjeto" value="%{idEducacion}" ></s:param>
                                                            </s:url>
                                                            <s:a href="%{editarURL}">
                                                                <img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/editar-icono-8419-16.png" align="top">
                                                            </s:a>
                                                            <s:url id="borrarURL" action="borrarEducacionFormalOtrasInstituciones.action">
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
                                    <br>
                                    <div class="fromtables" style="margin-left: 110px; width: 200px">
                                        <a href="crearEducacionFormalOtrasInstituciones.action" target="contenido">
                                            <button type="submit" class="boton_auxiliar boton guardar" name="nuevo">
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
                                            <h3 style="margin-left: 50px;width: 400px">Generar Nueva Educacion No Formal</h3>
                                            <s:form action="guardarEducacionFormalOtrasInstituciones.action" id="formEducacion">
                                                <s:url id="ciudadURL" action="SelectCiudad"/>
                                                <s:url id="areaEstudiosURL" action="SelectAreaEstudios"/>
                                                <s:push value="objeto">
                                                    <s:hidden name="idEducacion"></s:hidden>
                                                        <table style="margin-left: -75px;width: 500px">
                                                            <tr>
                                                                <td><jq:select href="%{ciudadURL}" onChangeTopics="reloadsecondlist" name="pais" id="pais"
                                                                       list="listaPaises" listKey="id" listValue="nombre" onCompleteTopics="reloadsecondlist"
                                                                       headerKey="-1" headerValue="- Seleccione -" label="País" errorPosition="bottom"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><jq:select href="%{ciudadURL}" onChangeTopics="reloadThirdlist" onCompleteTopics="reloadThirdlist"
                                                                       formIds="formEducacion" reloadTopics="reloadsecondlist" name="departamento" id="departamento"
                                                                       list="listaDepartamentos" listKey="id" listValue="nombre" headerKey="-1"
                                                                       headerValue="- Seleccione -" label="Departamento" errorPosition="bottom"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><jq:select href="%{ciudadURL}" formIds="formEducacion" reloadTopics="reloadThirdlist"
                                                                       name="ciudad" list="listaCiudades" listKey="id" listValue="nombre" headerKey="-1"
                                                                       headerValue="- Seleccione -" id="ciudad" label="Ciudad" errorPosition="bottom"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><s:select label="Institución" errorPosition="bottom" name="institucion" id="institucion" list="listaInstituciones" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                                                        </tr>
                                                            <tr>
                                                                <td><s:checkbox name="checkOtraInstitucion" onchange="fnOtraInstitucion(this.checked);"></s:checkbox>
                                                                    <s:textfield label="Otra Institución" errorPosition="bottom" name="otraInstitucion" id="otraInstitucion" disabled="true"></s:textfield></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:textfield name="titulo" label="Título" errorPosition="bottom"></s:textfield></td>
                                                            </tr>
                                                            <tr>
                                                                <td><jq:select href="%{areaEstudiosURL}" onChangeTopics="reloadsecondlist2" name="nivelEstudios" id="nivelEstudios"
                                                                       list="listaNivelesEstudios" listKey="id" listValue="nombre" onCompleteTopics="reloadsecondlist2"
                                                                       headerKey="-1" headerValue="- Seleccione -" label="Nivel estudios" errorPosition="bottom"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><jq:select href="%{areaEstudiosURL}" formIds="formEducacion" reloadTopics="reloadsecondlist2"
                                                                       name="areaEstudios" id="areaEstudios" list="listaAreasEstudios" listKey="id" 
                                                                       listValue="nombre" headerKey="-1" headerValue="- Seleccione -" label="Área estudios" errorPosition="bottom"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><s:select label="Modalidad" errorPosition="bottom" name="modalidad" list="listaModalidades" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
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
                                                                <td><s:submit cssClass="boton_auxiliar" cssStyle="width:auto;" value="Guardar"></s:submit></td>
                                                            </tr>    
                                                    </table>
                                                </s:push>
                                            </s:form>
                                        </s:if>
                                    </div>
                                    <div class="enlaces">
                                        <div class="tdsiguiente"><a href="siguienteEducacionFormalOtrasInstituciones.action"><img src="imagenes/next.png" width="24" height="24"></a></div>
                                        <div class="tdatras"><a href="anteriorEducacionFormalOtrasInstituciones.action" class="tdatras"><img src="imagenes/atras.jpg" width="24" height="24"></a></div>
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