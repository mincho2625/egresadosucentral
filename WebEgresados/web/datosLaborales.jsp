
<html lang="es"><head><title>Datos Laborales</title>

        <meta charset="utf-8">

        <link rel="stylesheet" href="estilo.css"></head>

    <body>

        <div id="Tabla" align="center">

            <form method="post" action=".jsp" name="f1"> <br>

                <table cellpadding="2" cellspacing="10">
                    <caption>Guardar/Editar/Eliminar</caption>
                    <tr>
                        <td class="tduno" colspan="2">Nombre de Empresa:</td>
                        <td class="tduno" colspan="2">Tipo Contrato:</td>
                    </tr>
                    <tr>
                        <td colspan="2"><input name="nombreEmpresa">
                        </td>
                        <td colspan="2">
                            <select name="tipoContrato">
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

