/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ci�ncia da Computa��o
 * Departamento de Sistemas e Computa��o
 * Universidade Federal da Para�ba
 *
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 * N�o redistribuir sem permiss�o.
 */
package p1.io;
import java.io.*;

/**
 * Equivalente a um Reader com coisinhas para ajudar novatos na programa��o.
 * Permite ler linhas, palavras individuais, inteiros e double.
 *
 * @see      p1.io.Console
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */

public class ParserReader extends BufferedReader {

	/** Cria um ParserReader.
     * @param in O Reader a partir do qual se cria um ParserReader.
     */
	public ParserReader(Reader in) {
		super(in);
	}
	
	/** L� uma linha.
	 * @return A linha lida. Retorna null no fim da entrada.
	 */
	public String lerLinha() throws IOException {
		return readLine();
	}

	/** L� uma palavra, um conjunto de caracteres delimitados por espa�o em branco.
	 * @return A palavra lida. Retorna null no fim da entrada.
	 */
	public String lerPalavra() throws IOException {
		int ch;
		String r = "";
		while((ch = read()) >= 0 && Character.isWhitespace((char)ch))
			;	// pula espaco em branco inicial
		r += (char)ch;
		while((ch = read()) >= 0 && !Character.isWhitespace((char)ch)) {
			r += (char)ch;
		}
		return r.length() == 0 ? null : r;
	}

	/** L� um n�mero inteiro.
	 * @return O inteiro lido, como objeto Integer. Retorna null no fim da entrada.
	 */
	public Integer lerInteiro() throws IOException, NumberFormatException {
		String w = lerPalavra();
		return w == null ? null : new Integer(w);
	}

	/** L� um n�mero real.
	 * @return O n�mero real lido, como objeto Double. Retorna null no fim da entrada.
	 */
	public Double lerDouble() throws IOException, NumberFormatException {
		String w = lerPalavra();
		return w == null ? null : new Double(w);
	}

    /* precisa converter esses testes para JUNIT */
	public void testar() throws IOException, NumberFormatException {
		String	s;
		Integer	i;
		int	ch;
		Double	d;
		int	isoma;
		double	dsoma;
		// testes
		// 1. teste de linha
		System.out.println("Leitura de linhas");
		while((s = lerLinha()) != null && !s.equals("fimlinha")) {
			System.out.println(s);
		}
		// 2. teste de palavra
		System.out.println("Leitura de palavras");
		while((s = lerPalavra()) != null && !s.equals("fimpalavra")) {
			System.out.println(s);
		}
		// 3. teste de inteiro
		System.out.println("Leitura de inteiros");
		isoma = 0;
		while((i = lerInteiro()) != null && i.intValue() >= 0) {
			System.out.println(i);
			isoma += i.intValue();
		}
		System.out.println("Soma de inteiros = " + isoma);
		// 4. teste de double
		System.out.println("Leitura de double");
		dsoma = 0;
		while((d = lerDouble()) != null && d.doubleValue() >= 0.0) {
			System.out.println(d);
			dsoma += d.doubleValue();
		}
		System.out.println("Soma de double = " + dsoma);
		// 5. teste de caracteres at� o fim de arquivo
		System.out.println("Leitura de caracteres ate o fim de arquivo");
		while((ch = read()) >= 0) {
			System.out.write(ch);
		}
		System.out.println("Fim dos testes");
	}
}
