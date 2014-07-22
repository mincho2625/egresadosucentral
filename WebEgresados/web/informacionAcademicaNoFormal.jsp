
<html lang="es"><head><title>Informacion Academica No Formal</title>

        <meta charset="utf-8">

        <link rel="stylesheet" href="estilo.css"></head>

    <body>

        <div id="Tabla" align="center">

            <s:form method="post" action=".jsp" name="f1"> <br>

                <table cellpadding="2" cellspacing="10">
                    <caption>Guardar/Editar/Eliminar</caption>
                    <tr>
                        <td class="tduno" colspan="2">Tipo De Estudios:</td>
                        <td class="tduno" colspan="2">Otro Tipo:</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <select name="tipoEstudio">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td colspan="2"><input name="otroTipo">
                        </td>                        
                    </tr>
                    <tr>
                        <td class="tduno" colspan="2">Modalidad:</td>
                        <td class="tduno" colspan="2">Area del Curso:</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <select name="modalidad">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td colspan="2">
                            <select name="areaCurso">
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
                        <td class="tduno">Departamento:</td>
                        <td class="tduno">Ciudad:</td>
                    </tr>
                    <tr>
                        <td colspan="2"><input name="titulo">
                        </td>
                        <td>
                            <select name="departamento">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td>
                            <select name="ciudad">
                                <option>Seleccione</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="tduno">Intensidad Horaria:</td>
                        <td class="tduno">Ingreso:</td>
                        <td class="tduno">Estado:</td>
                        <td class="tduno">Finalizacion:</td>
                    </tr>
                    <tr>
                        <td>
                            <select name="intensidad">
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
                        <td><input name="finalizacion">
                        </td>
                    </tr>
                    <tr>
                        <td class="tduno" colspan="2">Descripcion del Curso:</td>
                        <td class="tduno"></td>
                        <td class="tduno"></td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <textarea name="descripcion" cols="70" rows="6">Ingrese una descripcion del Curso</textarea>
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