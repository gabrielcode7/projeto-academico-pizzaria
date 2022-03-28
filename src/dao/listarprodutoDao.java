package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import conexao.ConexaoPGSQL;
import dto.produtoDto;

public class listarprodutoDao {
	public listarprodutoDao() {
// TODO Auto-generated constructor stub
	}

	public Collection list_produtos() throws Exception {
		Collection<produtoDto> collection = new ArrayList<produtoDto>();
		ResultSet resultSet;
		String consulta = "select * from produto as c";
		consulta = consulta + " order by c.nome_do_produto";
		try {
			ConexaoPGSQL conexao = new ConexaoPGSQL();
			Statement stmt = conexao.Conectar();
			produtoDto pdtDto;
			resultSet = stmt.executeQuery(consulta);
			while (resultSet.next()) {
				pdtDto = new produtoDto();

				pdtDto.setNome_do_produto(resultSet.getString("nome_do_produto"));
				pdtDto.setCodigo_de_barras(resultSet.getString("codigo_de_barras"));
				pdtDto.setEstoque_unitario(resultSet.getString("estoque_unitario"));
				pdtDto.setTamanho(resultSet.getString("tamanho"));

				pdtDto.setValor_de_venda(resultSet.getString("valor_de_venda"));
				collection.add(pdtDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return collection;
	}
}

