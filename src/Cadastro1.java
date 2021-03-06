/*
 * Uso de arrays
 */

import p1.io.*;
import java.util.*;

public class Cadastro1 {
	public static void main(String[] args) {
		final int MAX_PESSOAS = 10;
		final String prompt = "Digite o nome de uma pessoa: ";

		String[] cadastro = new String[MAX_PESSOAS];
		String nome;
		// entrada dos dados de cadastro
		int numPessoas = 0;
		while ((nome = Entrada.in.lerLinha(prompt)) != null) {
			cadastro[numPessoas++] = nome;
		}

		// imprime o cadastro antes da ordena��o
		System.out.println();
		for (int i = 0; i < numPessoas; i++) {
			System.out.println(cadastro[i]);
		}

		// ordena o cadastro
		String[] cadOrdenado = new String[numPessoas];
		for (int i = 0; i < numPessoas; i++) {
			cadOrdenado[i] = cadastro[i];
		}
		Arrays.sort(cadOrdenado);

		// imprime o cadastro ordenado
		System.out.println();
		for (int i = 0; i < numPessoas; i++) {
			System.out.println(cadOrdenado[i]);
		}
	} // main
} // Cadastro1
