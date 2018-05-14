/*
 * Operadores aritméticos simples com o tipo double
 */

// Observe a ausência de comando "import" aqui
public class Oper1 {
	public static void main(String args[]) {
		double d1;
		double d2, d3; // duas declarações no mesmo comando

		System.out.println("Teste de operadores simples com double");
		d1 = 3.0; // 3.0 é uma constante double
		d2 = 7.0;
		d3 = d1 + d2;
		System.out.println(d1 + " + " + d2 + " = " + d3);
		d3 = d1 - 7.0;
		System.out.println(d1 + " - 7.0" + " = " + d3);
		System.out.println(d1 + " * " + d2 + " = " + d1 * d2);
		d3 = d1 / d2;
		System.out.println(d1 + " / " + d2 + " = " + d3);
	} // main
} // Oper1
