/*
 * Operadores aritméticos simples com o tipo int
 */

public class Oper2 {
	public static void main(String args[]) {
		int i1, i2, i3;

		System.out.println("Teste de operadores simples com int");
		i1 = 3; // 3 é uma constante inteira (int)
		i2 = 7;
		i3 = i1 + i2;
		System.out.println(i1 + " + " + i2 + " = " + i3);
		i3 = i1 - 4;
		System.out.println(i1 + " - 4" + " = " + i3);
		System.out.println(i1 + " * " + i2 + " = " + i1 * i2);
		i3 = i1 / i2;
		System.out.println(i1 + " / " + i2 + " = " + i3);
		i3 = i2 / i1;
		System.out.println(i2 + " / " + i1 + " = " + i3);
		i3 = i2 % i1;
		System.out.println(i2 + " % " + i1 + " = " + i3);
	} // main
} // Oper2
