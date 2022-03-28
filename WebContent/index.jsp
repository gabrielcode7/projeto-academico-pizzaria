<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@page import="dto.usuarioDto"%>
<%@page import="dao.usuarioDao"%>

<html>

<head>
<!-- Meta tags -->
<meta charset="utf-8">
<meta http-equiv=”Content-Type” content=”text/html; charset=utf-8″>
<meta name="viewport" content="width=h1, initial-scale=1.0">

<title>LaPizza</title>
<link rel="stylesheet" href="css/main.css">
</head>



<%
	Integer codigo = 0;
	String nome = "";
	if ((usuarioDto) session.getAttribute("usuario") != null) {
		nome = ((usuarioDto) session.getAttribute("usuario")).getLogin_usuario();
		codigo = ((usuarioDto) session.getAttribute("usuario")).getCod_usuario();
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
					<li><a class="title" href="cardapio.jsp"><strong>CARDAPIO</strong></a>
					</li>
					<li><a class="title" href="login.jsp"><strong>PERFIL</strong></a>
					</li>
					<li><a class="title" href="atualizacadastro.jsp"><strong>ATUALIZAR</strong></a>
					</li>
					<li><a class="title"></a><%=nome%></li>

				</ul>
			</div>
		</nav>
	</header>

	<main>
	<form>
		<div class="image-container">
			<img class="home-image" src="img/pizzamain.png"
				alt="Foto de uma pizza">
		</div>
	</form>
	</main>

	<section class="seccion" id="testimonials">
		<div>
			<h2 class="title">Depoimentos de clientes</h2>
		</div>
		<div class="container2">
			<div class="divSec1">
				<div>
					<blockquote>
						<p>
							<span>"</span> Só tem produtos de primeira! Além do bom
							atendimento, a entrega é rápida e garantida... Recomendo á todos
							Comprem
						</p>
						<cite> <img src="img/gabriel.png" alt="Foto de Gabriel" />
							Gabriel Belon
						</cite>
					</blockquote>
				</div>
				<div>
					<blockquote>
						<p>
							<span>"</span> Pizzas de excelente qualidade, muito saborosa e
							bastante recheada, chegaram rapidamente!! Recomendo !!


						</p>
						<cite> <img src="img/tainah.png" alt="Foto de Tainah" />
							Tainah Agnes
						</cite>
					</blockquote>
				</div>
				<div>
					<blockquote>
						<p>
							<span>"</span> Produtos muito frescos, boa variedade, atendimento
							excelente, tempo de entrega muito bom e o mais importante a pizza
							chega quentinha.

						</p>
						<cite> <img src="img/ulisses.png" alt="Foto de Ulisses" />
							Ulisses Pedro
						</cite>
					</blockquote>
				</div>
			</div>
		</div>
	</section>

	<!--CONTACT-->
	<section class="section" id="contact">
		<div class="container grid">
			<div class="text">
				<h2 class="title">Entre em Contato com a gente!</h2>
				<a
					href="https://api.whatsapp.com/send?phone=55999999999999&text=Ol%C3%A1"
					class="button" target="_blank"><img src="img/iconwhats.png" />Entrar
					em Contato</a>
			</div>

			<div class="links">
				<ul class="grid">
					<li>(71)9 9999-9999</li>
					<li>Rua Pizzas 623 - Bahia</li>
					<li>@La.Pizza</li>
				</ul>
			</div>
		</div>
	</section>

	<footer class="section3">
		<div class="container grid">
			<div class="brand">
				<a class="logo" href="index.jsp"><img src="img/logog.png" /></a>
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