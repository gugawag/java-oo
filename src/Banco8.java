/*
 * La�o: leitura/processamento (at� um marcador final)
 */

import p1.aplic.banco.ContaSimples;
import p1.io.Entrada;

public class Banco8 {
	public static void main(String args[]) {
		final int DEPOSITAR = 1;
		final int SACAR = 2;
		final int SALDO = 3;
		final int SAIR = 4;
		// o caractere de fim de linha pode ser diferente de um sistema para
		// outro
		// exemplo: "\r\n" no MSDOS/Windows, "\n" no UNIX, "\r" no MacIntosh.
		// etc.
		final String fimDeLinha = System.getProperty("line.separator");
		final String prompt = "Digite a opcao desejada:" + fimDeLinha
				+ DEPOSITAR + ". Depositar" + fimDeLinha + SACAR + ". Sacar"
				+ fimDeLinha + SALDO + ". Saldo" + fimDeLinha + SAIR + ". Sair"
				+ fimDeLinha + "Opcao: ";
		if (args.length != 3) {
			System.err
					.println("Sintaxe: java Banco8 titular cpf numeroDaConta");
			System.exit(1);
		}
		ContaSimples aConta = new ContaSimples(args[0], args[1], Integer
				.parseInt(args[2]));

		int op��o = Entrada.in.lerInt(prompt);
		while (op��o != SAIR) {
			switch (op��o) {
			case DEPOSITAR:
				double valorADepositar = Entrada.in
						.lerdouble("Entre com o valor a depositar: ");
				aConta.depositar(valorADepositar);
				break;
			case SACAR:
				double valorASacar = Entrada.in
						.lerdouble("Entre com o valor a sacar: ");
				aConta.sacar(valorASacar);
				break;
			case SALDO:
				System.out.println("Saldo: " + aConta.getSaldoMonet�rio());
				break;
			default:
				System.err.println("Opcao " + op��o + " desconhecida");
				break;
			}
			// leia novamente para voltar ao in�cio do la�o
			op��o = Entrada.in.lerInt(prompt);
		}
		System.out.println("Saldo final: " + aConta.getSaldoMonet�rio());
	} // main
} // Banco8
