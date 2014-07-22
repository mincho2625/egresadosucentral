
<html lang="es"><head><title>Datos Laborales</title>

        <meta charset="utf-8">

        <link rel="stylesheet" href="estilo.css"></head>

    <body>

        <div id="Tabla" align="center">

            <s:form method="post" action=".jsp" name="f1"> <br>

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
                        <td class="tduno">Pais:</td>
                        <td class="tduno">Departamento:</td>
                        <td class="tduno">Ciudad:</td>
                        <td class="tduno">Telefono:</td>
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
                        <td>
                            <select name="ciudad">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td><input name="telefono">
                        </td>
                    </tr>
                    <tr>
                        <td class="tduno" colspan="2">Sector Empresaa:</td>
                        <td class="tduno" colspan="2">Subsector Empresa:</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <select name="sectorEmp">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td colspan="2">
                            <select name="sectorSub">
                                <option>Seleccione</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="tduno">Cargo:</td>
                        <td class="tduno">Nivel Cargo:</td>
                        <td class="tduno">Cargo Equivalente:</td>
                        <td class="tduno">Area Empresa:</td>
                    </tr>
                    <tr>
                        <td><input name="cargo">
                        </td>
                        <td>
                            <select name="nivelCargo">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td>
                            <select name="cargoEqui">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td>
                            <select name="areaEmp">
                                <option>Seleccione</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="tduno" colspan="2">Jefe Inmediato:</td>
                        <td class="tduno">Fecha Ingreso:</td>
                        <td class="tduno">Fecha Finalizacion:</td>
                    </tr>
                    <tr>
                        <td colspan="2"><input name="jefe">
                        </td>
                        <td><input name="fecIngre">
                        </td>
                        <td><input name="fecFinal">
                        </td>
                    </tr>
                    <tr>
                        <td class="tduno" colspan="2">Rango Salarial:</td>
                        <td class="tduno"></td>
                        <td class="tduno"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <select name="rango">
                                <option>Seleccione</option>
                            </select>
                        </td>
                        <td>
                        </td>
                        <td>
                        </td>
                    </tr>
                    <tr>
                        <td class="tduno" colspan="2">Funciones Y logros:</td>
                        <td class="tduno"></td>
                        <td class="tduno"></td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <textarea name="descripcion" cols="70" rows="6">Ingrese una descripcion de sus Funciones y/o Logros!</textarea>
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

