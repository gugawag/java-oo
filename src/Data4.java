/*
 * Array de valores
 */

import p1.aplic.geral.*;

public class Data4 {
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
		String[] nomeDoMês = { "", "janeiro", "favereiro", "marco", "abril",
				"maio", "junho", "julho", "agosto", "setembro", "outubro",
				"novembro", "dezembro" };
		if (mês <= 0 || mês > 12) {
			System.err.println("Mes errado (numero " + mês + ")");
			System.exit(1);
		}
		System.out.println(dia + " de " + nomeDoMês[mês] + " de " + ano);
	} // main
} // Data4
