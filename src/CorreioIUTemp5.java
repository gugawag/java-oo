// ***************************************
// ATEN��O: C�DIGO FEIO � FRENTE!!!!!!!!!!
// ***************************************
// interface com o usu�rio para um sisteminha de correio eletr�nico
// a classe ainda n�o faz parte do package p1.aplic.correio
import p1.aplic.correio.*;
import p1.io.*;
import java.util.*;

public class CorreioIUTemp5 {
	private CaixaPostal caixa;

	public CorreioIUTemp5(String titular) {
		caixa = new CaixaPostal(titular);
	}

	public void interfaceComUsu�rio() {
		while (true) {
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
			String cmd = Entrada.in
					.lerLinha("exibir, enviar, excluir, +, -, quit? ");
			if (cmd.startsWith("exi")) {
				Mensagem m = caixa.mensagemCorrente();
				if (m != null) {
					m.exibir();
				}
			} else if (cmd.startsWith("en")) {
				String destinat�rio;
				while ((destinat�rio = Entrada.in.lerLinha("Para quem? "))
						.equals("")) {
					System.out.println("Favor fornecer alguma informacao");
				}
				String assunto;
				while ((assunto = Entrada.in.lerLinha("Assunto? ")).equals("")) {
					System.out.println("Favor fornecer alguma informacao");
				}
				String conte�do = "";
				String separador = System.getProperty("line.separator");
				String linha;
				System.out.println("Conteudo da mensagem? (. para terminar) ");
				while (!(linha = Entrada.in.lerLinha("")).equals(".")) {
					conte�do += linha + separador;
				}
				CaixaPostal caixaDestino = new CaixaPostal(destinat�rio);
				caixaDestino.inserir(new Mensagem(caixa.getTitular(), assunto,
						conte�do));
				caixaDestino.salvar();
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

	// um mainzinho para testar
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Sintaxe: java CorreioIUTemp5 nome");
			System.exit(1);
		}
		CorreioIUTemp5 ciu = new CorreioIUTemp5(args[0]);
		ciu.interfaceComUsu�rio();
	}
}
