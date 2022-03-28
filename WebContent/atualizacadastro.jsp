<!DOCTYPE html>
<%@page import= "dto.usuarioDto"%>
<%@page import= "dao.usuarioDao"%>
<html>

<head>
<!-- Meta tags -->
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=h1, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="css/login.css">

<title>Cadastro</title>

</head>
<%
Integer codigo = 0;
String nome = "";
String login = "";
String senha = "";
String email = "";
String telefone = "";
if ((usuarioDto) session.getAttribute("usuario") != null){
	codigo = ((usuarioDto) session.getAttribute("usuario")).getCod_usuario();
	nome = ((usuarioDto) session.getAttribute("usuario")).getLogin_usuario();
	 senha = ((usuarioDto) session.getAttribute("usuario")).getSenha_usuario();
	 email = ((usuarioDto) session.getAttribute("usuario")).getEmail_usuario();
	 telefone = ((usuarioDto) session.getAttribute("usuario")).getTelefone_usuario();
	
}
%>
<body>

	<header id="header" class="scroll">
		<nav class="container">
			<a class="logo" href="index.jsp"> <img src="img/logo.png">
			</a>
			<!---MENU-->
			<div class="menu">
				<ul class="grid">
					<li><a class="title" href="index.jsp"><strong>INICIO</strong></a>
					</li>
					<li><a class="title" href="sobre.jsp"><strong>SOBRE</strong></a>
					</li>
					<li><a class="title" href="cardapio.jsp"><strong>CARDAPIO</strong></a>
					</li>
					<li><a class="title" href="login.jsp"><strong>PERFIL</strong></a>
					</li>
					<li><a class="title"></a><%=nome %></li>
				</ul>
			</div>
		</nav>
	</header>

	<div class="container">
		<section class="section-cadastro">
			<div class="titulo">
				<h1>Atualizar Dados</h1>
			</div>
			<div class="formulario-cadastro">
			<form action="AtualizaUsuarioServlet" method="POST">
				<table>
					<tr>
						<td> <input type="number" name="codigo" class="campos" value="<%out.print(codigo); %>"></td>
					</tr>
					
					<tr>
						<td> <input type="text" name="nome" class="campos" value="<%out.print(nome); %>" ></td>
					</tr>
					
					<tr>
						<td> <input type="password" name="senha" class="campos" value="<%out.print(senha); %>" ></td>
					</tr>
				
					<tr>
						<td> <input type="email" name="email" class="campos" value="<%out.print(email); %>"></td>
					</tr>
				
					<tr>
						<td> <input type="phone" name="telefone" class="campos" value="<%out.print(telefone); %>"></td>
					</tr>

				</table>
						<button type="submit">Atualizar</button>
				</form>
			</div>
			<div class="cadastro">
				<p>Já possui cadastro?</p>
				<br> <a href="login.jsp"><b>Login</b></a>
			</div>
		</section>
	</div>


	<footer class="section3">
		<div class="container grid">
			<div class="brand">
				<a class="logo" href="index.jsp"><img src="img/logog.png" />
					<p>© 2021 Pizzaria La Pizza</p>
			</div>

			<div class="social">
				<a href="https://pt-br.facebook.com/" target="_blanck"><img
					src="img/facebook.png" /></a> <a href="https://www.instagram.com/"
					target="_blanck"><img src="img/instagram.png" /></a>
			</div>
		</div>
	</footer>

</body>

</html>