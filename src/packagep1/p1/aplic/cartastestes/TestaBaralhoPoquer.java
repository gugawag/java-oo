package p1.aplic.cartastestes;

import junit.framework.*;
import p1.aplic.cartas.*;
import java.util.*;

/**
 * Testes da classe BaralhoPoquer.
 *
 */
public class TestaBaralhoPoquer extends TestCase {
	protected BaralhoPoquer  b1;

	public TestaBaralhoPoquer(String name) {
		super(name);
	}
	public static void main(String[] args) {
		junit.textui.TestRunner.run (suite());
	}
	protected void setUp() {
        b1 = new BaralhoPoquer();
	}
	public static Test suite() {
		return new TestSuite(TestaBaralhoPoquer.class);
	}
	public void testNúmeroDeCartas() {
        assertEquals(6, b1.menorValor());
        assertEquals(14, b1.maiorValor());
        assertEquals(36, b1.númeroDeCartas());
    }
}