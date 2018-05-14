package p1.aplic.cartastestes;

import junit.framework.*;
import p1.aplic.cartas.*;
import java.util.*;

/**
 * Testes da classe MaoPoquer
 *
 */
public class TestaMaoPoquer extends TestCase {
    protected CartaPoquer seisPaus;
    protected CartaPoquer setePaus;
    protected CartaPoquer oitoPaus;
    protected CartaPoquer novePaus;
    protected CartaPoquer dezPaus;
    protected CartaPoquer valetePaus;
    protected CartaPoquer damaPaus;
    protected CartaPoquer reiPaus;
    protected CartaPoquer asPaus;
    protected CartaPoquer damaCopas;
    protected CartaPoquer seisCopas;
    protected CartaPoquer oitoCopas;
    protected CartaPoquer dezCopas;
    protected CartaPoquer seisOuros;
    protected CartaPoquer seisEspadas;

    protected Mao nada;
    protected Mao par;
    protected Mao doisPares;
    protected Mao trinca;
    protected Mao sequencia;
    protected Mao flush;
    protected Mao fullHouse;
    protected Mao four;
    protected Mao straightFlush;
    protected Mao royalStraightFlush;

	public TestaMaoPoquer(String name) {
		super(name);
	}
	public static void main(String[] args) {
		junit.textui.TestRunner.run (suite());
	}
	protected void setUp() {
        CartaPoquer seisPaus = new CartaPoquer(6, CartaPoquer.PAUS);
        CartaPoquer setePaus = new CartaPoquer(7, CartaPoquer.PAUS);
        CartaPoquer oitoPaus = new CartaPoquer(8, CartaPoquer.PAUS);
        CartaPoquer novePaus = new CartaPoquer(9, CartaPoquer.PAUS);
        CartaPoquer dezPaus = new CartaPoquer(10, CartaPoquer.PAUS);
        CartaPoquer valetePaus = new CartaPoquer(CartaPoquer.VALETE, CartaPoquer.PAUS);
        CartaPoquer damaPaus = new CartaPoquer(CartaPoquer.DAMA, CartaPoquer.PAUS);
        CartaPoquer reiPaus = new CartaPoquer(CartaPoquer.REI, CartaPoquer.PAUS);
        CartaPoquer asPaus = new CartaPoquer(CartaPoquer.AS, CartaPoquer.PAUS);
        CartaPoquer damaCopas = new CartaPoquer(CartaPoquer.DAMA, CartaPoquer.COPAS);
        CartaPoquer seisCopas = new CartaPoquer(6, CartaPoquer.COPAS);
        CartaPoquer oitoCopas = new CartaPoquer(8, CartaPoquer.COPAS);
        CartaPoquer dezCopas = new CartaPoquer(10, CartaPoquer.COPAS);
        CartaPoquer seisOuros = new CartaPoquer(6, CartaPoquer.OUROS);
        CartaPoquer seisEspadas = new CartaPoquer(6, CartaPoquer.ESPADAS);
        nada = new MaoPoquer();
            nada.adicionar(seisPaus);
            nada.adicionar(setePaus);
            nada.adicionar(oitoPaus);
            nada.adicionar(novePaus);
            nada.adicionar(damaCopas);
        par = new MaoPoquer();
            par.adicionar(seisPaus);
            par.adicionar(seisCopas);
            par.adicionar(oitoPaus);
            par.adicionar(novePaus);
            par.adicionar(damaCopas);
        doisPares = new MaoPoquer();
            doisPares.adicionar(seisPaus);
            doisPares.adicionar(seisCopas);
            doisPares.adicionar(oitoPaus);
            doisPares.adicionar(oitoCopas);
            doisPares.adicionar(damaCopas);
        trinca = new MaoPoquer();
            trinca.adicionar(seisPaus);
            trinca.adicionar(seisCopas);
            trinca.adicionar(seisOuros);
            trinca.adicionar(oitoCopas);
            trinca.adicionar(damaCopas);
        sequencia = new MaoPoquer();
            sequencia.adicionar(seisPaus);
            sequencia.adicionar(setePaus);
            sequencia.adicionar(oitoPaus);
            sequencia.adicionar(novePaus);
            sequencia.adicionar(dezCopas);
        flush = new MaoPoquer();
            flush.adicionar(seisPaus);
            flush.adicionar(setePaus);
            flush.adicionar(oitoPaus);
            flush.adicionar(novePaus);
            flush.adicionar(damaPaus);
        fullHouse = new MaoPoquer();
            fullHouse.adicionar(seisPaus);
            fullHouse.adicionar(seisCopas);
            fullHouse.adicionar(seisOuros);
            fullHouse.adicionar(oitoPaus);
            fullHouse.adicionar(oitoCopas);
        four = new MaoPoquer();
            four.adicionar(seisPaus);
            four.adicionar(seisCopas);
            four.adicionar(seisOuros);
            four.adicionar(seisEspadas);
            four.adicionar(oitoCopas);
        straightFlush = new MaoPoquer();
            straightFlush.adicionar(seisPaus);
            straightFlush.adicionar(setePaus);
            straightFlush.adicionar(oitoPaus);
            straightFlush.adicionar(novePaus);
            straightFlush.adicionar(dezPaus);
        royalStraightFlush = new MaoPoquer();
            royalStraightFlush.adicionar(dezPaus);
            royalStraightFlush.adicionar(valetePaus);
            royalStraightFlush.adicionar(damaPaus);
            royalStraightFlush.adicionar(reiPaus);
            royalStraightFlush.adicionar(asPaus);
	}
	public static Test suite() {
		return new TestSuite(TestaMaoPoquer.class);
	}
    public void testNada() {
        assertEquals(MaoPoquer.NADA, nada.valor());
    }
    public void testPar() {
        assertEquals(MaoPoquer.PAR, par.valor());
    }
    public void testDoisPares() {
        assertEquals(MaoPoquer.DOIS_PARES, doisPares.valor());
    }
    public void testTrinca() {
        assertEquals(MaoPoquer.TRINCA, trinca.valor());
    }
    public void testSequenciaNada() {
        assertEquals(MaoPoquer.SEQUENCIA, sequencia.valor());
    }
    public void testFlush() {
        assertEquals(MaoPoquer.FLUSH, flush.valor());
    }
    public void testFullHouse() {
        assertEquals(MaoPoquer.FULL_HOUSE, fullHouse.valor());
    }
    public void testFourNada() {
        assertEquals(MaoPoquer.FOUR, four.valor());
    }
    public void testStraightFlush() {
        assertEquals(MaoPoquer.STRAIGHT_FLUSH, straightFlush.valor());
    }
    public void testRoyalStraightFlush() {
        assertEquals(MaoPoquer.ROYAL_STRAIGHT_FLUSH, royalStraightFlush.valor());
    }
    public void testNomeRoyalStraightFlush() {
        assertEquals("Royal Straight Flush", ((MaoPoquer)royalStraightFlush).nomeDaMão());
    }
}