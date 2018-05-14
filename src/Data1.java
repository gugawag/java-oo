/*
 * Tomada de decisão múltipla e tratamento de erro
 * Ver a documento javadoc da classe p1.aplic.geral.Data
 */

import p1.aplic.geral.*;

public class Data1 {
	public static void main(String args[]) {
		int dia = 0;
		int mês = 0;
		int ano = 0;

		if (args.length == 0) {
			Data hoje = new Data();
			dia = hoje.getDia();
			mês = hoje.getMes() + 1;
			ano = hoje.getAno();
		} else if (args.length == 3) {
			dia = Integer.parseInt(args[0]);
			mês = Integer.parseInt(args[1]);
			ano = Integer.parseInt(args[2]);
		} else {
			// Erro de sintaxe de comando
			System.err.println("Sintaxe: java Data1 [dia mes ano]");
			System.exit(1);
		}
		System.out.println(dia + " de " + mês + " de " + ano);
	} // main
} // Data1
