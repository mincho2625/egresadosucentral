
<%@taglib uri="/struts-tags" prefix="s"%>
<html lang="es"><head><title>Registro Sistema</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="estilo.css"></head>
    <body>
        <div id="Tabla" align="center">
            <s:form action="Registro"> <br>

                <table cellpadding="2" cellspacing="12">
                    <caption>REGISTRO EN EL SISTEMA</caption>
                    <tr>
                        <td class="tduno">Primer Apellido:<br>
                        </td>
                        <td class="tduno">Segundo Apellido:<br>
                        </td>
                        <td class="tduno" colspan="2">Nombres:</td>
                    </tr>
                    <tr>
                        <td><s:textfield name="primerApellido"/><br>
                        </td>
                        <td><s:textfield name="segundoApellido"/><br>
                        </td>
                        <td colspan="2"><s:textfield name="nombres"/><br>
                        </td>
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
                        <td><s:date name="fechaNacimiento"/><br>
                        </td>
                        <td><s:number name="numeroDocumento"/><br>
                        </td>
                        <td><s:date name="fechaExpedicion"/><br>
                        </td>
                        <td>
                            <s:select name="paisExpedicion" list="listaPaises" listKey="idPais" listValue="nombre" headerValue="Pais"/>
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
                            <s:select name="departamentoExpedicion" list="listaDepartamentos" listKey="idDepartamento" listValue="nombre" headerValue="Departamento"/>
                            <br>
                        </td>
                        <td>
                            <s:select name="ciudadExpedicion" list="listaCiudades" listKey="idCiudad" listValue="nombre" headerValue="Ciudad"/>
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
                            <s:select name="departamentoNacimiento" list="listaDepartamentos" listKey="idDepartamento" listValue="nombre" headerValue="Departamento"/>
                            <br>
                        </td>
                        <td>
                            <s:select name="ciudadNacimiento" list="listaCiudades" listKey="idCiudad" listValue="nombre" headerValue="Ciudad"/>
                            <br>
                        </td>
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
                        <td colspan="2"><input name="usuario"><br>
                        </td>
                        <td colspan="2"><input name="correoInst"><br>
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
                        <td colspan="2"><input name="preguntaSegu"><br>
                        </td>
                        <td colspan="2"><input name="respuestaSecre"><br>
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
                        <td><input value="Cambio Clave" name="BtnCambioClave" type="submit"> </td>
                        <td><br>
                        </td>
                        <td><br>
                        </td>
                        <td><br>
                        </td>
                    </tr>
                    <tr>
                        <td><input  class="checkbox" name="terminosCodiciones" type="checkbox">Terminos y Condiciones.<br>
                        </td>
                        <td><br>
                        </td>
                        <td><input class="boton" name="GuardarRS" value="Guardar" type="submit"> </td>
                        <td><br>

                </table>

            </s:form>

        </div>
        <br>
        <br>

    </body>
</html>