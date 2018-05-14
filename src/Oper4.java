/*
 * A manipula��o de strings.
 *
 * Observe que a concatena��o usa o mesmo s�mbolo da adi��o
 * e a mesma sintaxe (um operador de cada lado)
 * mas o significado (a sem�ntica) � diferente
 */

public class Oper4 {
	public static void main(String args[]) {

		System.out.println("\"Somar\" strings significa \"concatenar\"");
		String s = "alo " + "mamae";
		System.out.println("alo + mamae = " + s);

		// Extra��o de sub-cadeias
		System.out.println(s.substring(1, 6));
		System.out.println(s.substring(0, 3) + "*" + s.substring(4));
	} // main
} // Oper4
