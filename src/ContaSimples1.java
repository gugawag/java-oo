/**
 * Classe de conta banc�ria simples.
 * 
 * @author Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1 <br>
 *          Copyright (C) 1999 Universidade Federal da Para�ba.
 */
public class ContaSimples1 {
	// atributos
	private String nome;

	private String cpf;

	private int numero;

	private double saldo;

	// construtor
	/**
	 * Cria uma conta a partir de um nome e cpf de pessoa f�sica, e um numero de
	 * conta.
	 * 
	 * @param nome
	 *            O nome do titular da conta.
	 * @param cpf
	 *            O CPF do titular da conta.
	 * @param numero
	 *            O numero da conta.
	 */
	public ContaSimples1(String nome, String cpf, int numero) {
		this.nome = nome;
		this.cpf = cpf;
		this.numero = numero;
		saldo = 0.0;
	}

	// m�todos
	/**
	 * Recupera o numero da conta.
	 * 
	 * @return O numero da conta.
	 */
	public int getnumero() {
		return numero;
	}

	/**
	 * Recupera o nome do titular da conta.
	 * 
	 * @return O nome do titular da conta.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Recupera o CPF do titular da conta.
	 * 
	 * @return O CPF do titular da conta.
	 */
	public String getCPF() {
		return cpf;
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
		return "numero " + numero + ", nome " + nome + ", saldo " + saldo;
	}

	// O programa sempre tem um "m�todo" main que � onde come�a a execu��o
	public static void main(String args[]) {
		// Abra uma conta de numero 1 para Jo�o com CPF 309140605-06
		// A conta ser� "referenciada" com a vari�vel umaConta
		ContaSimples1 umaConta = new ContaSimples1("Joao", "30914060506", 1);
		// Nesta conta, deposite R$1000,00
		umaConta.depositar(1000.0);

		// Imprima o saldo da conta de Jo�o
		double saldo = umaConta.getSaldo();
		System.out.print("Saldo da conta de Joao antes do saque: ");
		System.out.println(saldo);

		// Saque R$300,00 desta conta
		umaConta.sacar(300.0);
		// Imprima o objeto umaConta
		System.out.println(umaConta);
		// Imprima o saldo da conta de Jo�o
		System.out.println("Saldo da conta de Joao depois do saque: "
				+ umaConta.getSaldo());
	} // fim do m�todo main
}
