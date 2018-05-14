/*
 * Polimorfismo. Programa principal.
 */
import p1.aplic.correio.*;

public class Correio2 {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Sintaxe: java Correio2 nome");
			System.exit(1);
		}
		CorreioIU2 ciu = new CorreioIU2(args[0]);
		ciu.interfaceComUsuário();
	}
}
