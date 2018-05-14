/*
 * "Ler 3 números inteiros da entrada, imprimir o menor e o maior"
 *
 * Autor: Jacques Sauvé
 */

import p1.io.*;

public class MinMax2 {
	public static void main(String[] args) {
		int n1, n2, n3;

		n1 = Entrada.in.lerInt("Entre com o primeiro inteiro: ");
		n2 = Entrada.in.lerInt("Entre com o segundo inteiro: ");
		n3 = Entrada.in.lerInt("Entre com o terceiro inteiro: ");

		int mínimo;
		int máximo;
		if (n1 > n2) {
			if (n1 > n3) {
				if (n2 < n3) {
					mínimo = n2;
				} else {
					mínimo = n3;
				}
				máximo = n1;
			} else {
				if (n1 < n2) {
					mínimo = n1;
				} else {
					mínimo = n2;
				}
				máximo = n3;
			}
		} else {
			if (n2 > n3) {
				if (n1 < n3) {
					mínimo = n1;
				} else {
					mínimo = n3;
				}
				máximo = n2;
			} else {
				if (n1 < n2) {
					mínimo = n1;
				} else {
					mínimo = n3;
				}
				máximo = n3;
			}
		}
		System.out.println("O menor numero eh: " + mínimo);
		System.out.println("O maior numero eh: " + máximo);
	}
}