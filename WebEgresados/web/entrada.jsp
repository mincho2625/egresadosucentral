<!DOCTYPE html>

<html lang="es">

<head>
	<title>Entrada</title>
	<meta charset="utf-8"/>
	
	<link rel="stylesheet" href="estilo.css">
</head>

<body >

	<div id="cabecera"><img src="imagenes/logosimbolo-ucentral-v1-large.png">
		</div>

<div id="frameAbajo">
	<div id="menu">
		<div class="tituloMenu">Acceso</div>
		<s:form name="f1" method="post" action="index.jsp">

			<center><table>
				<tr><br><br>
					<td align="center"><img src="imagenes/logosimbolo-ucentral-v2-medium.png"></td>
				</tr>
				<tr>
					<td class="tduno">Usuario</td>
				</tr>
				<tr>
					<td><input type="text" name="cod_usua" id="cod_usua"></td>
				</tr>
				<tr>
					<td class="tduno">Clave</td>
				</tr>
				<tr>
					<td><input type="text" name="clave" id="clave"></td>
				</tr>
				<tr>
					<td><input type="submit" name="ingreso" id="ingreso" value="ENTRAR"></td>
				</tr>
			</table></center>

		</s:form>
	</div>
	
	<div id="contenido">
	<iframe src="frameContenido.jsp" name="contenido">
	</iframe>
	</div>
	
</div>

	<div id="footer">footer</div>

</body>

</html>