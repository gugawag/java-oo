// interface com o usuário para um sisteminha de correio eletrônico
// a classe ainda não faz parte do package p1.aplic.correio
import p1.aplic.correio.*;
import p1.io.*;
import java.util.*;

public class CorreioIUTemp4 {
	private CaixaPostal caixa;

	public CorreioIUTemp4(String titular) {
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
				String destinatário = obtemUmaLinha("Para quem? ");
				String assunto = obtemUmaLinha("Assunto? ");
				String conteúdo = obtemVáriasLinhas("Conteudo da mensagem? (. para terminar) ");
				enviarMensagem(caixa.getTitular(), destinatário, assunto,
						conteúdo);
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
		Iterator it = caixa.iterator();
		if (!it.hasNext()) {
			System.out.println("Nao ha mensagem.");
			return;
		}
		int numMensagem = 1;
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
	}

	// Observe que este método *não* é public
	String obtemUmaLinha(String prompt) {
		String linha;
		while ((linha = Entrada.in.lerLinha(prompt)).equals("")) {
			System.out.println("Favor fornecer alguma informacao");
		}
		return linha;
	}

	/**
	 * Método auxiliar para obter várias linhas da entrada padrão. O final da
	 * entrada é indicado digitando "." sozinho no início de uma linha.
	 * 
	 * @param prompt
	 *            O prompt a exibir ao usuário antes de ler a informação.
	 * @return As linhas lida, como string único. As linhas são separadas por um
	 *         caractere de separação de linha apropriado.
	 */
	// Observe que este método *não* é public
	String obtemVáriasLinhas(String prompt) {
		String resposta = "";
		String separador = System.getProperty("line.separator");
		String linha;
		System.out.println(prompt);
		while (!(linha = Entrada.in.lerLinha("")).equals(".")) {
			resposta += linha + separador;
		}
		return resposta;
	}

	/**
	 * Envia uma mensagem de correio eletrônico para um destinatário.
	 * 
	 * @param remetente
	 *            O remetente da mensagem.
	 * @param destinatário
	 *            O destinatário da mensagem.
	 * @param assunto
	 *            O assunto da mensagem.
	 * @param conteúdo
	 *            O conteúdo da mensagem, podendo conter várias linhas de texto.
	 */
	// Observe que este método *não* é public
	void enviarMensagem(String remetente, String destinatário, String assunto,
			String conteúdo) {
		CaixaPostal caixaDestino = new CaixaPostal(destinatário);
		caixaDestino.inserir(new Mensagem(remetente, assunto, conteúdo));
		caixaDestino.salvar();
	}

	// um mainzinho para testar
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Sintaxe: java CorreioIUTemp4 nome");
			System.exit(1);
		}
		CorreioIUTemp4 ciu = new CorreioIUTemp4(args[0]);
		ciu.interfaceComUsuário();
	}
}
