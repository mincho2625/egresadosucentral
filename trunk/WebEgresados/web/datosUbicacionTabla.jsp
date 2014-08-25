<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<html lang="es">
    <head>
        <title>Datos Ubicacion Tabla</title>
        <meta charset="utf-8"/>
        <link rel="stylesheet" href="estilo.css">
    </head>
    <body>
        <div id="Tabla" align="center">
            <table rules="all" >
                <caption>DATOS DE UBICACION</caption>
                <tr>
                    <td class="tddos">Tipo Contacto<br>
                    </td>
                    <td class="tddos">Descripcion<br>
                    </td>
                    <td class="tddos">Accion<br>
                    </td>
                </tr>

                <s:iterator value="listaObjetos" status="contacto">
                    <tr>
                        <td class="tdtres"><s:property value="idTipoContacto.nombre"></s:property><br>
                            </td>
                            <td class="tdtres"><s:property value="descripcion"></s:property><br>
                            </td>
                            <td class="tdtres">
                            <s:url id="editarURL" action="editarUbicacion.action">
                                <s:param name="idObjeto" value="%{idContacto}"></s:param>
                            </s:url>
                            <s:a href="%{editarURL}">
                                <img style="width: 20px; height: 19px;" title="Editar" alt="Editar" src="imagenes/Icono_de_editar.png" align="top"><br>
                            </s:a>
                            <s:url id="borrarURL" action="borrarUbicacion.action">
                                <s:param name="idObjeto" value="%{idContacto}"></s:param>
                            </s:url>
                            <s:a href="%{borrarURL}">
                                <img style="width: 20px; height: 19px;" title="Borrar" alt="Borrar" src="imagenes/Icono_de_editar.png" align="top"><br>
                            </s:a>
                        </td>
                    </tr>
                </s:iterator>
            </table>
            <br>
            <div class="buttons">
                <a href="desplegarUbicacion.action" target="contenido">
                    <button type="submit" class="positive" name="nuevo">
                        <img src="imagenes/btnGuardar.png" alt=""/>
                        Nuevo
                    </button>
                </a><br>
            </div>
            <br>
            <a href="obtenerListaEgresadoRedSocial.action" class="tduno"><div>Siguiente</div></a>
            <br>
            <a href="obtenerEgresadoRegistro.action" class="tdatras"><div>Anterior</div></a>
            <br>
            <br>

        </div>
        <div id="contenido">
            <s:if test="editar">
                <s:form action="guardarUbicacion.action"> 
                    <s:push value="objeto">
                        <s:hidden name="idContacto"></s:hidden>
                            <div class="tdun">Generar Nuevo Registro</div>
                            <br>
                            <table >
                                <tr>
                                    <td>
                                        <div class="tduno">Tipo Contacto</div><s:select cssClass="center" name="tipoContacto" list="listaTiposContacto" listKey="idTipoContacto" listValue="nombre"></s:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="tduno">Descripción</div><s:textfield cssClass="center" name="descripcion"></s:textfield>
                                    </td>
                                </tr>
                                <tr>
                                <s:submit cssClass="center1" value="Guardar"></s:submit>
                                </tr>
                            </table>
                    </s:push>
                </s:form>
            </s:if>
        </div>
</body>
</html>