<!DOCTYPE html>
<html>

<head>
<!-- Meta tags -->
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=h1, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="css/login.css">

<title>Cadastro do ADM</title>

</head>

<body>

	<header id="header" class="scroll">
		<nav class="container">
			<a class="logo" href="index.jsp"> <img src="img/logo.png">
			</a>
			<!---MENU-->
			<!--<div class="menu">
				<ul class="grid">
					<li><a class="title" href="index.jsp"><strong>INICIO</strong></a>
					</li>
					<li><a class="title" href="sobre.jsp"><strong>SOBRE</strong></a>
					</li>
					<li><a class="title" href="cardapio.jsp"><strong>CARDAPIO</strong></a>
					</li>
					<li><a class="title" href="login.jsp"><strong>PERFIL</strong></a>
					</li>
				</ul>
			</div> -->
		</nav>
	</header>

	<div class="container">
		<section class="section-cadastro">
			<div class="titulo">
				<h1>Cadastro de administrador</h1>
			</div>
			<div class="formulario-cadastro">
			<form action="AdmCadastroServlet" method="POST">
				<input type="text" name="nome_func" id="nome_func" class="campos"
					placeholder="Nome do funcionario" required><br> <input type="password"
					name="cpf" id="cpf" class="campos" placeholder="CPF"
					required><br> ><br>
				<button type="submit">Cadastrar</button>
				</form>
			</div>
			<div class="cadastro">
				<p>Já possui cadastro?</p>
				<br> <a href="login.jsp"><b>Login</b></a>
			</div>
		</section>
	</div>


	<!--  <footer class="section3">
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
	</footer> -->

</body>

</html>