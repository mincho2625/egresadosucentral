
<html lang="es"><head><title>Registro Sistema</title>

        <meta charset="utf-8">

        <link rel="stylesheet" href="estilo.css"></head>

    <body>

        <div id="Tabla" align="center">

            <form method="post" action=".jsp" name="f1"> <br>

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
                        <td><input name="primerApellido"><br>
                        </td>
                        <td><input name="segundoApellido"><br>
                        </td>
                        <td colspan="2"><input name="nombres"><br>
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
                        <td><input name="fecNaci"><br>
                        </td>
                        <td><input name="documento"><br>
                        </td>
                        <td><input name="fecExpe"><br>
                        </td>
                        <td>
                            <select name="paisExp">
                                <option>Seleccione</option>
                            </select>
                            <br>
                        </td>
                    </tr>
                    <tr>
                        <td class="tduno">Departamento
                            Expedicion:<br>
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
                            <select name="deparExp">
                                <option>Seleccione</option>
                            </select>
                            <br>
                        </td>
                        <td>
                            <select name="ciudadExp">
                                <option>Seleccione</option>
                            </select>
                            <br>
                        </td>
                        <td>
                            <select name="tipoDocu">
                                <option>Seleccione</option>
                            </select>
                            <br>
                        </td>
                        <td>
                            <select name="grupoSang">
                                <option>Seleccione</option>
                            </select>
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
                            <select name="depNaci">
                                <option>Seleccione</option>
                            </select>
                            <br>
                        </td>
                        <td>
                            <select name="ciudadNaci">
                                <option>Seleccione</option>
                            </select>
                            <br>
                        </td>
                        <td>
                            <select name="genero">
                                <option>Seleccione</option>
                            </select>
                            <br>
                        </td>
                        <td>
                            <select name="estadoCivil">
                                <option>Seleccione</option>
                            </select>
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
              
            </form>

        </div>
        <br>
        <br>

    </body></html>