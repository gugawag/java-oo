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
 * Um PromptingReader que não retorna exceção (para principiantes).
 *
 * @see	  p1.io.PromptingReader
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 */
public class PromptingReaderSemExcecao extends PromptingReader {

	public PromptingReaderSemExcecao(Reader in) {
		super(in);
	}

	/**
	 * Lê uma linha da entrada padrão. Não lança exceção.
	 * @return A linha lida.
	 */
	public String lerLinha() {
		try {
			return super.lerLinha();
		} catch(IOException e) {
			return null;
		}
	}

	/**
	 * Lê uma linha da entrada padrão. Não lança exceção. Dá um prompt para o usuário.
	 * @return A linha lida. Retorna null no fim da entrada.
	 */
	public String lerLinha(String prompt) {
	  	printPrompt(prompt);
		return lerLinha();
	}

	/**
	 * Lê uma palavra da entrada padrão. Não lança exceção.
	 * @return A palavra lida. Retorna null no fim da entrada.
	 */
	public String lerPalavra() {
		try {
			return super.lerPalavra();
		} catch(IOException e) {
			return null;
		}
	}

	/**
	 * Lê uma palavra da entrada padrão. Não lança exceção. Dá um prompt para o usuário.
	 * @return A palavra lida. Retorna null no fim da entrada.
	 */
	public String lerPalavra(String prompt) {
	  	printPrompt(prompt);
		return lerPalavra();
	}

	/**
	 * Lê um inteiro da entrada padrão. Não lança exceção.
	 * @return O inteiro lido, como objeto Integer. Retorna null no fim da entrada.
	 */
	public Integer lerInteiro() {
		Integer i;
		while(true) {
				try {
				return super.lerInteiro();
			} catch(IOException e) {
				return null;
			} catch(NumberFormatException e) {
				System.out.println("Nao eh um numero inteiro. Tente novamente.");
			}
		}
	}

	/**
	 * Lê um inteiro da entrada padrão. Não lança exceção. Dá um prompt para o usuário.
	 * @return O inteiro lido, como objeto Integer. Retorna null no fim da entrada.
	 */
	public Integer lerInteiro(String prompt) {
	  	printPrompt(prompt);
		return lerInteiro();
	}

	/**
	 * Lê um inteiro da entrada padrão. Não lança exceção.
	 * @return O inteiro lido, como int. Não indica fim de entrada.
	 */
	public int lerInt() {
        Integer i = lerInteiro();
        return i == null ? 0 : i.intValue();
    }

	/**
	 * Lê um inteiro da entrada padrão. Não lança exceção.  Dá um prompt para o usuário.
	 * @return O inteiro lido, como int. Não indica fim de entrada.
	 */
	public int lerInt(String prompt) {
        Integer i = lerInteiro(prompt);
        return i == null ? 0 : i.intValue();
    }

	/**
	 * Lê um número real da entrada padrão. Não lança exceção.
	 * @return O número lido, como objeto Double. Retorna null no fim da entrada.
	 */
	public Double lerDouble() {
		Double d;
		while(true) {
				try {
				return super.lerDouble();
			} catch(IOException e) {
				return null;
			} catch(NumberFormatException e) {
				System.out.println("Nao eh um numero real. Tente novamente.");
			}
		}
	}

	/**
	 * Lê um número real da entrada padrão. Não lança exceção. Dá um prompt para o usuário.
	 * @return O número lido, como objeto Double. Retorna null no fim da entrada.
	 */
	public Double lerDouble(String prompt) {
	  	printPrompt(prompt);
		return lerDouble();
	}

	/**
	 * Lê um número real da entrada padrão. Não lança exceção.
	 * @return O número lido, como double. Não indica fim da entrada.
	 */
	public double lerdouble() {
		Double d;
		while(true) {
				try {
				return super.lerDouble().doubleValue();
			} catch(IOException e) {
				return 0.0;
			} catch(NumberFormatException e) {
				System.out.println("Nao eh um numero real. Tente novamente.");
			}
		}
	}

	/**
	 * Lê um número real da entrada padrão. Não lança exceção. Dá um prompt para o usuário.
	 * @return O número lido, como double. Não indica fim da entrada.
	 */
	public double lerdouble(String prompt) {
	  	printPrompt(prompt);
		return lerdouble();
	}

	/**
	 * Lê um caractere da entrada padrão. Não lança exceção.
	 * @return O caractere lido. Retorna -1 no fim da entrada.
	 */
	public int read() {
		try {
			return super.read();
		} catch(IOException e) {
			// vai retornar lixo (MAX_VALUE), mas esta classe é
			// para principiantes ate que eles usem exceções
			// Talvez o MAX_VALUE faça o programa pipocar ...
			return Integer.MAX_VALUE;
		}
	}

	/**
	 * Lê um caractere da entrada padrão. Não lança exceção. Dá um prompt para o usuário.
	 * @return O caractere lido. Retorna -1 no fim da entrada.
	 */
	public int read(String prompt) {
  		printPrompt(prompt);
		return read();
	}

    /* falta converter os testes para JUNIT */
	public void testar() {
		try {
			super.testar();
		} catch(IOException e) {}	// Nao deve ter excecao devido ao override das funcoes acima
									// o try-catch é só para satisfazer o compilador
	}
}
