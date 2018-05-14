/**
 * Classe de conta banc�ria simples.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */

import p1.aplic.geral.*;

public class ContaSimples2 {
	// atributos
	private int n�mero;

	private Pessoa titular;

	private double saldo;

	// construtores
	/**
	 * Cria uma conta a partir de uma pessoa e n�mero de conta.
	 * 
	 * @param titular
	 *            O titular da conta.
	 * @param n�mero
	 *            O n�mero da conta.
	 */
	public ContaSimples2(Pessoa titular, int n�mero) {
		this.n�mero = n�mero;
		this.titular = titular;
		saldo = 0.0;
	}

	/**
	 * Cria uma conta a partir de um nome e cpf de pessoa f�sica, e um n�mero de
	 * conta.
	 * 
	 * @param nome
	 *            O nome do titular da conta.
	 * @param cpf
	 *            O CPF do titular da conta.
	 * @param n�mero
	 *            O n�mero da conta.
	 */
	// h� sobrecarga do m�todo construtor
	public ContaSimples2(String nome, String cpf, int n�mero) {
		// aninhamento de m�todo construtor
		this(new Pessoa(nome, cpf), n�mero);
	}

	/**
	 * Recupera o n�mero da conta.
	 * 
	 * @return O n�mero da conta.
	 */
	public int getN�mero() {
		return n�mero;
	}

	/**
	 * Recupera o titular da conta.
	 * 
	 * @return O titular da conta.
	 */
	public Pessoa getTitular() {
		return titular;
	}

	/**
	 * Recupera o nome do titular da conta.
	 * 
	 * @return O nome do titular da conta.
	 */
	/* feito para ajudar os principiantes escondendo a classe Pessoa no inicio */
	public String getNome() {
		// aninhamento de m�todo
		return titular.getNome();
	}

	/**
	 * Recupera o CPF do titular da conta.
	 * 
	 * @return O CPF do titular da conta.
	 */
	/* feito para ajudar os principiantes escondendo a classe Pessoa no inicio */
	public String getCPF() {
		return titular.getCPF();
	}

	/**
	 * Recupera o saldo da conta.
	 * 
	 * @return O saldo da conta.
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * Efetua um dep�sito numa conta.
	 * 
	 * @param valor
	 *            O valor a depositar.
	 */
	public void depositar(double valor) {
		// credita a conta
		saldo += valor;
	}

	/**
	 * Efetua sacada na conta.
	 * 
	 * @param valor
	 *            O valor a sacar.
	 * @return O sucesso ou n�o da opera��o.
	 */
	public boolean sacar(double valor) {
		// debita a conta
		if (saldo - valor >= 0) {
			saldo -= valor;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Transforma os dados da conta em um String.
	 * 
	 * @return O string com os dados da conta.
	 */
	public String toString() {
		return "numero " + n�mero + ", nome " + getNome() + ", saldo " + saldo;
	}
}
