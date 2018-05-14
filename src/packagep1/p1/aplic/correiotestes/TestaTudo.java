package p1.aplic.correiotestes;

import junit.framework.*;

/**
 * TestSuite para todos os testes do pacote p1.aplic.correio
 *
 */
public class TestaTudo {
	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
	public static Test suite() {
		TestSuite suite= new TestSuite();
		suite.addTest(TestaMensagemTexto.suite());
		suite.addTest(TestaMensagemMissaoImpossivel.suite());
		suite.addTest(TestaMensagemAudio.suite());
		suite.addTest(TestaCaixaPostal.suite());
	    return suite;
	}
}