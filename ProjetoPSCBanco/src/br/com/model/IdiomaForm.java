package br.com.model;

import java.sql.Timestamp;

/**
 * 
 * @version Thiago de Lima Gonçalves RA: 100838359
 *
 */

public class IdiomaForm {

	private Integer Idioma_id;
	private String Idioma;
	private Timestamp ultima_atualizacao;

	public Integer getIdioma_id() {
		return Idioma_id;
	}

	public void setIdioma_id(Integer Idioma_id) {
		this.Idioma_id = Idioma_id;
	}

	public String getIdioma() {
		return Idioma;
	}

	public void setIdioma(String Idioma) {
		this.Idioma = Idioma;
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
		result = prime * result + ((Idioma_id == null) ? 0 : Idioma_id.hashCode());
		result = prime * result
				+ ((Idioma == null) ? 0 : Idioma.hashCode());
		result = prime
				* result
				+ ((ultima_atualizacao == null) ? 0 : ultima_atualizacao
						.hashCode());
		
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
		IdiomaForm other = (IdiomaForm) obj;
		if (Idioma_id == null) {
			if (other.Idioma_id != null)
				return false;
		} else if (!Idioma_id.equals(other.Idioma_id))
			return false;
		if (Idioma == null) {
			if (other.Idioma != null)
				return false;
		} else if (!Idioma.equals(other.Idioma))
			return false;
		if (ultima_atualizacao == null) {
			if (other.ultima_atualizacao != null)
				return false;
		} else if (!ultima_atualizacao.equals(other.ultima_atualizacao))
			return false;
		
		
		return true;
	}

	@Override
	public String toString() {
		return "IdiomaForm [Idioma_id=" + Idioma_id + ", Idioma="
				+ Idioma + ",  =" +  
				 ultima_atualizacao + "]";
	}
}
