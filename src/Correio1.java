/*
 * Correio Eletrônico simples. Programa principal.
 */
import p1.aplic.correio.*;

public class Correio1 {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Sintaxe: java Correio1 nome");
			System.exit(1);
		}
		CorreioIU1 ciu = new CorreioIU1(args[0]);
		ciu.interfaceComUsuário();
	}
}
