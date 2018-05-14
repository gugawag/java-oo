/*
 * Uso de break
 */

import java.util.ArrayList;
import java.util.List;

import p1.aplic.geral.Pessoa;
import p1.io.Entrada;

public class Pesquisa2 {
	public static void main(String[] args) {
		final String prompt1 = "Digite o nome de uma pessoa (\"fim\" para terminar): ";
		final String prompt2 = "Digite o CPF dessa pessoa: ";
		final String prompt3 = "Digite o CPF a pesquisar (\"fim\" para terminar): ";
		List cadastro;
		String nome;
		String cpf;

		cadastro = new ArrayList();

		// entrada dos dados de cadastro
		while ((nome = Entrada.in.lerLinha(prompt1)) != null
				&& !nome.equals("fim")) {
			cpf = Entrada.in.lerLinha(prompt2);
			if (cpf != null) {
				cadastro.add(new Pessoa(nome, cpf));
			}
		} // while

		// pesquisa de dados por cpf
		// observe o aninhamento de laços
		// Seria possivel usar o método indexOf de List, mas
		// queremos mostrar como fazer pesquisa sequencial numa List
		while ((cpf = Entrada.in.lerLinha(prompt3)) != null
				&& !cpf.equals("fim")) {
			Pessoa p = null;
			for (int i = 0; i < cadastro.size(); i++) {
				p = (Pessoa) cadastro.get(i);
				if (p.getCPF().equals(cpf)) {
					System.out.println(p.getNome());
					break; // cai fora do laço de pesquisa
				}
			} // for
			if (p == null || !p.getCPF().equals(cpf)) {
				System.out.println("Nao achei CPF " + cpf + " no cadastro.");
			}
		} // while
	} // main
} // Pesquisa2
