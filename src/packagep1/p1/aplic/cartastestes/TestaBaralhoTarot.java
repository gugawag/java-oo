package p1.aplic.cartastestes;

import junit.framework.*;
import p1.aplic.cartas.*;
import java.util.*;

/**
 * Testes da classe BaralhoTarot.
 *
 */
public class TestaBaralhoTarot extends TestCase {
	protected BaralhoTarot  b1;

	public TestaBaralhoTarot(String name) {
		super(name);
	}
	public static void main(String[] args) {
		junit.textui.TestRunner.run (suite());
	}
	protected void setUp() {
        b1 = new BaralhoTarot();
	}
	public static Test suite() {
		return new TestSuite(TestaBaralhoTarot.class);
	}
	public void testNúmeroDeCartas() {
        assertEquals(1, b1.menorValor());
        assertEquals(14, b1.maiorValor());
        assertEquals(78, b1.númeroDeCartas());
    }
}