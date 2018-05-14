// interface com o usuário para um sisteminha de correio eletrônico
// a classe ainda não faz parte do package p1.aplic.correio
import p1.aplic.correio.*;
import p1.io.*;
import java.util.*;

public class CorreioIUTemp3 {
	private CaixaPostal caixa;

	public CorreioIUTemp3(String titular) {
		caixa = new CaixaPostal(titular);
	}

	public void interfaceComUsuário() {
		while (true) {
			mostraResumoCaixaPostal(caixa);
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

	// Observe que este método *não* é public
	void mostraResumoCaixaPostal(CaixaPostal caixa) {
		final String separador = "---------------------------------------------------------------------";
		Iterator it = caixa.iterator();
		if (!it.hasNext()) {
			System.out.println(separador);
			System.out.println("Nao ha mensagem.");
			System.out.println(separador);
			return;
		}
		int numMensagem = 1;
		System.out.println(separador);
		while (it.hasNext()) {
			Mensagem m = (Mensagem) it.next();
			String cursor = " ";
			if (m == caixa.mensagemCorrente()) {
				cursor = ">";
			}
			System.out.println(cursor + numMensagem + " Rem: "
					+ m.getRemetente() + " Data: "
					+ m.getDataEnvio().DDMMAAAAHHMM() + " Ass: "
					+ m.getAssunto());
			numMensagem++;
		}
		System.out.println(separador);
	}

	// um mainzinho para testar
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Sintaxe: java CorreioIUTemp3 nome");
			System.exit(1);
		}
		CorreioIUTemp3 ciu = new CorreioIUTemp3(args[0]);
		ciu.interfaceComUsuário();
	}
}
