/*
 * Expressão booleana
 */

import p1.aplic.geral.*;

public class Data2 {
	public static void main(String args[]) {
		int dia = 0;
		int mês = 0;
		int ano = 0;
		Data data = null;

		if (args.length == 0) {
			data = new Data();
			dia = data.getDia();
			mês = data.getMes() + 1;
			ano = data.getAno();
		} else if (args.length == 3) {
			dia = Integer.parseInt(args[0]);
			mês = Integer.parseInt(args[1]);
			ano = Integer.parseInt(args[2]);
			data = new Data(dia, mês, ano);
		} else {
			// Erro de sintaxe de comando
			System.err.println("Sintaxe: java Data1 [dia mes ano]");
			System.exit(1);
		}
		int diaDaSemana = data.getDiaDaSemana();
		boolean fimDeSemana = diaDaSemana == Data.SÁBADO
				|| diaDaSemana == Data.DOMINGO;
		System.out.println(dia + " de " + mês + " de " + ano
				+ (fimDeSemana ? " (Fim de Semana!)" : ""));
	} // main
} // Data2
