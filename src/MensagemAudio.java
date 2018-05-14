/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ciência da Computação
 * Departamento de Sistemas e Computação
 * Universidade Federal da Paraíba
 *
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 * Não redistribuir sem permissão.
 */

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

import p1.aplic.geral.Data;

/**
 * Classe que representa uma mensagem de áudio de correio eletronico.
 * 
 * @author Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1 <br>
 *          Copyright (C) 1999 Universidade Federal da Paraíba.
 */

public class MensagemAudio implements p1.aplic.correio.Mensagem {
	private static final int LIDA = 0x1;

	private static final int EXCLUÍDA = 0x2;

	private static final int NOVA = ~(LIDA | EXCLUÍDA);

	private String remetente;

	private String assunto;

	private String arquivoÁudio;

	private Data dataEnvio;

	private int estado;

	/**
	 * Cria uma mensagem de áudio de correio eletrônico
	 * 
	 * @param remetente
	 *            O remetente da mensagem
	 * @param assunto
	 *            O assunto da mensagem
	 * @param arquivoÁudio
	 *            O arquivo contendo o áudio da mensagem
	 */
	public MensagemAudio(String remetente, String assunto, String arquivoÁudio) {
		this.remetente = remetente;
		this.assunto = assunto;
		this.arquivoÁudio = arquivoÁudio;
		dataEnvio = new Data();
		estado = NOVA;
	}

	/**
	 * Recupera o remetente da mensagem
	 * 
	 * @return O remetente da mensagem
	 */
	public String getRemetente() {
		return remetente;
	}

	/**
	 * Recupera o assunto da mensagem
	 * 
	 * @return O assunto da mensagem
	 */
	public String getAssunto() {
		return assunto;
	}

	/**
	 * Recupera o arquivo de áudio da mensagem.
	 * 
	 * @return O arquivo de áudio da mensagem.
	 */
	public String getarquivoÁudio() {
		return arquivoÁudio;
	}

	/**
	 * Recupera a data de envio da mensagem
	 * 
	 * @return A data de envio da mensagem
	 */
	public Data getDataEnvio() {
		return dataEnvio;
	}

	/**
	 * Informa se a mensagem foi lida ou não
	 * 
	 * @return true se a mensagem foi lida, false caso contrário
	 */
	public boolean isLida() {
		return (estado & LIDA) == LIDA;
	}

	/**
	 * Informa se a mensagem foi excluída ou não
	 * 
	 * @return true se a mensagem foi excluída, false caso contrário
	 */
	public boolean isExcluída() {
		return (estado & EXCLUÍDA) == EXCLUÍDA;
	}

	/**
	 * Marcar a mensagem como excluída. A exclusão deve ser feita pela coleção
	 * que armazena as mensagens. Um exemplo de tal coleção é CaixaPostal.
	 */
	public void excluir() {
		estado |= EXCLUÍDA;
	}

	/**
	 * Marcar a mensagem como não excluída.
	 */
	public void marcarNãoExcluída() {
		estado &= ~EXCLUÍDA;
	}

	/**
	 * Marcar a mensagem como não lida.
	 */
	public void marcarNãoLida() {
		estado &= ~LIDA;
	}

	/**
	 * Exibir a mensagem. O arquivo de áudio é tocado. Após este método, a
	 * mensagem é considerada "lida".
	 */
	public void exibir() {
		try {
			URL u = new URL("file", "localhost", arquivoÁudio);
			AudioClip clip = Applet.newAudioClip(u);
			System.out
					.println("Se tiver multimidia no computador, o clip deve estar tocando");
			clip.play();
		} catch (Exception e) {
			System.out.println("Nao pode abrir Audio Clip: " + arquivoÁudio);
		}
		estado |= LIDA;
	}

	/**
	 * Testa a igualdade de um objeto com esta mensagem.
	 * 
	 * @param objeto
	 *            O objeto a comparar com esta mensagem.
	 * @return true se o objeto for igual a esta mensagem, false caso contrário.
	 */
	public boolean equals(Object objeto) {
		if (!(objeto instanceof MensagemAudio)) {
			return false;
		}
		MensagemAudio outra = (MensagemAudio) objeto;
		return super.equals(objeto)
				&& getarquivoÁudio().equals(outra.getarquivoÁudio());
	}

	/**
	 * Forneça uma representação da mensagem como String
	 * 
	 * @return A representação da mensagem como String.
	 */
	public String toString() {
		return "Remetente: " + remetente + ", Data: "
				+ dataEnvio.DDMMAAAAHHMM() + ", Assunto: " + assunto
				+ ", Arquivo de áudio: " + arquivoÁudio;
	}
}
