<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<html lang="es">
    <head><title>Registro Sistema</title>
        <meta charset="utf-8">
        <link href="estilo2.css" rel="stylesheet" type="text/css">
        <jq:head></jq:head>
        </head>
        <body>
            <div class="TituloPrincipal" style="/* [disabled]margin-left:10px; */ font-size: 20px">
                <div align="center">Portal Egresados  Universidad Central</div>
            </div>
            <div class="titu">
                <p align="left"><img src="imagenes/document-open.png" width="107" height="94">		      <span class="titu2">a a a</span><img src="imagenes/logosimbolo-ucentral-v1-medium.png" width="273" height="62">  <span class="titu2">a as</span>Aficiones y Deportes</p>
            </div>
            <!--<div id="default-example" data-collapse>
                <h3>Informacion</h3>-->
                <div align="center" class="tabla" id="Tabla">
                    <table rules="all" class="table2" >
                <caption>&nbsp;</caption>
                <tr>
                    <td class="texfield"><div align="center" class="fuentetabla">Tipo Actividad<br>
                    </div></td>
                    <td class="texfield"><div align="center" class="fuentetabla">Lista de Actividades<br>
                    </div></td>
                    <td class="texfield"><div align="center" class="fuentetabla">Accion<br>
                    </div></td>
                </tr>
                    
                <s:hidden name="cantidadObjetos"></s:hidden>
                <s:iterator value="listaObjetos">
                    <tr>
                        <td class="texfield"><s:property value="idTipoActividad.nombre"></s:property><br>
                            </td>
                            <td class="texfield"><s:property value="listaActividades"></s:property><br>
                            </td>
                            <td class="texfield">
                            <s:url id="editarURL" action="editarAficion.action">
                                <s:param name="idObjeto" value="%{idAficion}"></s:param>
                            </s:url>
                            <s:a href="%{editarURL}">
                                <div class="fuentetabla2"><img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/Icono_de_editar.png" align="top">Editar</div><br>
                            </s:a>
                            <s:url id="borrarURL" action="borrarAficion.action">
                                <s:param name="idObjeto" value="%{idAficion}"></s:param>
                            </s:url>
                            <s:a href="%{borrarURL}">
                                <div class="fuentetabla2"><img style="width: 20px; height: 19px;" title="Borrar" alt="Borrar" src="imagenes/Icono_de_editar.png" align="top">Borrar</div><br>
                            </s:a>
                        </td>
                    </tr>
                </s:iterator>
            </table>
                <br>
            <div class="buttons">
                <a href="desplegarAficion.action" target="contenido">
                    <button type="submit" class="positive" name="nuevo">
                        <img src="imagenes/btnGuardar.png" alt=""/>
                        Nuevo
                    </button>
                </a><br>
            </div>
                <div class="fromtables" id="contenido1">
                    <s:if test="editar">
                <s:form action="guardarAficion.action">
                    <s:push value="objeto">
                        <s:hidden name="idAficion"></s:hidden>
                            <div class="fuente2">Generar Nuevo Registro</div>
                            <table>
                                <tr>
                                    <td>
                                    <s:select name="tipoActividad" cssClass="texfield" label="Tipo Actividad" list="listaTiposActividades" listKey="idTipoActividad" listValue="nombre" headerKey="-1" headerValue="- Seleccione -"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                    <s:textfield label="Lista Actividades" cssClass="texfield" name="listaActividades"></s:textfield>
                                    </td>
                                </tr>
                                <tr>
                                <tr>
                                    <s:actionerror></s:actionerror>
                                <s:submit cssClass="center1" value="Guardar">
                                </s:submit>
                            </tr>
                        </table>
                    </s:push>
                </s:form>
            </s:if>
                </div>
            </div>
        <!--</div>-->
        <p></p>
        <p><br>
        </p>
        <a href="siguienteAficion.action"><div class="tdsiguiente"><img src="imagenes/button_next_89675.jpg" width="21" height="21"></div></a>
        <br>
        <a href="anteriorAficion.action" class="tdatras"><div class="tdatras"><img src="imagenes/boton_atras.png" width="24" height="24"></div></a>
        <br>
        <br>
        <br>
        <s:if test="hasActionErrors()">
            <div class="errors">
               <s:actionerror/>
            </div>
        </s:if>
        <br>
        <br>
    </body>
</html>