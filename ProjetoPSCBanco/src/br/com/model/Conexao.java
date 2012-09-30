package br.com.model;

import java.sql.*;
import javax.swing.JOptionPane;


/**
 * 
 * @version Thiago de Lima Gonçalves RA: 100838359
 *
 */

public class Conexao {
	public Connection con; // Recebe string que conecta com o banco
	public Statement stmt; // Recebe string que permitirá a execução SQL
	public ResultSet res;
	private final String PATH = "jdbc:mysql://localhost:3306/sakila-portugues";
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String LOGIN = "root";
	private final String SENHA = "";

	public Connection conecta() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(PATH, LOGIN, SENHA);
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			//JOptionPane.showMessageDialog(null, "Conectou");
		} catch (ClassNotFoundException Driver) {
			JOptionPane.showMessageDialog(null, "Driver não localizado: "
					+ Driver);
		} catch (SQLException Fonte) {
			JOptionPane.showMessageDialog(null,
					"Deu erro na conexao com a fonte de dados" + Fonte);
		}
		return con;
	}

	public void desconecta() {
		try {
			con.close();
			//JOptionPane.showMessageDialog(null, "Banco Fechado");
		} catch (SQLException fecha) {
			JOptionPane.showMessageDialog(null,
					"Deu erro na conexao com a fonte de dados" + fecha);
		}
	}

	public void executeSQL(String sql) {
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			res = stmt.executeQuery(sql);
		} catch (SQLException sqlex) {
			JOptionPane.showMessageDialog(null, sqlex.getMessage());
		}
	}
}
