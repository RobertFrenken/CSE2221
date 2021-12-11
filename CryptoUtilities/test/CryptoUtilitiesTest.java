import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * @author Robert Frenken
 *
 */
public class CryptoUtilitiesTest {

    /*
     * Tests of reduceToGCD
     */

    // boundary
    @Test
    public void testReduceToGCD_0_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals("0", n.toString());
        assertEquals("0", m.toString());
    }

    // routine
    @Test
    public void testReduceToGCD_8_3() {
        NaturalNumber n = new NaturalNumber2(8);
        NaturalNumber m = new NaturalNumber2(3);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals("1", n.toString());
        assertEquals("0", m.toString());
    }

    //routine
    @Test
    public void testReduceToGCD_30_21() {
        NaturalNumber n = new NaturalNumber2(30);
        NaturalNumber m = new NaturalNumber2(21);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals("3", n.toString());
        assertEquals("0", m.toString());
    }

    // hard
    @Test
    public void testReduceToGCD_1000_25() {
        NaturalNumber n = new NaturalNumber2(1000);
        NaturalNumber m = new NaturalNumber2(25);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals("25", n.toString());
        assertEquals("0", m.toString());
    }

    /*
     * Tests of isEven
     */

    // boundary
    @Test
    public void testIsEven_0() {
        NaturalNumber n = new NaturalNumber2(0);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("0", n.toString());
        assertTrue(result);
    }

    // routine (boundary)
    @Test
    public void testIsEven_1() {
        NaturalNumber n = new NaturalNumber2(1);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("1", n.toString());
        assertTrue(!result);
    }

    // hard
    @Test
    public void testIsEven_101() {
        NaturalNumber n = new NaturalNumber2(101);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("101", n.toString());
        assertTrue(!result);
    }

    /*
     * Tests of powerMod
     */

    // boundary
    @Test
    public void testPowerMod_0_0_2() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber p = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals("1", n.toString());
        assertEquals("0", p.toString());
        assertEquals("2", m.toString());
    }

    // routine
    @Test
    public void testPowerMod_17_18_19() {
        NaturalNumber n = new NaturalNumber2(17);
        NaturalNumber p = new NaturalNumber2(18);
        NaturalNumber m = new NaturalNumber2(19);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals("1", n.toString());
        assertEquals("18", p.toString());
        assertEquals("19", m.toString());
    }

    // hard
    @Test
    public void testPowerMod_3_2_10() {
        NaturalNumber n = new NaturalNumber2(3);
        NaturalNumber p = new NaturalNumber2(2);
        NaturalNumber m = new NaturalNumber2(10);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals("9", n.toString());
        assertEquals("2", p.toString());
        assertEquals("10", m.toString());
    }

    // routine
    @Test
    public void testPowerMod_12_3_11() {
        NaturalNumber n = new NaturalNumber2(12);
        NaturalNumber p = new NaturalNumber2(3);
        NaturalNumber m = new NaturalNumber2(11);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals("1", n.toString());
        assertEquals("3", p.toString());
        assertEquals("11", m.toString());
    }

    /*
     * Tests of isWitnessToCompositeness
     */

    // routine
    @Test
    public void isWitnessToCompositeness_3_13() {
        NaturalNumber w = new NaturalNumber2(3);
        NaturalNumber n = new NaturalNumber2(13);
        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals("3", w.toString());
        assertEquals("13", n.toString());
        assertTrue(!result);
    }

    // hard
    @Test
    public void isWitnessToCompositeness_23_3571() {
        NaturalNumber w = new NaturalNumber2(23);
        NaturalNumber n = new NaturalNumber2(3571);
        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals("23", w.toString());
        assertEquals("3571", n.toString());
        assertTrue(!result);
    }

    // routine
    @Test
    public void isWitnessToCompositeness_4_16() {
        NaturalNumber w = new NaturalNumber2(4);
        NaturalNumber n = new NaturalNumber2(16);
        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals("4", w.toString());
        assertEquals("16", n.toString());
        assertTrue(result);
    }

    // boundary
    @Test
    public void isWitnessToCompositeness_2_4() {
        NaturalNumber w = new NaturalNumber2(2);
        NaturalNumber n = new NaturalNumber2(4);
        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals("2", w.toString());
        assertEquals("4", n.toString());
        assertTrue(result);
    }

    /*
     * Tests of isPrime2
     */

    // routine
    @Test
    public void isPrime2_13() {
        NaturalNumber n = new NaturalNumber2(13);
        boolean result = CryptoUtilities.isPrime2(n);
        assertEquals("13", n.toString());
        assertTrue(result);
    }

    // hard
    @Test
    public void isPrime2_104729() {
        NaturalNumber n = new NaturalNumber2(104729);
        boolean result = CryptoUtilities.isPrime2(n);
        assertEquals("104729", n.toString());
        assertTrue(result);
    }

    // boundary
    @Test
    public void isPrime2_4() {
        NaturalNumber n = new NaturalNumber2(4);
        boolean result = CryptoUtilities.isPrime2(n);
        assertEquals("4", n.toString());
        assertTrue(!result);
    }

    /*
     * Tests of isPrime2
     */

    // boundary
    @Test
    public void generateNextLikelyPrime_4() {
        NaturalNumber n = new NaturalNumber2(4);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals("5", n.toString());
    }

    // hard
    @Test
    public void generateNextLikelyPrime_104727() {
        NaturalNumber n = new NaturalNumber2(104727);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals("104729", n.toString());
    }

    // routine
    @Test
    public void generateNextLikelyPrime_143() {
        NaturalNumber n = new NaturalNumber2(143);
        CryptoUtilities.generateNextLikelyPrime(n);
        assertEquals("149", n.toString());
    }
}
