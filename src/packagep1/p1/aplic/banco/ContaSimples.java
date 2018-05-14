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

import p1.aplic.geral.*;

/**
 * Classe de conta banc�ria simples para pessoa f�sica.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */
public class ContaSimples extends Conta {
	// construtores
	/**
	 * Cria uma conta a partir de uma pessoa e n�mero de conta.
	 * @param titular O titular da conta.
	 * @param n�mero O n�mero da conta.
	 */
	public ContaSimples(Pessoa titular, int n�mero) {
		super(titular, n�mero);
		Agencia.addTitular(titular);
		Agencia.addConta(this);
	}

	/**
	 * Cria uma conta a partir de um nome e cpf de pessoa f�sica, e um n�mero de conta.
	 * @param nome O nome do titular da conta.
	 * @param cpf O CPF do titular da conta.
	 * @param n�mero O n�mero da conta.
	 */
	/* Este m�todo existe para esconder a classe Pessoa dos principiantes */
	public ContaSimples(String nome, String cpf, int n�mero) {
		this(new Pessoa(nome, cpf), n�mero);
	}

	/**
	 * Transforma os dados da conta em um String.
	 * @return O string com os dados da conta.
	 */
	public String toString() {
		return "ContaSimples " + super.toString();
	}
}
