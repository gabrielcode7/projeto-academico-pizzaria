package dao;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.ConexaoPGSQL;
import dto.adminDto;

public class adminDao {
	public adminDao() {
// TODO Auto-generated constructor stub
	}

	public void save(Object o) throws java.lang.ClassNotFoundException {

		adminDto admDto = (adminDto) o;
		String consulta = "INSERT INTO administrador (nome_func, cpf) " + " VALUES ('" + admDto.getNome_func() + "','" + admDto.getCpf() +  "');";
		System.out.println(consulta);
		try {
			ConexaoPGSQL conexao = new ConexaoPGSQL();
			Statement stmt = conexao.Conectar();
			adminDto admDto02 = new adminDto();
			admDto02 =

					getAdministrador(admDto.getMatricula(), admDto.getNome_func().trim(), admDto.getCpf().trim());

			if (admDto02 == null) {
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

	public adminDto getAdministrador(Integer matricula, String nome_func, String cpf) {
		adminDto admDto = new adminDto();
		String consulta = "SELECT matricula,nome_func,cpf FROM " + "administrador "

				+

				"WHERE nome_func='" + nome_func + "' " + "AND cpf='" + cpf + "'";

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
				admDto.setMatricula(resultSet.getInt("matricula"));
				admDto.setNome_func(resultSet.getString("nome_func"));
				admDto.setCpf(resultSet.getString("cpf"));

			} else
				admDto = null;

			conexao.Desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admDto;
	}

}
