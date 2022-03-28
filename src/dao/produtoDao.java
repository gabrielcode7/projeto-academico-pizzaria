package dao;


import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.ConexaoPGSQL;
import dto.produtoDto;

public class produtoDao {
	public produtoDao() {
// TODO Auto-generated constructor stub
	}

	public void save(Object o) throws java.lang.ClassNotFoundException {

		produtoDto pdtDto = (produtoDto) o;
		String consulta = "INSERT INTO produto (nome_do_produto,codigo_de_barras,estoque_unitario,tamanho,valor_de_venda)" + " VALUES ('" + pdtDto.getNome_do_produto().trim() + "','"
				+ pdtDto.getCodigo_de_barras().trim() + "','" + pdtDto.getEstoque_unitario().trim() + "','" + pdtDto.getTamanho().trim() + "','" + pdtDto.getValor_de_venda().trim() + "');";
		System.out.println(consulta);
		try {
			ConexaoPGSQL conexao = new ConexaoPGSQL();
			Statement stmt = conexao.Conectar();
			produtoDto pdtDto02 = new produtoDto();
			pdtDto02 =

					getProduto(pdtDto.getNome_do_produto().trim(), pdtDto.getCodigo_de_barras().trim(), pdtDto.getEstoque_unitario().trim(), 
								pdtDto.getTamanho().trim(), pdtDto.getValor_de_venda().trim());

			if (pdtDto02 == null) {
				try {
					stmt.executeUpdate(consulta);

				} catch (SQLException e) {
					System.err.print("SQL exception: ");
					System.err.println(e.getMessage());
				}
			}
			conexao.Desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public produtoDto getProduto(String nome_do_produto, String codigo_de_barras, String estoque_unitario, String tamanho, String valor_de_venda) {
		produtoDto pdtDto = new produtoDto();
		String consulta = "SELECT nome_do_produto,codigo_de_barras,estoque_unitario,tamanho,valor_de_venda FROM " + "produto "

				+

				"WHERE nome_do_produto='" + nome_do_produto + "' " + "AND codigo_de_barras='" + codigo_de_barras + "'";

		System.out.println(consulta);
		try {
			ConexaoPGSQL conexao = new ConexaoPGSQL();
			Statement stmt = conexao.Conectar();
			System.out.println("TESTE");
			ResultSet resultSet = null;
			resultSet = stmt.executeQuery(consulta);
			System.out.println("TESTE01");
			if (resultSet.next()) {
				System.out.println("TESTE02");
				pdtDto.setNome_do_produto(resultSet.getString("nome_do_produto"));
				pdtDto.setCodigo_de_barras(resultSet.getString("codigo_de_barras"));
				pdtDto.setEstoque_unitario(resultSet.getString("estoque_unitario"));
				pdtDto.setTamanho(resultSet.getString("tamanho"));

				pdtDto.setValor_de_venda(resultSet.getString("valor_de_venda"));
			} else
				pdtDto = null;

			conexao.Desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pdtDto;
	}

}