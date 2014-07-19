
<html lang="es"><head><title>dDatos de Residencia</title>

        <meta charset="utf-8">

        <link rel="stylesheet" href="estilo.css"></head>

    <body>

        <div id="Tabla" align="center">

            <form method="post" action=".jsp" name="f1"> <br>

                <table cellpadding="2" cellspacing="10">
                    <caption>Guardar/Editar/Eliminar</caption>
                    <tr>
                        <td class="tduno">Pais:</td>
                        <td class="tduno">Departamento:</td>
                        <td class="tduno" colspan="2">Ciudad:</td>
                    </tr>
                    <tr>
                        <td>
                            <select name="pais">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td>
                            <select name="departamento">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td colspan="2">
                            <select name="ciudad">
                                <option>Seleccione</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="tduno">Tipo Vivienda:</td>
                        <td class="tduno">Tendencia Vivienda:</td>
                        <td class="tduno" colspan="2">Direccion:</td>
                    </tr>
                    <tr>
                        <td>
                            <select name="tipoVivienda">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td>
                            <select name="tendVivienda">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td colspan="2"><input name="direccion">
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td colspan="2"><input value="Guardar" name="BtnGuardar" type="submit"></td>
                    </tr>
                    <br>
                </table>
            </form>

        </div>
        <br>
        <br>

    </body></html>