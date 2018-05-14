/*
 * Declaração e uso de tipos básicos e variáveis
 */

import p1.aplic.banco.*;

public class Banco3 {
	public static void main(String args[]) {
		int numConta; // um inteiro, não inicializado
		String nome = "Joao"; // um string, inicializado
		double grana = 1000.0; // um double, inicializado
		ContaSimples umaConta; // uma referência a um objeto, não inicializada

		// Abra uma conta
		numConta = 1; // atribui um valor à variável numConta
		String cpf = "30914060506"; // declaração e inicialização da variável
		umaConta = new ContaSimples(nome, cpf, numConta);
		// manuseio da conta
		umaConta.depositar(grana);
		umaConta.depositar(2 * grana);
		// comando grande espalhado em 3 linhas
		System.out.println("Saldo da conta de " + umaConta.getNome() + ": "
				+ umaConta.getSaldoMonetário());
	} // main
} // Banco3
