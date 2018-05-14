/*
 * Uso de arrays, verificação de overflow de array
 */

import p1.io.*;
import java.util.*;

public class Cadastro2 {
	public static void main(String[] args) {
		final int MAX_PESSOAS = 10;
		final String prompt = "Digite o nome de uma pessoa: ";

		String[] cadastro = new String[MAX_PESSOAS];
		String nome;
		// entrada dos dados de cadastro
		int numPessoas = 0;
		while ((nome = Entrada.in.lerLinha(prompt)) != null) {
			if (numPessoas < MAX_PESSOAS) {
				cadastro[numPessoas++] = nome;
			} else {
				System.err.println("Tem dados demais " + "(max de "
						+ MAX_PESSOAS + "). " + nome + " nao foi cadastrado.");
			}
		}

		// imprime o cadastro antes da ordenação
		System.out.println();
		for (int i = 0; i < numPessoas; i++) {
			System.out.println(cadastro[i]);
		}

		// para ordenar, o array tem que estar "cheio"
		// portanto, transfira o cadastro para outro array
		// do tamanho exato do cadastro
		String[] cadOrdenado = new String[numPessoas];
		for (int i = 0; i < numPessoas; i++) {
			cadOrdenado[i] = cadastro[i];
		}
		// ordena o cadastro
		Arrays.sort(cadOrdenado);

		// imprime o cadastro ordenado
		System.out.println();
		for (int i = 0; i < numPessoas; i++) {
			System.out.println(cadOrdenado[i]);
		}
	} // main
} // Cadastro2
