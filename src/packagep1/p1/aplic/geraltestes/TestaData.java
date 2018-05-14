package p1.aplic.geraltestes;

import java.util.*;
import junit.framework.*;
import p1.aplic.geral.*;

/**
 * Testes da classe Data.
 *
 */
public class TestaData extends TestCase {
    protected Data data1;
    protected Data data2;

    public TestaData(String name) {
        super(name);
    }
    public static void main(String[] args) {
        junit.textui.TestRunner.run (suite());
    }
    public static Test suite() {
        return new TestSuite(TestaData.class);
    }
    protected void setUp() {
    	data1 = new Data(10,10,2000,12,0,0);
	try { Thread.sleep(1000); } catch(Exception e) {}
    	data2 = new Data(10,10,2000,12,0,0);
    }
    public void testCompareTo() {
        assertEquals(0, data1.compareTo(data2));
    }
}