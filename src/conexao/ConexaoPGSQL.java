package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;




public class ConexaoPGSQL {
	/** Usada para a conexao com o banco de dados */
	private Connection con = null;
	/** Usada para realizar as instrucoes SQL */
	public Statement stmt;
	/** Retorna os dados das tabelas do banco */
	public ResultSet rs;
	private static String URL = "";
	private static String USER_NAME = "";
	private static String PASSWORD = "";
	private static String DRIVER_NAME = "";

	public ConexaoPGSQL() {

// TODO Auto-generated constructor stub

	}

	public String databaseFile = this.getClass().getClassLoader().getResource(

			"conf" + File.separator + "database.properties").getPath();

	public Statement Conectar() throws FileNotFoundException, IOException {
		try {
			/** Pasando o nome do Driver do PostgreSQL */
			Class.forName("org.postgresql.Driver");
			Properties properties = new Properties();
			System.out.println(databaseFile);
			properties.load(new FileInputStream(databaseFile));
			DRIVER_NAME = properties.getProperty("jdbc.driverName");
			URL = properties.getProperty("jdbc.url");
			USER_NAME = properties.getProperty("jdbc.username");
			PASSWORD = properties.getProperty("jdbc.password");
			Class.forName(DRIVER_NAME);
			/** Obtendo a conexao com o banco de dados */
			con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			/** Criando o Statement */
			stmt = con.createStatement();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			/** Retorna um erro caso exista erro de query SQL */
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();

		}
		return stmt;
	}

	/** Esse metodo quando invocado, realiza a desconexao com o banco */
	public void Desconectar() {
		try {
			con.close();
			/** Retorna um erro caso nao consiga desconectar */
		} catch (SQLException onConClose) {
			onConClose.printStackTrace();
		}
	}
}
