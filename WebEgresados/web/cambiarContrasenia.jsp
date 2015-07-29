<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
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
                        <br>
                        <div class="row" style="margin-left: 150px">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                <img style="text-align: center;width: 100px;height: 100px"src="imagenes/cambiarContrasenia.jpg">
                            </div>
                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 ">
                                <h1 style="margin-left: -30px;color: #2a6155;width:300px">Cambiar contrase&ntilde;a</h1>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-11 col-md-11 col-sm-11 col-xs-11 center-block">
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
                                <div class="col-lg-5 col-md-5 col-sm-5 col-xs-5">
                                    <s:form action="cambiarContraseniaSeguridad.action">
                                        <div class="item-page">
                                            <br>
                                            <table style="alignment-adjust: central; width: 550px;margin-left: -40px">
                                                <tbody>
                                                    <tr>
                                                        <td><s:password name="actual" label="Contraseña actual" errorPosition="bottom"></s:password></td>
                                                        </tr>
                                                        <tr>
                                                            <td><s:password name="nueva" label="Contraseña nueva" errorPosition="bottom"></s:password></td>
                                                        </tr>
                                                        <tr>
                                                            <td><s:password name="confirmarNueva" label="Confirmar contraseña nueva" errorPosition="bottom"></s:password></td>
                                                        </tr>
                                                        <tr>
                                                            <td></td>
                                                            <td><s:submit  cssClass="boton_auxiliar boton guardar" cssStyle="width:auto;" value="Guardar"></s:submit></td>
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