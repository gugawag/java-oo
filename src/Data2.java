/*
 * Express�o booleana
 */

import p1.aplic.geral.*;

public class Data2 {
	public static void main(String args[]) {
		int dia = 0;
		int m�s = 0;
		int ano = 0;
		Data data = null;

		if (args.length == 0) {
			data = new Data();
			dia = data.getDia();
			m�s = data.getMes() + 1;
			ano = data.getAno();
		} else if (args.length == 3) {
			dia = Integer.parseInt(args[0]);
			m�s = Integer.parseInt(args[1]);
			ano = Integer.parseInt(args[2]);
			data = new Data(dia, m�s, ano);
		} else {
			// Erro de sintaxe de comando
			System.err.println("Sintaxe: java Data1 [dia mes ano]");
			System.exit(1);
		}
		int diaDaSemana = data.getDiaDaSemana();
		boolean fimDeSemana = diaDaSemana == Data.S�BADO
				|| diaDaSemana == Data.DOMINGO;
		System.out.println(dia + " de " + m�s + " de " + ano
				+ (fimDeSemana ? " (Fim de Semana!)" : ""));
	} // main
} // Data2
