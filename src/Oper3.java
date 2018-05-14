/*
 * Precedência de alguns operadores aritméticos
 */

public class Oper3 {
	public static void main(String args[]) {

		System.out.println("Teste de precedencia");
		int i = 3 + 7 * 4;
		System.out.println("3+7*4 = " + i);
		i = (3 + 7) * 4;
		System.out.println("(3+7)*4 = " + i);
	} // main
} // Oper3
