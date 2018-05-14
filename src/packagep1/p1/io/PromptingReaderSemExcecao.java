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
 * Um PromptingReader que n�o retorna exce��o (para principiantes).
 *
 * @see	  p1.io.PromptingReader
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */
public class PromptingReaderSemExcecao extends PromptingReader {

	public PromptingReaderSemExcecao(Reader in) {
		super(in);
	}

	/**
	 * L� uma linha da entrada padr�o. N�o lan�a exce��o.
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
	 * L� uma linha da entrada padr�o. N�o lan�a exce��o. D� um prompt para o usu�rio.
	 * @return A linha lida. Retorna null no fim da entrada.
	 */
	public String lerLinha(String prompt) {
	  	printPrompt(prompt);
		return lerLinha();
	}

	/**
	 * L� uma palavra da entrada padr�o. N�o lan�a exce��o.
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
	 * L� uma palavra da entrada padr�o. N�o lan�a exce��o. D� um prompt para o usu�rio.
	 * @return A palavra lida. Retorna null no fim da entrada.
	 */
	public String lerPalavra(String prompt) {
	  	printPrompt(prompt);
		return lerPalavra();
	}

	/**
	 * L� um inteiro da entrada padr�o. N�o lan�a exce��o.
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
	 * L� um inteiro da entrada padr�o. N�o lan�a exce��o. D� um prompt para o usu�rio.
	 * @return O inteiro lido, como objeto Integer. Retorna null no fim da entrada.
	 */
	public Integer lerInteiro(String prompt) {
	  	printPrompt(prompt);
		return lerInteiro();
	}

	/**
	 * L� um inteiro da entrada padr�o. N�o lan�a exce��o.
	 * @return O inteiro lido, como int. N�o indica fim de entrada.
	 */
	public int lerInt() {
        Integer i = lerInteiro();
        return i == null ? 0 : i.intValue();
    }

	/**
	 * L� um inteiro da entrada padr�o. N�o lan�a exce��o.  D� um prompt para o usu�rio.
	 * @return O inteiro lido, como int. N�o indica fim de entrada.
	 */
	public int lerInt(String prompt) {
        Integer i = lerInteiro(prompt);
        return i == null ? 0 : i.intValue();
    }

	/**
	 * L� um n�mero real da entrada padr�o. N�o lan�a exce��o.
	 * @return O n�mero lido, como objeto Double. Retorna null no fim da entrada.
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
	 * L� um n�mero real da entrada padr�o. N�o lan�a exce��o. D� um prompt para o usu�rio.
	 * @return O n�mero lido, como objeto Double. Retorna null no fim da entrada.
	 */
	public Double lerDouble(String prompt) {
	  	printPrompt(prompt);
		return lerDouble();
	}

	/**
	 * L� um n�mero real da entrada padr�o. N�o lan�a exce��o.
	 * @return O n�mero lido, como double. N�o indica fim da entrada.
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
	 * L� um n�mero real da entrada padr�o. N�o lan�a exce��o. D� um prompt para o usu�rio.
	 * @return O n�mero lido, como double. N�o indica fim da entrada.
	 */
	public double lerdouble(String prompt) {
	  	printPrompt(prompt);
		return lerdouble();
	}

	/**
	 * L� um caractere da entrada padr�o. N�o lan�a exce��o.
	 * @return O caractere lido. Retorna -1 no fim da entrada.
	 */
	public int read() {
		try {
			return super.read();
		} catch(IOException e) {
			// vai retornar lixo (MAX_VALUE), mas esta classe �
			// para principiantes ate que eles usem exce��es
			// Talvez o MAX_VALUE fa�a o programa pipocar ...
			return Integer.MAX_VALUE;
		}
	}

	/**
	 * L� um caractere da entrada padr�o. N�o lan�a exce��o. D� um prompt para o usu�rio.
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
									// o try-catch � s� para satisfazer o compilador
	}
}
