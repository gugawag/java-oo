/*
 * Switch
 */

import p1.aplic.geral.*;

public class Data3 {
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
		String nomeDoMês = "";
		switch (mês) {
		case 1:
			nomeDoMês = "janeiro";
			break;
		case 2:
			nomeDoMês = "favereiro";
			break;
		case 3:
			nomeDoMês = "marco";
			break;
		case 4:
			nomeDoMês = "abril";
			break;
		case 5:
			nomeDoMês = "maio";
			break;
		case 6:
			nomeDoMês = "junho";
			break;
		case 7:
			nomeDoMês = "julho";
			break;
		case 8:
			nomeDoMês = "agosto";
			break;
		case 9:
			nomeDoMês = "setembro";
			break;
		case 10:
			nomeDoMês = "outubro";
			break;
		case 11:
			nomeDoMês = "novembro";
			break;
		case 12:
			nomeDoMês = "dezembro";
			break;
		default:
			System.err.println("Mes errado (numero " + mês + ")");
			System.exit(1);
			break;
		}
		System.out.println(dia + " de " + nomeDoMês + " de " + ano);
	} // main
} // Data3
