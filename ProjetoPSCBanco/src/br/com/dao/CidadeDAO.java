package br.com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.model.CidadeForm;
import br.com.model.Conexao;

/**
 * 
 * @version Thiago de Lima Gonçalves RA: 100838359
 *
 */


public class CidadeDAO {

	private static Conexao conexao = new Conexao();

	public static Integer getIdAtor() {
		Integer result = 0;
		conexao.conecta();

		try {

			conexao.executeSQL("SELECT * FROM CIDADE");

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

	public static Integer ultimoAtor() {
		Statement statement= null;
		ResultSet resultSet = null;

		try {

			statement = conexao.conecta().createStatement();
			String query = "SELECT * FROM CIDADE";
			resultSet = statement.executeQuery(query);

			if (resultSet.last()) {
				return resultSet.getInt("CIDADE_ID") + 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

	public static CidadeForm getCidade(CidadeForm cidadeForm) {

		conexao.conecta();

		try {

			conexao.executeSQL("SELECT * FROM CIDADE WHERE CIDADE_ID = "
					+ cidadeForm.getCidade_id());

			while (conexao.res.next()) {

				cidadeForm.setCidade_id(conexao.res.getInt("CIDADE_ID"));
				cidadeForm.setCidade(conexao.res
						.getString("CIDADE"));
				cidadeForm.setPais_id(conexao.res.getInt("PAIS_ID"));
				cidadeForm.setUltima_atualizacao(conexao.res
						.getTimestamp("ULTIMA_ATUALIZACAO"));

			}
			conexao.desconecta();
		} catch (SQLException exc) {
			JOptionPane.showMessageDialog(null, "Erro: " + exc);
		}
		conexao.desconecta();
		return cidadeForm;
	}

	public static List<CidadeForm> getTodasCidades() {

		List<CidadeForm> cidadelist = new ArrayList<CidadeForm>();
		conexao.conecta();

		try {

			conexao.executeSQL("SELECT * FROM CIDADE");

			while (conexao.res.next()) {

				CidadeForm CidadeForm = new CidadeForm();
				CidadeForm.setCidade_id(conexao.res.getInt("CIDADE_ID"));
				CidadeForm.setCidade(conexao.res
						.getString("CIDADE"));
				CidadeForm.setPais_id(conexao.res.getInt("PAIS_ID"));
				CidadeForm.setUltima_atualizacao(conexao.res
						.getTimestamp("ULTIMA_ATUALIZACAO"));

				cidadelist.add(CidadeForm);
			}
			conexao.desconecta();
		} catch (SQLException exc) {
			JOptionPane.showMessageDialog(null, "Erro: " + exc);
		}
		return cidadelist;
	}

	public void inserir(CidadeForm cidadeForm) {
		try {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder
					.append("INSERT INTO CIDADE(CIDADE_ID, CIDADE, ULTIMA_ATUALIZACAO)");
			stringBuilder.append("VALUES('")
					.append(cidadeForm.getCidade()).append("',");
			stringBuilder.append("'").append(cidadeForm.getPais_id())
					.append("',");
			stringBuilder.append("'").append(cidadeForm.getUltima_atualizacao())
					.append("')");
			System.out.println(stringBuilder);

			String sqlInsert = "INSERT INTO ATOR(PRIMEIRO_NOME, ULTIMO_NOME, ULTIMA_ATUALIZACAO)"
					+ " VALUES('"
					+ cidadeForm.getCidade()
					+ "','"
					+ cidadeForm.getPais_id()
					+ "','"
					+ cidadeForm.getUltima_atualizacao() + "')";

			conexao.stmt.executeUpdate(sqlInsert);

			JOptionPane.showMessageDialog(null,
					"Gravação na tabela ATOR realizado com sucesso!");
			conexao.desconecta();
		} catch (Exception erro) {

			JOptionPane.showMessageDialog(null,
					"Erro a tentar Gravar o registro... " + erro);

		}
	}

	public void excluir(CidadeForm cidadeForm) {
		// procedimento para exclusão de registro
		try {

			String sqlExcluir = "DELETE FROM CIDADE WHERE CIDADE_ID = "
					+ cidadeForm.getCidade_id();
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

	public void alterar(CidadeForm cidadeForm) {
		// código para Alterar os dados no Banco de Dados
		try {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("UPDATE CIDADE ");
			stringBuilder.append("SET CIDADE = '")
					.append(cidadeForm.getCidade()).append("'");
			stringBuilder.append(", PAIS_ID = '")
					.append(cidadeForm.getPais_id()).append("'");
			stringBuilder.append(", ULTIMA_ATUALIZACAO = '")
					.append(cidadeForm.getUltima_atualizacao()).append("'");
			stringBuilder.append(" WHERE ATOR_ID = ").append(
					cidadeForm.getCidade_id());
			System.out.println(stringBuilder);

			String sqlAlterar = "UPDATE CIDADE " + "SET CIDADE = '"
					+ cidadeForm.getCidade() + "'" + ", PAIS_ID = '"
					+ cidadeForm.getPais_id() + "'"
					+ ", ULTIMA_ATUALIZACAO = '"
					+ cidadeForm.getUltima_atualizacao() + "'"
					+ " WHERE CIDADE_ID = " + cidadeForm.getCidade_id();
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

	public void consultar(CidadeForm cidadeForm) {
		try {
			conexao.executeSQL("SELECT * FROM CIDADE WHERE ATOR_ID = "
					+ cidadeForm.getCidade_id());

			while (conexao.res.next()) {
				cidadeForm.setCidade_id(conexao.res.getInt(0));
				cidadeForm.setCidade(conexao.res
						.getString("CIDADE"));
				cidadeForm.setPais_id(conexao.res.getInt("PAIS_ID"));
				cidadeForm.setUltima_atualizacao(conexao.res
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
