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

/**
 * Classe de Exce��o quando tenta-se fechar uma conta sem estar com saldo zerado.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */
public class NaoPodeFecharContaException extends Exception {
    static final long serialVersionUID = 6857729033909487478L;    
	Conta conta;

    /**
     * Construtor de exce��o informando que uma conta n�o pode ser fechada.
     * @param conta A conta que n�o pode ser fechada.
     * @param motivo O motivo pelo qual n�o se pode fechar a conta.
     */
	public NaoPodeFecharContaException(Conta conta, String motivo) {
		super(motivo);
		this.conta = conta;
	}
}
