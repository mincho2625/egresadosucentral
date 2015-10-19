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
            function fnTrabajoActual(checked)
            {
                if (checked) {
                    anioFinalizacion.disabled = true;
                    mesFinalizacion.disabled = true;
                }
                else {
                    anioFinalizacion.disabled = false;
                    mesFinalizacion.disabled = false;
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
                                <img style="text-align: center;width: 100px;height: 100px"src="imagenes/empleo.png">
                            </div>
                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 ">
                                <h1 style="margin-left: -30px;color: #2a6155;width:300px">Experiencia Laboral</h1>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
                                <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
                                    <table rules="all" class="table table-striped table-bordered tabla_verde" style="margin-left: -100px;width: 600px">
                                        <thead>
                                            <tr>
                                                <th>Tipo Contrato</th>
                                                <th>Empresa</th>
                                                <th>Cargo</th>
                                                <th>Ingreso</th>
                                                <th>Finalizacion</th>
                                                <th>Accion</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <s:hidden name="cantidadObjetos"></s:hidden>
                                            <s:iterator value="listaObjetos">
                                                <tr>
                                                    <td><s:property value="idTipoContrato.nombre"></s:property><br>
                                                        </td>
                                                        <td><s:property value="nombreEmpresa"></s:property><br>
                                                        </td>
                                                        <td><s:property value="cargo"></s:property><br>
                                                        </td>
                                                        <td><s:property value="anioIngreso"></s:property><br>
                                                        </td>
                                                        <td><s:property value="anioFinalizacion"></s:property>
                                                            <br>
                                                        </td>
                                                        <td>  
                                                            <div class="fuentetabla2">
                                                            <s:url id="editarURL" action="editarExperienciaLaboral.action">
                                                                <s:param name="idObjeto" value="%{idExperienciaLaboral}" ></s:param>
                                                            </s:url>
                                                            <s:a href="%{editarURL}">
                                                                <img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/editar-icono-8419-16.png" align="top">
                                                            </s:a>
                                                            <s:url id="borrarURL" action="borrarExperienciaLaboral.action">
                                                                <s:param name="idObjeto" value="%{idExperienciaLaboral}"></s:param>
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
                                        <a href="crearExperienciaLaboral.action" target="contenido">
                                            <button  type="submit" class="boton_descargar boton guardar" name="nuevo">
                                                Registro Nuevo
                                            </button>
                                        </a>
                                    </div>
                                    <s:if test="hasActionErrors()">
                                        <div style="width: 450px">
                                            <s:actionerror cssClass="alert alert-danger"/>
                                        </div>
                                    </s:if>
                                    <div class="tabla" id="contenido1">
                                        <s:if test="editar">
                                            <h3 style="margin-left: 50px;width: 400px">Agregar Nueva Experiencia Laboral</h3>
                                            <s:form action="guardarExperienciaLaboral.action" id="formExperienciaLaboral">
                                                <s:url id="ciudadURL" action="SelectCiudad"/>
                                                <s:url id="subsectorURL" action="SelectSubsector"/>
                                                <s:push value="objeto">
                                                    <s:hidden name="idExperienciaLaboral"></s:hidden>
                                                    <s:set name="actual" value="trabajoActual"></s:set>
                                                        <table style="margin-left: -100px;width: 500px">
                                                            <tr>
                                                                <td><s:select label="Tipo Contrato" errorPosition="bottom" name="tipoContrato" list="listaTiposContrato" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:textfield name="nombreEmpresa" label="Nombre Empresa" errorPosition="bottom"></s:textfield></td>
                                                            </tr>
                                                            <tr>
                                                                <td><jq:select href="%{ciudadURL}" onChangeTopics="reloadsecondlist" name="pais" id="pais"
                                                                   list="listaPaises" listKey="id" listValue="nombre" onCompleteTopics="reloadsecondlist"
                                                                   headerKey="-1" headerValue="- Seleccione -" label="País" errorPosition="bottom"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><jq:select href="%{ciudadURL}" onChangeTopics="reloadThirdlist" onCompleteTopics="reloadThirdlist"
                                                                       formIds="formExperienciaLaboral" reloadTopics="reloadsecondlist" name="departamento" id="departamento"
                                                                       list="listaDepartamentos" listKey="id" listValue="nombre" headerKey="-1"
                                                                       headerValue="- Seleccione -" label="Departamento" errorPosition="bottom"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><jq:select href="%{ciudadURL}" formIds="formExperienciaLaboral" reloadTopics="reloadThirdlist"
                                                                       name="ciudad" list="listaCiudades" listKey="id" listValue="nombre" headerKey="-1"
                                                                       headerValue="- Seleccione -" id="ciudad" label="Ciudad" errorPosition="bottom"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><s:textfield name="telefonoEmpresa" label="Teléfono Empresa" errorPosition="bottom"></s:textfield></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:select label="Área de la Empresa" errorPosition="bottom" name="areaEmpresa" list="listaAreasEmpresa" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                                                            </tr>
                                                            <tr>
                                                                <td>:</td
                                                                <td><s:textfield  name="cargo" label="Cargo" errorPosition="bottom"></s:textfield></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:select label="Nivel del Cargo" errorPosition="bottom" name="nivelCargo" list="listaNivelesCargo" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:select label="Cargo Equivalente" errorPosition="bottom" name="cargoEquivalente" list="listaCargosEquivalentes" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                                                            </tr>
                                                            <tr>
                                                                <td>
                                                                <jq:select href="%{subsectorURL}" onChangeTopics="reloadsecondlist2" name="sector" id="sector"
                                                                       list="listaSectores" listKey="id" listValue="nombre" onCompleteTopics="reloadsecondlist2"
                                                                       headerKey="-1" headerValue="- Seleccione -" label="Sector" errorPosition="bottom"/>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>
                                                                    <jq:select href="%{subsectorURL}" formIds="formExperienciaLaboral" reloadTopics="reloadsecondlist2"
                                                                       name="subsector" id="subsector" list="listaSubsectores" listKey="id" 
                                                                       listValue="nombre" headerKey="-1" headerValue="- Seleccione -" label="Subsector" errorPosition="bottom"/>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:select label="Rango salarial" errorPosition="bottom" name="rangoSalarial" list="listaRangosSalariales" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:textfield name="jefeInmediato" label="Jefe Inmediato" errorPosition="bottom"></s:textfield></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:textarea name="funcionesLogros" label="Funciones Logros" errorPosition="bottom"></s:textarea></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:checkbox cssClass="checkbox" name="conexionInternet" label="Conexión a internet" errorPosition="bottom"></s:checkbox></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:select label="Año de ingreso" errorPosition="bottom" name="anioIngreso" list="listaAnios" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:select label="Mes de ingreso" errorPosition="bottom" name="mesIngreso" list="listaMeses" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:checkbox label="Trabajo actual" name="trabajoActual" onchange="fnTrabajoActual(this.checked);"></s:checkbox></td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:select label="Año Finalización" disabled="%{#actual}" errorPosition="bottom" name="anioFinalizacion" id="anioFinalizacion" list="listaAnios" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td><s:select label="Mes Finalización" disabled="%{#actual}" errorPosition="bottom" name="mesFinalizacion" id="mesFinalizacion" list="listaMeses" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
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
                                        <div class="tdsiguiente"><a href="siguienteExperienciaLaboral.action"><img src="imagenes/next.png" width="24" height="24"></a></div>
                                        <div class="tdatras"><a href="anteriorExperienciaLaboral.action" class="tdatras"><img src="imagenes/atras.jpg" width="24" height="24"></a></div>
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