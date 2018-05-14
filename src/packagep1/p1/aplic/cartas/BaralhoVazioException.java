/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ciência da Computação
 * Departamento de Sistemas e Computação
 * Universidade Federal da Paraíba
 *
 * Copyright (C) 2001 Universidade Federal da Paraíba.
 * Não redistribuir sem permissão.
 */
package p1.aplic.cartas;

/**
 * Classe de Exceção quando tenta-se poegar uma carta de um baralho vazio.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 2001 Universidade Federal da Paraíba.
 */
public class BaralhoVazioException extends Exception {

    /**
     * Construtor de exceção informando que o baralho está vazio.
     * @param motivo O motivo pelo qual não se pode fechar a conta.
     */
	public BaralhoVazioException(String motivo) {
		super(motivo);
	}
}
