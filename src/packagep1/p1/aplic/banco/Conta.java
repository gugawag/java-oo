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

import java.util.*;
import java.io.*;
import p1.aplic.geral.*;

/**
 * Classe abstrata de conta banc�ria com implementa��es default de alguns m�todos.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */
public abstract class Conta implements Serializable {
  static final long serialVersionUID = 8972898734498390810L;
	private int			   n�mero;
	private Pessoa     titular;
	private Data       dataAbertura;
	private Moeda		   saldo;
	private Movimento  movimento;

	// construtores
	/**
	 * Cria uma conta a partir de uma pessoa e n�mero de conta.
	 * @param titular O titular da conta.
	 * @param n�mero O n�mero da conta.
	 */
	public Conta(Pessoa titular, int n�mero) {
		this.n�mero = n�mero;
		this.titular = titular;
		dataAbertura = new Data();	// A data representa este instante de tempo
		saldo = new Real(0.0);		// Conta em reais e zerada
		movimento = new Movimento();
	}

	// M�todos
	/**
	 * Recupera o n�mero da conta.
	 * @return O n�mero da conta.
	 */
	public int getN�mero() {
		return n�mero;
	}

	/**
	 * Recupera o titular da conta.
	 * @return O titular da conta.
	 */
	public Pessoa getTitular() {
		return titular;
	}

	/**
	 * Recupera o nome do titular da conta.
	 * @return O nome do titular da conta.
	 */
	/* feito para ajudar os principiantes escondendo a classe Pessoa no inicio */
	public String getNome() {
		return titular.getNome();
	}

	/**
	 * Recupera o CPF do titular da conta.
	 * @return O CPF do titular da conta.
	 */
	/* feito para ajudar os principiantes escondendo a classe Pessoa no inicio */
	public String getCPF() {
		return titular.getCPF();
	}

	/**
	 * Recupera a data de abertura da conta.
	 * @return A data de abertura da conta.
	 */
	public Data getDataAbertura() {
		return dataAbertura;
	}
   
	/**
	 * Recupera o saldo da conta.
	 * @return O saldo da conta como double.
	 */
	public double getSaldo() {
		return saldo.getValor();
	}

	/**
	 * Recupera o saldo da conta.
	 * @return O saldo da conta como Moeda.
	 */
	public Moeda getSaldoMonet�rio() {
		return saldo;
	}

	/**
	 * Recupera o movimento da conta.
	 * @return O movimento da conta.
	 */
	public Movimento getMovimento() {
		return movimento;
	}

	/**
	 * Fornece um Iterator para varrer as transa��es por data.
	 * @return O Iterator.
	 */
	public Iterator getTransa��es() {
		return getMovimento().getTransa��es();
	}

	/**
	 * Transfere um valor para outra conta.
	 * @param destino A conta destino.
	 * @param valor O valor a transferir.
	 * @return O sucesso ou n�o da opera��o.
	 */
	public boolean transferir(Conta destino, double valor) {
		return transferir(destino, valor, "transferencia para conta " + destino.getN�mero());
	}

	/**
	 * Transfere um valor para outra conta.
	 * @param destino A conta destino.
	 * @param valor O valor a transferir.
	 * @param descr A descri��o da transa��o.
	 * @return O sucesso ou n�o da opera��o. H� insucesso se n�o houver saldo suficiente.
	 */
	public boolean transferir(Conta destino, double valor, String descr) {
		if(saldo.getValor() - valor >= 0) {
			this.receber(-valor);
			destino.receber(valor);
			logarTransacao(this, destino, new Real(valor), descr);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Recebe valor na conta.
	 * @param valor O valor a receber.
	 */
    // observe que o m�todo *n�o* � p�blico
	void receber(double valor) {
		saldo.setValor(saldo.getValor() + valor);
	}

	/**
	 * Efetua um dep�sito numa conta.
	 * @param valor O valor a depositar.
	 */
	public boolean depositar(double valor) {
		// credita a conta e debita o caixa
		return Agencia.getContaCaixa().transferir(this, valor, "deposito");
	}

	/**
	 * Efetua sacada na conta.
	 * @param valor O valor a sacar.
	 * @return O sucesso ou n�o da opera��o.
	 */
	public boolean sacar(double valor) {
		// debita a conta e credita o caixa
		return transferir(Agencia.getContaCaixa(), valor, "saque");
	}

	/**
	 * Efetua log de uma transa��o no movimento.
     * @param contaD�bito A conta que foi debitada.
     * @param contaCr�dito A conta que foi creditada.
	 * @param valor O valor da transa��o.
     * @param descr A descri��o da transa��o.
	 */
    // observe que p m�todo *n�o* � p�blico
    void logarTransacao(Conta contaD�bito, Conta contaCr�dito, Moeda valor, String descr) {
		Transacao transacao = new Transacao(new Data(), contaD�bito, contaCr�dito, valor, descr);
		contaD�bito.getMovimento().add(transacao);
		contaCr�dito.getMovimento().add(transacao);
		Agencia.getMovimento().add(transacao);
	}

	/**
	 * Transforma os dados da conta em um String.
	 * @return O string com os dados da conta.
	 */
	public String toString() {
		return "numero " + getN�mero()
				+ ", titular " + getNome()
				+ ", data " + getDataAbertura().DDMMAAAA()
				+ ", saldo " + getSaldoMonet�rio();
	}

	/**
	 * Fecha a conta.
	 * @throws NaoPodeFecharContaException Quando se tenta fechar uma conta com saldo n�o zero.
	 */
	public void fechar() throws NaoPodeFecharContaException  {
		Agencia.fecharConta(n�mero);
	}

	/**
	 * Cria um extrato com todas as transa��es entre duas datas.
	 * @param dataInicial A data inicial do extrato (inclusive).
	 * @param dataFinal A data final do extrato (inclusive).
	 */
	public Extrato criarExtrato(Data dataInicial, Data dataFinal) {
		return new Extrato(dataInicial, dataFinal, movimento);
	}
}
