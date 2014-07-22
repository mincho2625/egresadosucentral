
<html lang="es"><head><title>Distinciones y Reconocimientos</title>

        <meta charset="utf-8">

        <link rel="stylesheet" href="estilo.css"></head>

    <body>

        <div id="Tabla" align="center">

            <s:form method="post" action=".jsp" name="f1"> <br>

                <table cellpadding="2" cellspacing="10">
                    <caption>Guardar/Editar/Eliminar</caption>
                    <tr>
                        <td class="tduno" colspan="2">Tipo De Premio:</td>
                        <td class="tduno" colspan="2">Clase:</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <select name="tipoPremio">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td colspan="2">
                            <select name="clase">
                                <option>Seleccione</option>
                            </select>
                        </td>                       
                    </tr>
                    <tr>
                        <td class="tduno" colspan="2">Entidad Otorgante:</td>
                        <td class="tduno">Fecha del Premio:</td>
                        <td class="tduno">Pais:</td>
                    </tr>
                    <tr>
                        <td colspan="2"><input name="entidad">
                        </td>
                        <td><input name="fecha">
                        </td>
                        <td colspan="2">
                            <select name="pais">
                                <option>Seleccione</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="tduno" colspan="2">Descripcion del Premio:</td>
                        <td class="tduno"></td>
                        <td class="tduno"></td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <textarea name="descripcion" cols="70" rows="6">Ingrese una descripcion del Premio otorgado!</textarea>
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