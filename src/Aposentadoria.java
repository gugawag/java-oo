/*
 * Planejamento de aposentadoria
 *
 * Autor: Jacques Sauvé (roubado de CoreJava)
 */

import p1.io.*;

public class Aposentadoria {
	public static void main(String[] args) {
		double alvo;
		double juros;
		double contribuição;
		int anos = 0;
		double saldo = 0;

		alvo = Entrada.in
				.lerdouble("Quanto dinheiro voce quer para se aposentar?");
		contribuição = Entrada.in
				.lerdouble("Quanto dinheiro voce vai contribuir todo ano?");
		juros = Entrada.in
				.lerdouble("Taxa de juros em % (exemplo: digite 7.5 para 7.5%): ") / 100;

		while (saldo < alvo) {
			saldo = (saldo + contribuição) * (1 + juros);
			anos++;
		}

		System.out.println("Voce pode se aposentar em " + anos + " anos.");
	}
}