<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
        <jq:head jqueryui="true" jquerytheme="simple"/>
    </head>
    <body>
        <s:form action="guardarResidencia.action" id="formResidencia">
            <s:url id="ciudadURL" action="SelectCiudad"/>
            <s:push value="objeto">
                <s:hidden name="idResidencia"></s:hidden>
                    <table style="margin-left: -5px;width: 425px">
                        <tr>
                            <td><jq:select href="%{ciudadURL}" onChangeTopics="reloadsecondlist" name="pais" id="pais"
                                   list="listaPaises" listKey="id" listValue="nombre" cssClass="center" onCompleteTopics="reloadsecondlist"
                                   headerKey="-1" headerValue="- Seleccione -" label="País Residencia" errorPosition="bottom"/></td>
                    </tr>
                    <tr>
                        <td><jq:select href="%{ciudadURL}" onChangeTopics="reloadThirdlist" onCompleteTopics="reloadThirdlist"
                                   formIds="formResidencia" reloadTopics="reloadsecondlist" name="departamento" id="departamento"
                                   list="listaDepartamentos" listKey="id" listValue="nombre" headerKey="-1"
                                   headerValue="- Seleccione -" cssClass="center" label="Departamento Residencia" errorPosition="bottom"/></td>
                    </tr>
                    <tr>
                        <td><jq:select href="%{ciudadURL}" formIds="formResidencia" reloadTopics="reloadThirdlist"
                                   name="ciudad" list="listaCiudades" listKey="id" listValue="nombre" headerKey="-1"
                                   headerValue="- Seleccione -" id="ciudad" cssClass="center" label="Ciudad Residencia" errorPosition="bottom"/></td>
                    </tr>
                    <tr>
                        <td><s:select label="Tipo Vivienda" errorPosition="bottom" cssClass="center" name="tipoVivienda" list="listaTiposVivienda" listKey="idTipoVivienda" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                        </tr>
                        <tr>
                            <td><s:select label="Tipo Tenencia Vivienda" errorPosition="bottom" cssClass="center" name="tipoTenenciaVivienda" list="listaTiposTenenciaVivienda" listKey="idTipoTenenciaVivienda" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                        </tr>
                        <tr>
                            <td><s:textfield label="Dirección" errorPosition="bottom" cssClass="center" name="direccion"></s:textfield></td>
                        </tr>
                        <tr>
                            <td><s:select label="Estrato" errorPosition="bottom" cssClass="center" name="estrato" list="listaEstratos" listKey="idEstrato" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select></td>
                        </tr>
                        <tr>
                            <td><s:checkbox label="Tiene computador" errorPosition="bottom" cssClass="center" name="computador"></s:checkbox></td>
                        </tr>
                        <tr>
                            <td><s:checkbox label="Tiene acceso a internet" errorPosition="bottom" cssClass="center" name="conexionInternet"></s:checkbox></td>
                        </tr>
                        <tr> <s:actionerror></s:actionerror></tr>
                        <tr>
                            <td></td>
                            <td><s:submit cssClass="boton_auxiliar boton guardar" cssStyle="width:auto;"value="Guardar"></s:submit></td>
                        </tr>    
                    </table>
            </s:push>
        </s:form>
    </body>
</html>
