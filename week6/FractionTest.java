import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.assertEquals;

public class FractionTest {
    Fraction frac;// create the four fraction to help 
    Fraction frac2;
    Fraction frac3;
    Fraction frac4;
        @BeforeEach
        public void setUp(){// assign values half,half, two, one
            frac = new Fraction(1,2);
            frac2= new Fraction(2,4);
            frac3= new Fraction(2,1);
            frac4= new Fraction(1/1);
        }
        
        @Test 

        public void testGetNumerator(){      
            setUp();
            int num = frac.getNumerator(); 
            assertEquals(1,num);
        }
        @Test
        public void testGetDenominator(){
            setUp();
            int den = frac.getDenominator();
            assertEquals(2,den);
        }
        @Test
        public void testSetNumerator(){
            setUp();
            int newNum = 4;
            frac.setNumerator(newNum);
            assertEquals(4,newNum);
        }
        @Test
        public void testSetDenominator(){
            setUp();
            int newNum = 3;
            frac.setDenominator(newNum);
            assertEquals(3,newNum);
        }
        @Test
        public void testToString(){
            setUp();
            String str = frac.toString();//frac = 1/2
            assertEquals("1/2",str);
        }
        @Test
        public void testEquals(){
            setUp();
            boolean a = frac.equals(frac2);// frac =1/2, frac2 = 2/4
            assertEquals(true,a);
        }
        @Test
        public void testCompareTo(){
            setUp();
            int zero = frac.compareTo(frac2);// even so zero should be retunred
            int minus1 = frac.compareTo(frac3);// frac is less than so it should be -1
            int one = frac3.compareTo(frac);// frac3 is greater so it should be 1
            assertEquals(0,zero);
            assertEquals(-1,minus1);
            assertEquals(1,one);
        }
        @Test
        public void testAdd(){
            setUp();// adding is tough because 1/1 doesnt always equal 1/1
            frac.add(frac2);// 1/2 + 2/4 =1= frac4
            boolean b = frac.equals(frac4);
            assertEquals(true,b);
        }
        @Test
        public void testSubtract(){
            setUp();
            frac4.subtract(frac2);// 1 - 1/2 = 1/2 = frac2
            boolean b =  frac4.equals(frac2);
            assertEquals(true,b);

        }
        @Test
        public void testMultiply(){
            setUp();
            frac4.multiply(frac2);// 1 * 1/2 = 1/2 = frac2
            boolean b = frac4.equals(frac2);
            assertEquals(true,b);
        }
        @Test
        public void testDivide(){
            setUp();
            frac.divide(frac2);// (1/2 / 2/4) = (1/2 * 4/2) = 1 = frac4
            boolean b = frac.equals(frac4);
            assertEquals(true,b);
        }

}


