<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<html lang="es">
    <head><title>Registro Sistema</title>
        <meta charset="utf-8">
        <link href="estilo2.css" rel="stylesheet" type="text/css">
        <jq:head jqueryui="true" />
        </head>
        <body>
            <div class="TituloPrincipal" style="/* [disabled]margin-left:10px; */ font-size: 20px">
                <div align="center">Portal Egresados  Universidad Central</div>
            </div>
            <div class="titu">
                <p align="left"><img src="imagenes/document-open.png" width="107" height="94">		      <span class="titu2">a a a</span><img src="imagenes/logosimbolo-ucentral-v1-medium.png" width="273" height="62">  <span class="titu2">a asda </span>Datos de Ubicacion</p>
            </div>
            <!--<div id="default-example" data-collapse>
                <h3>Informacion</h3>-->
            <div align="center" class="tabla" id="Tabla">
                <table rules="all" class="table2" >
                    <caption>Experiencia Laboral</caption>
                    <tr>
                        <td class="texfield"><div align="center" class="fuentetabla">Tipo Contrato<br>
                            </div></td>
                        <td class="texfield"><div align="center" class="fuentetabla">Empresa<br>
                            </div></td>
                        <td class="texfield"><div align="center" class="fuentetabla">Cargo<br>
                            </div></td>
                        <td class="texfield"><div align="center" class="fuentetabla">Ingreso<br>
                            </div></td>
                        <td class="texfield"><div align="center" class="fuentetabla">Finalizacion<br>
                            </div></td>

                    </tr>

                <s:hidden name="cantidadObjetos"></s:hidden>
                <s:iterator value="listaObjetos">
                    <tr>
                        <td class="tdtres"><s:property value="idTipoContrato.nombre"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="nombreEmpresa"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="cargo"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="anioIngreso"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="anioFinalizacion"></s:property>
                            <br>
                        </td>
                        <td class="tdtres">  
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
            </table>
            <br>
            <div class="fromtables">
                <a href="desplegarExperienciaLaboral.action" target="contenido">
                    <button type="submit" class="positive" name="nuevo">
                        <img src="imagenes/btnGuardar.png" alt=""/>
                        Nuevo
                    </button>
                </a><br>
            </div>
            <br>
            <div class="tabla" id="contenido1">
                <s:if test="editar">
                    <s:form action="guardarExperienciaLaboral.action" id="formExperienciaLaboral">
                        <s:url id="ciudadURL" action="SelectCiudad"/>
                        <s:push value="objeto">
                            <s:hidden name="idExperienciaLaboral"></s:hidden>
                                <div class="fuente2">Agregar Nueva Experiencia Laboral</div>
                                <br>
                                <table>
                                    <tr>
                                        <td>
                                            <span class="tabla">
                                            <s:select  label="Tipo Contrato" cssClass="texfield" name="tipoContrato" list="listaTiposContrato" listKey="idTipoContrato" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></span></td>
                                    </tr>
                                    <tr>
                                        <td class="texfield"><div align="center">
                                            </div><s:textfield label="Nombre Empresa" cssClass="texfield" name="nombreEmpresa"></s:textfield>                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="tduno">
                                            <jq:select href="%{ciudadURL}" onChangeTopics="reloadsecondlist" name="pais" id="pais"
                                                       list="listaPaises" listKey="id" listValue="nombre" onCompleteTopics="reloadsecondlist"
                                                       headerKey="-1" headerValue="- Seleccione -" label="Pa�s:"/>
                                        </td>
                                        <td>
                                            <jq:select href="%{ciudadURL}" onChangeTopics="reloadThirdlist" onCompleteTopics="reloadThirdlist"
                                                       formIds="formExperienciaLaboral" reloadTopics="reloadsecondlist" name="departamento" id="departamento"
                                                       list="listaDepartamentos" listKey="id" listValue="nombre" headerKey="-1"
                                                       headerValue="- Seleccione -" label="Departamento:"/>
                                        </td>
                                        <td>
                                            <jq:select href="%{ciudadURL}" formIds="formExperienciaLaboral" reloadTopics="reloadThirdlist"
                                                       name="ciudad" list="listaCiudades" listKey="id" listValue="nombre" headerKey="-1"
                                                       headerValue="- Seleccione -" id="ciudad" label="Ciudad:"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><div align="center">
                                            </div>
                                        <s:textfield label="Telefono de la Empresa" cssClass="texfield" name="telefonoEmpresa"></s:textfield>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="texfield"><s:select label="Area de la Empresa" cssClass="texfield" name="areaEmpresa" list="listaAreasEmpresa" listKey="idAreaEmpresa" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="texfield"><div align="center">
                                            </div>                                          <s:textfield label="Cargo" cssClass="texfield" name="cargo"></s:textfield>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="texfield"><s:select cssClass="texfield" label="Nivel del Cargo" name="nivelCargo" list="listaNivelesCargo" listKey="idNivelCargo" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><s:select label="Cargo Equivalente" cssClass="texfield" name="cargoEquivalente" list="listaCargosEquivalentes" listKey="idCargoEquivalente" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="texfield"><s:select label="Tipos SubSector" cssClass="texfield" name="subsector" list="listaSubsectores" listKey="idSubsector" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td class="texfield"><s:select label="Rango salarial" cssClass="texfield" name="rangoSalarial" list="listaRangosSalariales" listKey="idRangoSalarial" listValue="descripcion" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><div align="center">
                                            </div>                                          <s:textfield label="Jefe Inmediato" cssClass="texfield" name="jefeInmediato"></s:textfield>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><div align="center">
                                            </div>                                          <s:textarea label="Funciones Logros" cssClass="texfield" name="funcionesLogros"></s:textarea>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="texfield"><s:checkbox cssClass="checkbox" name="conexionInternet" label="Conexion a internet"></s:checkbox>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><s:select label="Ano de ingreso" cssClass="texfield" name="anioIngreso" list="listaAnios" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><s:select label="Mes de ingreso" cssClass="texfield" name="mesIngreso" list="listaMeses" listKey="idMes" listValue="mes" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><s:select label="Ano Finalizacion" cssClass="texfield" name="anioFinalizacion" list="listaAnios" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><s:select label="Mes Finalizacion" cssClass="texfield" name="mesFinalizacion" list="listaMeses" listKey="idMes" listValue="mes" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><div align="center"><span class="tabla">
                                                </span>                                      <span class="tabla">
                                                </span></div>
                                            <span class="tabla">
                                            <s:actionerror></s:actionerror>
                                            <s:submit cssClass="center1" value="Guardar">
                                            </s:submit></span>
                                    </td>
                                </tr>
                            </table>
                        </s:push>
                    </s:form>
                </s:if>
            </div> 
        </div>
        <div class="enlaces">
            <div class="tdsiguiente"><a href="siguienteExperienciaLaboral.action"><img src="imagenes/next.png" width="24" height="24"></a></div>
            <div class="tdatras"><a href="anteriorExperienciaLaboral.action" class="tdatras"><img src="imagenes/atras.jpg" width="24" height="24"></a></div>
        </div>
        <s:if test="hasActionErrors()">
            <div class="errors">
                <s:actionerror/>
            </div>
        </s:if>
    </body>
</html>