// interface com o usu�rio para um sisteminha de correio eletr�nico
// a classe ainda n�o faz parte do package p1.aplic.correio
import p1.aplic.correio.*;
import p1.io.*;
import java.util.*;

public class CorreioIUTemp4 {
	private CaixaPostal caixa;

	public CorreioIUTemp4(String titular) {
		caixa = new CaixaPostal(titular);
	}

	public void interfaceComUsu�rio() {
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
				String destinat�rio = obtemUmaLinha("Para quem? ");
				String assunto = obtemUmaLinha("Assunto? ");
				String conte�do = obtemV�riasLinhas("Conteudo da mensagem? (. para terminar) ");
				enviarMensagem(caixa.getTitular(), destinat�rio, assunto,
						conte�do);
			} else if (cmd.startsWith("exc")) {
				caixa.excluir();
			} else if (cmd.startsWith("+")) {
				caixa.avan�ar();
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

	// Observe que este m�todo *n�o* � public
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

	// Observe que este m�todo *n�o* � public
	String obtemUmaLinha(String prompt) {
		String linha;
		while ((linha = Entrada.in.lerLinha(prompt)).equals("")) {
			System.out.println("Favor fornecer alguma informacao");
		}
		return linha;
	}

	/**
	 * M�todo auxiliar para obter v�rias linhas da entrada padr�o. O final da
	 * entrada � indicado digitando "." sozinho no in�cio de uma linha.
	 * 
	 * @param prompt
	 *            O prompt a exibir ao usu�rio antes de ler a informa��o.
	 * @return As linhas lida, como string �nico. As linhas s�o separadas por um
	 *         caractere de separa��o de linha apropriado.
	 */
	// Observe que este m�todo *n�o* � public
	String obtemV�riasLinhas(String prompt) {
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
	 * Envia uma mensagem de correio eletr�nico para um destinat�rio.
	 * 
	 * @param remetente
	 *            O remetente da mensagem.
	 * @param destinat�rio
	 *            O destinat�rio da mensagem.
	 * @param assunto
	 *            O assunto da mensagem.
	 * @param conte�do
	 *            O conte�do da mensagem, podendo conter v�rias linhas de texto.
	 */
	// Observe que este m�todo *n�o* � public
	void enviarMensagem(String remetente, String destinat�rio, String assunto,
			String conte�do) {
		CaixaPostal caixaDestino = new CaixaPostal(destinat�rio);
		caixaDestino.inserir(new Mensagem(remetente, assunto, conte�do));
		caixaDestino.salvar();
	}

	// um mainzinho para testar
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Sintaxe: java CorreioIUTemp4 nome");
			System.exit(1);
		}
		CorreioIUTemp4 ciu = new CorreioIUTemp4(args[0]);
		ciu.interfaceComUsu�rio();
	}
}
