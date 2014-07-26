<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/struts-dojo-tags" prefix="d"%>
<html lang="es">
    <head>
        <title>Formulario Principal Nuevos</title>
        <meta charset="utf-8"/>
        <link rel="stylesheet" href="estilo.css">
        <d:head />
    </head>

    <body>
        <div id="cabecera"><img src="imagenes/logosimbolo-ucentral-v1-large.png">
        </div>

        <div id="Tabla" align="center">
            <s:form action="crearEgresadoRegistro.action" id="formRegistro"> <br>

                <table cellpadding="2" cellspacing="12">
                    <caption>REGISTRO EN EL SISTEMA</caption>
                    <tr>
                        <td class="tduno">Primer Apellido:
                        </td>
                        <td class="tduno">Segundo Apellido:
                        </td>
                        <td class="tduno" colspan="2">Nombres:</td>
                    </tr>
                    <tr>
                        <td><s:textfield name="primerApellido"/></td>
                        <td><s:textfield name="segundoApellido"/></td>
                        <td colspan="2"><s:textfield name="nombres"/></td>
                    </tr>
                    <tr>
                        <td class="tduno">Fecha Nacimiento:<br>
                        </td>
                        <td class="tduno">Numero Documento:<br>
                        </td>
                        <td class="tduno">Fecha Expedicion:<br>
                        </td>
                        <td class="tduno">Pais Expedicion:<br>
                        </td>
                    </tr>
                    <tr>
                        <td><d:datetimepicker name="fechaNacimiento"/><br>
                        </td>
                        <td><s:number name="numeroDocumento"/><br>
                        </td>
                        <td><s:date name="fechaExpedicion"/><br>
                        </td>
                        <td>
                            <s:url var="refrescarPaisesURL" action="refrescarPaises"></s:url>

                            </td>
                        </tr>
                        <tr>
                            <td class="tduno">DepartamentoExpedicion:<br>
                            </td>
                            <td class="tduno">Ciudad Expedicion:<br>
                            </td>
                            <td class="tduno">Tipo Documento:<br>
                            </td>
                            <td class="tduno">Grupo Sanguineo:<br>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <br>
                            </td>
                            <td>
                            <s:select
                                id="ciudadExpedicion"
                                name="ciudadExpedicion"
                                list="listaCiudades"
                                listKey="idCiudad"
                                listValue="nombre"
                                headerKey="-1"
                                headerValue="Seleccione Ciudad"/>
                            <br>
                        </td>
                        <td>
                            <s:select name="tipoDocumento" list="listaTiposDocumento" listKey="idTipoDocumento" listValue="nombre" headerValue="TipoDocumento"/>
                            <br>
                        </td>
                        <td>
                            <s:select name="grupoSanguineo" list="listaGruposSanguineos" listKey="idGrupoSanguineo" listValue="nombre" headerValue="GrupoSanguineo"/>
                            <br>
                        </td>
                    </tr>
                    <tr>
                        <td class="tduno">Departamento
                            Nacimiento:<br>
                        </td>
                        <td class="tduno">Ciudad Nacimiento:<br>
                        </td>
                        <td class="tduno">Genero:<br>
                        </td>
                        <td class="tduno">Estado Civil:<br>
                        </td>
                    </tr>
                    <tr>

                        <td>
                            <s:select name="genero" list="listaGeneros" listKey="idGenero" listValue="nombre" headerValue="Genero"/>
                            <br>
                        </td>
                        <td>
                            <s:select name="estadoCivil" list="listaEstadosCiviles" listKey="idEstadoCivil" listValue="nombre" headerValue="EstadoCivil"/>
                            <br>
                        </td>
                    </tr>
                    <tr>
                        <td><br>
                        </td>
                        <td><br>
                        </td>
                        <td><br>
                        </td>
                        <td><br>
                        </td>
                    </tr>
                    <tr>
                        <td class="tduno" colspan="2">Usuario:<br>
                        </td>
                        <td class="tduno" colspan="2">Correo
                            Institucional: </td>
                    </tr>
                    <tr>
                        <td colspan="2"><s:textfield name="nombreUsuario"></s:textfield><br>
                            </td>
                            <td colspan="2"><s:textfield name="correoInstitucional"></s:textfield><br>
                            </td>
                        </tr>
                        <tr>
                            <td class="tduno" colspan="2">Contraseña:<br>
                            </td>
                            <td class="tduno" colspan="2">Confirmar contraseña:<br>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2"><s:password name="clave"></s:password><br>
                            </td>
                            <td colspan="2"><s:password name="confirmacionClave"></s:password><br>
                            </td>
                        </tr>
                        <tr>
                            <td class="tduno" colspan="2">Pregunta
                                Seguridad:<br>
                            </td>
                            <td class="tduno" colspan="2">Respuesta
                                Secreta:<br>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2"><s:select name="idPreguntaSeguridad" list="listaPreguntas" listKey="idPreguntaSeguridad" listValue="preguntaSeguridad"/><br>
                        </td>
                        <td colspan="2"><s:password name="respuestaSeguridad"></s:password><br>
                            </td>
                        </tr>
                        <tr>
                            <td><br>
                            </td>
                            <td><br>
                            </td>
                            <td><br>
                            </td>
                            <td><br>
                            </td>
                        </tr>
                        <tr>
                            <td><div class="buttons">
                                    <button type="submit" class="positive" name="cambioClave">
                                        <img src="imagenes/btnCambioClave.png" alt=""/>
                                        Cambio Clave
                                    </button><br>
                                </div></td>
                            <td><br>
                            </td>
                            <td><br>
                            </td>
                            <td><br>
                            </td>
                        </tr>
                        <tr>
                            <td>
                            <s:checkbox cssClass="checkbox" name="terminos">Terminos y Condiciones.</s:checkbox>
                            </td>

                        <s:if test="hasActionErrors()">
                            <td>
                                <s:actionerror />
                            </td>
                        </s:if>
                        <td><div class="buttons">
                                <s:submit cssClass="positive"></s:submit>
                                    <img src="imagenes/btnGuardar.png" alt=""/>
                                    Guardar<br>
                                </div></td>
                            <td><br>

                    </table>

            </s:form>

        </div>
        <br>
        <br>

    </body>
</html>