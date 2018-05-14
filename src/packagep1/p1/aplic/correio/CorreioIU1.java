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

import p1.io.*;
import p1.util.*;
import java.util.*;

/**
 * Classe que implementa uma interface simples (a caractere)
 * de manipulação de mensagens de correio eletrônico.
 * <p>
 * O programa manipula uma caixa postal de mensagens de correio eletrônico.
 * O funcionamento da interface é como segue. Um objeto dessa
 * classe deve ser criado com um argumento especificando o titular da caixa postal
 * a ser manipulada. Ao chamar o método principal (interfaceComUsuário()),
 * o conteúdo da caixa postal pode ser manipulado e novas mensagens podem ser enviadas.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 */

public class CorreioIU1 {
    private CaixaPostal caixa;

    /**
     * Construtor de uma interface com o usuário para manipular
     * uma caixa postal de correio eletrônico.
     * @param titular O titular da caixa postal que se deseja manipular.
     */
    public CorreioIU1(String titular) {
        caixa = new CaixaPostal(titular);
    }

    /**
     * Interface com o usuário para a manipulação de caixa postal.
     * A interface consiste basicamente de um laço de interpretação de comandos.
     * O conteúdo da caixa postal é mostrado na tela e um menu de comandos
     * é exibido. Os comandos disponíveis são:
     * <p><strong>exibir</strong>: exibe a mensagem corrente.
     * <p><strong>enviar</strong>: envia uma nova mensagem de correio.
     * Neste caso, deve-se especificar ainda o destinatário, o assunto e
     * o conteúdo da mensagem propriamente dita. O remetente será o titular da caixa postal.
     * <p><strong>excluir</strong>: marca a mensagem corrente para exclusão. Chamamos isso
     * de <strong>exclusão lógica</strong>. A exclusão em sí (física)
     * é feita ao salvar a caixa postal no final (vide o comando "quit").
     * <p><strong>+</strong>: avança para a próxima mensagem.
     * <p><strong>-</strong>: recua para a mensagem anterior.
     * <p><strong>quit</strong>: encerra a manipulação da caixa postal. Pede-se neste momento
     * se a caixa postal deve ser salva em disco ou não. Responda com 's' ou 'n'.
     * <p>Os comandos podem ser digitados de forma abreviada, desde que um número
     * suficiente de letras seja informado. Por exemplo, basta digitar "en" para
     * enviar uma mensagem nova. Digitar "ex" não é suficiente, pois há dois comandos começando
     * com "ex". Deve-se digitar pelo menos "exc" (excluir) ou "exi" (exibir).
     */
    public void interfaceComUsuário() {
        while(true) {
            mostraResumoCaixaPostal(caixa);
            String cmd = Entrada.in.lerLinha("exibir, enviar, excluir, +, -, quit? ");
            if(cmd.startsWith("exi")) {
                Mensagem m = caixa.mensagemCorrente();
                if(m != null) {
                    m.exibir();
                }
            } else if(cmd.startsWith("en")) {
                String destinatário = obtemUmaLinha("Para quem? ");
                String assunto = obtemUmaLinha("Assunto? ");
                String conteúdo = obtemVáriasLinhas("Conteudo da mensagem? (. para terminar) ");
                enviarMensagem(caixa.getTitular(), destinatário, assunto, conteúdo);
            } else if(cmd.startsWith("exc")) {
                caixa.excluir();
            } else if(cmd.startsWith("+")) {
                caixa.avançar();
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
     * Exibe na saída padrão um resumo da mensagens presentes na caixa postal.
     * @param caixa A caixa postal a ser exibida
     */
    // Observe que este método *não* é public
    private void mostraResumoCaixaPostal(CaixaPostal caixa) {
        final String separador = "---------------------------------------------------------------------";
        Iterator it = caixa.iterator();
        if(!it.hasNext()) {
            System.out.println(separador);
            System.out.println("Nao ha mensagem.");
            System.out.println(separador);
            return;
        }
        // -16.16s significa um string (s) alinhado à esquerda (-)
        // com um mínimo de 16 caracteres e um máximo de 16 caracteres
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
            String estado = m.isExcluída() ? "X" : " ";
            System.out.println(cursor + estado +
                                f3.form(numMensagem) + " " +
                                f4.form(m.getRemetente()) + " " +
                                f1.form(m.getDataEnvio().DDMMAAAAHHMM()) + " " +
                                f2.form(m.getAssunto()));
            numMensagem++;
        }
        System.out.println(separador);
    }

    /** Método auxiliar para obter uma linha da entrada padrão, tendo
     * o cuidado de não aceitar uma linha vazia.
     * @param prompt O prompt a exibir ao usuário antes de ler a informação.
     * @return A linha lida.
     */
    // Observe que este método *não* é public
    private String obtemUmaLinha(String prompt) {
        String linha;
        while((linha = Entrada.in.lerLinha(prompt)).equals("")) {
            System.out.println("Favor fornecer alguma informacao");
        }
        return linha;
    }

    /** Método auxiliar para obter várias linhas da entrada padrão.
     * O final da entrada é indicado digitando "." sozinho no início
     * de uma linha.
     * @param prompt O prompt a exibir ao usuário antes de ler a informação.
     * @return As linhas lida, como string único. As linhas são separadas
     * por um caractere de separação de linha apropriado.
     */
    // Observe que este método *não* é public
    private String obtemVáriasLinhas(String prompt) {
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
     * Envia uma mensagem de correio eletrônico para um destinatário.
     * @param remetente O remetente da mensagem.
     * @param destinatário O destinatário da mensagem.
     * @param assunto O assunto da mensagem.
     * @param conteúdo O conteúdo da mensagem, podendo conter várias linhas de texto.
     */
    // Observe que este método *não* é public
    private void enviarMensagem(String remetente, String destinatário, String assunto, String conteúdo) {
        CaixaPostal caixaDestino = new CaixaPostal(destinatário);
        caixaDestino.inserir(new MensagemTexto(remetente, assunto, conteúdo));
        caixaDestino.salvar();
    }
}
