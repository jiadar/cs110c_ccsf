import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

public class TestMyFraction {

    private static double DELTA=0.00000001;
    
    @Test 
    public void testToString() { 
        MyFraction f = new MyFraction(4,12);
        assertEquals(f.toString(),"4.0/12.0");
        f=new MyFraction(-123.112, 4321.16);
        assertEquals(f.toString(),"-123.112/4321.16");
    }

    @Test
    public void testAdd() {
        MyFraction f1 = new MyFraction(9.0,17.0);
        MyFraction f2 = new MyFraction(2.0,5.0);
        assertEquals(f1.add(f2).toString(), "79.0/85.0");
        f1 = new MyFraction(5.0,6.0);
        f2 = new MyFraction(7.0,24.0);
        assertEquals(f1.add(f2).toString(), "9.0/8.0");
    }

    @Test
    public void testSubtract() {
        MyFraction f1 = new MyFraction(9.0,17.0);
        MyFraction f2 = new MyFraction(2.0,5.0);
        assertEquals(f1.subtract(f2).toString(), "11.0/85.0");        
        f1 = new MyFraction(5.0,6.0);
        f2 = new MyFraction(7.0,24.0);
        assertEquals(f1.subtract(f2).toString(), "13.0/24.0");        
    }

    @Test
    public void testMultiply() {
        MyFraction f1 = new MyFraction(9.0,17.0);
        MyFraction f2 = new MyFraction(2.0,5.0);
        assertEquals(f1.multiply(f2).toString(), "18.0/85.0");        
        f1 = new MyFraction(5.0,6.0);
        f2 = new MyFraction(7.0,24.0);
        assertEquals(f1.multiply(f2).toString(), "35.0/144.0");        
    }

    @Test
    public void testDivide() {
        MyFraction f1 = new MyFraction(9.0,17.0);
        MyFraction f2 = new MyFraction(2.0,5.0);
        assertEquals(f1.divide(f2).toString(), "45.0/34.0");        
        f1 = new MyFraction(5.0,6.0);
        f2 = new MyFraction(7.0,24.0);
        assertEquals(f1.divide(f2).toString(), "20.0/7.0");        
    }

    @Test
    public void testReciprocal() {
        MyFraction f1 = new MyFraction(9.0,17.0);
        MyFraction f2 = new MyFraction(2.0,5.0);
        assertEquals(f1.reciprocal().toString(), "17.0/9.0");        
        assertEquals(f2.reciprocal().toString(), "5.0/2.0");        
    }

    @Test
    public void testEquals() {
        MyFraction f1 = new MyFraction(9.0,17.0);
        MyFraction f2 = new MyFraction(5.0,5.0);
        MyFraction f3 = new MyFraction(18.0,34.0);
        assertEquals(f1.equals(f2), false);
        assertEquals(f2.equals(f3), false);
        assertEquals(f1.equals(f3), true);
    }

    @Test
    public void testSimplify() {
        MyFraction f1 = new MyFraction(9.0,27.0);
        MyFraction f2 = new MyFraction(-5.0,-15.0);
        MyFraction f3 = new MyFraction(9.0,37.0);
        f1.simplify();
        f2.simplify();
        f3.simplify();
        assertEquals(f1.toString(), "1.0/3.0");
        assertEquals(f2.toString(), "1.0/3.0");
        assertEquals(f3.toString(), "9.0/37.0");
    }

    @Test
    public void testGetSet() {
        MyFraction f1 = new MyFraction(1,1);
        f1.setNum(4);
        assertEquals(f1.getNum(), 4.0, DELTA);
        f1.setDem(6);
        assertEquals(f1.getDem(), 6.0, DELTA);
    }
 
}

