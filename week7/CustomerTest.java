import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import org.junit.jupiter.api.BeforeEach;

public class CustomerTest {
    @Test 
    public void testCompareTo(){// last name comparision
        Customer pers = new Customer("zach ben","default@gmail.com","0123456789");
        Customer pers1 = new Customer("OG name","default@gmail.com","0123456789");
        int num;
        num = pers.compareTo(pers1);// if pers is greater than pers1, then should be 1 
        assertEquals(num,1);// b comes before n so 1 is the ouput

        Customer pers2 = new Customer("OG name","default@gmail.com","0123456789");
        Customer pers3 = new Customer("OG name","default@gmail.com","0123456789");
        num = pers2.compareTo(pers3);
        assertEquals(num,0 );// last names are equal so 0 is output

        Customer pers4 = new Customer("zach ben","default@gmail.com","0123456789");
        Customer pers5 = new Customer("OG name","default@gmail.com","0123456789");
        num = pers5.compareTo(pers4);
        assertEquals(num,-1);
    }

    @Test
    public void testSetName(){
        Customer pers = new Customer("OGname","default@gmail.com","0123456789");
        pers.setName("NewName");
        String name = pers.getName();
        assertEquals(name,"NewName");
    }

    @Test 
    public void testSetEmail(){
        Customer pers = new Customer("OGname","default@gmail.com","0123456789");
        String email = pers.getEmail();
        
        pers.setEmail("THISIVALID@gmail.com");// no caps. shouldnt work
        email = pers.getEmail();
        assertEquals(email,"default@gmail.com");

        pers.setEmail("switchdotasdat.gmail@com");// . before @ no workky
        email = pers.getEmail(); 
        assertEquals("default@gmail.com",email);

        pers.setEmail("badem@il@yaho.com");// more than one @ no good
        email = pers.getEmail();
        assertEquals("default@gmail.com",email);

        pers.setEmail("whereistheatgmail.com");// no @ no good
        email = pers.getEmail();
        assertEquals("default@gmail.com",email);

        pers.setEmail("thisshouldwork@yaho.com");// valid email to set as
        email= pers.getEmail();
        assertEquals("thisshouldwork@yaho.com",email);// should work
        
        pers.setEmail("thisnewemail@gmail.com");// another valid email to set
        email= pers.getEmail();
        assertEquals("thisnewemail@gmail.com",email);

    }
    @Test 
    public void testSetPhone(){
        Customer pers = new Customer("OGname","default@gmail.com","0123456789");
        pers.setPhone("1212121212");
        String phone = pers.getPhone();
        assertEquals(phone, "1212121212");
        
        pers.setPhone("12");// bad number should not be set to 
        assertEquals("1212121212", phone);

        pers.setPhone("lol");// bad number should not be made number
        assertEquals("1212121212",phone);
    }
    @Test
    public void testToString(){
        Customer pers = new Customer("OGname","default@gmail.com","0123456789");
        String name = pers.getName();
        String email = pers.getEmail();
        String phone = pers.getPhone();
        String profile = pers.toString();
        assertEquals(name+"\n"+email+"\n"+phone,profile);
        }
    @Test 
    public void testEquals(){
        Customer pers = new Customer("OGname","default@gmail.com","0123456789");
        Customer pers1 = new Customer("OGname","default@gmail.com","0123456789");
        boolean confirm = pers.equals(pers1);
        assertEquals(true, confirm);
    }
}
