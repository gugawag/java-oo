package p1.aplic.geraltestes;

import junit.framework.*;

/**
 * TestSuite para todos os testes do pacote p1.aplic.geral
 *
 */
public class TestaTudo {
	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
	public static Test suite() {
		TestSuite suite= new TestSuite();
		suite.addTest(TestaData.suite());
	    return suite;
	}
}