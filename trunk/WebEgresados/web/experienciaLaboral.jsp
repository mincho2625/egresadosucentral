<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<html lang="es">
    <head>
        <title>Experiencia Laboral</title>
        <meta charset="utf-8"/>
        <link rel="stylesheet" href="estilo.css">
    </head>
    <body>
        <div id="Tabla" align="center">
            <table rules="all" >
                <caption>Experiencia Laboral</caption>
                <tr>
                    <td class="tddos">Tipo Contrato<br>
                    </td>
                    <td class="tddos">Empresa<br>
                    </td>
                    <td class="tddos">Cargo<br>
                    </td>
                    <td class="tddos">Ingreso<br>
                    </td>
                    <td class="tddos">Finalización<br>
                    </td>

                </tr>

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
                            <td class="tdtres"><s:property value="anioFinalizacion"></s:property><br>
                            </td>
                            <td class="tdtres">
                            <s:url id="editarURL" action="editarExperienciaLaboral.action">
                                <s:param name="idObjeto" value="%{idExperienciaLaboral}"></s:param>
                            </s:url>
                            <s:a href="%{editarURL}">
                                <img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/Icono_de_editar.png" align="top"><br>
                            </s:a>
                            <s:url id="borrarURL" action="borrarExperienciaLaboral.action">
                                <s:param name="idObjeto" value="%{idExperienciaLaboral}"></s:param>
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
                <a href="desplegarExperienciaLaboral.action" target="contenido">
                    <button type="submit" class="positive" name="nuevo">
                        <img src="imagenes/btnGuardar.png" alt=""/>
                        Nuevo
                    </button>
                </a><br>
            </div>
            <br>
            <a href="obtenerListaEducacionFormalUCentral.action" class="tduno"><div>Siguiente</div></a>
            <br>
            <a href="obtenerListaResidencia.action" class="tdatras"><div>Anterior</div></a>
            <br>
            <br>

        </div>

        <div id="contenido1">
            <s:if test="editar">
                <s:form action="guardarExperienciaLaboral.action">
                    <s:push value="objeto">
                        <s:hidden name="idExperienciaLaboral"></s:hidden>
                            <div class="tdun">Generar Nuevo Registro</div>
                            <br>
                            <table>
                                <tr>
                                    <td>
                                        <div class="tduno">Tipo Contrato</div><s:select  cssClass="center" name="tipoContrato" list="listaTiposContrato" listKey="idTipoContrato" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno">Nombre Empresa</div><s:textfield cssClass="center" name="nombreEmpresa"></s:textfield>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno">Ciudad</div><s:select cssClass="center" name="ciudad" list="listaCiudades" listKey="idCiudad" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno">Cargo</div><s:textfield cssClass="center" name="cargo"></s:textfield>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno">Tipos SubSector</div><s:select cssClass="center" name="subsector" list="listaSubsectores" listKey="idSubsector" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno">Nivel del Cargo</div><s:select cssClass="center" name="nivelCargo" list="listaNivelesCargo" listKey="idNivelCargo" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno">Area de la Empresa</div><s:select cssClass="center" name="areaEmpresa" list="listaAreasEmpresa" listKey="idAreaEmpresa" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                    <s:checkbox cssClass="checkbox" name="conexionInternet" > <div class="tduno">Conexion a internet </div> </s:checkbox>
                                    </td>
                                </tr>  
                                <tr>
                                    <td>
                                        <div class="tduno">Rango salarial</div><s:select cssClass="center" name="rangoSalarial" list="listaRangosSalariales" listKey="idRangoSalarial" listValue="descripcion"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno">Funciones Logros</div><s:textarea cssClass="center" name="funcionesLogros"></s:textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno"> Telefono de la Empresa</div><s:textfield cssClass="center" name="telefonoEmpresa"></s:textfield>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno">Cargo Equivalente</div><s:select cssClass="center" name="cargoEquivalente" list="listaCargosEquivalentes" listKey="idCargoEquivalente" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno">Jefe Inmediato</div><s:textfield cssClass="center" name="jefeInmediato"></s:textfield>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno">Año de ingreso</div><s:select cssClass="center" name="anioIngreso" list="listaAnios"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno">Mes de ingreso</div><s:select cssClass="center" name="mesIngreso" list="listaMeses" listKey="idMes" listValue="mes"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno">Año Finalización</div><s:select cssClass="center" name="anioFinalizacion" list="listaAnios"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno">Mes Finalización</div><s:select cssClass="center" name="mesFinalizacion" list="listaMeses" listKey="idMes" listValue="mes"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                <s:submit cssClass="center1" value="Guardar">
                                </s:submit>
                            </tr>
                        </table>
                    </s:push>
                </s:form>
            </s:if>
        </div>
    </body>
</html>