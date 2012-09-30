package br.com.control;

import java.util.ArrayList;
import java.util.List;


import br.com.dao.CidadeDAO;
import br.com.model.CidadeForm;

/**
 * 
 * @version Thiago de Lima Gonçalves RA: 100838359
 *
 */


public class CidadeControl extends CidadeDAO {

	private static List<CidadeForm> cidadeList = new ArrayList<CidadeForm>();

	public static List<CidadeForm> getCidade() {
		return cidadeList;
	}

	public static CidadeForm obtemCidade(CidadeForm cidadeForm) {
		return CidadeDAO.getCidade(cidadeForm);
	}

	public static List<CidadeForm> getTodasCidades() {
		return CidadeDAO.getTodasCidades();
	}

	public static void addCidade(CidadeForm CidadeForm) {
		cidadeList.add(CidadeForm);
		new CidadeDAO().inserir(CidadeForm);
	}

	public static void atualizarCidade(CidadeForm CidadeForm) {
		new CidadeDAO().alterar(CidadeForm);
	}

	public static void removerCidade(CidadeForm CidadeForm) {
		new CidadeDAO().excluir(CidadeForm);
	}

}
