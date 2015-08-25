<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<html lang="es">
    <head><title>Datos de Ubicacion</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="estilo.css">
        <link rel="stylesheet" type="text/css" href="normalize.min.css">
        <link rel="stylesheet" type="text/css" href="bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="styles.css">
        <link rel="stylesheet" type="text/css" href="jce.css">
        <s:head />
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <jq:head jqueryui="true" />
        
        <script src="simpleFacebookGraph.js"></script>
        <!-- SCRIPTS PROPIOS QUE USA ESTA PÁGINA -->
        <script>

        // Cuando la pagina carga miramos si ya hay un usuario identificado.
            fb.ready(function () {
                if (fb.logged)
                {
                    // Cambiamos el link de identificarse por el nombre y la foto del usuario.
                    html = "<p>Hola " + fb.user.name + "</p>";
                    html += '<p><img src="' + fb.user.picture + '"/></p>';
                    html += '<p><a href="#" onclick="fb.logout(); return false;">Salir</a></p>';
                    document.getElementById("conectar_facebook").innerHTML = html;
                }
            });


        // Funcion para logarse con Facebook.
            function login() {
                fb.login(function () {
                    if (fb.logged) {
                        // Cambiamos el link de identificarse por el nombre y la foto del usuario.
                        html = "<p>Hola " + fb.user.name + "</p>";
                        html += "<p><img src='" + fb.user.picture + "'/></p>";
                        document.getElementById("conectar_facebook").innerHTML = html;
                    } else {
                        alert("No se pudo identificar al usuario");
                    }
                })
            }
            ;

        // Funcion para publicar un mensaje en tu muro
            var publish = function () {
                fb.publish({
                    message: "document.formul.textito",
                    name: "Universidad Central",
                    description: "Publicacion Realzia por la Universidad Central"
                }, function (published) {
                    if (published)
                        alert("publicado!");
                    else
                        alert("No publicado :(, seguramente porque no estas identificado o no diste permisos");
                });
            }
        </script>
        <script>(function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id))
                    return;
                js = d.createElement(s);
                js.id = id;
                js.src = "//connect.facebook.net/es_ES/sdk.js#xfbml=1&version=v2.3&appId=1592589994358772";
                fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));</script>
        <script>!function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0], p = /^http:/.test(d.location) ? 'http' : 'https';
                if (!d.getElementById(id)) {
                    js = d.createElement(s);
                    js.id = id;
                    js.src = p + "://platform.twitter.com/widgets.js";
                    fjs.parentNode.insertBefore(js, fjs);
                }
            }(document, "script", "twitter-wjs");
        </script>
    </head>
    <body class="default" ontouchstart="">
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
                        <div class="row" style="margin-left: 150px">
                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 ">
                                <h1 style="margin-left: 70px;color: #2a6155;width:300px">Redes Sociales</h1>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">
                                <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
                                    <h1>Facebook</h1>
                                    <div style="width: 200px" class="fb-page" data-href="https://www.facebook.com/ucentralbogota" data-width="10000"  data-height="500" data-hide-cover="true" data-show-facepile="true" data-show-posts="true"><div class="fb-xfbml-parse-ignore"><blockquote cite="https://www.facebook.com/ucentralbogota"><a href="https://www.facebook.com/ucentralbogota">Universidad Central</a></blockquote></div></div>
                                    <!--<div class="fb-login-button" data-max-rows="1" data-size="large" data-show-faces="true" data-auto-logout-link="true"></div>-->
                                    <h5 style="color: #2a6155;width:300px">Deseas compartir la pagina con personas que conoscas</h5>
                                    <div style="alignment-baseline: central;" class="fb-send" data-href="https://www.facebook.com/ucentralbogota"></div>
                                </div>
                                <div class="col-lg-1 col-md-1 col-sm-1 col-xs-1">

                                </div>
                                <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
                                    <h1>Twitter</h1>
                                    <a  style="width: 400px" class="twitter-timeline" href="https://twitter.com/ucentralbogota" data-widget-id="600355336869027841">Tweets por el @ucentralbogota.</a>    
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">
                                <textarea name="comentarios" rows="10" cols="40">Escribe aquí tus comentarios</textarea>
                                  <div id="conectar_facebook">
                                    <a href="#" onclick="login(); return false;">Contectarse a Facebook</a>
                                  </div>
                                  <br/><br/>
                                  <p><a href="#" onclick="publish(); return false;">Publicar algo en tu muro</p>
                            </div>    
                        </div>
                    </div>
                </div> 
            </div>          
    </body>
</html>