package br.com.control;

import java.util.ArrayList;
import java.util.List;


import br.com.dao.IdiomaDAO;
import br.com.model.IdiomaForm;

/**
 * 
 * @version Thiago de Lima Gonçalves RA: 100838359
 *
 */


public class IdiomaControl extends IdiomaDAO {

	private static List<IdiomaForm> idiomaList = new ArrayList<IdiomaForm>();

	public static List<IdiomaForm> getIdioma() {
		return idiomaList;
	}

	public static IdiomaForm obtemCidade(IdiomaForm idiomaForm) {
		return IdiomaDAO.getIdioma(idiomaForm);
	}

	public static List<IdiomaForm> getTodosIdiomas() {
		return IdiomaDAO.getTodosIdiomas();
	}

	public static void addCidade(IdiomaForm idiomaForm) {
		idiomaList.add(idiomaForm);
		new IdiomaDAO().inserir(idiomaForm);
	}

	public static void atualizaIdioma(IdiomaForm idiomaForm) {
		new IdiomaDAO().alterar(idiomaForm);
	}

	public static void removerIdioma(IdiomaForm idiomaForm) {
		new IdiomaDAO().excluir(idiomaForm);
	}

}
