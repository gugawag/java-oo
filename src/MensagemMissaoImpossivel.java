/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ci�ncia da Computa��o
 * Departamento de Sistemas e Computa��o
 * Universidade Federal da Para�ba
 *
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 * N�o redistribuir sem permiss�o.
 */

import p1.aplic.geral.Data;

/**
 * Classe que representa uma mensagem normal de correio eletronico.
 * 
 * Uma mensagem cont�m um remetente, um assunto uma data de envio e algum
 * conte�do. O conte�do depende do tipo exato de mensagem (textual, �udio). Uma
 * mensagem pode ser exibida (lida) e marcada para exclus�o.
 * 
 * @author Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1 <br>
 *          Copyright (C) 1999 Universidade Federal da Para�ba.
 */

public class MensagemMissaoImpossivel implements p1.aplic.correio.Mensagem {
	private static final int LIDA = 0x1;

	private static final int EXCLU�DA = 0x2;

	private static final int NOVA = ~(LIDA | EXCLU�DA);

	private String remetente;

	private String assunto;

	private String conte�do;

	private Data dataEnvio;

	private int estado;

	public MensagemMissaoImpossivel(String remetente, String assunto,
			String conte�do) {
		this.remetente = remetente;
		this.assunto = assunto;
		this.conte�do = conte�do;
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
	 * Recupera o conte�do da mensagem
	 * 
	 * @return O conte�do da mensagem
	 */
	public String getConte�do() {
		return conte�do;
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
	 * Testa a igualdade de um objeto com esta mensagem.
	 * 
	 * @param objeto
	 *            O objeto a comparar com esta mensagem.
	 * @return true se o objeto for igual a esta mensagem, false caso contr�rio.
	 */
	public boolean equals(Object objeto) {
		if (!(objeto instanceof Mensagem)) {
			return false;
		}
		Mensagem outra = (Mensagem) objeto;
		return getRemetente().equals(outra.getRemetente())
				&& getAssunto().equals(outra.getAssunto())
				&& getConte�do().equals(outra.getConte�do());
	}

	/**
	 * Exibir a mensagem. Os dados da mensagem s�o apresentados na sa�da padr�o.
	 * Ap�s este m�todo, a mensagem se auto-destroi.
	 */
	public void exibir() {
		System.out.println("De: " + remetente);
		System.out.println("Data: " + dataEnvio.DDMMAAAAHHMM());
		System.out.println("Assunto: " + assunto);
		System.out.println(conte�do);
		estado |= LIDA;
		excluir();
	}

	/**
	 * Forne�a uma representa��o da mensagem como String
	 * 
	 * @return A representa��o da mensagem como String.
	 */
	public String toString() {
		return "Remetente: " + remetente + ", Data: "
				+ dataEnvio.DDMMAAAAHHMM() + ", Assunto: " + assunto
				+ ", Conte�do: " + conte�do;
	}
}
