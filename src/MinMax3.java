/*
 * "Ler 3 números inteiros da entrada, imprimir o menor e o maior"
 *
 * Autor: Jacques Sauvé
 */

import p1.io.*;

public class MinMax3 {
	public static void main(String[] args) {
		int num;
		int mínimo = Integer.MAX_VALUE;
		int máximo = Integer.MIN_VALUE;

		num = Entrada.in.lerInt("Entre com o primeiro inteiro: ");
		if (num < mínimo) {
			mínimo = num;
		}
		if (num > máximo) {
			máximo = num;
		}

		num = Entrada.in.lerInt("Entre com o segundo inteiro: ");
		if (num < mínimo) {
			mínimo = num;
		}
		if (num > máximo) {
			máximo = num;
		}

		num = Entrada.in.lerInt("Entre com o terceiro inteiro: ");
		if (num < mínimo) {
			mínimo = num;
		}
		if (num > máximo) {
			máximo = num;
		}

		System.out.println("O menor numero eh: " + mínimo);
		System.out.println("O maior numero eh: " + máximo);
	}
}