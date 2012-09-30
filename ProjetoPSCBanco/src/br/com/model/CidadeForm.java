package br.com.model;

import java.sql.Timestamp;

/**
 * 
 * @version Thiago de Lima Gonçalves RA: 100838359
 *
 */

public class CidadeForm {

	private Integer cidade_id;
	private String cidade;
	private Integer pais_id;
	private Timestamp ultima_atualizacao;

	public Integer getCidade_id() {
		return cidade_id;
	}

	public void setCidade_id(Integer cidade_id) {
		this.cidade_id = cidade_id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getPais_id() {
		return pais_id;
	}

	public void setPais_id(Integer pais_id) {
		this.pais_id = pais_id;
	}

	public Timestamp getUltima_atualizacao() {
		return ultima_atualizacao;
	}

	public void setUltima_atualizacao(Timestamp ultima_atualizacao) {
		this.ultima_atualizacao = ultima_atualizacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade_id == null) ? 0 : cidade_id.hashCode());
		result = prime * result
				+ ((cidade == null) ? 0 : cidade.hashCode());
		result = prime
				* result
				+ ((ultima_atualizacao == null) ? 0 : ultima_atualizacao
						.hashCode());
		result = prime * result
				+ ((pais_id == null) ? 0 : pais_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CidadeForm other = (CidadeForm) obj;
		if (cidade_id == null) {
			if (other.cidade_id != null)
				return false;
		} else if (!cidade_id.equals(other.cidade_id))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (ultima_atualizacao == null) {
			if (other.ultima_atualizacao != null)
				return false;
		} else if (!ultima_atualizacao.equals(other.ultima_atualizacao))
			return false;
		if (pais_id == null) {
			if (other.pais_id != null)
				return false;
		} else if (!pais_id.equals(other.pais_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AtorForm [cidade_id=" + cidade_id + ", cidade="
				+ cidade + ", pais_id=" + pais_id
				+ ", ultima_atualizacao=" + ultima_atualizacao + "]";
	}
}
