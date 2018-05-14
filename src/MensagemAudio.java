/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ci�ncia da Computa��o
 * Departamento de Sistemas e Computa��o
 * Universidade Federal da Para�ba
 *
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 * N�o redistribuir sem permiss�o.
 */

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

import p1.aplic.geral.Data;

/**
 * Classe que representa uma mensagem de �udio de correio eletronico.
 * 
 * @author Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1 <br>
 *          Copyright (C) 1999 Universidade Federal da Para�ba.
 */

public class MensagemAudio implements p1.aplic.correio.Mensagem {
	private static final int LIDA = 0x1;

	private static final int EXCLU�DA = 0x2;

	private static final int NOVA = ~(LIDA | EXCLU�DA);

	private String remetente;

	private String assunto;

	private String arquivo�udio;

	private Data dataEnvio;

	private int estado;

	/**
	 * Cria uma mensagem de �udio de correio eletr�nico
	 * 
	 * @param remetente
	 *            O remetente da mensagem
	 * @param assunto
	 *            O assunto da mensagem
	 * @param arquivo�udio
	 *            O arquivo contendo o �udio da mensagem
	 */
	public MensagemAudio(String remetente, String assunto, String arquivo�udio) {
		this.remetente = remetente;
		this.assunto = assunto;
		this.arquivo�udio = arquivo�udio;
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
	 * Recupera o arquivo de �udio da mensagem.
	 * 
	 * @return O arquivo de �udio da mensagem.
	 */
	public String getarquivo�udio() {
		return arquivo�udio;
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
	 * Informa se a mensagem foi lida ou n�o
	 * 
	 * @return true se a mensagem foi lida, false caso contr�rio
	 */
	public boolean isLida() {
		return (estado & LIDA) == LIDA;
	}

	/**
	 * Informa se a mensagem foi exclu�da ou n�o
	 * 
	 * @return true se a mensagem foi exclu�da, false caso contr�rio
	 */
	public boolean isExclu�da() {
		return (estado & EXCLU�DA) == EXCLU�DA;
	}

	/**
	 * Marcar a mensagem como exclu�da. A exclus�o deve ser feita pela cole��o
	 * que armazena as mensagens. Um exemplo de tal cole��o � CaixaPostal.
	 */
	public void excluir() {
		estado |= EXCLU�DA;
	}

	/**
	 * Marcar a mensagem como n�o exclu�da.
	 */
	public void marcarN�oExclu�da() {
		estado &= ~EXCLU�DA;
	}

	/**
	 * Marcar a mensagem como n�o lida.
	 */
	public void marcarN�oLida() {
		estado &= ~LIDA;
	}

	/**
	 * Exibir a mensagem. O arquivo de �udio � tocado. Ap�s este m�todo, a
	 * mensagem � considerada "lida".
	 */
	public void exibir() {
		try {
			URL u = new URL("file", "localhost", arquivo�udio);
			AudioClip clip = Applet.newAudioClip(u);
			System.out
					.println("Se tiver multimidia no computador, o clip deve estar tocando");
			clip.play();
		} catch (Exception e) {
			System.out.println("Nao pode abrir Audio Clip: " + arquivo�udio);
		}
		estado |= LIDA;
	}

	/**
	 * Testa a igualdade de um objeto com esta mensagem.
	 * 
	 * @param objeto
	 *            O objeto a comparar com esta mensagem.
	 * @return true se o objeto for igual a esta mensagem, false caso contr�rio.
	 */
	public boolean equals(Object objeto) {
		if (!(objeto instanceof MensagemAudio)) {
			return false;
		}
		MensagemAudio outra = (MensagemAudio) objeto;
		return super.equals(objeto)
				&& getarquivo�udio().equals(outra.getarquivo�udio());
	}

	/**
	 * Forne�a uma representa��o da mensagem como String
	 * 
	 * @return A representa��o da mensagem como String.
	 */
	public String toString() {
		return "Remetente: " + remetente + ", Data: "
				+ dataEnvio.DDMMAAAAHHMM() + ", Assunto: " + assunto
				+ ", Arquivo de �udio: " + arquivo�udio;
	}
}
