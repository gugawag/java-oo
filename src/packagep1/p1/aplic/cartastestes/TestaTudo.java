package p1.aplic.cartastestes;

import junit.framework.*;

/**
 * TestSuite para todos os testes do pacote p1.aplic.cartas
 *
 */
public class TestaTudo {
	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
	public static Test suite() {
		TestSuite suite= new TestSuite();
		suite.addTest(TestaCarta.suite());
		suite.addTest(TestaCartaPoquer.suite());
		suite.addTest(TestaCartaTarot.suite());
		suite.addTest(TestaBaralho.suite());
		suite.addTest(TestaBaralhoPoquer.suite());
		suite.addTest(TestaBaralhoTarot.suite());
		suite.addTest(TestaMao.suite());
		suite.addTest(TestaMaoPoquer.suite());
	    return suite;
	}
}