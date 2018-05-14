/*
 * Cadastro com ArrayList em vez de array.
 * Mostra como ArrayList é essencialmente um array que cresce sob demanda.
 */

import p1.io.*;
import java.util.*;

public class Cadastro3 {
	public static void main(String[] args) {
		final String prompt = "Digite o nome de uma pessoa: ";

		List cadastro = new ArrayList();
		String nome;
		// entrada dos dados de cadastro
		while ((nome = Entrada.in.lerLinha(prompt)) != null) {
			cadastro.add(nome);
		}

		// imprime o cadastro antes da ordenação
		// (deveria usar um iterador, mas queremos mostrar
		// como o ArrayList é semelhante a um array)
		System.out.println();
		for (int i = 0; i < cadastro.size(); i++) {
			System.out.println(cadastro.get(i));
		}

		// ordena o cadastro
		Collections.sort(cadastro);

		// imprime o cadastro ordenado
		System.out.println();
		for (int i = 0; i < cadastro.size(); i++) {
			System.out.println(cadastro.get(i));
		}
	} // main
} // Cadastro3
