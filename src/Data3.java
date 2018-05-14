/*
 * Switch
 */

import p1.aplic.geral.*;

public class Data3 {
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
		String nomeDoM�s = "";
		switch (m�s) {
		case 1:
			nomeDoM�s = "janeiro";
			break;
		case 2:
			nomeDoM�s = "favereiro";
			break;
		case 3:
			nomeDoM�s = "marco";
			break;
		case 4:
			nomeDoM�s = "abril";
			break;
		case 5:
			nomeDoM�s = "maio";
			break;
		case 6:
			nomeDoM�s = "junho";
			break;
		case 7:
			nomeDoM�s = "julho";
			break;
		case 8:
			nomeDoM�s = "agosto";
			break;
		case 9:
			nomeDoM�s = "setembro";
			break;
		case 10:
			nomeDoM�s = "outubro";
			break;
		case 11:
			nomeDoM�s = "novembro";
			break;
		case 12:
			nomeDoM�s = "dezembro";
			break;
		default:
			System.err.println("Mes errado (numero " + m�s + ")");
			System.exit(1);
			break;
		}
		System.out.println(dia + " de " + nomeDoM�s + " de " + ano);
	} // main
} // Data3
