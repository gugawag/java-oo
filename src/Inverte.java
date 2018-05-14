/*
 * Ler 10 números inteiros da entrada, imprimir em ordem inversa
 *
 * Autor: Jacques Sauvé
 */

import p1.io.*;

public class Inverte {
	public static void main(String[] args) {
		final int NÚMEROS_A_LER = 10;
		int[] números = new int[NÚMEROS_A_LER]; // criação do array de 10
												// inteiros

		for (int i = 0; i < números.length; i++) {
			números[i] = Entrada.in.lerInt("Entre com o proximo inteiro: ");
		}
		for (int i = números.length - 1; i >= 0; i--) {
			System.out.println(números[i]);
		}
	}
}