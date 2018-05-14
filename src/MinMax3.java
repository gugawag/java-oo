/*
 * "Ler 3 n�meros inteiros da entrada, imprimir o menor e o maior"
 *
 * Autor: Jacques Sauv�
 */

import p1.io.*;

public class MinMax3 {
	public static void main(String[] args) {
		int num;
		int m�nimo = Integer.MAX_VALUE;
		int m�ximo = Integer.MIN_VALUE;

		num = Entrada.in.lerInt("Entre com o primeiro inteiro: ");
		if (num < m�nimo) {
			m�nimo = num;
		}
		if (num > m�ximo) {
			m�ximo = num;
		}

		num = Entrada.in.lerInt("Entre com o segundo inteiro: ");
		if (num < m�nimo) {
			m�nimo = num;
		}
		if (num > m�ximo) {
			m�ximo = num;
		}

		num = Entrada.in.lerInt("Entre com o terceiro inteiro: ");
		if (num < m�nimo) {
			m�nimo = num;
		}
		if (num > m�ximo) {
			m�ximo = num;
		}

		System.out.println("O menor numero eh: " + m�nimo);
		System.out.println("O maior numero eh: " + m�ximo);
	}
}