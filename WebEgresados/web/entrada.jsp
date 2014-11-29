<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Entrada</title>
        <meta charset="utf-8"/>
        <link rel="stylesheet" href="estilo2.css"/>
    </head>

    <body class="fondo">
        <div class="fondo">
            <div class="imagentitulo">
                <p><img src="imagenes/logosimbolo-ucentral-v1-large.png" width="360" height="102" /></p>
                <p>&nbsp;</p>
            </div>
            <div class="menuPrincipal">
                <form action="" method="post" name="form2" class="imagen" id="form2">
                </form>
                <div class="menu">
                    <p>¡Bienvenido al Sistema de egresados universidad)!          </p>
                    <p>Para iniciar su sesión, tenga en cuenta que:</p>
                    <p> Su usuario es el número de su documento de identidad.</p>
                    <p> Su contraseña por defecto es el número de su documento de identidad. Recuerde que es importante cambiarla durante la primera sesión. </p>
                </div>
                <div class="tituloTable">
                    <li class="t-item t-state-active">Registro
                        <div class="titulotable" id="LoagOn1MenuPanelBar-1">
                            <s:form name="f1" method="post" action="Ingreso" id="Ingreso">
                                <table style="border:hidden;text-align:center;width:100%;font-size:14px;">
                                    <tbody>
                                        <tr>
                                            <td>
                                                <s:textfield label="Usuario" name="usuario" id="Ingreso_usuario" style="height:30px;border:1px solid #636f07;width:98%;display :block;"></s:textfield>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                <s:password label="Contrase�a" name="contrasenia" id="Ingreso_contrasenia" style="height:30px;border:1px solid #636f07;width:98%;display :block;"></s:password>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td style="text-align:right">
                                                <s:actionerror></s:actionerror>
                                                <s:submit value="ENTRAR" id="Ingreso_0"></s:submit>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                            </s:form>
                        </div></li>
                </div>
                <div class="menu">
                    <p>Si no dispone de una cuenta, haga clic <s:a href="desplegarRegistro.action" target="contenido" >aqu�</s:a>.</p>
                </div>
                <p>&nbsp;</p>
                <p>&nbsp;</p>
            </div>
            <div class="from">
                <div class="TituloPrincipal2" style="/* [disabled]margin-left:10px; */ font-size: 20px">
                    <div align="center">Portal Egresados  Universidad Central</div>
                </div>                 
                <div>
                    <p><img src="imagenes/800px-Facultad_de_ingenieria_de_la_Universidad_Central.jpg" width="600" height="229" /></p>
                </div>
                <div id="contenido" class="menu">
                    <div>
                        <div align="justify">
                            <p>Para la Direccion de Egresados y Exalumnos es muy importante la constante interaccion con quienes son parte esencial y razon</p>
                            <p>de ser de esta dependencia, por lo cual es fundamental mantener actualizados sus datos de contacto, con el fin de mantenerlos informados sobre las</p>
                            <p>diferentes actividades academicas, culturales y sociales que se programan, asi como de los servicios que les ofrecemos</p>
                            <p>&nbsp;</p>
                            <p>Para�<strong>Actualizar�</strong><strong>sus datos</strong>, Ingresa al sistema</p>
                        </div>
                    </div>
                    <p align="justify">&nbsp;</p>
                </div>
                <div class="menu">
                    Noticias
                </div>
                <p>&nbsp;</p>
            </div>
        </div>
        <div class="footer">
            <div align="center">Institución de educación superior sujeta a inspección y vigilancia del Ministerio de Educación Nacional<br> 
                    <span style=""><strong>Sede Centro</strong>: Cra. 5 N° 21-38 <span style="color: #b50900;">•</span> <strong>Sede Norte</strong>: Cll. 75 Nº 16-03 <span style="color: #b50900;">•</span> <strong>Sede El Lago:</strong> Cra.15 Nº 75-14<span style=""> <span style="color: #b50900;">•</span> Conmutadores: <strong>323 9868 y 326 6820</strong></span><span style="color: #b50900;"> • </span></span><span style="font-size: 8pt;"><span style="">Centro de atención:  <strong>326 6826 y 744 7606.</strong></span> <br> 
                            <span style="color: #5b6606;"><strong><span style="">© Universidad Central 2014</span></strong><span style="color: #b50900;"> •</span> <strong>Colombia</strong><span style="color: #b50900;"> •</span></span> <br>
                                </span>
                                </div>
                                </div>
                                </body>
                                </html>
