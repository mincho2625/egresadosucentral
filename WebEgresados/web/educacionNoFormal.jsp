<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<html lang="es">
    <head><title>Registro Sistema</title>
        <meta charset="utf-8">
        <link href="estilo2.css" rel="stylesheet" type="text/css">
        <s:head/>
        <jq:head jqueryui="true" />
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script>document.documentElement.className = "js";</script>
        <script src="vendor/jquery-1.9.1.js"></script>
        <script src="vendor/json2.js"></script>
        <script src="src/jquery.collapse.js"></script>
        <script src="src/jquery.collapse_storage.js"></script>
        <script src="src/jquery.collapse_cookie_storage.js"></script>

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

            function fnOtroTipoEdNoFormal(checked)
            {
                if (checked) {
                    tipoEdNoFormal.disabled = true;
                    otroTipoEdNoFormal.disabled = false;
                }
                else {
                    tipoEdNoFormal.disabled = false;
                    otroTipoEdNoFormal.disabled = true;
                }
            }
        </script>
    </head>
    <body>
        <div class="TituloPrincipal" style="/* [disabled]margin-left:10px; */ font-size: 20px">
            <div align="center">Portal Egresados  Universidad Central</div>
        </div>
        <div class="titu">
            <p align="left"><img src="imagenes/document-open.png" width="107" height="94">
                <span class="titu2">a a a</span><img src="imagenes/logosimbolo-ucentral-v1-medium.png" width="273" height="62">  <span class="titu2">a as</span>Educacion no Formal</p>
        </div>
        <!--<div id="default-example" data-collapse>
            <h3>Informacion</h3>-->
        <div align="center" class="tabla" id="Tabla">
            <table rules="all" class="table2" >
                <caption>&nbsp;</caption>
                <tr class="fuentetabla">
                    <td class="tddos">Ciudad<br>
                    </td>
                    <td class="tddos">Institucion<br>
                    </td>
                    <td class="tddos">Tipo Educacion no Formal<br>
                    </td>
                    <td class="tddos">Intensidad Horaria<br>
                    </td>
                    <td class="tddos">Ano Finalizacion<br>
                    </td>
                    <td class="tddos">Estado<br>
                    </td>
                    <td class="tddos">Accion<br>
                    </td>
                </tr>

                <s:hidden name="cantidadObjetos"></s:hidden>
                <s:iterator value="listaObjetos">
                    <tr>
                        <td class="tdtres"><s:property value="idCiudad.nombre"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="idInstitucion.nombre"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="idTipoEdNoFormal.nombre"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="idIntensidadHoraria.nombre"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="anioFinalizacion"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="idEstadoEducacion.nombre"></s:property><br>
                            </td>
                            <td class="tdtres">
                                <div class="fuentetabla2">
                                <s:url id="editarURL" action="editarEducacionNoFormal.action">
                                    <s:param name="idObjeto" value="%{idEducacion}" ></s:param>
                                </s:url>
                                <s:a href="%{editarURL}">
                                    <img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/editar-icono-8419-16.png" align="top">
                                </s:a>
                                <s:url id="borrarURL" action="borrarEducacionNoFormal.action">
                                    <s:param name="idObjeto" value="%{idEducacion}"></s:param>
                                </s:url>
                                <s:a href="%{borrarURL}">
                                    <img style="width: 20px; height: 19px;" title="Borrar" alt="Borrar" src="imagenes/eliminar.png" align="top">
                                </s:a></div>
                        </td>
                    </tr>
                </s:iterator>
            </table>
            <br>
            <div class="buttons">
                <a href="desplegarEducacionNoFormal.action" target="contenido">
                    <button type="submit" class="positive" name="nuevo">
                        <img src="imagenes/btnGuardar.png" alt=""/>
                        Nuevo
                    </button>
                </a><br>
            </div>
            <div class="fromtables" id="contenido1">
                <s:if test="editar">
                    <s:form action="guardarEducacionNoFormal.action" id="formEducacion">
                        <s:url id="ciudadURL" action="SelectCiudad"/>
                        <s:push value="objeto">
                            <s:hidden name="idEducacion"></s:hidden>
                                <div class="fuente2">
                                    <p>Generar Nuevo Registro                                </p>
                                </div>
                                <table >
                                    <tr>
                                        <td class="tduno">
                                            <jq:select href="%{ciudadURL}" onChangeTopics="reloadsecondlist" name="pais" id="pais"
                                                       list="listaPaises" listKey="id" listValue="nombre"
                                                       headerKey="-1" headerValue="- Seleccione -" label="País:"/>
                                        </td>
                                        <td>
                                            <jq:select href="%{ciudadURL}" onChangeTopics="reloadThirdlist" onCompleteTopics="reloadThirdlist"
                                                       formIds="formEducacion" reloadTopics="reloadsecondlist" name="departamento" id="departamento"
                                                       list="listaDepartamentos" listKey="id" listValue="nombre" headerKey="-1"
                                                       headerValue="- Seleccione -" label="Departamento:"/>
                                        </td>
                                        <td>
                                            <jq:select href="%{ciudadURL}" formIds="formEducacion" reloadTopics="reloadThirdlist"
                                                       name="ciudad" list="listaCiudades" listKey="id" listValue="nombre" headerKey="-1"
                                                       headerValue="- Seleccione -" id="ciudad" label="Ciudad:"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:select label="Institucion" cssClass="texfield" name="institucion" id="institucion" list="listaInstituciones" listKey="idInstitucion" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        <s:checkbox cssClass="texfield" name="checkOtraInstitucion" onchange="fnOtraInstitucion(this.checked);" label="Otra Instituciï¿½n"></s:checkbox>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:textfield name="otraInstitucion" id="otraInstitucion" disabled="true"></s:textfield>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:select  label="Tipo" cssClass="texfield" name="nivelEstudios" id="nivelEstudios" list="listaNivelesEstudios" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        <s:checkbox cssClass="texfield" name="checkOtroTipo" onchange="fnOtroTipoEdNoFormal(this.checked);" label="Otro"></s:checkbox>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:textfield label="Cual" name="otroNivelEstudios" id="otroNivelEstudios" cssClass="texfield" disabled="true"></s:textfield>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:select label="Area estudios " cssClass="texfield" name="areaEstudios" list="listaAreasEstudios" listKey="idAreaEstudios" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:textfield name="titulo" cssClass="texfield" label="Titulo"></s:textfield>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:textfield name="descripcion" label="Descripciï¿½n" cssClass="texfield"></s:textfield>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:select label="Modalidad" cssClass="texfield" name="modalidad" list="listaModalidades" listKey="idModalidad" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:select label="Intensidad Horaria" cssClass="texfield" name="intensidadHoraria" list="listaIntensidadesHorarias" listKey="idIntensidadHoraria" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:select label="Ano Inicio" cssClass="texfield" name="anioInicio" list="listaAnios" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:select cssClass="texfield" label="Mes Inicio " name="mesInicio" list="listaMeses" listKey="idMes" listValue="mes" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:select label="Ano Finalizacion" cssClass="texfield" name="anioFinalizacion" list="listaAnios" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:select label="Mes Finalizacion " cssClass="texfield" name="mesFinalizacion" list="listaMeses" listKey="idMes" listValue="mes" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:select cssClass="texfield"  label="Estado" name="estadoEducacion" list="listaEstadosEducacion" listKey="idEstadoEducacion" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        </td>
                                    </tr>
                                <s:actionerror></s:actionerror>
                                <s:submit cssClass="center1" value="Guardar">
                                    <br>
                                </s:submit>
                            </table>
                        </s:push>
                    </s:form>
                </s:if>
            </div>
        </div>
        <div class="enlaces">
            <div class="tdsiguiente"><a href="siguienteEducacionNoFormal.action"><img src="imagenes/next.png" width="24" height="24"></a></div>
            <div class="tdatras"><a href="anteriorEducacionNoFormal.action" class="tdatras"><img src="imagenes/atras.jpg" width="24" height="24"></a></div>
        </div>
        <s:if test="hasActionErrors()">
            <div class="errors">
                <s:actionerror/>
            </div>
        </s:if>
        <br>
        <br>
    </body>
</html>