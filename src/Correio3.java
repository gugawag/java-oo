/*
 * Mais polimorfismo. Programa principal.
 */
import p1.aplic.correio.*;

public class Correio3 {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Sintaxe: java Correio3 nome");
			System.exit(1);
		}
		CorreioIU3 ciu = new CorreioIU3(args[0]);
		ciu.interfaceComUsuário();
	}
}
