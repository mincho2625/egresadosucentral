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

                    <a href="obtenerEgresadoRegistro.action" target="contenido"><li>Registro en Sistema</li></a>

                    <li>Informacion Personal
                        <ul>
                            <a href="obtenerListaUbicacion.action" target="contenido"><li>Datos de Ubicacion</li></a>
                            <a href="obtenerListaEgresadoRedSocial.action" target="contenido"><li>Redes Sociales</li></a>
                            <a href="obtenerListaResidencia.action" target="contenido"><li>Datos de Residencia</li></a>
                        </ul>
                    </li>

                    <a href="obtenerListaExperienciaLaboral.action" target="contenido"><li>Experiecia Laboral</li></a>

                    <li>Educacion Formal
                        <ul>
                            <a href="obtenerListaEducacionFormalUCentral.action" target="contenido"><li>Datos Academicos Ucentral</li></a>
                            <a href="informacionAcademicaOtrasTabla.jsp" target="contenido"><li>Informacion Academica Otras Instituciones</li></a>
                        </ul>
                    </li>

                    <li>Educacion No Formal e Idiomas
                        <ul>
                            <a href="informacionAcademicaNoFormalTabla.jsp" target="contenido"><li>Educacion No Formal</li></a>
                            <a href="lenguaExtranjeraTabla.jsp" target="contenido"><li>Lengua Extranjera</li></a>
                        </ul>
                    </li>

                    <li>Datos Adicionales
                        <ul>
                            <a href="obtenerListaReconocimiento.action" target="contenido"><li>Distinciones y Reconocimientos</li></a>
                            <a href="obtenerListaAsociacion.action" target="contenido"><li>Asociaciones o Redes Profesionales</li></a>
                            <a href="obtenerListaAficion.action" target="contenido"><li>Deportes o Aficiones</li></a>
                        </ul>
                    </li>


                    <a href="encuesta.jsp" target="contenido"><li>Encuesta</li></a>

                    <a href="entrada.jsp" ><li>Salir</li></a>
                </ul>
            </div>

            <div id="contenido">
                <iframe src="frameContenido.jsp" name="contenido">
                </iframe>
            </div>
        </div>

        <div id="footer">Sede Centro: carrera 5 n.º 21-38 
            Sede Norte: calle 75 n.º 16-03 
            Institución de educación superior sujeta a inspección y vigilancia del Ministerio de Educación Nacional</div>

    </body>

</html>
