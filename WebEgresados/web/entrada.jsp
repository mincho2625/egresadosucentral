<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<html lang="es">

    <head>
        <title>Entrada</title>
        <meta charset="utf-8"/>

        <link rel="stylesheet" href="estilo.css">
    </head>

    <body >

        <div id="cabecera"><img src="imagenes/logosimbolo-ucentral-v1-large.png">
        </div>

        <div id="frameAbajo">
            <div id="menu">
                <div class="tituloMenu">Acceso</div>
                <s:form name="f1" method="post" action="Ingreso">

                    <center><table>
                            <tr><br><br>
                            <td align="center"><img src="imagenes/logosimbolo-ucentral-v2-medium.png"></td>
                            </tr>
                            <tr>
                                <td class="tduno">Usuario</td>
                            </tr>
                            <tr>
                                <td><s:textfield name="usuario"></s:textfield></td>
                                </tr>
                                <tr>
                                    <td class="tduno">Clave</td>
                                </tr>
                                <tr>
                                    <td><s:password name="contrasenia"></s:password></td>
                                </tr>
                            <s:if test="hasActionErrors()">
                                <tr>
                                <div class="errors">
                                    <s:actionerror />
                                    <s:a href="desplegarRegistro.action">Registro</s:a>
                                    </div>
                                    </tr>
                            </s:if>
                            <tr>
                                <td><s:submit value="ENTRAR"></s:submit></td>
                                </tr>
                            </table></center>

                </s:form>
            </div>

            <div id="contenido">
                <iframe src="frameContenido.jsp" name="contenido">
                </iframe>
            </div>

        </div>

        <div id="footer">footer</div>

    </body>

</html>