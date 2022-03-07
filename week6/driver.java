import java.util.Scanner;
import java.io.File;

public class driver {
    public static void main(String[] args){
        Fraction frac1 = new Fraction(4,-8);
        Fraction frac2 = new Fraction(5);
        Fraction frac3 = new Fraction(8,2);
        Fraction frac4 = new Fraction(-4,-1);

        System.out.printf("the numerator of frac4 is: %d and the denominator is: %d\n",frac4.getNumerator(),frac4.getDenominator());
        System.out.printf("the numerator of frac1 is: %d and the denominator is: %d\n",frac1.getNumerator(),frac1.getDenominator());
        System.out.printf("-1 if frac2<frac1, 0 if = , or 1 if frac2 is greater: %d\n",frac2.compareTo(frac1));
        System.out.printf("does frac1 equal frac3? %s\n",frac1.equals(frac3));        
        frac1.add(frac3);
        System.out.printf("when frac3 is added to frac1 we get: %s\n", frac1.toString() );
        frac4.multiply(frac2);
        System.out.printf("when frac4 is multiplied by frac2 we get: %s\n", frac4.toString());
        frac3.subtract(frac2);
        System.out.printf("when frac2 is subtracted from frac3 we get: %s\n",frac3.toString());
        frac2.divide(frac1);
        System.out.printf("when frac2 is divided by frac1 we get: %s\n",frac2.toString());
        
        Fraction[] fractions = new Fraction[100];
        try{
            File f = new File("fractions.txt"); 
            Scanner scanner = new Scanner(f);            
            int index=0;           
            while(scanner.hasNext()){
                String[] nums = (scanner.nextLine()).split(",");
                int numerator= Integer.parseInt(nums[0]);
                int denominator = Integer.parseInt(nums[1]);
                Fraction frac = new Fraction(numerator,denominator);
                fractions[index] = frac;
                index+=1;
            }
        scanner.close();
        }
        catch(Exception e){
            System.out.println("no worky");
        }
        Fraction top = new Fraction(0/1);
        for(Fraction frac : fractions){
            if (frac.compareTo(top)==1){
                top = frac;
            }
        }
        System.out.printf("the highest number is: %s\n",top.toString());
    }
}
