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

                    <center>
                        <table>
                            <br><br><br><br><br><br><br><br>
                            <tr>
                                <td>
                                    <div id="text" class="tduno">Usuario</div><s:textfield cssClass="center" name="usuario"></s:textfield>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div id="text" class="tduno">Contraseña</div><s:password cssClass="center" name="contrasenia"></s:password>
                                    </td>
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
                                <td><s:submit cssClass="center1" value="ENTRAR"></s:submit></td>
                                </tr>
                            </table>
                    </center>

                </s:form>
            </div>

            <div id="contenido" class="center">
                <iframe src="frameContenido.jsp" name="contenido">
                </iframe>
            </div>

        </div>

        <div id="footer">Sede Centro: carrera 5 n.º 21-38 
            Sede Norte: calle 75 n.º 16-03 
            Institución de educación superior sujeta a inspección y vigilancia del Ministerio de Educación Nacional</div>

    </body>

</html>