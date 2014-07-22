
<html lang="es"><head><title>Lengua Extranjera</title>

        <meta charset="utf-8">

        <link rel="stylesheet" href="estilo.css"></head>

    <body>

        <div id="Tabla" align="center">

            <s:form method="post" action=".jsp" name="f1"> <br>

                <table cellpadding="2" cellspacing="10">
                    <caption>Guardar/Editar/Eliminar</caption>
                    <tr>
                        <td class="tduno" colspan="2">Idioma:</td>
                        <td class="tduno" colspan="2">Institucion:</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <select name="idioma">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td colspan="2">
                            <select name="institucion">
                                <option>Seleccione</option>
                            </select>
                        </td>                       
                    </tr>
                    <tr>
                        <td class="tduno" colspan="2">Otra Institucion:</td>
                        <td class="tduno" colspan="2">Dominio:</td>
                    </tr>
                    <tr>
                        <td colspan="2"><input name="otraIntitucion">
                        </td>
                        <td colspan="2">
                            <select name="dominio">
                                <option>Seleccione</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">Ojo Hay que ponerle la ayuda del dominio para ver si esta en A1,A2...                          
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