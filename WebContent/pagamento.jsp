<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="dto.usuarioDto"%>
<%@page import="dao.usuarioDao"%>

<html>
<head>
<title>Compra</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<link rel="shortcut icon" type="icon" href="icon.jpg">
<link rel="stylesheet" type="text/css" href="css/pagamento.css">
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
	<section4>
	<div class="modal fade" id="ExemploModalCentralizado" tabindex="-1"
		role="dialog" aria-labelledby="TituloModalCentralizado"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="TituloModalCentralizado">Esolha a
						forma de pagamento</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Fechar">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">

					<div class="custom-control custom-radio">
						<input type="radio" id="customRadio1" name="customRadio"
							class="custom-control-input"> <label
							class="custom-control-label" for="customRadio1">Cartão de
							Crédito</label><br> <img class="img" src="img/credito.png">
					</div>

					<div class="custom-control custom-radio">
						<input type="radio" id="customRadio2" name="customRadio"
							class="custom-control-input"> <label
							class="custom-control-label" for="customRadio2">Cartão de
							Débito</label><br> <img class="img" src="img/debito.png">
					</div>

					<div class="custom-control custom-radio">
						<input type="radio" id="customRadio3" name="customRadio"
							class="custom-control-input"> <label
							class="custom-control-label" for="customRadio3">Boleto</label><br>
						<img class="img" src="img/boleto.jpg">
					</div>
					<br>

					<p class="neg">
						Valor total da compra: <a id="cart--totalitem subtotal">
					</p>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Fechar</button>
					<button type="button" class="btn btn-primary btn-block">Clique
						aqui para confirmar o pagamento</button>
				</div>
			</div>
		</div>
	</div>

	<tr>
		<td colspan="3"></td>
		<th></th>Tem certeza que deseja finalizar?
		<th><p id="cart--totalitem total big"></p></th>
	</tr>

	<tr>
		<th colspan="4"></th>
		<th><button type="button" class="btn btn-primary"
				data-toggle="modal" data-target="#ExemploModalCentralizado"
				onclick="calcularTotal()">Efetuar Pagamento</button> <a
			class="title" href="cardapio.jsp"><strong>Voltar</strong></a>
	</tr>
	</tbody>
	</table>
	</div>


	</section4>
	<script type="text/javascript" src="js/script.js"></script>
	<script type="text/javascript" src="js/pizzaria.js"></script>
	<script type="text/javascript" src="js/pagamento.js"></script>


	


</body>

</html>