/*
 * Tomada de decisão, usando if-else
 */

import p1.aplic.banco.*;
import p1.aplic.geral.*;// para mexer com a classe Pessoa
import p1.io.*; // para fazer entrada de dados

public class Banco7 {
	public static void main(String args[]) {
		Pessoa oTitular;
		ContaSimples umaConta;

		oTitular = new Pessoa("Joao", "309140605-06");
		umaConta = new ContaSimples(oTitular, 10);
		double valorADepositar = Entrada.in
				.lerdouble("Entre com o valor a depositar: ");
		if (valorADepositar <= 0.0) {
			System.err.println("Valor a depositar deve ser positivo. "
					+ "Encerrando programa.");
		} else {
			System.out.println("Vou depositar " + valorADepositar);
			umaConta.depositar(valorADepositar);

			// Vamos ver quanto vamos transferir
			double valorASacar = Entrada.in
					.lerdouble("Entre com o valor a sacar: ");
			double saldo = umaConta.getSaldo();
			if (valorASacar > saldo) {
				System.err.println("Saldo eh apenas " + saldo
						+ ". Saque nao realizado. Encerrando programa.");
			} else {
				System.out.println("Vou sacar " + valorASacar);
				umaConta.sacar(valorASacar);
			}
		}
	} // main
} // Banco7
