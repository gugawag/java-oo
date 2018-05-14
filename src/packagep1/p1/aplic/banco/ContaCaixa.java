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
 * Classe de conta caixa.
 * A agencia tem uma conta caixa que � uma conta com v�rias restri��es.
 * A conta caixa representa o caixa da ag�ncia. Como todos os movimentos
 * feitos a contas banc�rias devem envolver <i>duas</i> contas (pelos
 * princ�pios da contabilidade), a conta caixa � usada durante os dep�sitos
 * e saques feitos pelos clientes com suas contas normais.
 * <P>Por exemplo, um dep�sito envolve uma transfer�ncia de valor <i>para</i>
 * uma conta. De onde veio este dinheiro? Da conta caixa. Em outras palavras,
 * a conta caixa � debitada e a conta alvo � creditada.
 * <p>Da mesma forma, um saque envolve um d�bito de uma conta normal e um cr�dito
 * na conta caixa.
 * <p>A conta caixa tem um comportamento diferente das demais contas.
 * Por exemplo: ela pode ter saldo negativo � vontade (resultados de dep�sitos)
 * e certas outras opera��es lan�am exce��es.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */
public class ContaCaixa extends Conta {
	// construtores
    /** Constroi uma conta caixa */
	public ContaCaixa() {
		// usa uma pessoa fisica ficticia
		super(new Pessoa("caixa"), 0);
	}

	/**
	 * Transfere um valor do caixa para outra conta (dep�sito).
	 * @param destino A conta destino.
	 * @param valor O valor a transferir.
	 * @param descr A descri��o da transa��o.
	 * @return O sucesso ou n�o da opera��o.
	 */
	public boolean transferir(Conta destino, double valor, String descr) {
		this.receber(-valor);
		destino.receber(valor);
		logarTransacao(this, destino, new Real(valor), descr);
		return true; // sempre pode debitar o caixa: nunca d� erro
	}

	/**
	 * N�o deixa efetuar dep�sito no caixa. Para que n�o haja dep�sito feito
	 * diretamente na conta "caixa", fazemos override de um dep�sito normal
	 * para que este n�o seja permitido para a conta caixa.
	 * @param valor O valor que se quer depositar.
	 * @return O sucesso ou n�o da opera��o (sempre false).
	 */
	public boolean depositar(double valor) {
		return false; // nao se deve fazer "dep�sitos" diretos no caixa
	}

	/**
	 * N�o deixa efetuar saques no caixa. Para que n�o haja saque feito
	 * diretamente na conta "caixa", fazemos override de um saque normal
	 * para que este n�o seja permitido para a conta caixa.
	 * @param valor O valor que se quer sacar.
	 * @return O sucesso ou n�o da opera��o (sempre d� false).
	 */
	public boolean sacar(double valor) {
		return false; // nao se deve fazer "saques" no caixa
	}

	/**
	 * N�o permite o fechamento da conta
	 * @throws NaoPodeFecharContaException Porque n�o � permitido fechar o caixa.
	 */
	public void fechar() throws NaoPodeFecharContaException  {
		throw new NaoPodeFecharContaException(this, "Nao pode fechar o caixa");
	}

	/**
	 * Transforma os dados da conta em um String.
	 * @return O string com os dados da conta.
	 */
   	public String toString() {
		return "ContaCaixa saldo " + getSaldoMonet�rio();
	}
}
