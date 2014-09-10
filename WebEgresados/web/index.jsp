<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
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

                    <a href="editarEgresado.action" target="contenido"><li>Registro en Sistema</li></a>

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
                            <a href="obtenerListaEducacionFormalOtrasInstituciones.action" target="contenido"><li>Informacion Academica Otras Instituciones</li></a>
                        </ul>
                    </li>

                    <li>Educacion No Formal e Idiomas
                        <ul>
                            <a href="obtenerListaEducacionNoFormal.action" target="contenido"><li>Educacion No Formal</li></a>
                            <a href="obtenerListaLenguaExtranjera.action" target="contenido"><li>Lengua Extranjera</li></a>
                        </ul>
                    </li>

                    <li>Datos Adicionales
                        <ul>
                            <a href="obtenerListaReconocimiento.action" target="contenido"><li>Distinciones y Reconocimientos</li></a>
                            <a href="obtenerListaAsociacion.action" target="contenido"><li>Asociaciones o Redes Profesionales</li></a>
                            <a href="obtenerListaAficion.action" target="contenido"><li>Deportes o Aficiones</li></a>
                        </ul>
                    </li>

                    <li>Encuesta
                        <ul>
                            <s:iterator value="listaEncuestas" status="estado">
                                <s:url id="encuestaURL" action="desplegarEncuesta.action">
                                    <s:param name="idEncuesta" value="%{idEncuesta}"></s:param>
                                </s:url>
                                <a href="<s:property value="#encuestaURL" />" target="contenido">
                                    <li><s:property value="nombre"></s:property></li>
                                </a>
                            </s:iterator>
                        </ul>
                    </li>

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
