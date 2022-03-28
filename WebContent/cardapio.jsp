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

<link rel="stylesheet" href="css/cardapio.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://fonts.googleapis.com/css?family=Hepta+Slab:400,700|Lato:400,700&display=swap"
	rel="stylesheet">

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
			<a class="logo" href="index.html"> <img src="img/logo.png">
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
					<li><a class="title"></a><%=nome%></li>
				</ul>
			</div>
		</nav>
	</header>

	<section class="seccion" id="seccion">

		<div class="models">
			<div class="pizza-item">
				<a href="">
					<div class="pizza-item--img">
						<img src="" />
					</div>
					<div class="pizza-item--add">+</div>
				</a>
				<div class="pizza-item--price">R$ --</div>
				<div class="pizza-item--name">--</div>
				<div class="pizza-item--desc">--</div>
			</div>
			<div class="cart--item">
				<img src="" />
				<div class="cart--item-nome">--</div>
				<div class="cart--item--qtarea">
					<button class="cart--item-qtmenos">-</button>
					<div class="cart--item--qt">1</div>
					<button class="cart--item-qtmais">+</button>
				</div>
			</div>
		</div>

		<form>
			<div class="menu-openner">
				<span>0</span>🛒
			</div>
		</form>

		<main>
		<h1>Pizzas</h1>
		<div class="pizza-area"></div>
		</main>
		<aside>
			<div class="cart--area">
				<div class="menu-closer">❌</div>
				<h1>Suas Pizzas</h1>
				<div class="cart"></div>
				<div class="cart--details">
					<div class="cart--totalitem subtotal">
						<span>Subtotal</span> <span>R$ --</span>
					</div>
					<div class="cart--totalitem desconto">
						<span>Desconto (-10%)</span> <span>R$ --</span>
					</div>
					<div class="cart--totalitem total big">
						<span>Total</span> <span>R$ --</span>
					</div>
					<a class="cart--finalizar" type="button" href="pagamento.jsp"
						data-toggle="modal" data-target="#ExemploModalCentralizado"
						onclick="calcularTotal()"> <strong>Finalizar Compra</strong></a>
				</div>
			</div>
		</aside>
		<div class="pizzaWindowArea">
			<div class="pizzaWindowBody">
				<div class="pizzaInfo--cancelMobileButton">Voltar</div>
				<div class="pizzaBig">
					<img src="" />
				</div>
				<div class="pizzaInfo">
					<h1>--</h1>
					<div class="pizzaInfo--desc">--</div>
					<div class="pizzaInfo--sizearea">
						<div class="pizzaInfo--sector">Tamanho</div>
						<div class="pizzaInfo--sizes">
							<div data-key="0" class="pizzaInfo--size">
								PEQUENA <span>--</span>
							</div>
							<div data-key="1" class="pizzaInfo--size">
								MÉDIO <span>--</span>
							</div>
							<div data-key="2" class="pizzaInfo--size selected">
								GRANDE <span>--</span>
							</div>
						</div>
					</div>
					<div class="pizzaInfo--pricearea">
						<div class="pizzaInfo--sector">Preço</div>
						<div class="pizzaInfo--price">
							<div class="pizzaInfo--actualPrice">R$ --</div>
							<div class="pizzaInfo--qtarea">
								<button class="pizzaInfo--qtmenos">-</button>
								<div class="pizzaInfo--qt">1</div>
								<button class="pizzaInfo--qtmais">+</button>
							</div>
						</div>
					</div>
					<div class="pizzaInfo--addButton">Adicionar ao carrinho</div>
					<div class="pizzaInfo--cancelButton">Cancelar</div>
				</div>
			</div>
		</div>

	</section>



</body>
<script type="text/javascript" src="js/pizzas.js"></script>
<script type="text/javascript" src="js/script.js"></script>
</html>