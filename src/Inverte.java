/*
 * Ler 10 n�meros inteiros da entrada, imprimir em ordem inversa
 *
 * Autor: Jacques Sauv�
 */

import p1.io.*;

public class Inverte {
	public static void main(String[] args) {
		final int N�MEROS_A_LER = 10;
		int[] n�meros = new int[N�MEROS_A_LER]; // cria��o do array de 10
												// inteiros

		for (int i = 0; i < n�meros.length; i++) {
			n�meros[i] = Entrada.in.lerInt("Entre com o proximo inteiro: ");
		}
		for (int i = n�meros.length - 1; i >= 0; i--) {
			System.out.println(n�meros[i]);
		}
	}
}