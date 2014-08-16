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
                    <td class="tddos">Id Tipo Contrato<br>
                    </td>
                    <td class="tddos">NOMBRE EMPRESA<br>
                    </td>
                    <td class="tddos">CARGO<br>
                    </td>
                    <td class="tddos">Id Subsector<br>
                    </td>
                    <td class="tddos">Id Nivel Cargo<br>
                    </td>
                    <td class="tddos">Id Area Empresa<br>
                    </td>
                    <td class="tddos">Conexion Internet<br>
                    </td>
                    <td class="tddos">Id Rango Salarial<br>
                    </td>
                    <td class="tddos">Fecha Registro<br>
                    </td>
                    <td class="tddos">Funciones Logros<br>
                    </td>
                    <td class="tddos">Telefono Empresa<br>
                    </td>
                    <td class="tddos">Id Cargo Equivalente<br>
                    </td>
                    <td class="tddos">Jefe Inmediato<br>
                    </td>
                    <td class="tddos">Id Mes Ingreso<br>
                    </td>
                    <td class="tddos">Id Mes Finalizacion<br>
                    </td>
                    <td class="tddos">Año Iingreso<br>
                    </td>
                    <td class="tddos">Año Ffinalizacion<br>
                    </td>

                </tr>

                <s:iterator value="listaObjetos">
                    <tr>
                        <td class="tdtres"><s:property value="idRedSocial"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="url"></s:property><br>
                            </td>
                            <td class="tdtres">
                            <s:url id="editarURL" action="editarEgresadoRedSocial.action">
                                <s:param name="idObjeto" value="%{idEgresadoRedSocial}"></s:param>
                            </s:url>
                            <s:a href="%{editarURL}">
                                <img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/Icono_de_editar.png" align="top"><br>
                            </s:a>
                            <s:url id="borrarURL" action="borrarEgresadoRedSocial.action">
                                <s:param name="idObjeto" value="%{idEgresadoRedSocial}"></s:param>
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
                <s:form action="guardarEgresadoRedSocial.action">
                    <s:push value="objeto">
                        <s:hidden name="idEgresadoRedSocial"></s:hidden>
                            <table>
                                <tr>
                                    <td>
                                        Tipo Contrato
                                    </td>
                                    <td>
                                    <s:select name="idTipoContrato" list="listaTipoContacto" listKey="idTipoContrato" listValue="nombre"></s:select>
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
                                    <s:select name="idSubsector" list="listasubSector" listKey="idSubsector" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Tipos Nivel Cargo
                                    </td>
                                    <td>
                                    <s:select name="idNivelCargo" list="ListaNivelCargo" listKey="idNivelCargo" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Area de la Empresa
                                    </td>
                                    <td>
                                    <s:select name="idAreaEmpresa" list="ListaAreaEmpresa" listKey="idAreaEmpresa" listValue="nombre"></s:select>
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
                                    <s:select name="idRangoSalarial" list="ListaRangoSalarial" listKey="idRangoSalarial" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Fecha de Registro
                                    </td>
                                    <td>
                                <jq:datepicker name="fechaRegistro" changeMonth="true" changeYear="true" showButtonPanel="true"></jq:datepicker>
                                <br>
                                </td>
                                </tr>
                                <tr>
                                    <td>
                                        Funciones Logros
                                    </td>
                                    <td>
                                    <s:textfield name="funcionesLogros"></s:textfield>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Telefono Empresa
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
                                    <s:select name="idCargoEquivalente" list="ListaCargoEquivalente" listKey="idCargoEquivalente" listValue="nombre"></s:select>
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
                                        Mes de ingreso
                                    </td>
                                    <td>
                                    <s:select name="idMes" list="listaMesIngreso" listKey="idMes" listValue="mes"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Mes de ingreso
                                    </td>
                                    <td>
                                    <s:select name="idMes" list="listaMesTerminacion" listKey="idMes" listValue="mes"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Año de ingreso
                                    </td>
                                    <td>
                                    <s:textfield name="anioIngreso"></s:textfield>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Año de Terminacion
                                    </td>
                                    <td>
                                    <s:textfield name="anioFinalizacion"></s:textfield>
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