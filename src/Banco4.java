/*
 * Uso de objetos de várias classes, entrada de dados
 */

import p1.aplic.banco.*;
import p1.aplic.geral.*; // para mexer com a classe Pessoa
import p1.io.*; // para fazer entrada de dados

public class Banco4 {
	public static void main(String args[]) {
		// declaração de variáveis de 2 classes (tipos) diferentes
		// no fim, teremos 4 objetos de 2 classes
		Pessoa oTitular1, oTitular2;
		ContaSimples umaConta, outraConta;

		// tempo de vida: os objetos ainda nao existem
		// a seguinte linha daria erro:
		// umaConta.depositar(1000.0);

		// cria dois objetos Pessoa com nome e CPF
		oTitular1 = new Pessoa("Joao", "30914060506");
		oTitular2 = new Pessoa("Ana", "12345678901");

		// cria as duas contas
		// Observe que ContaSimples pode ser criada com um titular
		// do tipo Pessoa em vez de dar nome e CPF separadamente
		umaConta = new ContaSimples(oTitular1, 1);
		outraConta = new ContaSimples(oTitular2, 2);

		// Vamos ver quanto vamos depositar
		double valorADepositar = Entrada.in
				.lerdouble("Entre com o valor a depositar: ");
		System.out.println("Vou depositar " + valorADepositar);
		umaConta.depositar(valorADepositar);

		// Vamos ver quanto vamos transferir
		double valorATransferir = Entrada.in
				.lerdouble("Entre com o valor a transferir: ");
		System.out.println("Vou transferir " + valorATransferir);
		umaConta.transferir(outraConta, valorATransferir);

		// Fecha a agencia e guarda toda a informação em arquivo
		Agencia.fecharCaixa();
		System.out.println("OK. Caixa fechado.");
	} // main
} // Banco4
