/*
 * "Ler 3 n�meros inteiros da entrada, imprimir o menor e o maior"
 *
 * Autor: Jacques Sauv�
 */

import p1.io.*;

public class MinMax2 {
	public static void main(String[] args) {
		int n1, n2, n3;

		n1 = Entrada.in.lerInt("Entre com o primeiro inteiro: ");
		n2 = Entrada.in.lerInt("Entre com o segundo inteiro: ");
		n3 = Entrada.in.lerInt("Entre com o terceiro inteiro: ");

		int m�nimo;
		int m�ximo;
		if (n1 > n2) {
			if (n1 > n3) {
				if (n2 < n3) {
					m�nimo = n2;
				} else {
					m�nimo = n3;
				}
				m�ximo = n1;
			} else {
				if (n1 < n2) {
					m�nimo = n1;
				} else {
					m�nimo = n2;
				}
				m�ximo = n3;
			}
		} else {
			if (n2 > n3) {
				if (n1 < n3) {
					m�nimo = n1;
				} else {
					m�nimo = n3;
				}
				m�ximo = n2;
			} else {
				if (n1 < n2) {
					m�nimo = n1;
				} else {
					m�nimo = n3;
				}
				m�ximo = n3;
			}
		}
		System.out.println("O menor numero eh: " + m�nimo);
		System.out.println("O maior numero eh: " + m�ximo);
	}
}