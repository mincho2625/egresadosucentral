/*Curso JavaScript aprenderaprogramar.com */
var editando = false;

function transformarEnEditable(nodo) {
//El nodo recibido es SPAN
    if (editando == false) {
        var nodoTd = nodo.parentNode; //Nodo TD
        var nodoTr = nodoTd.parentNode; //Nodo TR
        var nodoContenedorForm = document.getElementById('contenedorForm'); //Nodo DIV
        var nodosEnTr = nodoTr.getElementsByTagName('td');
        var alimento = nodosEnTr[0].textContent;
        var calorias = nodosEnTr[1].textContent;
        var grasas = nodosEnTr[2].textContent;
        var proteina = nodosEnTr[3].textContent;
        var carbohidratos = nodosEnTr[4].textContent;
        var opciones = nodosEnTr[5].textContent;
        var nuevoCodigoHtml = '<td><input type="text" name="idEncuesta" id="idEncuesta" value="' + alimento + '" size="10"></td>' +
                '<td><input type="text" name="nombre" id="nombre" value="' + calorias + '" size="5"</td>' +
                '<td><input type="text" name="descripcion" id="grasas" descripcion="' + grasas + '" size="5"</td>' +
                '<td><input type="text" name="estado" id="estado" value="' + proteina + '" size="5"</td>' +
                '<td><input type="text" name="orden" id="orden" value="' + carbohidratos + '" size="5"</td> <td>En edición</td>';

        nodoTr.innerHTML = nuevoCodigoHtml;

        nodoContenedorForm.innerHTML = 'Pulse Aceptar para terminar edicion o cancelar para anularlos' +
                '<s:form action="guardarEncuesta.action" enctype="multipart/form-data" method="POST">' +
                '<table style="margin-left: -50px;width: 300px; page: 5"><tr>' +
                '<s:submit cssClass="boton_auxiliar" cssStyle="width:100px;margin-left: 120px;" value="Enviar"></s:submit>'+
                '<td><input class="boton_auxiliar" style="width:100px;margin-left: 120px;" type="reset" value="Cancelar"></td>' +
                '</tr></table>'+
                '</s:form>';
        editando = "true";
    }
    else {
        alert('Solo se puede editar una línea. Recargue la página para poder editar otra');
    }
}

function capturarEnvio() {
    var nodoContenedorForm = document.getElementById('contenedorForm'); //Nodo DIV
    nodoContenedorForm.innerHTML = 
            '<input type="hidden" name="idEncuesta" value="' + document.querySelector('#idEncuesta').value + '">' +
            '<input type="hidden" name="nombre" value="' + document.querySelector('#nombre').value + '">' +
            '<input type="hidden" name="descripcion" value="' + document.querySelector('#descripcion').value + '">' +
            '<input type="hidden" name="estado" value="' + document.querySelector('#estado').value + '">' +
            '<input type="hidden" name="orden" value="' + document.querySelector('#orden').value + '">' +
            '<input class="boton" type = "submit" value="Aceptar"> <input class="boton" type="reset" value="Cancelar">';
    document.formulario.submit();
    
    
}

function anular() {
    window.location.reload();
}
