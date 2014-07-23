<!DOCTYPE html>

<html lang="es">
    <head>
        <title>Formulario Principal </title>
        <meta charset="utf-8"/>
        <link rel="stylesheet" href="estilo.css">
    </head>

    <body>
        <div id="cabecera"><img src="imagenes/logosimbolo-ucentral-v1-large.png">
        </div>

        <div id="frameAbajo">

            <div id="menu">
                <div class="tituloMenu">Datos Personales</div>
                <ul class="menu">
                    
                    <a href="populateRegistro.action" target="contenido"><li>Registro en Sistema</li></a>
                    
                    <a href="informacionPersonal.jsp" target="contenido">
                        <li>Informacion Personal
                            <ul>
                                <li>Datos de Ubicacion</li>
                                <li>Redes Sociales</li>
                                <li>Datos de Residencia</li>
                            </ul>
                        </li>
                    </a>
                    
                    <a href="experienciaLaboral.jsp" target="contenido">
                        <li>Experiecia Laboral
                            <ul>
                                <li>Datos Laborales</li>
                            </ul>
                        </li>
                    </a>
                    
                    <a href="educacionFormal.jsp" target="contenido">
                        <li>Educacion Formal
                            <ul>
                                <li>Datos Academicos Ucentral</li>
                                <li>Informacion Academica Otras Instituciones</li>
                            </ul>
                        </li>
                    </a>
                    
                    <a href="educacionNoFormal.jsp" target="contenido">
                        <li>Educacion No Formal e Idiomas
                            <ul>
                                <li>Educacion No Formal</li>
                                <li>Lengua Extranjera</li>
                            </ul>
                        </li>
                    </a>
                    
                    <a href="datosAdicionales.jsp" target="contenido">
                        <li>Datos Adicionales
                            <ul>
                                <li>Distinciones y Reconocimientos</li>
                                <li>Asociaciones o Redes Profesionales</li>
                                <li>Deportes o Aficiones</li>
                            </ul>
                        </li>
                    </a>
                    
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