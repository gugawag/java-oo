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

import java.io.*;
import java.util.*;
import p1.aplic.geral.*;

/**
 * Uma transa��o banc�ria. Uma transa��o envolve a transfer�ncia de valores
 * entre contas. Toda a movimenta��o banc�ria envolve transa��es.
 * Quando h�, aparentemente, uma �nica conta envolvida (dep�sito ou saque),
 * a segunda conta envolvida � a Conta Caixa.
 *
 * @see p1.aplic.banco.ContaCaixa
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */
public class Transacao implements Serializable {
  static final long serialVersionUID = 6150522172556957388L;
	private Data	data;
	private Conta	contaD�bito;
	private Conta	contaCr�dito;
	private Moeda	valor;
	private String	descri��o;

	// Construtores
    /**
     * Constroi uma transa��o.
     * @param data A data da transa��o.
     * @param contaD�bito A conta que foi debitado.
     * @param contaCr�dito A conta que foi creditado.
     * @param valor O valor da transa��o.
     * @param descri��o A descri��o da transa��o.
     */
	public Transacao(Data data, Conta contaD�bito, Conta contaCr�dito, Moeda valor, String descri��o) {
		this.data = data;
		this.contaD�bito = contaD�bito;
		this.contaCr�dito = contaCr�dito;
		this.valor = valor;
		this.descri��o = descri��o;
	}


	/**
	 * Recupera a data da transa��o.
	 * @return A data da transa��o.
	 */
	public Data getData() {
		return data;
	}
   
	/**
	 * Recupera a conta d�bito.
	 * @return A conta d�bito.
	 */
	public Conta getContaD�bito() {
		return contaD�bito;
	}

	/**
	 * Recupera a conta cr�dito.
	 * @return A conta cr�dito.
	 */
	public Conta getContaCr�dito() {
		return contaCr�dito;
	}

	/**
	 * Recupera o valor da transa��o.
	 * @return O valor da transa��o como double.
	 */
	public double getValor() {
		return valor.getValor();
	}

	/**
	 * Recupera o valor da transa��o.
	 * @return O valor da transa��o como Moeda.
	 */
	public Moeda getValorMonet�rio() {
		return valor;
	}

	/**
	 * Recupera a descri��o da transa��o.
	 * @return A descri��o da transa��o.
	 */
	public String getDescri��o() {
		return descri��o;
	}

	/**
	 * Transforma os dados da transa��o em um String.
	 * @return O string descrevendo a transa��o.
	 */
	public String toString() {
		return "Transacao data " + getData().DDMMAAAA()
			+ ", debito " + getContaD�bito().getN�mero()
			+ ", credito " + getContaCr�dito().getN�mero()
			+ ", valor " + getValorMonet�rio()
			+ ", descricao [" + getDescri��o();
	}
}
