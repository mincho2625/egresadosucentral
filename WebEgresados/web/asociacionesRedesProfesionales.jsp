
<html lang="es"><head><title>Asociaciones o Redes Profesionales</title>

        <meta charset="utf-8">

        <link rel="stylesheet" href="estilo.css"></head>

    <body>

        <div id="Tabla" align="center">

            <s:form method="post" action=".jsp" name="f1"> <br>

                <table cellpadding="2" cellspacing="10">
                    <caption>Guardar/Editar/Eliminar</caption>
                    <tr>
                        <td class="tduno" colspan="2">Tipo Asociacion:</td>
                        <td class="tduno" colspan="2">Fecha Vinculacion:</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <select name="tipoAsociacion">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td colspan="2"><input name="fecha">
                        </td>                       
                    </tr>
                    <tr>
                        <td class="tduno" colspan="2">Pais:</td>
                        <td class="tduno"></td>
                        <td class="tduno"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <select name="pais">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td colspan="2">
                        </td>
                        <td>
                        </td>
                    </tr>
                    <tr>
                        <td class="tduno" colspan="2">Descripcion de Asociacion o Red Profesional:</td>
                        <td class="tduno"></td>
                        <td class="tduno"></td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <textarea name="descripcion" cols="70" rows="6">Ingrese una descripcion!</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td colspan="2"><input value="Guardar" name="BtnGuardar" type="submit"></td>
                    </tr>
                    <br>
                </table>
            </s:form>
        </div>
        <br>
        <br>

    </body></html>