package p1.aplic.cartastestes;

import junit.framework.*;
import p1.aplic.cartas.*;

/**
 * Testes da classe CartaTarot.
 *
 */
public class TestaCartaTarot extends TestCase {
    protected CartaTarot   oneWands;
    protected CartaTarot   twoCups;
    protected CartaTarot   kingSwords;
    protected CartaTarot   oneMajorArcana;
    protected CartaTarot   twoMajorArcana;
    protected CartaTarot   menorCarta;   
    protected CartaTarot   maiorCarta;   

	public TestaCartaTarot(String name) {
		super(name);
	}
	public static void main(String[] args) {
		junit.textui.TestRunner.run (suite());
	}
	protected void setUp() {
        oneWands = new CartaTarot(CartaTarot.ONE, CartaTarot.WANDS);
        twoCups = new CartaTarot(CartaTarot.TWO, CartaTarot.CUPS);
        kingSwords = new CartaTarot(CartaTarot.KING, CartaTarot.SWORDS);
        oneMajorArcana = new CartaTarot(CartaTarot.ONE, CartaTarot.MAJOR_ARCANA);
        twoMajorArcana = new CartaTarot(CartaTarot.TWO, CartaTarot.MAJOR_ARCANA);
        menorCarta = new CartaTarot(CartaTarot.menorValor(), CartaTarot.primeiroNaipe());
        maiorCarta = new CartaTarot(CartaTarot.maiorValor(), CartaTarot.últimoNaipe());
	}
	public static Test suite() {
		return new TestSuite(TestaCartaTarot.class);
	}
    public void testMenor() {
        assertEquals(oneWands, menorCarta);
    }
    public void testMaior() {
        assertEquals(kingSwords, maiorCarta);
    }
	public void testCompareTo() {
        assertTrue("1", oneWands.compareTo(twoCups) < 0);
        assertTrue("2", oneMajorArcana.compareTo(twoMajorArcana) < 0);
        assertTrue("3", oneMajorArcana.compareTo(twoCups) > 0);
        assertTrue("3", twoCups.compareTo(oneMajorArcana) < 0);
    }
}