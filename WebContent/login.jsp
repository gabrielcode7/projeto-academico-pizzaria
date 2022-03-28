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

<title>Login</title>

</head>

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
				</ul>
			</div>
		</nav>
	</header>

	<div class="container">
		<section class="section-login">
			<div class="titulo">
				<h1>Login</h1>
			</div>
			<div class="formulario-login">
				<form name="tagFrmLogin" action="LogonServlet" method="post">
					<input type="text" name="nome" id="nome" id="email" id="telefone"
						class="campos" placeholder="Usuario"><br> <input
						type="password" name="senha" id="senha" class="campos"
						placeholder="Senha"><br> <input type="checkbox"
						name="lembrar" id="lembrar"> <label for="lembrar">Manter
						conectado</label>
					<button type="submit" id="botao">Entrar</button>
					<a href="" id="recuperar-senha"><b>Esqueci a senha</b></a>
				</form>
			</div>
			<div class="cadastro">
				<p>Não possui cadastro?</p>
				<br> <a href="cadastro.jsp"><b>Cadastre-se</b></a>
			</div>
		</section>
	</div>
</body>
</html>