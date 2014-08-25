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
            <br>

        </div>

        <div id="contenido">
            <s:if test="editar">
                <s:form action="guardarExperienciaLaboral.action">
                    <s:push value="objeto">
                        <s:hidden name="idExperienciaLaboral"></s:hidden>
                            <table>
                                <tr>
                                    <td>
                                        Tipo Contrato
                                    </td>
                                    <td>
                                    <s:select name="tipoContrato" list="listaTiposContrato" listKey="idTipoContrato" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Nombre Empresa
                                    </td>
                                    <td>
                                    <s:textfield name="nombreEmpresa"></s:textfield>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Ciudad
                                    </td>
                                    <td>
                                    <s:select name="ciudad" list="listaCiudades" listKey="idCiudad" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Cargo
                                    </td>
                                    <td>
                                    <s:textfield name="cargo"></s:textfield>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Tipos SubSector
                                    </td>
                                    <td>
                                    <s:select name="subsector" list="listaSubsectores" listKey="idSubsector" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Nivel del Cargo
                                    </td>
                                    <td>
                                    <s:select name="nivelCargo" list="listaNivelesCargo" listKey="idNivelCargo" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Area de la Empresa
                                    </td>
                                    <td>
                                    <s:select name="areaEmpresa" list="listaAreasEmpresa" listKey="idAreaEmpresa" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                    <s:checkbox cssClass="checkbox" name="conexionInternet">Conexion a internet</s:checkbox>
                                    </td>
                                </tr>  
                                <tr>
                                    <td>
                                        Rango salarial
                                    </td>
                                    <td>
                                    <s:select name="rangoSalarial" list="listaRangosSalariales" listKey="idRangoSalarial" listValue="descripcion"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Funciones Logros
                                    </td>
                                    <td>
                                    <s:textarea name="funcionesLogros"></s:textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Telefono de la Empresa
                                    </td>
                                    <td>
                                    <s:textfield name="telefonoEmpresa"></s:textfield>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Cargo Equivalente
                                    </td>
                                    <td>
                                    <s:select name="cargoEquivalente" list="listaCargosEquivalentes" listKey="idCargoEquivalente" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Jefe Inmediato
                                    </td>
                                    <td>
                                    <s:textfield name="jefeInmediato"></s:textfield>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Año de ingreso
                                    </td>
                                    <td>
                                    <s:select name="anioIngreso" list="listaAnios"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Mes de ingreso
                                    </td>
                                    <td>
                                    <s:select name="mesIngreso" list="listaMeses" listKey="idMes" listValue="mes"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Año Finalización
                                    </td>
                                    <td>
                                        <s:select name="anioFinalizacion" list="listaAnios"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Mes Finalización
                                    </td>
                                    <td>
                                    <s:select name="mesFinalizacion" list="listaMeses" listKey="idMes" listValue="mes"></s:select>
                                    </td>
                                </tr>
                            <s:submit cssClass="positive">
                                <img src="imagenes/btnGuardar.png" alt=""/>Guardar<br>
                            </s:submit>
                            </tr>
                        </table>
                    </s:push>
                </s:form>
            </s:if>
        </div>
    </body>
</html>