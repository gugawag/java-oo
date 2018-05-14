/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ci�ncia da Computa��o
 * Departamento de Sistemas e Computa��o
 * Universidade Federal da Para�ba
 *
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 * N�o redistribuir sem permiss�o.
 */
package p1.aplic.banco;

import java.util.*;
import p1.aplic.geral.*;

/**
 * Classe que implementa um extrato com formata��o HTML
 * Um extrato � um subconjunto das transa��es de um movimento
 * que ocorreram entre duas datas.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */
public class ExtratoHTML extends Extrato {
    /**
     * Constroi um ExtratoHTML.
     * @param dataInicial A data inicial desejada para o extrato.
     * @param dataFinal A data final desejada para o extrato.
     */
	public ExtratoHTML(Data dataInicial, Data dataFinal, Movimento movimento) {
        super(dataInicial, dataFinal, movimento);
	}

	/**
	 * Formata o movimento como string HTML.
	 * @return O movimento formatado como string HTML, pronto para visualiza��o.
	 */
	public String formatar() {
		String newLine = System.getProperty("line.separator");
		String resultado = "<html>" + newLine;
		resultado += "<head>" + newLine;
		resultado += "<title>Extrato de Conta</title>" + newLine;
		resultado += "<style type=\"text/css\">" + newLine;
		resultado += "<!--" + newLine;
		resultado += "body {  font-family: Verdana, Arial, Helvetica, sans-serif;; font-weight: normal; font-variant: normal}" + newLine;
		resultado += ".clsIndex { }" + newLine;
		resultado += ".clsTitle { background-color: #CCCCCC; text-align: center }" + newLine;
		resultado += "td {  font-size: 9pt; font-family: Verdana, Arial, Helvetica, sans-serif; background-color: #EEEEEE}" + newLine;
		resultado += "-->" + newLine;
		resultado += "</style>" + newLine;
		resultado += "</head>" + newLine;
		resultado += "<body>" + newLine;
		resultado += "<h2>Extrato de conta entre " + dataInicial.DDMMAAAAHHMM() +
				" e " + dataFinal.DDMMAAAAHHMM() + "</h2>" + newLine;
		resultado += "<TABLE CLASS=\"clsIndex\">" + newLine;
		resultado += "<tr>" + newLine;
		resultado += "<TD CLASS=\"clsTitle\"><B>Data</B></TD>" + newLine;
		resultado += "<TD CLASS=\"clsTitle\"><B>D�bito</B></TD>" + newLine;
		resultado += "<TD CLASS=\"clsTitle\"><B>Cr�dito</B></TD>" + newLine;
		resultado += "<TD CLASS=\"clsTitle\"><B>Valor</B></TD>" + newLine;
		resultado += "<TD CLASS=\"clsTitle\"><B>Descri��o</B></TD>" + newLine;
		resultado += "</tr>" + newLine;
		Iterator it = getTransa��es();
		while(it.hasNext()) {
			Transacao t = (Transacao)it.next();
			resultado += "<tr>" + newLine;
			resultado += "<TD align=\"left\">" + t.getData().DDMMAAAAHHMM() + "</TD>" + newLine;
			resultado += "<TD align=\"right\">" + t.getContaD�bito().getN�mero() + "</TD>" + newLine;
			resultado += "<TD align=\"right\">" + t.getContaCr�dito().getN�mero() + "</TD>" + newLine;
			resultado += "<TD align=\"right\">" + t.getValorMonet�rio().toString() + "</TD>" + newLine;
			resultado += "<TD align=\"left\">" + t.getDescri��o() + "</TD>" + newLine;
			resultado += "</tr>" + newLine;
		}
		resultado += "</table>" + newLine;
		resultado += "</body>" + newLine;
		resultado += "</html>" + newLine;
		return resultado;
	}
}