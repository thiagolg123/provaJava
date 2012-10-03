package br.com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.model.IdiomaForm;
import br.com.model.Conexao;

/**
 * 
 * @version Thiago de Lima Gonçalves RA: 100838359
 *
 */


public class IdiomaDAO {

	private static Conexao conexao = new Conexao();

	public static Integer getIdIdioma() {
		Integer result = 0;
		conexao.conecta();

		try {

			conexao.executeSQL("SELECT * FROM Idioma");

			while (conexao.res.next()) {
				result++;
			}

			result = result + 1;
			conexao.desconecta();

		} catch (SQLException exc) {
			JOptionPane.showMessageDialog(null, "Erro: " + exc);
		}
		return result;
	}

	public static Integer ultimoIdioma() {
		Statement statement= null;
		ResultSet resultSet = null;

		try {

			statement = conexao.conecta().createStatement();
			String query = "SELECT * FROM Idioma";
			resultSet = statement.executeQuery(query);

			if (resultSet.last()) {
				return resultSet.getInt("Idioma_ID") + 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

	public static IdiomaForm getIdioma(IdiomaForm idiomaForm) {

		conexao.conecta();

		try {

			conexao.executeSQL("SELECT * FROM Idioma WHERE Idioma_ID = "
					+ idiomaForm.getIdioma_id());

			while (conexao.res.next()) {

				idiomaForm.setIdioma_id(conexao.res.getInt("Idioma_ID"));
				idiomaForm.setIdioma(conexao.res
						.getString("Idioma"));
				idiomaForm.setUltima_atualizacao(conexao.res
						.getTimestamp("ULTIMA_ATUALIZACAO"));

			}
			conexao.desconecta();
		} catch (SQLException exc) {
			JOptionPane.showMessageDialog(null, "Erro: " + exc);
		}
		conexao.desconecta();
		return idiomaForm;
	}

	public static List<IdiomaForm> getTodosIdiomas() {

		List<IdiomaForm> idiomalist = new ArrayList<IdiomaForm>();
		conexao.conecta();

		try {

			conexao.executeSQL("SELECT * FROM Idioma");

			while (conexao.res.next()) {

				IdiomaForm idiomaForm = new IdiomaForm();
				idiomaForm.setIdioma_id(conexao.res.getInt("Idioma_ID"));
				idiomaForm.setIdioma(conexao.res
						.getString("Idioma"));
				idiomaForm.setUltima_atualizacao(conexao.res
						.getTimestamp("ULTIMA_ATUALIZACAO"));

				idiomalist.add(idiomaForm);
			}
			conexao.desconecta();
		} catch (SQLException exc) {
			JOptionPane.showMessageDialog(null, "Erro: " + exc);
		}
		return idiomalist;
	}

	public void inserir(IdiomaForm idiomaForm) {
		try {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder
					.append("INSERT INTO Idioma(Idioma_ID, Idioma, ULTIMA_ATUALIZACAO)");
			stringBuilder.append("VALUES('")
					.append(idiomaForm.getIdioma()).append("',");
			stringBuilder.append("'").append(idiomaForm.getUltima_atualizacao())
					.append("')");
			System.out.println(stringBuilder);

			String sqlInsert = "INSERT INTO Idioma(Idioma_ID, Idioma, ULTIMA_ATUALIZACAO)"
					+ " VALUES('"
					+ idiomaForm.getIdioma_id()
					+ "','"
					+ idiomaForm.getIdioma_id()
					+ "','"
					+ idiomaForm.getUltima_atualizacao() + "')";

			conexao.stmt.executeUpdate(sqlInsert);

			JOptionPane.showMessageDialog(null,
					"Gravação na tabela Idioma realizado com sucesso!");
			conexao.desconecta();
		} catch (Exception erro) {

			JOptionPane.showMessageDialog(null,
					"Erro a tentar Gravar o registro... " + erro);

		}
	}

	public void excluir(IdiomaForm idiomaForm) {
		// procedimento para exclusão de registro
		try {

			String sqlExcluir = "DELETE FROM Idioma WHERE Idioma_ID = "
					+ idiomaForm.getIdioma_id();
			conexao.conecta();
			conexao.stmt.executeUpdate(sqlExcluir);

			// limparCampos();
			JOptionPane.showMessageDialog(null,
					"Exclusão realizada com sucesso");
			conexao.desconecta();
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null,
					"Erro a tentar deletar o registro... " + erro);
		}
	}

	public void alterar(IdiomaForm idiomaForm) {
		// código para Alterar os dados no Banco de Dados
		try {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("UPDATE Idioma ");
			stringBuilder.append("SET Idioma = '")
					.append(idiomaForm.getIdioma()).append("'");
			
			stringBuilder.append(", ULTIMA_ATUALIZACAO = '")
					.append(idiomaForm.getUltima_atualizacao()).append("'");
			stringBuilder.append(" WHERE Idioma_ID = ").append(
					idiomaForm.getIdioma_id());
			System.out.println(stringBuilder);

			String sqlAlterar = "UPDATE Idioma " + "SET Idioma = '"
					+ idiomaForm.getIdioma_id() + "'"
					+ ", ULTIMA_ATUALIZACAO = '"
					+ idiomaForm.getUltima_atualizacao() + "'"
					+ " WHERE Idioma_ID = " + idiomaForm.getIdioma_id();
			conexao.conecta();
			conexao.stmt.executeUpdate(sqlAlterar);
			JOptionPane.showMessageDialog(null,
					"Alteração realizado com sucesso!");
			conexao.desconecta();
		} catch (Exception erro) {

			JOptionPane.showMessageDialog(null,
					"Erro a tentar Alterar o registro... " + erro);

		}
	}

	public void consultar(IdiomaForm idiomaForm) {
		try {
			conexao.executeSQL("SELECT * FROM Idioma WHERE Idioma_ID = "
					+ idiomaForm.getIdioma_id());

			while (conexao.res.next()) {
				idiomaForm.setIdioma_id(conexao.res.getInt(0));
				idiomaForm.setIdioma(conexao.res
						.getString("Idioma"));
				
				idiomaForm.setUltima_atualizacao(conexao.res
						.getTimestamp("ULTIMA_ATUALIZACAO"));
			}
			conexao.desconecta();
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Nao localizou dados " + erro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
