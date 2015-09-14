<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<html lang="es-es" class="no-js">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="stylesheet" href="estilo.css">
        <link rel="stylesheet" type="text/css" href="normalize.min.css">
        <link rel="stylesheet" type="text/css" href="bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="styles.css">
        <link rel="stylesheet" type="text/css" href="jce-index.css">
        <script>document.documentElement.className = "js";</script>
        <script src="vendor/jquery-1.9.1.js"></script>
        <script src="vendor/json2.js"></script>
        <script src="src/jquery.collapse.js"></script>
        <script src="src/jquery.collapse_storage.js"></script>
        <script src="src/jquery.collapse_cookie_storage.js"></script>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300,300italic,700' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=PT+Serif:400,700' rel='stylesheet' type='text/css'>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>Portal Egresados Universidad Central</title>
        <link href="/templates/ucentral/favicon.ico" rel="shortcut icon" type="image/vnd.microsoft.icon" />
        <link rel="stylesheet" href="/plugins/system/jcemediabox/css/jcemediabox.css?08ebf8a171d1a19317c2b1b68ebfed96" type="text/css" />
        <link rel="stylesheet" href="/plugins/system/jcemediabox/themes/standard/css/style.css?67fbaeceb987316db98c64feea18d9fa" type="text/css" />
        <style type="text/css">
            body { background-image: url(imagenes/fondo_template_default.jpg); background-repeat: repeat; background-position: 0% 0%; background-color: #ffffff; }
            .item-125:hover .menu-dropdown-125 { display: block !important; }
            .menu-principal-separador-1 { display: inline-block; vertical-align: top; margin: 0 2% 0 0; width: 49%; }
            .menu-principal-separador-2 { display: inline-block; vertical-align: top; width: 49%; }
            .item-237:hover .menu-dropdown-237 { display: block !important; }
            .item-102:hover .menu-dropdown-102 { display: block !important; }
            .item-101:hover .menu-dropdown-101 { display: block !important; }
            .menu-principal-separador-3 { display: inline-block; vertical-align: top; margin: 0 2% 0 0; width: 32%; }
            .menu-principal-separador-4 { display: inline-block; vertical-align: top; margin: 0 2% 0 0; width: 32%; }
            .menu-principal-separador-5 { display: inline-block; vertical-align: top; width: 32%; }
        </style>
        <script src="/media/system/js/mootools-core.js" type="text/javascript"></script>
        <script src="/media/system/js/core.js" type="text/javascript"></script>
        <script src="/media/jui/js/jquery.min.js" type="text/javascript"></script>
        <script src="/media/jui/js/jquery-noconflict.js" type="text/javascript"></script>
        <script src="/media/jui/js/jquery-migrate.min.js" type="text/javascript"></script>
        <script src="/media/system/js/caption.js" type="text/javascript"></script>
        <script src="/plugins/system/jcemediabox/js/jcemediabox.js?bab2623533a38959d58ee39b77ca85cd" type="text/javascript"></script>
        <script src="/modules/mod_redes_js_uc/js/mod_redes_js_uc.min.js" type="text/javascript"></script>
        <script type="text/javascript">
            jQuery(window).on('load', function() {

                new JCaption('img.caption');
            });
            JCEMediaBox.init({popup: {width: "", height: "", legacy: 0, lightbox: 0, shadowbox: 0, resize: 1, icons: 1, overlay: 1, overlayopacity: 0.8, overlaycolor: "#000000", fadespeed: 500, scalespeed: 500, hideobjects: 0, scrolling: "fixed", close: 2, labels: {'close': 'Close', 'next': 'Next', 'previous': 'Previous', 'cancel': 'Cancel', 'numbers': '{$current} of {$total}'}, cookie_expiry: "", google_viewer: 0, pdfjs: 0}, tooltip: {className: "tooltip", opacity: 0.8, speed: 150, position: "br", offsets: {x: 16, y: 16}}, base: "/", imgpath: "plugins/system/jcemediabox/img", theme: "standard", themecustom: "", themepath: "plugins/system/jcemediabox/themes"});
            jQuery(document).ready(function()
            {
                jQuery('.hasTooltip').tooltip({"html": true, "container": "body"});
            });
        </script>
        <style type="text/css">.sige_cont_0 {width:205px;height:146px;float:left;display:inline-block;}
        </style>
        <link rel="stylesheet" href="http://www.ucentral.edu.co/plugins/content/sige/plugin_sige/sige.css" type="text/css" media="screen" />
        <script type="text/javascript" src="http://www.ucentral.edu.co/plugins/content/sige/plugin_sige/slimbox.js"></script>
        <script type="text/javascript">
            Slimbox.scanPage = function() {
                $$("a[rel^=lightbox]").slimbox({counterText: "Image {x} of {y}"}, null, function(el) {
                    return (this == el) || ((this.rel.length > 8) && (this.rel == el.rel));
                });
            };
            if (!/android|iphone|ipod|series60|symbian|windows ce|blackberry/i.test(navigator.userAgent)) {
                window.addEvent("domready", Slimbox.scanPage);
            }
        </script>
        <link rel="stylesheet" href="http://www.ucentral.edu.co/plugins/content/sige/plugin_sige/slimbox.css" type="text/css" media="screen" />

        <script type="text/javascript" src="/templates/ucentral/js/jquery.mobile.custom.min.js"></script>
        <script type="text/javascript" src="/templates/ucentral/js/jquery.scrollstop.min.js"></script>
        <script type="text/javascript" src="/templates/ucentral/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="/templates/ucentral/js/scripts.min.js"></script>
        <script>
            (function(i, s, o, g, r, a, m) {
                i['GoogleAnalyticsObject'] = r;
                i[r] = i[r] || function() {
                    (i[r].q = i[r].q || []).push(arguments)
                }, i[r].l = 1 * new Date();
                a = s.createElement(o),
                        m = s.getElementsByTagName(o)[0];
                a.async = 1;
                a.src = g;
                m.parentNode.insertBefore(a, m)
            })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');

            ga('create', 'UA-22722948-1', 'auto');
            ga('send', 'pageview');

        </script>

        <script language="JavaScript">
            function mueveReloj() {
                momentoActual = new Date()
                hora = momentoActual.getHours()
                minuto = momentoActual.getMinutes()
                segundo = momentoActual.getSeconds()

                str_segundo = new String(segundo)
                if (str_segundo.length == 1)
                    segundo = "0" + segundo

                str_minuto = new String(minuto)
                if (str_minuto.length == 1)
                    minuto = "0" + minuto

                str_hora = new String(hora)
                if (str_hora.length == 1)
                    hora = "0" + hora

                horaImprimible = hora + " : " + minuto + " : " + segundo

                document.form_reloj.reloj.value = horaImprimible

                setTimeout("mueveReloj()", 1000)
            }
        </script> 
    </head>
    <body class="default" ontouchstart="" onload="mueveReloj()">
        <header id="top" class="container">
            <div class="row">
                <div class="date col-lg-5 col-md-5 col-sm-12 col-xs-12 hidden-xs hidden-sm ">
                    <a href="http://www.ucentral.edu.co" title="Colombia"/>
                    <form name="form_reloj"> 
                        <img alt="Colombia" src="imagenes/colombia.gif"/></a>&nbsp;&nbsp;
                        <script>
                            var meses = new Array("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");
                            var diasSemana = new Array("Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado");
                            var f = new Date();
                            document.write(diasSemana[f.getDay()] + " " + f.getDate() + " de " + meses[f.getMonth()] + " del " + f.getFullYear());
                        </script>
                    </form>
                </div>
                <div class="col-lg-7 col-md-7 col-sm-12 col-xs-12">
                    <nav class="navbar navbar-default" role="navigation">
                        <div class="container-fluid">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle pull-left" data-toggle="collapse" data-target="#menu-1919926903">
                                    <span class="sr-only">Men&uacute; comunidad unicentralista</span>
                                    <h6>Men&uacute;</h6>
                                </button>
                            </div>
                            <div class="navbar-collapse collapse" id="menu-1919926903">
                                <ul class="menu pull-right ">
                                    <li class="item-793"><a  href="http://www.ucentral.edu.co/" ><span> Inicio</span></a></li>
                                    <li class="item-264 parent"><a href="http://www.ucentral.edu.co/egresados" ><span> Egresados</span></a></li>
                                    <li class="item-264 parent"><a href="entrada.jsp" ><span> Salir</span></a></li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>
            </div>    
            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-3 col-xs-12">
                    <figure class="logo">
                        <a href="http://www.ucentral.edu.co/" title="Universidad Central">
                            <img class="img-responsive" alt="Universidad Central" src="imagenes/logo_ucentral.png">
                        </a>
                        <figcaption class="hide">Universidad Central</figcaption>
                    </figure>
                    <div class="tag-line hidden-sm hidden-xs">
                        <span>Programas de educaci&oacute;n superior</span>
                    </div>
                </div>
                <div class="col-lg-8 col-md-8 col-sm-9 col-xs-12 hidden-xs">
                    <div class="custom"  >
                        <div class="search pull-right">
                            <h2 style="color: #B11F16; text-align: center">Portal Administrativo Egresados</h2>
                        </div>
                    </div>
                </div>    
            </div>
        </header>   
        <div id="main" class="container" role="main">
            <div class="row">
                <aside>
                    <div id="system-message-container">
                    </div>
                </aside>
            </div>
            <div id="main-cuerpo">
                <div class="row contenido show">
                    <div class="componente col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div>
                            <div class="global-position-aux-2 col-lg-2 col-md-2 col-sm-12 col-xs-12" style="z-index: 10000">
                                <div>
                                    <div class="custom">
                                        <div class="titulo-articulo-arrow">
                                            <p>Bienvenido al portal administrativo de egresados de la Universidad Central</p>
                                        </div>  
                                    </div>
                                </div>
                                <div>
                                    <s:div cssClass="col">
                                        <div id="default-example" data-collapse="accordion">
                                            <!--<div id="css3-animated-example">-->
                                            <h6>Correo electrónico</h6>
                                            <div>
                                                <div class="content">                            
                                                    <a href="obtenerListaPlantillaCorreo.action" target="contenido"><li class="letra">Plantillas</li></a>
                                                    <a href="editarConfiguracionCorreo.action" target="contenido"><li class="letra">Cuenta</li></a>
                                                    <a href="mostrarCorreoMasivo.action" target="contenido"><li class="letra">Correo masivo</li></a>
                                                </div>
                                            </div>
                                            <h6>Listas formulario actualización</h6>
                                            <div>
                                                <div class="content"  style="height: 300px;overflow: auto;">
                                                    <a href="obtenerListaEstadoCivil.action" target="contenido"><li class="letra">Estado civil</li>
                                                        <a href="obtenerListaEstrato.action" target="contenido"><li class="letra">Estrato</li></a>
                                                        <a href="obtenerListaGrupoSanguineo.action" target="contenido"><li class="letra">Grupos sangu&iacute;neos</li></a>
                                                        <a href="obtenerListaPais.action" target="contenido"><li class="letra">Pa&iacute;ses</li></a>
                                                        <a href="obtenerListaPreguntaSeguridad.action" target="contenido"><li class="letra">Preguntas de seguridad</li></a>
                                                        <a href="obtenerListaTipoContacto.action" target="contenido"><li class="letra">Tipos de contacto</li></a>
                                                        <a href="obtenerListaTipoDocumento.action" target="contenido"><li class="letra">Tipos de documento</li></a>
                                                        <a href="obtenerListaTipoTenenciaVivienda.action" target="contenido"><li class="letra">Tipos tenencia vivienda</li></a>
                                                        <a href="obtenerListaTipoVivienda.action" target="contenido"><li class="letra">Tipos de vivienda</li></a>
                                                        <a href="obtenerListaAreaEstudios.action" target="contenido"><li class="letra">&Aacute;rea estudios</li></a>
                                                        <a href="obtenerListaDominioLenguaExt.action" target="contenido"><li class="letra">Dominio lengua extranjera</li></a>
                                                        <a href="obtenerListaEstadoEducacion.action" target="contenido"><li class="letra">Estado educaci&oacute;n</li></a>
                                                        <a href="obtenerListaFacultad.action" target="contenido"><li class="letra">Facultades</li></a>
                                                        <a href="obtenerListaIdioma.action" target="contenido"><li class="letra">Idiomas</li></a>
                                                        <a href="obtenerListaInstitucion.action" target="contenido"><li class="letra">Instituciones</li></a>
                                                        <a href="obtenerListaIntensidadHoraria.action" target="contenido"><li class="letra">Intensidades horarias</li></a>
                                                        <a href="obtenerListaJornada.action" target="contenido"><li class="letra">Jornadas</li></a>
                                                        <a href="obtenerListaModalidad.action" target="contenido"><li class="letra">Modalidades</li></a>
                                                        <a href="obtenerListaNivelEstudios.action" target="contenido"><li class="letra">Niveles estudios</li></a>
                                                        <a href="obtenerListaAreaEmpresa.action" target="contenido"><li class="letra">&Aacute;rea empresa</li></a>
                                                        <a href="obtenerListaCargoEquivalente.action" target="contenido"><li class="letra">Cargo equivalente</li></a>
                                                        <a href="obtenerListaNivelCargo.action" target="contenido"><li class="letra">Niveles cargos</li></a>
                                                        <a href="obtenerListaRangoSalarial.action" target="contenido"><li class="letra">Rangos salariales</li></a>
                                                        <a href="obtenerListaSector.action" target="contenido"><li class="letra">Sectores</li></a>
                                                        <a href="obtenerListaTipoContrato.action" target="contenido"><li class="letra">Tipos de contrato</li></a>
                                                        <a href="obtenerListaClaseReconocimiento.action" target="contenido"><li class="letra">Clase de reconocimiento</li></a>
                                                        <a href="obtenerListaTipoAsociacion.action" target="contenido"><li class="letra">Asociaciones o Redes Profesionales</li></a>
                                                        <a href="obtenerListaRedSocial.action" target="contenido"><li class="letra">Redes sociales</li></a>
                                                        <a href="obtenerListaTipoActividad.action" target="contenido"><li class="letra">Tipos actividades</li></a>
                                                        <a href="obtenerListaTipoReconocimiento.action" target="contenido"><li class="letra">Tipos de reconocimiento</li></a>
                                                </div>
                                            </div>
                                            <h6>Consultas</h6>
                                            <div>
                                                <div class="content">
                                                    <a href="mostrarBusquedaAvanzada.action" target="contenido"><li class="letra">Egresados</li></a>
                                                </div>
                                            </div>
                                            <h6>Migraci&oacute;n</h6>
                                            <div>
                                                <div class="content">
                                                    <a href="desplegarCargueMasivo.action" target="contenido"><li class="letra">Cargue Masivo de Egresados</li></a>
                                                    <a href="obtenerListaEncuesta.action" target="contenido"><li class="letra">Encuesta</li></a>
                                                    <a href="obtenerListaPreguntaEncuestaPreguntasEncuestas.action" target="contenido"><li class="letra">Preguntas Encuesta</li></a>
                                                </div>
                                            </div>
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
                                    </s:div>
                                    <br>
                                    <br>
                                    <br>
                                </div>
                            </div>
                            <div class="col-lg-10 col-md-10 col-sm-12 col-xs-12">
                                <section>
                                    <div class="item-page">
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
                                </section>
                            </div> 
                        </div>      
                    </div>
                </div>    
            </div>    
            <footer id="bottom" class="container">
                <div id="footer" class="row">
                    <div class="col-lg-2 col-md-2 col-sm-12 col-xs-11">
                        <figure class="logo">
                            <a href="http://www.ucentral.edu.co/" title="Universidad Central">
                                <img class="img-responsive" alt="Universidad Central" src="imagenes/logo_ucentral_footer.png">
                            </a>
                            <figcaption class="hide">Universidad Central</figcaption>
                        </figure>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-11">
                        <div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-11">
                                <span>Sede Centro: carrera 5 n&deg; 21-38</span>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-11">
                                <span>Sede Norte: calle 75 n.&deg; 16-03</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-11 col-md-12 col-sm-12 col-xs-11">
                                <span>Instituci&oacute;n de educaci&oacute;n superior sujeta a inspecci&oacute;n y vigilancia del Ministerio de Educaci&oacute;n Nacional</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-11">
                        <div class="custom"  >
                            <div class="pull-left hidden-sm hidden-xs"></div>
                            <div class="pull-left hidden-sm hidden-xs">
                                <p><strong>Conmutadores:</strong> <br />323 98 68 y 326 68 20 <br /><strong>L&iacute;nea Admisiones Bogot&aacute;:</strong><br />326 68 26 <br /> <strong>L&iacute;nea gratuita nacional:</strong><br />01 8000 912 534</p>
                                <p>Universidad Central 2014 &#8226; Colombia</p>
                            </div>
                            <div class="hidden-md hidden-lg"><br />
                                <p>Conmutadores: <br />323 98 68 y 326 68 20 <br />L&iacute;nea Admisiones Bogot&aacute;:&nbsp;<br />326 68 26 <br /> L&iacute;nea gratuita nacional: <br />01 8000 912 534</p>
                                <p>Universidad Central 2014 &#8226; Colombia</p>
                            </div>
                        </div>
                    </div>
                </div>
            </footer> 
    </body>
</html>