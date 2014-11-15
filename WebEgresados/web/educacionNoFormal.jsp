<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<html lang="es">
    <head><title>Registro Sistema</title>
        <meta charset="utf-8">
        <link href="estilo2.css" rel="stylesheet" type="text/css">
        <jq:head></jq:head>
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
                    else{
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
                    else{
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
                <p align="left"><img src="imagenes/document-open.png" width="107" height="94">		      <span class="titu2">a a a</span><img src="imagenes/logosimbolo-ucentral-v1-medium.png" width="273" height="62">  <span class="titu2">a as</span>Educacion no Formal</p>
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
                            <s:url id="editarURL" action="editarEducacionNoFormal.action">
                                <s:param name="idObjeto" value="%{idEducacion}"></s:param>
                            </s:url>
                            <s:a href="%{editarURL}">
                                <div class="fuentetabla2"><img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/Icono_de_editar.png" align="top">Editar</div><br>
                            </s:a>
                            <s:url id="borrarURL" action="borrarEducacionNoFormal.action">
                                <s:param name="idObjeto" value="%{idEducacion}"></s:param>
                            </s:url>
                            <s:a href="%{borrarURL}">
                                <div class="fuentetabla2"><img style="width: 20px; height: 19px;" title="Borrar" alt="Borrar" src="imagenes/Icono_de_editar.png" align="top">Borrar</div><br>
                            </s:a>
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
                    <s:form action="guardarEducacionNoFormal.action">
                        <s:push value="objeto">
                            <s:hidden name="idEducacion"></s:hidden>
                                <div class="fuente2">
                                  <p>Generar Nuevo Registro                                </p>
                                </div>
                                <table >
                                    <tr>
                                        <td>
                                        <s:select label="Ciudad" cssClass="texfield" name="ciudad" list="listaCiudades" listKey="idCiudad" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:select label="Institucion" cssClass="texfield" name="institucion" id="institucion" list="listaInstituciones" listKey="idInstitucion" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        <s:checkbox cssClass="texfield" name="checkOtraInstitucion" onchange="fnOtraInstitucion(this.checked);" label="Otra Institución"></s:checkbox>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <s:textfield name="otraInstitucion" id="otraInstitucion" disabled="true"></s:textfield>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:select  label="Tipo" cssClass="texfield" name="tipoEdNoFormal" id="tipoEdNoFormal" list="listaTiposEdNoFormal" listKey="idTipoEdNoFormal" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                        <s:checkbox cssClass="texfield" name="checkOtroTipo" onchange="fnOtroTipoEdNoFormal(this.checked);" label="Otro"></s:checkbox>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:textfield label="Cual" name="otroTipoEdNoFormal" id="otroTipoEdNoFormal" cssClass="texfield" disabled="true"></s:textfield>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:textfield name="titulo" cssClass="texfield" label="Titulo"></s:textfield>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:textfield name="descripcion" label="Descripción" cssClass="texfield"></s:textfield>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                        <s:select label="Area estudios " cssClass="texfield" name="areaEstudios" list="listaAreasEstudios" listKey="idAreaEstudios" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
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
        <!--</div>-->
        <p></p>
        <p><br>
        </p>
        <a href="siguienteEducacionNoFormal.action"><div class="tdsiguiente"><img src="imagenes/button_next_89675.jpg" width="21" height="21"></div></a>
        <br>
        <a href="anteriorEducacionNoFormal.action" class="tdatras"><div class="tdatras"><img src="imagenes/boton_atras.png" width="24" height="24"></div></a>
        <br>
        <br>
        <br>
        <s:if test="hasActionErrors()">
            <div class="errors">
               <s:actionerror/>
            </div>
        </s:if>
        <br>
        <br>
    </body>
</html>