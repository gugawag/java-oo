// interface com o usuário para um sisteminha de correio eletrônico
// a classe ainda não faz parte do package p1.aplic.correio
import p1.aplic.correio.*;
import p1.io.*;

public class CorreioIUTemp2 {
	private CaixaPostal caixa;

	public CorreioIUTemp2(String titular) {
		caixa = new CaixaPostal(titular);
	}

	public void interfaceComUsuário() {
		while (true) {
			System.out.println("Resumo da caixa postal para o usuario");
			String cmd = Entrada.in
					.lerLinha("exibir, enviar, excluir, +, -, quit? ");
			if (cmd.startsWith("exi")) {
				p1.aplic.correio.Mensagem m = caixa.mensagemCorrente();
				if (m != null) {
					m.exibir();
				}
			} else if (cmd.startsWith("en")) {
				// obtem dados (destinatário, assunto, texto da mensagem)
				// criar uma nova mensagem com esses dados
				// armazenar a mensagem na caixa postal do destinatário
				System.out.println("Envio de nova mensagem");
			} else if (cmd.startsWith("exc")) {
				caixa.excluir();
			} else if (cmd.startsWith("+")) {
				caixa.avançar();
			} else if (cmd.startsWith("-")) {
				caixa.recuar();
			} else if (cmd.startsWith("q")) {
				cmd = Entrada.in.lerLinha("Salvar CaixaPostal? ");
				if (cmd.startsWith("s")) {
					caixa.salvar();
				}
				break;
			} else {
				System.out.println("Comando <" + cmd + "> desconhecido");
			}
		}
	}

	// um mainzinho para testar
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Sintaxe: java CorreioIUTemp2 nome");
			System.exit(1);
		}
		CorreioIUTemp2 ciu = new CorreioIUTemp2(args[0]);
		ciu.interfaceComUsuário();
	}
}
