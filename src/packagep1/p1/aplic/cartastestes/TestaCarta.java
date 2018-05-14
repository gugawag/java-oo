package p1.aplic.cartastestes;

import junit.framework.*;
import p1.aplic.cartas.Carta;

/**
 * Testes da classe Carta.
 *
 */
public class TestaCarta extends TestCase {
    protected Carta asPaus;
    protected Carta asCopas;
    protected Carta reiPaus;
    protected Carta menorCarta;   
    protected Carta maiorCarta;   

	public TestaCarta(String name) {
		super(name);
	}
	public static void main(String[] args) {
		junit.textui.TestRunner.run (suite());
	}
	protected void setUp() {
        asPaus = new Carta(Carta.AS, Carta.PAUS);
        asCopas = new Carta(Carta.AS, Carta.COPAS);
        reiPaus = new Carta(Carta.REI, Carta.PAUS);
        menorCarta = new Carta(Carta.menorValor(), Carta.PAUS);
        maiorCarta = new Carta(Carta.maiorValor(), Carta.PAUS);
	}
	public static Test suite() {
		return new TestSuite(TestaCarta.class);
	}
	public void testEquals() {
        assertTrue(!asPaus.equals(null));
        assertEquals(asPaus, asPaus);
        assertEquals(new Carta(Carta.AS, Carta.PAUS), asPaus);
        assertTrue(!asPaus.equals(asCopas));
        assertTrue(!asPaus.equals(reiPaus));
    }
    public void testMenor() {
        assertEquals(asPaus, menorCarta);
    }
    public void testMaior() {
        assertEquals(reiPaus, maiorCarta);
    }
	public void testCompareTo() {
        assertEquals("1", 0, asPaus.compareTo(asPaus));
        assertEquals("2", 0, asPaus.compareTo(new Carta(Carta.AS, Carta.PAUS)));
        assertEquals("3", 0, asPaus.compareTo(asCopas));
        assertTrue("4", asPaus.compareTo(reiPaus) < 0);
        assertTrue("5", reiPaus.compareTo(asPaus) > 0);
    }
	public void testToString() {
        assertTrue(asPaus.toString().equals("AS de PAUS"));
    }
}