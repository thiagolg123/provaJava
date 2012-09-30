package br.com.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Util {

	/**
	 * Converte uma String para um objeto Date. Caso a String seja vazia ou
	 * nula, retorna null - para facilitar em casos onde formulários podem ter
	 * campos de datas vazios.
	 * 
	 * @param data
	 *            String no formato dd/MM/yyyy a ser formatada
	 * @return Date Objeto Date ou null caso receba uma String vazia ou nula
	 * @throws Exception
	 *             Caso a String esteja no formato errado
	 */
	public static Timestamp formatarData(String data) throws ParseException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		java.util.Date parsedDate = formatter.parse(data);
		java.sql.Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
		
		return timestamp;
		
	}
	
}
