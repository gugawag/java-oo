// interface com o usuário para um sisteminha de correio eletrônico
// a classe ainda não faz parte do package p1.aplic.correio
import p1.aplic.correio.CaixaPostal;
import p1.io.Entrada;

public class CorreioIUTemp1 {
	private CaixaPostal caixa;

	public CorreioIUTemp1(String titular) {
		caixa = new CaixaPostal(titular);
	}

	public void interfaceComUsuário() {
		while (true) {
			System.out.println("Resumo da caixa postal para o usuario");
			String cmd = Entrada.in
					.lerLinha("exibir, enviar, excluir, +, -, quit? ");
			if (cmd.startsWith("exi")) {
				System.out.println("Exibicao de mensagem");
			} else if (cmd.startsWith("en")) {
				// obtem dados (destinatário, assunto, texto da mensagem)
				// criar uma nova mensagem com esses dados
				// armazenar a mensagem na caixa postal do destinatário
				System.out.println("Envio de nova mensagem");
			} else if (cmd.startsWith("exc")) {
				System.out.println("Exclusao de mensagem");
			} else if (cmd.startsWith("+")) {
				System.out.println("Avanca para proxima mensagem");
			} else if (cmd.startsWith("-")) {
				System.out.println("Recua para mensagem anterior");
			} else if (cmd.startsWith("q")) {
				cmd = Entrada.in.lerLinha("Salvar CaixaPostal? ");
				if (cmd.startsWith("s")) {
					System.out.println("Salvamento da caixa postal");
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
			System.err.println("Sintaxe: java CorreioIUTemp1 nome");
			System.exit(1);
		}
		CorreioIUTemp1 ciu = new CorreioIUTemp1(args[0]);
		ciu.interfaceComUsuário();
	}
}
