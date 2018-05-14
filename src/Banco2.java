/*
 * Movimentação simples de duas contas bancárias
 */

import p1.aplic.banco.*; // para poder manusear contas bancárias

public class Banco2 {
	public static void main(String args[]) {
		// Abra uma conta de número 1 para João com CPF 309140605-06
		// A conta será "referenciada" com a variável umaConta
		ContaSimples umaConta = new ContaSimples("Joao", "30914060506", 1);
		// Nesta conta, deposite R$1000,00
		umaConta.depositar(1000.0);

		// Abra uma conta de número 2 para Ana com CPF 123456789-01
		// A conta será "referenciada" com a variável outraConta
		ContaSimples outraConta = new ContaSimples("Ana", "12345678901", 2);
		// Transfira R$400,00 da conta de João para a conta de Ana
		umaConta.transferir(outraConta, 400.0);

		// Imprima o saldo da conta de João
		double saldo = umaConta.getSaldo();
		System.out.print("Saldo da conta de Joao: ");
		System.out.println(saldo);

		// Imprima o saldo da conta de Ana
		System.out.println("Saldo da conta de Ana: " + outraConta.getSaldo());
		// Imprima o saldo da conta de Ana, novamente, com outro método
		System.out.println("Saldo da conta de Ana: "
				+ outraConta.getSaldoMonetário());

		// Impressao dos objetos
		System.out.println("Situacao da primeira conta: ");
		System.out.println(umaConta);
		System.out.println("Situacao da segunda conta: ");
		System.out.println(outraConta);
	} // fim do método main
} // fim da classe Banco2
