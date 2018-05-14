/*
 * "Ler 3 números inteiros da entrada, imprimir o menor e o maior"
 *
 * Autor: Jacques Sauvé
 */

import p1.io.*;

public class MinMax1 {
	public static void main(String[] args) {
		int n1, n2, n3;

		n1 = Entrada.in.lerInt("Entre com o primeiro inteiro: ");
		n2 = Entrada.in.lerInt("Entre com o segundo inteiro: ");
		n3 = Entrada.in.lerInt("Entre com o terceiro inteiro: ");
		if (n1 > n2) {
			if (n1 > n3) {
				if (n2 < n3) {
					System.out.println("O menor numero eh: " + n2);
				} else {
					System.out.println("O menor numero eh: " + n3);
				}
				System.out.println("O maior numero eh: " + n1);
			} else {
				if (n1 < n2) {
					System.out.println("O menor numero eh: " + n1);
				} else {
					System.out.println("O menor numero eh: " + n2);
				}
				System.out.println("O maior numero eh: " + n3);
			}
		} else {
			if (n2 > n3) {
				if (n1 < n3) {
					System.out.println("O menor numero eh: " + n1);
				} else {
					System.out.println("O menor numero eh: " + n3);
				}
				System.out.println("O maior numero eh: " + n2);
			} else {
				if (n1 < n2) {
					System.out.println("O menor numero eh: " + n1);
				} else {
					System.out.println("O menor numero eh: " + n2);
				}
				System.out.println("O maior numero eh: " + n3);
			}
		}
	}
}
