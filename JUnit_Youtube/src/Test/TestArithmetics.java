package Test;

import Calculation.Arithmetics;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class TestArithmetics {

    private Arithmetics a;

    @Rule
    public final ExpectedException exp = ExpectedException.none();

    @Rule
    public final Timeout timeout = new Timeout(1000);

    @Before
    public void setUp() throws Exception {
        a = new Arithmetics();
    }

    @After
    public void tearDown() throws Exception {
        a = null;
    }

    @Test
    public void testAdd() {
//        Arithmetics a = new Arithmetics();
        double res = a.add(3, 7);
/*
        if (res != 10) {
            fail();
        }
*/
        assertEquals(10, res, 0.0001);
    }

    @Ignore
    @Test
    public void testDeduct() {
//        Arithmetics a = new Arithmetics();
        double res = a.deduct(3, 7);
/*
        if (res != -4) {
            fail();
        }
*/
        assertEquals(4, res, 0.0001);
    }

    @Test
    public void testMult() {
//        Arithmetics a = new Arithmetics();
        double res = a.mult(3, 7);
/*
        if (res != 21) {
            fail();
        }
*/
        assertEquals(21, res, 0.0001);
    }

    @Test
    public void testDiv() {
        //        Arithmetics a = new Arithmetics();
        double res = a.div(10, 5);
/*
        if (res != 2.0) {
            fail();
        }
*/
        assertEquals(2.0, res, 0.0001);
    }

    @Test/*(expected = ArithmeticException.class)*/
    public void testDivException() {
        exp.expect(ArithmeticException.class);
        a.div(10.0, 0.0);
    }

    @Test/*(timeout = 1000)*/
    public void testN() {
        while (true) {

        }
    }
}