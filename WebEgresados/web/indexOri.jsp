<!DOCTYPE html>

<html lang="es">
    <head>
        <title>Formulario Principal</title>
        <meta charset="utf-8"/>
        <link rel="stylesheet" href="estilo.css">
    </head>

    <body>
        <div id="cabecera"><img src="imagenes/logosimbolo-ucentral-v1-large.png">
        </div>

        <div id="frameAbajo">

            <div id="menu">
                <div class="tituloMenu">Datos Personales</div>
                <ul>
                    <a href="populateRegistro.action" target="contenido"><li>Registro en Sistema</li></a>
                    <a href="informacionPersonal.jsp" target="contenido"><li>Informacion Personal</li></a>
                    <a href="experienciaLaboral.jsp" target="contenido"><li>Experiecia Laboral</li></a>
                    <a href="educacionFormal.jsp" target="contenido"><li>Educacion Formal</li></a>
                    <a href="educacionNoFormal.jsp" target="contenido"><li>Educacion No Formal e Idiomas</li></a>
                    <a href="datosAdicionales.jsp" target="contenido"><li>Datos Adicionales</li></a>
                    <a href="encuesta.jsp" target="contenido"><li>Encuesta</li></a>
                </ul>
            </div>

            <div id="contenido">
                <iframe src="frameContenido.jsp" name="contenido">
                </iframe>
            </div>
        </div>

        <div id="footer">footer</div>

    </body>

</html>