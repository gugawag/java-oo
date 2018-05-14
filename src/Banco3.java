/*
 * Declara��o e uso de tipos b�sicos e vari�veis
 */

import p1.aplic.banco.*;

public class Banco3 {
	public static void main(String args[]) {
		int numConta; // um inteiro, n�o inicializado
		String nome = "Joao"; // um string, inicializado
		double grana = 1000.0; // um double, inicializado
		ContaSimples umaConta; // uma refer�ncia a um objeto, n�o inicializada

		// Abra uma conta
		numConta = 1; // atribui um valor � vari�vel numConta
		String cpf = "30914060506"; // declara��o e inicializa��o da vari�vel
		umaConta = new ContaSimples(nome, cpf, numConta);
		// manuseio da conta
		umaConta.depositar(grana);
		umaConta.depositar(2 * grana);
		// comando grande espalhado em 3 linhas
		System.out.println("Saldo da conta de " + umaConta.getNome() + ": "
				+ umaConta.getSaldoMonet�rio());
	} // main
} // Banco3
