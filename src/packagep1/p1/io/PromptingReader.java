/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ciência da Computação
 * Departamento de Sistemas e Computação
 * Universidade Federal da Paraíba
 *
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 * Não redistribuir sem permissão.
 */
package p1.io;
import java.io.*;

/**
 * Equivalente a um ParserReader mas permitindo fornecer um prompt ao usuário antes de ler algo.
 *
 * @see	  p1.io.Console
 * @see	  p1.io.ParserReader
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 */

public class PromptingReader extends ParserReader {

	public PromptingReader(Reader in) {
		super(in);
	}
	
	/** lerLinha() com prompt para o usuário.
	  * @param prompt O string a exibir.
	  * @return A linha lida, sem caracteres de terminação de linha. Retorna null no fim da entrada.
	  */
	public String lerLinha(String prompt) throws IOException {
	  	printPrompt(prompt);
		return super.lerLinha();
	}

	/** lerPalavra() com prompt para o usuário.
	  * @param prompt O string a exibir.
	  * @return A palavra lida. Retorna null no fim da entrada.
	  */
	public String lerPalavra(String prompt) throws IOException {
	  	printPrompt(prompt);
		return super.lerPalavra();
	}

	/** lerInteiro() com prompt para o usuário.
	  * @param prompt O string a exibir.
	  * @return O inteiro lido, como objeto Integer. Retorna null no fim da entrada.
	  */
	public Integer lerInteiro(String prompt) throws IOException, NumberFormatException {
	  	printPrompt(prompt);
		return super.lerInteiro();
	}

	/** lerDouble() com prompt para o usuário.
	  * @param prompt O string a exibir.
	  * @return O número lido, como objeto Double. Retorna null no fim da entrada.
	  */
	public Double lerDouble(String prompt) throws IOException, NumberFormatException {
	  	printPrompt(prompt);
		return super.lerDouble();
	}

	/**
	 * Imprime um prompt em System.out.
	 */
	public void printPrompt(String prompt) {
		System.out.print(prompt);
		System.out.flush();
	}
}
