
<html lang="es"><head><title>Datos Acaademicos Ucentral</title>

        <meta charset="utf-8">

        <link rel="stylesheet" href="estilo.css"></head>

    <body>

        <div id="Tabla" align="center">

            <s:form method="post" action=".jsp" name="f1"> <br>

                <table cellpadding="2" cellspacing="10">
                    <caption>Guardar/Editar/Eliminar</caption>
                    <tr>
                        <td class="tduno" colspan="2">Nivel de Estudios:</td>
                        <td class="tduno" colspan="2">Area de Estudios:</td>
                    </tr>
                    <tr>
                        <td colspan="2"><input name="nivelEstu">
                        </td>
                        <td colspan="2">
                            <select name="areaEstu">
                                <option>Seleccione</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="tduno" colspan="2">Modalidad:</td>
                        <td class="tduno">Facultad:</td>
                        <td class="tduno">Programa:</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <select name="modalidad">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td>
                            <select name="facultad">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td>
                            <select name="Programa">
                                <option>Seleccione</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="tduno" colspan="2">Institucion:</td>
                        <td class="tduno">Jornada:</td>
                        <td class="tduno">Departamento:</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <select name="institucion">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td>
                            <select name="jornada">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td>
                            <select name="departamento">
                                <option>Seleccione</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="tduno">Ciudad:</td>
                        <td class="tduno">Ingreso:</td>
                        <td class="tduno">Estado:</td>
                        <td class="tduno">Finalizacion:</td>
                    </tr>
                    <tr>
                        <td>
                            <select name="ciudad">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td><input name="ingreso">
                        </td>
                        <td>
                            <select name="estado">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td><input name="final">
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td colspan="2"><input value="Regresar" name="BtnRegresar" type="submit"></td>
                    </tr>
                    <br>
                </table>
            </s:form>
        </div>
        <br>
        <br>

    </body></html>

