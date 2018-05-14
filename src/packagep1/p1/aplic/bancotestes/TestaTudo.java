package p1.aplic.bancotestes;

import junit.framework.*;

/**
 * TestSuite para todos os testes do pacote p1.aplic.banco
 *
 */
public class TestaTudo {
	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
	public static Test suite() {
		TestSuite suite= new TestSuite();
		suite.addTest(TestaReal.suite());
		suite.addTest(TestaContaSimples.suite());
// falta fazer os testes abaixo
//		suite.addTest(TestaContaCaixa.suite());
//		suite.addTest(TestaTransacao.suite());
//		suite.addTest(TestaMovimento.suite());
//		suite.addTest(TestaExtrato.suite());
//		suite.addTest(TestaAgencia.suite());
	    return suite;
	}
}