/*
 * La�o: leitura/processamento (at� o fim da entrada)
 * Esta solu��o � prefer�vel a Banco8.java porque Banco8.java
 * n�o trata o fim da entrada
 */

import p1.aplic.banco.Conta;
import p1.aplic.banco.ContaSimples;
import p1.io.Entrada;

public class Banco9 {
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
					.println("Sintaxe: java Banco9 titular cpf numeroDaConta");
			System.exit(1);
		}
		Conta aConta = new ContaSimples(args[0], args[1], Integer
				.parseInt(args[2]));

		String entrada = Entrada.in.lerLinha(prompt);
		int op��o;
		// curto circuito � importante aqui!
		while (entrada != null && (op��o = Integer.parseInt(entrada)) != SAIR) {
			switch (op��o) {
			case DEPOSITAR:
				entrada = Entrada.in
						.lerLinha("Entre com o valor a depositar: ");
				double valorADepositar = Double.parseDouble(entrada);
				aConta.depositar(valorADepositar);
				break;
			case SACAR:
				entrada = Entrada.in.lerLinha("Entre com o valor a sacar: ");
				double valorASacar = Double.parseDouble(entrada);
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
			entrada = Entrada.in.lerLinha(prompt);
		}
		System.out.println("Saldo final: " + aConta.getSaldoMonet�rio());
	} // main
} // Banco9
