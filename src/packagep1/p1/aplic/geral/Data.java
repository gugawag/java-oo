/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ci�ncia da Computa��o
 * Departamento de Sistemas e Computa��o
 * Universidade Federal da Para�ba
 *
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 * N�o redistribuir sem permiss�o.
 */
package p1.aplic.geral;

import java.util.*;
import java.io.*;


/**
 * Classe usada para formatar e manusear datas mais convenientemente.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.2
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */
public class Data implements Serializable, Cloneable, Comparable {
    static final long serialVersionUID = -8761915724530354838L;
    /**
     * DiaDaSemana (retornado por getDiaDaSemana()) que representa Domingo
     */
    public static final int DOMINGO = Calendar.SUNDAY;
    /**
     * DiaDaSemana (retornado por getDiaDaSemana()) que representa Segunda-Feira
     */
    public static final int SEGUNDA = Calendar.MONDAY;
    /**
     * DiaDaSemana (retornado por getDiaDaSemana()) que representa Ter�a-Feira
     */
    public static final int TER�A   = Calendar.TUESDAY;
    /**
     * DiaDaSemana (retornado por getDiaDaSemana()) que representa Quarta-Feira
     */
    public static final int QUARTA  = Calendar.WEDNESDAY;
    /**
     * DiaDaSemana (retornado por getDiaDaSemana()) que representa Quinta-Feira
     */
    public static final int QUINTA  = Calendar.THURSDAY;
    /**
     * DiaDaSemana (retornado por getDiaDaSemana()) que representa Sexta-Feira
     */
    public static final int SEXTA   = Calendar.FRIDAY;
    /**
     * DiaDaSemana (retornado por getDiaDaSemana()) que representa S�bado
     */
    public static final int S�BADO  = Calendar.SATURDAY;

	private Calendar aData;

	/**
	 * Constroi uma data representando agora
	 */
	public Data() {
		aData = Calendar.getInstance();
	}

	/**
	 * Constroi uma data representando um dado dia.
	 * Para efetuar compara��es entre datas, a hora ser� 00:00:00.0
	 * (0 horas, 0 minutos, 0 segundos, 0 milissegundos)
	 * @param dia O dia desejado
	 * @param mes O m�s desejado (0 = jan, 11 = dez)
	 * @param ano O ano desejado
	 */
	public Data(int dia, int mes, int ano) {
            this(dia, mes, ano, 0, 0, 0);
	}

	/**
	 * Constroi uma data representando um dado dia e hora.
	 * Para permitir compara��es de datas, os milissegundos da data s�o zerados.
	 * @param dia O dia desejado
	 * @param mes O m�s desejado (0 = jan, 11 = dez)
	 * @param ano O ano desejado
	 * @param hora As horas desejadas
	 * @param min Os minutos desejadas
	 * @param seg Os segundos desejados
	 */
	public Data(int dia, int mes, int ano, int hora, int min, int seg) {
            this();
            aData.set(ano, mes, dia, hora, min, seg);
            aData.set(Calendar.MILLISECOND, 0);
	}

    Calendar getCalendar() {
        return aData;
    }

    void setCalendar(Calendar aData) {
        this.aData = aData;
    }

   	/**
	 * Clona a data.
	 * @return Um clone da data
	 */
	public Object clone() {
		Data o = null;
		try {
			o = (Data)super.clone();
            o.setCalendar((Calendar)aData.clone());
		} catch(CloneNotSupportedException e) {}
		return o;
	}

	/**
	 * Retorna uma data do tipo Date correspondendo a esta data.
	 * @return A data como objeto da classe Date
	 */
	public Date getDate() {
		return aData.getTime();
	}

	/**
	 * Retorna o ano correspondendo a esta data.
	 * @return O ano da data
	 */
	public int getAno() {
		return aData.get(Calendar.YEAR);
	}

	/**
	 * Retorna o m�s correspondendo a esta data.
	 * @return O m�s da data
	 */
	public int getMes() {
		return aData.get(Calendar.MONTH);
	}

	/**
	 * Retorna o dia correspondendo a esta data.
	 * @return O dia da data
	 */
	public int getDia() {
		return aData.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * Retorna o dia da semana correspondendo a esta data.
	 * @return O dia da semana da data
	 */
	public int getDiaDaSemana() {
		return aData.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * Retorna as horas correspondendo a esta data.
	 * @return As horas da data
	 */
	public int getHoras() {
		return aData.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * Retorna os minutos correspondendo a esta data.
	 * @return Os minutos da data
	 */
	public int getMinutos() {
		return aData.get(Calendar.MINUTE);
	}

	/**
	 * Retorna os segundos correspondendo a esta data.
	 * @return os segundos da data
	 */
	public int getSegundos() {
		return aData.get(Calendar.SECOND);
	}

	/**
	 * Formata uma data no formato dd/mm/aaaa
	 * @return Um string representando a data no formato dd/mm/aaaa
	 */
	public String DDMMAAAA() {
		return new java.text.SimpleDateFormat("dd/MM/yyyy").format(getDate());
	}

	/**
	 * Formata uma data no formato dd/mm/aaaa hh:mm
	 * @return Um string representando a data no formato dd/mm/aaaa hh:mm
	 */
	public String DDMMAAAAHHMM() {
		return new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm").format(getDate());
	}

	/**
	 * Acrescenta um n�mero de anos � data.
	 * @param numAnos O n�mero de anos a acrescentar (pode ser negativo).
	 */
	public void somarAno(int numAnos) {
		aData.add(Calendar.YEAR, numAnos);
	}

	/**
	 * Acrescenta um n�mero de meses � data.
	 * @param numMeses O n�mero de meses a acrescentar (pode ser negativo).
	 */
	public void somarMes(int numMeses) {
		aData.add(Calendar.MONTH, numMeses);
	}

	/**
	 * Acrescenta um n�mero de dias � data.
	 * @param numDias O n�mero de dias a acrescentar (pode ser negativo).
	 */
	public void somarDia(int numDias) {
		aData.add(Calendar.DAY_OF_MONTH, numDias);
	}

	/**
	 * Acrescenta um n�mero de horas � data.
	 * @param numHoras O n�mero de horas a acrescentar (pode ser negativo).
	 */
	public void somarHoras(int numHoras) {
		aData.add(Calendar.HOUR_OF_DAY, numHoras);
	}

	/**
	 * Acrescenta um n�mero de minutos � data.
	 * @param numMinutos O n�mero de minutos a acrescentar (pode ser negativo).
	 */
	public void somarMinutos(int numMinutos) {
		aData.add(Calendar.MINUTE, numMinutos);
	}

	/**
	 * Acrescenta um n�mero de segundos � data.
	 * @param numSegundos O n�mero de segundos a acrescentar (pode ser negativo).
	 */
	public void somarSegundos(int numSegundos) {
		aData.add(Calendar.SECOND, numSegundos);
	}

	/**
	 * Compara a data com outra data.
	 * @param outraData A outra data a comparar com this.
	 * @return -1 se this for antes de outraData<br>
	 * 0 se this e outraData forem iguais<br>
	 * 1 se this for depois de outraData
	 */
	public int compareTo(Object outraData) throws ClassCastException {
		if(!(outraData instanceof Data)) {
			throw new ClassCastException();
		}
		return getDate().compareTo(((Data)outraData).getDate());
	}

    /**
     * Testa a igualdade de um objeto com esta Data.
     * @param objeto O objeto a comparar com esta data.
     * @return true se o objeto for igual a esta Data, false caso contr�rio.
     */
    public boolean equals(Object objeto) {
        if(! (objeto instanceof Data)) {
            return false;
        }
        return getCalendar().equals(((Data)objeto).getCalendar());
    }
}