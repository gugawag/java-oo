package p1.testes;

import junit.framework.*;

/**
 * TestSuite para todos os testes do pacote p1
 *
 */
public class TestaTudo {

	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
	public static Test suite() {
		TestSuite suite= new TestSuite();
		suite.addTest(p1.aplic.geraltestes.TestaTudo.suite());
		suite.addTest(p1.aplic.bancotestes.TestaTudo.suite());
		suite.addTest(p1.aplic.cartastestes.TestaTudo.suite());
		suite.addTest(p1.aplic.correiotestes.TestaTudo.suite());
	    return suite;
	}
}