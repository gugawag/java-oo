/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ciência da Computação
 * Departamento de Sistemas e Computação
 * Universidade Federal da Paraíba
 *
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 * Não redistribuir sem permissão.
 */
package p1.aplic.banco;

import java.util.*;
import p1.aplic.geral.*;

/**
 * Classe que implementa um extrato com formatação HTML
 * Um extrato é um subconjunto das transações de um movimento
 * que ocorreram entre duas datas.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
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
	 * @return O movimento formatado como string HTML, pronto para visualização.
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
		resultado += "<TD CLASS=\"clsTitle\"><B>Débito</B></TD>" + newLine;
		resultado += "<TD CLASS=\"clsTitle\"><B>Crédito</B></TD>" + newLine;
		resultado += "<TD CLASS=\"clsTitle\"><B>Valor</B></TD>" + newLine;
		resultado += "<TD CLASS=\"clsTitle\"><B>Descrição</B></TD>" + newLine;
		resultado += "</tr>" + newLine;
		Iterator it = getTransações();
		while(it.hasNext()) {
			Transacao t = (Transacao)it.next();
			resultado += "<tr>" + newLine;
			resultado += "<TD align=\"left\">" + t.getData().DDMMAAAAHHMM() + "</TD>" + newLine;
			resultado += "<TD align=\"right\">" + t.getContaDébito().getNúmero() + "</TD>" + newLine;
			resultado += "<TD align=\"right\">" + t.getContaCrédito().getNúmero() + "</TD>" + newLine;
			resultado += "<TD align=\"right\">" + t.getValorMonetário().toString() + "</TD>" + newLine;
			resultado += "<TD align=\"left\">" + t.getDescrição() + "</TD>" + newLine;
			resultado += "</tr>" + newLine;
		}
		resultado += "</table>" + newLine;
		resultado += "</body>" + newLine;
		resultado += "</html>" + newLine;
		return resultado;
	}
}