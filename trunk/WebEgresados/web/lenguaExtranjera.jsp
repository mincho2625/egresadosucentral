<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<html lang="es">
    <head>
        <title>Lengua Extranjera</title>
        <meta charset="utf-8"/>
        <link rel="stylesheet" href="estilo.css">
    </head>
    <body>
        <div id="Tabla" align="center">
            <table rules="all" >
                <caption>LENGUA EXTRANJERA</caption>
                <tr>
                    <td class="tddos">Ciudad<br>
                    </td>
                    <td class="tddos">Institución<br>
                    </td>
                    <td class="tddos">Dominio<br>
                    </td>
                    <td class="tddos">Idioma<br>
                    </td>
                    <td class="tddos">Año Finalización<br>
                    </td>
                    <td class="tddos">Estado<br>
                    </td>
                    <td class="tddos">Acción<br>
                    </td>
                </tr>

                <s:iterator value="listaObjetos">
                    <tr>
                        <td class="tdtres"><s:property value="idCiudad.nombre"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="idInstitucion.nombre"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="idDominio.dominioLenguaExt"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="idIdioma.nombre"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="anioFinalizacion"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="idEstadoEducacion.nombre"></s:property><br>
                            </td>
                            <td class="tdtres">
                            <s:url id="editarURL" action="editarLenguaExtranjera.action">
                                <s:param name="idObjeto" value="%{idEducacion}"></s:param>
                            </s:url>
                            <s:a href="%{editarURL}">
                                <img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/Icono_de_editar.png" align="top"><br>
                            </s:a>
                            <s:url id="borrarURL" action="borrarLenguaExtranjera.action">
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
                <a href="desplegarLenguaExtranjera.action" target="contenido">
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
                <s:form action="guardarLenguaExtranjera.action">
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
                                        <div class="tduno"> Institución </div><s:select cssClass="center" name="institucion" list="listaInstituciones" listKey="idInstitucion" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Dominio </div><s:select cssClass="center" name="dominio" list="listaDominioLenguaExt" listKey="idDominioLenguaExt" listValue="dominioLenguaExt"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Área estudios </div><s:select cssClass="center" name="areaEstudios" list="listaAreasEstudios" listKey="idAreaEstudios" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Modalidad </div><s:select cssClass="center" name="modalidad" list="listaModalidades" listKey="idModalidad" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Idioma </div><s:select cssClass="center" name="idioma" list="listaIdiomas" listKey="idIdioma" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Año Inicio </div><s:select cssClass="center" name="anioInicio" list="listaAnios"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Mes Inicio </div><s:select cssClass="center" name="mesInicio" list="listaMeses" listKey="idMes" listValue="mes"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Año Finalización </div><s:select cssClass="center" name="anioFinalizacion" list="listaAnios"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Mes Finalización </div><s:select cssClass="center" name="mesFinalizacion" list="listaMeses" listKey="idMes" listValue="mes"></s:select>
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