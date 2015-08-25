<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<html lang="es-es" class="no-js">
    <head>
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
            function mostrarImagen(event) {
                var selectedFile = event.target.files[0];
                var reader = new FileReader();

                var imgtag = document.getElementById("vistaPrevia");
                imgtag.title = selectedFile.name;

                reader.onload = function(event) {
                  imgtag.src = event.target.result;
                };

                reader.readAsDataURL(selectedFile);
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
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4 hidden-xs">
                                <img id="vistaPrevia" style="margin-left: 50px;  width: 130px; height: 100px"src="imagenes/no-photo.png">
                            </div>
                            <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5 hidden-xs">
                                <h1 style="text-align: match-parent; color: #2a6155; width: 400px" >Registro Usuario</h1>
                            </div>
                        </div>
                        <div class="row">
                            <br>
                            <br>
                            <br>
                            <br>
                            <br>
                            <br>
                            <br>
                            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 hidden-xs"></div>
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-11">
                                    <s:form action="guardarRegistro.action" id="formRegistro" enctype="multipart/form-data" method="POST">
                                        <s:url id="ciudadURL" action="SelectDobleCiudad"/>
                                            <div class="top item-page">
                                                <table style="width: 500px">
                                                    <tbody>
                                                        <tr>
                                                            <td><s:file label="Foto" errorPosition="bottom" name="fileUpload" id="fileUpload" onchange="mostrarImagen(event);"></s:file></td>
                                                        </tr>
                                                        <tr>
                                                            <td><s:textfield name="primerApellido" label="Primer Apellido" errorPosition="bottom"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><s:textfield name="segundoApellido" label="Segundo Apellido" errorPosition="bottom"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><s:textfield name="nombres" label="Nombres" errorPosition="bottom"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><jq:datepicker label="Fecha Nacimiento" errorPosition="bottom" size="45" name="fechaNacimiento" displayFormat="dd/mm/yy" changeMonth="true" changeYear="true" maxDate="1y" showButtonPanel="true"></jq:datepicker></td>
                                                        </tr>
                                                        <tr>
                                                            <td><jq:select href="%{ciudadURL}" cssStyle="minu" onChangeTopics="reloadsecondlist" name="pais" id="pais"
                                                                   list="listaPaises" listKey="id" listValue="nombre" onCompleteTopics="reloadsecondlist"
                                                                   headerKey="-1" headerValue="- Seleccione -" label="País Nacimiento" errorPosition="bottom"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><jq:select href="%{ciudadURL}"  onChangeTopics="reloadThirdlist" onCompleteTopics="reloadThirdlist"
                                                                   formIds="formRegistro" reloadTopics="reloadsecondlist" name="departamento" id="departamento"
                                                                   list="listaDepartamentos" listKey="id" listValue="nombre" headerKey="-1"
                                                                   headerValue="- Seleccione -" label="Departamento Nacimiento" errorPosition="bottom"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><jq:select href="%{ciudadURL}"  formIds="formRegistro" reloadTopics="reloadThirdlist"
                                                                   name="ciudadNacimiento" list="listaCiudades" listKey="id" listValue="nombre" headerKey="-1"
                                                                   headerValue="- Seleccione -" id="ciudad" label="Ciudad Nacimiento" errorPosition="bottom"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><s:select label="Tipo Documento" errorPosition="bottom" name="tipoDocumento" list="listaTiposDocumento" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione - "/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><s:textfield  name="numeroDocumento" label="Número Documento" errorPosition="bottom"></s:textfield></td>
                                                        </tr>
                                                        <tr>
                                                            <td><jq:datepicker label="Fecha Expedición" errorPosition="bottom" name="fechaExpedicion" displayFormat="dd/mm/yy" changeMonth="true" changeYear="true" showButtonPanel="true" maxDate="1y"></jq:datepicker></td>
                                                        </tr>
                                                        <tr>
                                                            <td><jq:select href="%{ciudadURL}" onChangeTopics="reloadsecondlist2" name="pais2" id="pais2"
                                                                   list="listaPaises2" listKey="id" listValue="nombre" onCompleteTopics="reloadsecondlist2"
                                                                   headerKey="-1" headerValue="- Seleccione -" label="País Expedición" errorPosition="bottom"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><jq:select href="%{ciudadURL}"  onChangeTopics="reloadThirdlist2" onCompleteTopics="reloadThirdlist2"
                                                                   formIds="formRegistro" reloadTopics="reloadsecondlist2" name="departamento2" id="departamento2"
                                                                   list="listaDepartamentos2" listKey="id" listValue="nombre" headerKey="-1"
                                                                   headerValue="- Seleccione -" label="Departamento Expedición" errorPosition="bottom"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><jq:select href="%{ciudadURL}"  reloadTopics="reloadThirdlist2" label="Ciudad Expedición" errorPosition="bottom"
                                                                   name="ciudadExpedicion" list="listaCiudades2" listKey="id" listValue="nombre" headerKey="-1"
                                                                   headerValue="- Seleccione -" id="ciudad2" formIds="formRegistro"/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><s:select label="Grupo Sanguíneo" errorPosition="bottom" name="grupoSanguineo" list="listaGruposSanguineos" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione - "/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><s:select label="Género" errorPosition="bottom" name="genero" list="listaGeneros" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione - "/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><s:select label="Estado Civil" errorPosition="bottom" name="estadoCivil" list="listaEstadosCiviles" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione - "/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><s:textfield name="correoInstitucional" label="Correo Institucional" errorPosition="bottom"></s:textfield></td>
                                                        </tr>
                                                        <tr>
                                                            <td><s:textfield name="nombre" label="Usuario" errorPosition="bottom"></s:textfield></td>
                                                        </tr>
                                                        <tr>
                                                            <td><s:password name="contrasenia" label="Contraseña" errorPosition="bottom"></s:password></td>
                                                        </tr>
                                                        <tr>
                                                            <td><s:password name="confirmacionClave" label="Confirmar contraseña" errorPosition="bottom"></s:password></td>
                                                        </tr>
                                                        <tr>
                                                            <td><s:select label="Pregunta Seguridad" errorPosition="bottom" name="preguntaSeguridad" list="listaPreguntas" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione - "/></td>
                                                        </tr>
                                                        <tr>
                                                            <td><s:password name="respuestaSeguridad" label="Respuesta Secreta" errorPosition="bottom"></s:password></td>
                                                        </tr>
                                                        <tr>
                                                            <td><s:checkbox cssClass="checkbox" name="terminos" label="Términos y Condiciones" errorPosition="bottom"></s:checkbox></td>
                                                        </tr>
                                                        <tr>
                                                            <td></td>
                                                            <td><s:actionerror></s:actionerror></td>
                                                        </tr>
                                                        <tr>
                                                            <td></td>
                                                            <td><s:submit value="Guardar" cssStyle="width:auto;" cssClass="boton_auxiliar boton guardar" ></s:submit></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                    </s:form>
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
                            </div>
                            <br>
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
