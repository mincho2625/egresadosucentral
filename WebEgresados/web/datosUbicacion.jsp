<%@taglib uri="/struts-tags" prefix="s"%>

<html lang="es">
    <head><title>Datos de Ubicacion</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="estilo.css">
    </head>

    <body>

        <div id="Tabla" align="center">

            <s:form method="post" action=".jsp" name="f1"> <br>

                <table cellpadding="2" cellspacing="10">
                    <caption>Guardar/Editar/Eliminar</caption>
                    <tr>
                        <td class="tduno" colspan="2">Tipo Contacto:</td>
                        <td class="tduno" colspan="2">Descripcion:</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <s:select name="idTipoContacto" list="listaTiposContacto" listKey="idTipoContacto" listValue="nombre" headerValue="Seleccione Tipo Contacto"/>
                        </td>
                        <td colspan="2"><s:textfield name="descripcion"/></td>
                    </tr>
                    <tr>
                        <td colspan="2"></td>
                        <td colspan="2"><input value="Guardar" name="BtnGuardar" type="submit"></td>
                    </tr>
                    <br>
                </table>
            </s:form>

        </div>
        <br>
        <br>

    </body></html>