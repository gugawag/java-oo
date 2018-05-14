/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ci�ncia da Computa��o
 * Departamento de Sistemas e Computa��o
 * Universidade Federal da Para�ba
 *
 * Copyright (C) 2001 Universidade Federal da Para�ba.
 * N�o redistribuir sem permiss�o.
 */
package p1.aplic.cartas;

/**
 * Classe de Exce��o quando tenta-se poegar uma carta de um baralho vazio.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 2001 Universidade Federal da Para�ba.
 */
public class BaralhoVazioException extends Exception {

    /**
     * Construtor de exce��o informando que o baralho est� vazio.
     * @param motivo O motivo pelo qual n�o se pode fechar a conta.
     */
	public BaralhoVazioException(String motivo) {
		super(motivo);
	}
}
