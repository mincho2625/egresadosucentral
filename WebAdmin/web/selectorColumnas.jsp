<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="jq" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head></s:head>
        <jq:head jqueryui="true"></jq:head>
            <script language="Javascript">
                function MoverSeleccion(SS1, SS2)
                {
                    var SelID = '';
                    var SelText = '';
                    // Move rows from SS1 to SS2 from bottom to top
                    for (i = SS1.options.length - 1; i >= 0; i--)
                    {
                        if (SS1.options[i].selected === true)
                        {
                            SelID = SS1.options[i].value;
                            SelText = SS1.options[i].text;
                            var newRow = new Option(SelText, SelID);
                            SS2.options[SS2.length] = newRow;
                            SS1.options[i] = null;
                        }
                    }
                }
                function MoverTodos(SS1, SS2)
                {
                    var SelID = '';
                    var SelText = '';
                    // Move rows from SS1 to SS2 from bottom to top
                    for (i = SS1.options.length - 1; i >= 0; i--)
                    {
                        SelID = SS1.options[i].value;
                        SelText = SS1.options[i].text;
                        var newRow = new Option(SelText, SelID);
                        SS2.options[SS2.length] = newRow;
                        SS1.options[i] = null;
                    }
                }
                function guardar()
                {
                    var lista = 'lista=';
                    var select = document.getElementById('seleccionColumnasQuitar').options;
                    for (i = select.length - 1; i >= 0; i--) {
                        lista += select[i].value + ',';
                    }

                    window.location = "${pageContext.request.contextPath}/guardarSelectorColumnas.action?" + lista;
                }


        </script>

        <script type="text/javascript">
            function cerrar() {
                $('#dialogColumnas').dialog('close');
            }
            ;
        </script>
    </head>
    <body>
        <div class="row" class="col-lg-11 col-md-11 col-sm-11 col-xs-11">
            <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
                <div >
                    <h4 style="color: #2a6155;width:100px">Columnas</h4>
                    <s:select cssStyle="width: 230px;height: 250px" list="listaColumnas"  multiple="true" id="seleccionColumnasAgregar" listKey="id" listValue="nombre"></s:select>
                    </div>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
                    <div style="margin-left: 160px;margin-top: 70px">
                    <jq:a href="#" button="true" onclick="MoverTodos(seleccionColumnasAgregar,seleccionColumnasQuitar);"><img style="width: 20px; height: 19px;" title="Agregar Todos" alt="Agregar Todos" src="imagenes/Agregar_Todos.png" align="top"></jq:a>
                    <br>
                    <br>
                    <jq:a   href="#"  button="true" onclick="MoverSeleccion(seleccionColumnasAgregar,seleccionColumnasQuitar);"><img style="width: 20px; height: 19px;" title="Agregar Selección" alt="Agregar Selección" src="imagenes/Agregar_Selección.png" align="top"></jq:a>
                    <br>
                    <br>
                    <jq:a href="#" button="true" onclick="MoverSeleccion(seleccionColumnasQuitar,seleccionColumnasAgregar);"><img style="width: 20px; height: 19px;" title="Quitar Selección" alt="Quitar Selección" src="imagenes/Quitar_Selección.png" align="top"></jq:a>
                    <br>
                    <br>
                    <jq:a href="#" button="true" onclick="MoverTodos(seleccionColumnasQuitar,seleccionColumnasAgregar);"><img style="width: 20px; height: 19px;" title="Quitar Todos" alt="Quitar Todos" src="imagenes/Quitar_Todos.png" align="top"></jq:a>
                    </div>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
                    <div style="margin-left: 130px">
                        <h4 style="color: #2a6155;width:100px">Selección</h4>
                    <s:select cssStyle="width: 230px;height: 250px" list="listaColumnasSeleccionadas" multiple="true" id="seleccionColumnasQuitar" listKey="id" listValue="nombre"></s:select>
                </div>
            </div>
        </div>
    </body>
</html>