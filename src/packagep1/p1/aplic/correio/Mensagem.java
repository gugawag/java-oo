/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ci�ncia da Computa��o
 * Departamento de Sistemas e Computa��o
 * Universidade Federal da Para�ba
 *
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 * N�o redistribuir sem permiss�o.
 */
package p1.aplic.correio;

import p1.aplic.geral.*;
import java.io.*;

/**
 * Interface para manipular uma mensagem de correio eletronico.
 * Uma mensagem cont�m um remetente, um assunto uma data de envio e algum conte�do.
 * O conte�do depende do tipo exato de mensagem (textual, �udio).
 * Uma mensagem pode ser exibida (lida) e marcada para exclus�o.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */

public interface Mensagem  {
    /**
     * Recupera o remetente da mensagem
     * @return O remetente da mensagem
     */
    public String getRemetente();

    /**
     * Recupera o assunto da mensagem
     * @return O assunto da mensagem
     */
    public String getAssunto();

    /**
     * Recupera a data de envio da mensagem
     * @return A data de envio da mensagem
     */
    public Data getDataEnvio();

    /**
     * Informa se a mensagem foi lida ou n�o
     * @return true se a mensagem foi lida, false caso contr�rio
     */
    public boolean isLida();

    /**
     * Informa se a mensagem foi exclu�da ou n�o
     * @return true se a mensagem foi exclu�da, false caso contr�rio
     */
    public boolean isExclu�da();

    /**
     * Marcar a mensagem como exclu�da.
     * A exclus�o deve ser feita pela cole��o que armazena as mensagens.
     * Um exemplo de tal cole��o � CaixaPostal.
     */
    public void excluir();

    /**
     * Marcar a mensagem como n�o exclu�da.
     */
    public void marcarN�oExclu�da();

    /**
     * Marcar a mensagem como n�o lida.
     */
    public void marcarN�oLida();

    /**
     * Testa a igualdade de um objeto com esta mensagem.
     * @param objeto O objeto a comparar com esta mensagem.
     * @return true se o objeto for igual a esta mensagem, false caso contr�rio.
     */
    public boolean equals(Object objeto);

    /**
     * Exibir a mensagem. Isso poder� imprimir algo na sa�da
     * ou provocar outras sa�das relacionadas com a leitura da mensagem.
     * Ap�s este m�todo, a mensagem � considerada "lida".
     */
    public void exibir();

    /**
     * Forne�a uma representa��o da mensagem como String
     * @return A representa��o da mensagem como String.
     */
    public String toString();
}