<%-- 
    Document   : selectorColumnas
    Created on : 04-oct-2015, 11:11:56
    Author     : YURY
--%>

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
            };
        </script>
    </head>
    <body>
        <s:select list="listaColumnas" label="Columnas" multiple="true" id="seleccionColumnasAgregar" listKey="id" listValue="nombre"></s:select>
        <jq:a href="#" onclick="MoverSeleccion(seleccionColumnasAgregar,seleccionColumnasQuitar);">Agregar Selección</jq:a>
        <jq:a href="#" onclick="MoverTodos(seleccionColumnasAgregar,seleccionColumnasQuitar);">Agregar Todos</jq:a>
        <jq:a href="#" onclick="MoverSeleccion(seleccionColumnasQuitar,seleccionColumnasAgregar);">Quitar Selección</jq:a>
        <jq:a href="#" onclick="MoverTodos(seleccionColumnasQuitar,seleccionColumnasAgregar);">Quitar Todos</jq:a>
        <s:select list="listaColumnasSeleccionadas" label="Selección" multiple="true" id="seleccionColumnasQuitar" listKey="id" listValue="nombre"></s:select>
    </body>
</html>