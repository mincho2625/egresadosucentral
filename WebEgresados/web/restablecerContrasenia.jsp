<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<html lang="es">
    <head><title>Restablecer contrase&ntilde;a</title>
        <jq:head jqueryui="true" />
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="stylesheet" href="estilo.css">
        <link rel="stylesheet" type="text/css" href="normalize.min.css">
        <link rel="stylesheet" type="text/css" href="bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="styles.css">
        <link rel="stylesheet" type="text/css" href="jce.css">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300,300italic,700' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=PT+Serif:400,700' rel='stylesheet' type='text/css'>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
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
                            var diasSemana = new Array("Domingo", "Lunes", "Martes", "Miï¿½rcoles", "Jueves", "Viernes", "Sï¿½bado");
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
                                    <span class="sr-only">Menu comunidad unicentralista</span>
                                    <h6>Menu</h6>
                                </button>
                            </div>
                            <div class="navbar-collapse collapse" id="menu-1919926903">
                                <ul class="menu pull-right ">
                                    <li class="item-793"><a  href="entrada.jsp" ><span> Inicio</span></a></li>
                                    <li class="item-264 parent"><a href="http://www.ucentral.edu.co/egresados" ><span> Egresados</span></a></li>
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
                        <span>Programas de educación superior</span>
                    </div>
                </div>
                <div class="col-lg-8 col-md-8 col-sm-9 col-xs-12 hidden-xs">
                    <div class="custom"  >
                        <div class="search pull-right">
                            <h3 style="color: #B11F16">Portal Egresados Universidad Central</h3>
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
                    <div class="componente col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">
                        <div class="row" style="margin-left: 250px;">
                            <br>
                            <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5 hidden-xs">
                                <h1 style="text-align: match-parent; color: #2a6155; width: 400px" >Restablecer contrase&ntilde;a</h1>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 hidden-xs"></div>
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-11">
                                    <s:form action="RestablecerContrasenia">
                                        <div class="item-page">
                                            <br>
                                            <table style="alignment-adjust: central; width: 550px;margin-left: -40px">
                                                <tbody>
                                                    <tr>
                                                        <td><s:select label="Tipo Documento" errorPosition="bottom" name="tipoDocumento" list="listaTiposDocumento" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione - "/></td>
                                                    </tr>
                                                    <tr>
                                                        <td><s:textfield  name="numeroDocumento" label="Número Documento" errorPosition="bottom"></s:textfield></td>
                                                    </tr>
                                                    <tr>
                                                        <td><jq:datepicker label="Fecha Nacimiento" errorPosition="bottom" size="45" name="fechaNacimiento" displayFormat="dd/mm/yy" changeMonth="true" changeYear="true" showButtonPanel="true"></jq:datepicker></td>
                                                    </tr>
                                                    <tr>
                                                        <td></td>
                                                        <td><s:submit  cssClass="boton_auxiliar boton guardar" cssStyle="width:auto;" value="Recuperar"></s:submit></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        <s:if test="hasActionErrors()">
                                            <div style="width: 450px">
                                                <s:actionerror cssClass="alert alert-danger"/>
                                            </div>
                                        </s:if>
                                    </s:form>
                                </div>
                                <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div> 
        </div>          
    </body>
</html>