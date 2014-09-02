<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<html lang="es">
    <head>
        <title>Educaci�n no Formal</title>
        <meta charset="utf-8"/>
        <link rel="stylesheet" href="estilo.css">
    </head>
    <body>
        <div id="Tabla" align="center">
            <table rules="all" >
                <caption>EDUCACI�N NO FORMAL</caption>
                <tr>
                    <td class="tddos">Ciudad<br>
                    </td>
                    <td class="tddos">Instituci�n<br>
                    </td>
                    <td class="tddos">Tipo Educaci�n no Formal<br>
                    </td>
                    <td class="tddos">Intensidad Horaria<br>
                    </td>
                    <td class="tddos">A�o Finalizaci�n<br>
                    </td>
                    <td class="tddos">Estado<br>
                    </td>
                    <td class="tddos">Acci�n<br>
                    </td>
                </tr>

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
                                <img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/Icono_de_editar.png" align="top"><br>
                            </s:a>
                            <s:url id="borrarURL" action="borrarEducacionNoFormal.action">
                                <s:param name="idObjeto" value="%{idEducacion}"></s:param>
                            </s:url>
                            <s:a href="%{borrarURL}">
                                <img style="width: 20px; height: 19px;" title="Borrar" alt="Borrar" src="imagenes/Icono_de_editar.png" align="top"><br>
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
            <br>
            <a href="informacionAcademicaNoFormalTabla.jsp" class="tduno"><div>Siguiente</div></a>
            <br>
            <a href="obtenerListaEducacionFormalOtrasInstituciones.action" class="tdatras"><div>Atras</div></a>
            <br>
            <br>

        </div>

        <div id="contenido1">
            <s:if test="editar">
                <s:form action="guardarEducacionNoFormal.action">
                    <s:push value="objeto">
                        <s:hidden name="idEducacion"></s:hidden>
                            <div class="tdun">Generar Nuevo Registro</div>
                            <table>
                                <tr>
                                    <td>
                                        <div class="tduno"> Ciudad </div><s:select cssClass="center" name="ciudad" list="listaCiudades" listKey="idCiudad" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Instituci�n </div><s:select cssClass="center" name="institucion" list="listaInstituciones" listKey="idInstitucion" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Tipo Educaci�n no Formal </div><s:select cssClass="center" name="tipoEdNoFormal" list="listaTiposEdNoFormal" listKey="idTipoEdNoFormal" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Cual </div><s:textfield name="otroTipoEdNoFormal"></s:textfield>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> T�tulo </div><s:textfield name="titulo"></s:textfield>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Descripci�n </div><s:textfield name="descripcion"></s:textfield>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> �rea estudios </div><s:select cssClass="center" name="areaEstudios" list="listaAreasEstudios" listKey="idAreaEstudios" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Modalidad </div><s:select cssClass="center" name="modalidad" list="listaModalidades" listKey="idModalidad" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Intensidad Horaria </div><s:select cssClass="center" name="intensidadHoraria" list="listaIntensidadesHorarias" listKey="idIntensidadHoraria" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> A�o Inicio </div><s:select cssClass="center" name="anioInicio" list="listaAnios"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Mes Inicio </div><s:select cssClass="center" name="mesInicio" list="listaMeses" listKey="idMes" listValue="mes"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> A�o Finalizaci�n </div><s:select cssClass="center" name="anioFinalizacion" list="listaAnios"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Mes Finalizaci�n </div><s:select cssClass="center" name="mesFinalizacion" list="listaMeses" listKey="idMes" listValue="mes"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Estado </div><s:select cssClass="center" name="estadoEducacion" list="listaEstadosEducacion" listKey="idEstadoEducacion" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                            <s:submit cssClass="center1" value="Guardar">
                                <br>
                            </s:submit>
                        </table>
                    </s:push>
                </s:form>
            </s:if>
        </div>
    </body>
</html>