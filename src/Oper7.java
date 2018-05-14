/*
 * Conversão automática entre tipos "nativos"
 */

public class Oper7 {
	public static void main(String args[]) {

		System.out.println("Testes de conversao");
		int i = 3;
		double d = 4.2;
		String s = "alo";
		System.out.println("double ganha de int: " + i + " + " + d + " = "
				+ (i + d));
		// conversão ocorre fora do println também
		double resultado = i + d; // int é "promovido" a double
		System.out.println("double ganha de int: " + i + " + " + d + " = "
				+ resultado);
		System.out.println("string ganha de int: " + i + " + " + s + " = "
				+ (i + s));
		System.out.println("string ganha de double: " + d + " + " + s + " = "
				+ (d + s));
		System.out.println("string ganha de int e double: " + d + " + " + s
				+ " + " + i + " = " + (d + s + i));
	} // main
} // Oper7
