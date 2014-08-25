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
                                        <div id="text" class="tduno">Contrase�a</div><s:password cssClass="center" name="contrasenia"></s:password>
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

        <div id="footer">Sede Centro: carrera 5 n.� 21-38 
            Sede Norte: calle 75 n.� 16-03 
            Instituci�n de educaci�n superior sujeta a inspecci�n y vigilancia del Ministerio de Educaci�n Nacional</div>

    </body>

</html>