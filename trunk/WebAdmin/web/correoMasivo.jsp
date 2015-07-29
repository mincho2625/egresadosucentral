<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<html lang="es">
    <head><title>Registro Sistema</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="estilo.css">
        <link rel="stylesheet" type="text/css" href="normalize.min.css">
        <link rel="stylesheet" type="text/css" href="bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="styles.css">
        <link rel="stylesheet" type="text/css" href="jce.css">
        <s:head />
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/111.0/jquery.min.js"></script>
        <jq:head jqueryui="true"/>
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
                    <div class="componente col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block" style="margin-left: -50px">
                        <div class="row" style="margin-left: 158px;">
                            <br>
                            <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5 " style="margin-left: -30px">
                                <h1 style="margin-left: 100px; color: #2a6155; width: 400px" >Actualizar Información</h1>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
                                <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
                                    <s:form action="enviarCorreoMasivo.action" id="formCorreo">
                                        <s:url id="programasURL" action="SelectPrograma"/>
                                        <div class="item-page">
                                            <br>
                                            <table style="alignment-adjust: central; width: 550px;margin-left: -40px">
                                                                                                    <tr>
                                                        <td><jq:select href="%{programasURL}" onChangeTopics="reloadThirdlist" name="nivelEstudios" id="nivelEstudios"
                                                                   list="listaNivelesEstudios" listKey="id" listValue="nombre" onCompleteTopics="reloadThirdlist"
                                                                   headerKey="-1" headerValue="- Seleccione -" label="Nivel de estudios" errorPosition="bottom"/></td>
                                                    </tr>
                                                    <tr>
                                                        <td><jq:select href="%{programasURL}" onChangeTopics="reloadThirdlist" name="facultad" id="facultad"
                                                                   formIds="formCorreo" list="listaFacultades" listKey="id" listValue="nombre"
                                                                   headerKey="-1" headerValue="- Seleccione -" onCompleteTopics="reloadThirdlist"
                                                                   label="Facultad" errorPosition="bottom"/></td>
                                                    </tr>
                                                    <tr>
                                                        <td><jq:select href="%{programasURL}" reloadTopics="reloadThirdlist" label="Programa" errorPosition="bottom"
                                                                   name="programa" list="listaProgramas" listKey="id" listValue="nombre" headerKey="-1"
                                                                   headerValue="- Seleccione -" id="programa" formIds="formCorreo"/></td>
                                                    </tr>
                                                    <tr>
                                                        <td><s:select label="Año Finalización" errorPosition="bottom" name="anioGrado" list="listaAnios" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                                                    </tr>
                                                    <tr>
                                                        <td><s:select label="Género" errorPosition="bottom" name="genero" list="listaGeneros" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                                                    </tr>
                                                    <tr>
                                                        <td><s:select label="Estado Civil" errorPosition="bottom" name="estadoCivil" list="listaEstadosCiviles" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                                                    </tr>
                                                    <tr>
                                                        <td><s:select label="Plantilla de correo" errorPosition="bottom" name="plantilla" list="listaPlantillas" listKey="id" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                                                    </tr>
                                                    <s:if test="hasActionErrors()">
                                                        <tr>
                                                            <s:actionerror/>
                                                        </tr>
                                                    </s:if>
                                                        
                                                    <s:if test="hasActionMessages()">
                                                        <tr>
                                                            <s:actionmessage/>
                                                        </tr>
                                                    </s:if>
                                                    <tr>
                                                        <td></td>
                                                        <td><s:submit  cssClass="boton_auxiliar boton guardar" cssStyle="width:auto;" value="Enviar"></s:submit></td>
                                                        </tr>
                                                    
                                                </table>     
                                            </div>
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