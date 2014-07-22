
<html lang="es"><head><title>Informacion Academica Otras Instituciones</title>

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
                        <td class="tduno" colspan="2">Institucion Educativa:</td>
                        <td class="tduno" colspan="2">Otra Institucion:</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <select name="institucion">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td colspan="2"><input name="otraIntitucion">
                        </td>
                    </tr>
                    <tr>
                        <td class="tduno" colspan="2">Titulo:</td>
                        <td class="tduno">Jornada:</td>
                        <td class="tduno">Pais:</td>
                    </tr>
                    <tr>
                        <td colspan="2"><input name="titulo">
                        </td>
                        <td>
                            <select name="jornada">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td>
                            <select name="pais">
                                <option>Seleccione</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="tduno" colspan="2">Departamento:</td>
                        <td class="tduno">Ciudad:</td>
                        <td class="tduno">Ingreso:</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <select name="departamento">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td>
                            <select name="ciudad">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td><input name="ingreso">
                        </td>
                    </tr>
                    <tr>
                        <td class="tduno" colspan="2">Estado:</td>
                        <td class="tduno">Finalizacion:</td>
                        <td class="tduno"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <select name="estado">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td><input name="finalizacion">
                        </td>
                        <td>                            
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