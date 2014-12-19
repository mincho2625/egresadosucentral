<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Entrada</title>
        <meta charset="utf-8"/>
        <link rel="stylesheet" href="estilo2.css">
            <script>document.documentElement.className = "js";</script>
            <script src="vendor/jquery-1.9.1.js"></script>
            <script src="vendor/json2.js"></script>
            <script src="src/jquery.collapse.js"></script>
            <script src="src/jquery.collapse_storage.js"></script>
            <script src="src/jquery.collapse_cookie_storage.js"></script>
    </head>

    <body class="fondo">
        <div class="fondo">
            <div class="imagentitulo2">
                <div class="">
                    <p><img src="imagenes/logosimbolo-ucentral-v1-large.png" width="360" height="102" align="texttop" /></p>
                </div>    
            </div>
            <div class="menuPrincipal2">
                <form action="" method="post" name="form2" class="imagen" id="form2">
                </form>
                <div class="menu">
                    <p>Bienvenido al portal de egeresados de la Universidad Central</p>
                    <p><s:property value="nombre"></s:property></p>
                </div>
                <s:if test="primeraVez">
                    <s:div cssClass="col">
                        <div id="default-example" data-collapse="false" >
                            <h3>Registro en Sistema</h3><div style="display: none"></div>
                            <h3>Informacion Personal</h3><div></div>
                            <h3>Educacion Formal</h3><div></div>
                            <h3>Educacion No Formal e Idiomas</h3><div></div>
                            <h3>Experiecia Laboral</h3><div></div>
                            <h3>Datos Adicionales</h3><div></div>
                            <h3>Encuesta</h3><div></div>
                            <a href="entrada.jsp"><h3>Salir</h3></a>
                        </div>
                    </s:div>
                </s:if>
                <s:else>
                    <s:div cssClass="col">
                        <div id="default-example" data-collapse="accordion">
                            <!--<div id="css3-animated-example">-->
                            <h3>Registro en Sistema</h3>
                            <div>
                                <div class="content">
                                    <p><a href="editarEgresado.action" target="contenido"><li class="letra">Registro</li></a></p>
                                </div>
                            </div>
                            <h3>Informacion Personal</h3>
                            <div ng-readonly="true">
                                <div class="content" >
                                    <p><a href="obtenerListaUbicacion.action" target="contenido"><li class="letra">Datos de Ubicacion</li></a></p>
                                    <p><a href="obtenerListaEgresadoRedSocial.action" target="contenido"><li class="letra">Redes Sociales</li></a></p>
                                    <p><a href="obtenerListaResidencia.action" target="contenido"><li class="letra">Datos de Residencia</li></a></p>
                                </div>
                            </div>
                            <h3>Educacion Formal</h3>
                            <div>
                                <div class="content">
                                    <p><a href="obtenerListaEducacionFormalUCentral.action" target="contenido"><li class="letra">Datos Academicos Ucentral</li></a></p>
                                    <p><a href="obtenerListaEducacionFormalOtrasInstituciones.action" target="contenido"><li class="letra">Informacion Academica Otras Instituciones</li></a></p>       
                                </div>
                            </div>
                            <h3>Educacion No Formal e Idiomas</h3>
                            <div>
                                <div class="content">
                                    <p><a href="obtenerListaEducacionNoFormal.action" target="contenido"><li class="letra">Educacion No Formal</li></a></p>
                                    <p><a href="obtenerListaLenguaExtranjera.action" target="contenido"><li class="letra">Lengua Extranjera</li></a></p>      
                                </div>
                            </div>
                            <h3>Experiecia Laboral</h3>
                            <div>
                                <div class="content">
                                    <p><a href="obtenerListaExperienciaLaboral.action" target="contenido"><li class="letra">Experiecia Laboral</li></a></p>
                                </div>
                            </div>
                            <h3>Datos Adicionales</h3>
                            <div>
                                <div class="content">                            
                                    <p><a href="obtenerListaReconocimiento.action" target="contenido"><li class="letra">Distinciones y Reconocimientos</li></a></p>
                                    <p><a href="obtenerListaAsociacion.action" target="contenido"><li class="letra">Asociaciones o Redes Profesionales</li></a></p>
                                    <p><a href="obtenerListaAficion.action" target="contenido"><li class="letra">Deportes o Aficiones</li></a></p>
                                </div>
                            </div>
                            <h3>Encuesta</h3>
                            <div>
                                <div class="content">                            
                                    <p>
                                        <s:url id="encuestaURL" action="editarEncuesta.action">
                                            <s:param name="orden" value="1"></s:param>
                                        </s:url>
                                        <a href="<s:property value="#encuestaURL" />" target="contenido">
                                            <li class="letra">Encuesta</li>
                                        </a>
                                    </p>
                                </div>
                            </div>
                            <h3>Salir</h3>
                            <div>
                                <div class="content">                            
                                    <p><a href="entrada.jsp"><li class="letra">Salir</li></a></p>
                                </div>
                            </div>
                            <!--</div>-->
                            <script>
                    $("#css3-animated-example").collapse({
                        accordion: true,
                        open: function() {
                            this.addClass("open");
                            this.css({height: this.children().outerHeight()});
                        },
                        close: function() {
                            this.css({height: "0px"});
                            this.removeClass("open");
                        }
                    });
                            </script>    
                        </div>
                        <div class="menu">
                            <p>Noticias </p>
                            <p>&nbsp;</p>
                        </div>
                    </s:div>
                </s:else>

                <p>&nbsp;</p>
                <p>&nbsp;</p>
                <div class="from2">
                    <div id="contenido">
                        <s:if test="primeraVez">
                            <iframe src="editarEgresado.action" name="contenido"> </iframe>
                        </s:if>
                        <s:else>
                            <iframe src="frameContenido.jsp" name="contenido"> </iframe>
                        </s:else>
                    </div>
                    <p>&nbsp;</p>
                </div>
            </div>
        </div>
        <div class="footer">
            <div align="center">Institución de educación superior sujeta a inspección y vigilancia del Ministerio de Educación Nacional<br />
                <span style=""><strong>Sede Centro</strong>: Cra. 5 N° 21-38 <span style="color: #b50900;">•</span> <strong>Sede Norte</strong>: Cll. 75 Nº 16-03 <span style="color: #b50900;">•</span> <strong>Sede El Lago:</strong> Cra.15 Nº 75-14 <span style="color: #b50900;">•</span> Conmutadores: <strong>323 9868 y 326 6820</strong><span style="color: #b50900;"> • </span></span><span style="font-size: 8pt;"><span style="">Centro de atención: <strong>326 6826 y 744 7606.</strong></span> <br />
                    <span style="color: #5b6606;"><strong><span style="">© Universidad Central 2014</span></strong><span style="color: #b50900;"> •</span> <strong>Colombia</strong><span style="color: #b50900;"> •</span></span> <br />
                </span> </div>
        </div>
    </body>
</html>
