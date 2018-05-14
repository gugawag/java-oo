/*
 * "Ler 3 n�meros inteiros da entrada, imprimir o menor e o maior"
 *
 * Autor: Jacques Sauv�
 */

import p1.io.*;

public class MinMax4 {
	public static void main(String[] args) {
		final int N�MEROS_A_LER = 3;
		int m�nimo = Integer.MAX_VALUE;
		int m�ximo = Integer.MIN_VALUE;

		for (int i = 0; i < N�MEROS_A_LER; i++) {
			int num = Entrada.in.lerInt("Entre com o proximo inteiro: ");
			if (num < m�nimo) {
				m�nimo = num;
			}
			if (num > m�ximo) {
				m�ximo = num;
			}
		}

		System.out.println("O menor numero eh: " + m�nimo);
		System.out.println("O maior numero eh: " + m�ximo);
	}
}