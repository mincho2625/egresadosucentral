
<html lang="es"><head><title>Redes Sociales</title>

        <meta charset="utf-8">

        <link rel="stylesheet" href="estilo.css"></head>

    <body>

        <div id="Tabla" align="center">

            <form method="post" action=".jsp" name="f1"> <br>

                <table cellpadding="2" cellspacing="10">
                    <caption>Guardar/Editar/Eliminar</caption>
                    <tr>
                        <td class="tduno">Red Social:</td>
                        <td class="tduno">Usuario:</td>
                        <td class="tduno" colspan="2">URL:</td>
                    </tr>
                    <tr>
                        <td>
                            <select name="redSocial">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td><input name="usuario">
                        </td>
                        <td colspan="2"><input name="url">
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