/*
 * Teste onde a conversão *não* funciona
 */

import p1.aplic.banco.*;

public class Oper8 {
  public static void main(String args[]) {

    // este programa nem sequer compila!
    ContaSimples minhaConta = new ContaSimples("Joao", "309140605-06", 1);
    int i = 3;
    // a linha abaixo dá a seguinte mensagem do compilador:
    // "Incompatible type for +.
    // Can't convert ContaSimples to int."
    System.out.println("Somando uma conta e um int = " + (minhaConta+i));
  } // main
} // Oper8
