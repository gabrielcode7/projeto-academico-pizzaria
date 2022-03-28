package dao;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.ConexaoPGSQL;
import dto.usuarioDto;

public class usuarioDao {
	public usuarioDao() {
// TODO Auto-generated constructor stub
	}

	public void save(Object o) throws java.lang.ClassNotFoundException {

		usuarioDto usrDto = (usuarioDto) o;
		String consulta = "INSERT INTO usuario (login_usuario, senha_usuario, email_usuario, telefone_usuario) " + " VALUES ('" + usrDto.getLogin_usuario() + "','"
				+ usrDto.getSenha_usuario() + "','" + usrDto.getEmail_usuario() + "','" + usrDto.getTelefone_usuario() + "');";
		System.out.println(consulta);
		try {
			ConexaoPGSQL conexao = new ConexaoPGSQL();
			Statement stmt = conexao.Conectar();
			usuarioDto usrDto02 = new usuarioDto();
			usrDto02 =

					getUsuario(usrDto.getLogin_usuario().trim(), usrDto.getSenha_usuario().trim(), usrDto.getEmail_usuario().trim(), 
								usrDto.getTelefone_usuario().trim());

			if (usrDto02 == null) {
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

	public usuarioDto getUsuario(String login, String senha, String email, String telefone) {
		usuarioDto usrDto = new usuarioDto();
		String consulta = "SELECT cod_usuario,login_usuario,senha_usuario,email_usuario,telefone_usuario FROM " + "usuario "

				+

				"WHERE login_usuario='" + login + "' " + "AND senha_usuario='" + senha + "'";

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
				usrDto.setCod_usuario(resultSet.getInt("cod_usuario"));
				usrDto.setLogin_usuario(resultSet.getString("login_usuario"));
				usrDto.setEmail_usuario(resultSet.getString("email_usuario"));
				usrDto.setTelefone_usuario(resultSet.getString("telefone_usuario"));

				usrDto.setSenha_usuario(resultSet.getString("senha_usuario"));
			} else
				usrDto = null;

			conexao.Desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usrDto;
	}
	
	public void editar(Object o) throws java.lang.ClassNotFoundException {

		usuarioDto usrDto = (usuarioDto) o;
		String consulta = "UPDATE usuario SET login_usuario = '" + usrDto.getLogin_usuario() + "'," + "senha_usuario = '" + usrDto.getSenha_usuario() + "',"
				+ "email_usuario = '" + usrDto.getEmail_usuario() + "'," + "telefone_usuario = '" + usrDto.getTelefone_usuario() + "' WHERE login_usuario = '" + usrDto.getLogin_usuario() + "';";
		System.out.println(consulta);
		try {
			ConexaoPGSQL conexao = new ConexaoPGSQL();
			Statement stmt = conexao.Conectar();
			usuarioDto usrDto02 = new usuarioDto();
			usrDto02 =

					getUsuario(usrDto.getLogin_usuario().trim(), usrDto.getSenha_usuario().trim(), usrDto.getEmail_usuario().trim(), 
							usrDto.getTelefone_usuario().trim(), usrDto.getCod_usuario());

			if (usrDto02 == null) {
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

	private usuarioDto getUsuario(String trim, String trim2, String trim3, String trim4, Integer cod_usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}