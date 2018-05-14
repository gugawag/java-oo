/*
 * Persist�ncia
 */

import p1.aplic.banco.*;
import p1.aplic.geral.*; // para mexer com a classe Data
import p1.io.*;

public class Banco5 {
	public static void main(String args[]) {
		// declara��o de vari�veis de 3 classes (tipos) diferentes
		// no fim, teremos 4 objetos de 3 classes
		ContaSimples umaConta;
		Extrato umExtrato;
		Data hoje, ontem;

		// localiza a conta de n�mero 1
		// (ela j� foi criada e armazenada anteriormente)
		// O "cast" (ContaSimples) ser� explicado em outro momento
		// O motivo � que localizarConta retorna um objeto do tipo Conta
		// que representa uma conta banc�ria gen�rica e n�o apenas uma
		// ContaSimples
		umaConta = (ContaSimples) Agencia.localizarConta(1);

		// Vamos fazer um saque
		System.out.println("Voce tem " + umaConta.getSaldoMonet�rio()
				+ " na conta");
		double valor = Entrada.in.lerdouble("Quanto voce quer sacar? ");
		umaConta.sacar(valor);

		// Vamos tirar um extrato de conta entre ontem e hoje
		hoje = new Data(); // hoje representa a data de hoje
		ontem = new Data(); // ontem ainda representa hoje
		ontem.somarDia(-1); // agora, temos a data de ontem
		umExtrato = umaConta.criarExtrato(ontem, hoje);
		// Imprime o extrato
		System.out.println(umExtrato.formatar());
		System.out.println("Saldo: " + umaConta.getSaldoMonet�rio());

		// Vamos atualizar as informa��es persistentes
		Agencia.fecharCaixa();
	} // main
} // Banco5
