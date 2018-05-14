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

import p1.io.*;
import p1.util.*;
import java.util.*;

/**
 * Classe que implementa uma interface simples (a caractere)
 * de manipula��o de mensagens de correio eletr�nico.
 * <p>
 * O programa manipula uma caixa postal de mensagens de correio eletr�nico.
 * O funcionamento da interface � como segue. Um objeto dessa
 * classe deve ser criado com um argumento especificando o titular da caixa postal
 * a ser manipulada. Ao chamar o m�todo principal (interfaceComUsu�rio()),
 * o conte�do da caixa postal pode ser manipulado e novas mensagens podem ser enviadas.
 *
 * @author   Jacques Philippe Sauv�, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Para�ba.
 */

public class CorreioIU1 {
    private CaixaPostal caixa;

    /**
     * Construtor de uma interface com o usu�rio para manipular
     * uma caixa postal de correio eletr�nico.
     * @param titular O titular da caixa postal que se deseja manipular.
     */
    public CorreioIU1(String titular) {
        caixa = new CaixaPostal(titular);
    }

    /**
     * Interface com o usu�rio para a manipula��o de caixa postal.
     * A interface consiste basicamente de um la�o de interpreta��o de comandos.
     * O conte�do da caixa postal � mostrado na tela e um menu de comandos
     * � exibido. Os comandos dispon�veis s�o:
     * <p><strong>exibir</strong>: exibe a mensagem corrente.
     * <p><strong>enviar</strong>: envia uma nova mensagem de correio.
     * Neste caso, deve-se especificar ainda o destinat�rio, o assunto e
     * o conte�do da mensagem propriamente dita. O remetente ser� o titular da caixa postal.
     * <p><strong>excluir</strong>: marca a mensagem corrente para exclus�o. Chamamos isso
     * de <strong>exclus�o l�gica</strong>. A exclus�o em s� (f�sica)
     * � feita ao salvar a caixa postal no final (vide o comando "quit").
     * <p><strong>+</strong>: avan�a para a pr�xima mensagem.
     * <p><strong>-</strong>: recua para a mensagem anterior.
     * <p><strong>quit</strong>: encerra a manipula��o da caixa postal. Pede-se neste momento
     * se a caixa postal deve ser salva em disco ou n�o. Responda com 's' ou 'n'.
     * <p>Os comandos podem ser digitados de forma abreviada, desde que um n�mero
     * suficiente de letras seja informado. Por exemplo, basta digitar "en" para
     * enviar uma mensagem nova. Digitar "ex" n�o � suficiente, pois h� dois comandos come�ando
     * com "ex". Deve-se digitar pelo menos "exc" (excluir) ou "exi" (exibir).
     */
    public void interfaceComUsu�rio() {
        while(true) {
            mostraResumoCaixaPostal(caixa);
            String cmd = Entrada.in.lerLinha("exibir, enviar, excluir, +, -, quit? ");
            if(cmd.startsWith("exi")) {
                Mensagem m = caixa.mensagemCorrente();
                if(m != null) {
                    m.exibir();
                }
            } else if(cmd.startsWith("en")) {
                String destinat�rio = obtemUmaLinha("Para quem? ");
                String assunto = obtemUmaLinha("Assunto? ");
                String conte�do = obtemV�riasLinhas("Conteudo da mensagem? (. para terminar) ");
                enviarMensagem(caixa.getTitular(), destinat�rio, assunto, conte�do);
            } else if(cmd.startsWith("exc")) {
                caixa.excluir();
            } else if(cmd.startsWith("+")) {
                caixa.avan�ar();
            } else if(cmd.startsWith("-")) {
                caixa.recuar();
            } else if(cmd.startsWith("q")) {
                cmd = Entrada.in.lerLinha("Salvar CaixaPostal? ");
                if(cmd.startsWith("s")) {
                    caixa.salvar();
                }
                break;
            } else {
                System.out.println("Comando <" + cmd + "> desconhecido");
            }
        }
    }

    /**
     * Exibe na sa�da padr�o um resumo da mensagens presentes na caixa postal.
     * @param caixa A caixa postal a ser exibida
     */
    // Observe que este m�todo *n�o* � public
    private void mostraResumoCaixaPostal(CaixaPostal caixa) {
        final String separador = "---------------------------------------------------------------------";
        Iterator it = caixa.iterator();
        if(!it.hasNext()) {
            System.out.println(separador);
            System.out.println("Nao ha mensagem.");
            System.out.println(separador);
            return;
        }
        // -16.16s significa um string (s) alinhado � esquerda (-)
        // com um m�nimo de 16 caracteres e um m�ximo de 16 caracteres
        Formata f1 = new Formata("%-16.16s");
        Formata f2 = new Formata("%-40.40s");
        Formata f3 = new Formata("%3d");
        Formata f4 = new Formata("%-12.12s");
        System.out.println(separador);
        System.out.println("  Num " + f4.form("Remetente") +
                           " " + f1.form("Data") +
                           " " + f2.form("Assunto"));
        int numMensagem = 1;
        while(it.hasNext()) {
            Mensagem m = (Mensagem)it.next();
            String cursor = " ";
            if(m == caixa.mensagemCorrente()) {
                cursor = ">";
            }
            String estado = m.isExclu�da() ? "X" : " ";
            System.out.println(cursor + estado +
                                f3.form(numMensagem) + " " +
                                f4.form(m.getRemetente()) + " " +
                                f1.form(m.getDataEnvio().DDMMAAAAHHMM()) + " " +
                                f2.form(m.getAssunto()));
            numMensagem++;
        }
        System.out.println(separador);
    }

    /** M�todo auxiliar para obter uma linha da entrada padr�o, tendo
     * o cuidado de n�o aceitar uma linha vazia.
     * @param prompt O prompt a exibir ao usu�rio antes de ler a informa��o.
     * @return A linha lida.
     */
    // Observe que este m�todo *n�o* � public
    private String obtemUmaLinha(String prompt) {
        String linha;
        while((linha = Entrada.in.lerLinha(prompt)).equals("")) {
            System.out.println("Favor fornecer alguma informacao");
        }
        return linha;
    }

    /** M�todo auxiliar para obter v�rias linhas da entrada padr�o.
     * O final da entrada � indicado digitando "." sozinho no in�cio
     * de uma linha.
     * @param prompt O prompt a exibir ao usu�rio antes de ler a informa��o.
     * @return As linhas lida, como string �nico. As linhas s�o separadas
     * por um caractere de separa��o de linha apropriado.
     */
    // Observe que este m�todo *n�o* � public
    private String obtemV�riasLinhas(String prompt) {
        String resposta = "";
        String separador = System.getProperty("line.separator");
        String linha;
        System.out.println(prompt);
        while(!(linha = Entrada.in.lerLinha("")).equals(".")) {
            resposta += linha + separador;
        }
        return resposta;
    }

    /**
     * Envia uma mensagem de correio eletr�nico para um destinat�rio.
     * @param remetente O remetente da mensagem.
     * @param destinat�rio O destinat�rio da mensagem.
     * @param assunto O assunto da mensagem.
     * @param conte�do O conte�do da mensagem, podendo conter v�rias linhas de texto.
     */
    // Observe que este m�todo *n�o* � public
    private void enviarMensagem(String remetente, String destinat�rio, String assunto, String conte�do) {
        CaixaPostal caixaDestino = new CaixaPostal(destinat�rio);
        caixaDestino.inserir(new MensagemTexto(remetente, assunto, conte�do));
        caixaDestino.salvar();
    }
}
