/*
 * "Ler 3 números inteiros da entrada, imprimir o menor e o maior"
 *
 * Autor: Jacques Sauvé
 */

import p1.io.*;

public class MinMax4 {
	public static void main(String[] args) {
		final int NÚMEROS_A_LER = 3;
		int mínimo = Integer.MAX_VALUE;
		int máximo = Integer.MIN_VALUE;

		for (int i = 0; i < NÚMEROS_A_LER; i++) {
			int num = Entrada.in.lerInt("Entre com o proximo inteiro: ");
			if (num < mínimo) {
				mínimo = num;
			}
			if (num > máximo) {
				máximo = num;
			}
		}

		System.out.println("O menor numero eh: " + mínimo);
		System.out.println("O maior numero eh: " + máximo);
	}
}