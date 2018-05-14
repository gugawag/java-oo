/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ciência da Computação
 * Departamento de Sistemas e Computação
 * Universidade Federal da Paraíba
 *
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 * Não redistribuir sem permissão.
 */
package p1.aplic.correio;

import p1.aplic.geral.*;
import java.io.*;

/**
 * Interface para manipular uma mensagem de correio eletronico.
 * Uma mensagem contém um remetente, um assunto uma data de envio e algum conteúdo.
 * O conteúdo depende do tipo exato de mensagem (textual, áudio).
 * Uma mensagem pode ser exibida (lida) e marcada para exclusão.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
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
     * Informa se a mensagem foi lida ou não
     * @return true se a mensagem foi lida, false caso contrário
     */
    public boolean isLida();

    /**
     * Informa se a mensagem foi excluída ou não
     * @return true se a mensagem foi excluída, false caso contrário
     */
    public boolean isExcluída();

    /**
     * Marcar a mensagem como excluída.
     * A exclusão deve ser feita pela coleção que armazena as mensagens.
     * Um exemplo de tal coleção é CaixaPostal.
     */
    public void excluir();

    /**
     * Marcar a mensagem como não excluída.
     */
    public void marcarNãoExcluída();

    /**
     * Marcar a mensagem como não lida.
     */
    public void marcarNãoLida();

    /**
     * Testa a igualdade de um objeto com esta mensagem.
     * @param objeto O objeto a comparar com esta mensagem.
     * @return true se o objeto for igual a esta mensagem, false caso contrário.
     */
    public boolean equals(Object objeto);

    /**
     * Exibir a mensagem. Isso poderá imprimir algo na saída
     * ou provocar outras saídas relacionadas com a leitura da mensagem.
     * Após este método, a mensagem é considerada "lida".
     */
    public void exibir();

    /**
     * Forneça uma representação da mensagem como String
     * @return A representação da mensagem como String.
     */
    public String toString();
}