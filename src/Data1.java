/*
 * Tomada de decis�o m�ltipla e tratamento de erro
 * Ver a documento javadoc da classe p1.aplic.geral.Data
 */

import p1.aplic.geral.*;

public class Data1 {
	public static void main(String args[]) {
		int dia = 0;
		int m�s = 0;
		int ano = 0;

		if (args.length == 0) {
			Data hoje = new Data();
			dia = hoje.getDia();
			m�s = hoje.getMes() + 1;
			ano = hoje.getAno();
		} else if (args.length == 3) {
			dia = Integer.parseInt(args[0]);
			m�s = Integer.parseInt(args[1]);
			ano = Integer.parseInt(args[2]);
		} else {
			// Erro de sintaxe de comando
			System.err.println("Sintaxe: java Data1 [dia mes ano]");
			System.exit(1);
		}
		System.out.println(dia + " de " + m�s + " de " + ano);
	} // main
} // Data1
