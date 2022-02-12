import java.util.Scanner;

class Primitives{
    public static void main(String[] args) {
        byte first = 45;    // calling each variable 'first','second' and so on based on creation oder 
        short second = 55;
        char third = 65;//also gives us 'A' in askii code
        int fourth = 75;
        long fifth = 85;
        float sixth = (4/3);//note: i was reminded that this will round down to a whole number
        double seventh = (4.0/3.0);
        char eighth = 'A';//once converted to a numerical form, should get 65

        System.out.printf("the byte value is: %d",first); 
        System.out.printf("\nthe short value is: %d",second);
        System.out.printf("\nthe char value is: "+third);
        System.out.printf("\nthe int vlue is: %d",fourth);
        System.out.printf("\nthe long value is: %d",fifth);                  
        System.out.printf("\nthe float value is: %f",sixth);
        System.out.printf("\nthe double value is: %.3f",seventh);//rounds to 3 decimal places 
        System.out.printf("\nthe second char value is: "+eighth);
        //widening every varibale 

        short first1= first;// no change in the apperance. the change is in space
        char second1= (char)second;//this one will give us a letter from the askii code that is equal to 55. this one required the (char)
        int third1= third;// no change in apperance
        long fourth1 = fourth;//no change in apperance 
        float fifth1= fifth;//this will add the decimal place to the number 
        double sixth1= sixth;// this will only use one decimal instead of 6
        int eighth1 = eighth;//convert the 'A' to a integer on the askii sheet

        System.out.println("\n\nThe byte value as a short is:"+first1);
        System.out.println("The short value as a char is:"+second1);
        System.out.println("The char value as an int is:"+third1);
        System.out.println("The int value as a long is:"+fourth1);
        System.out.println("The long value as a float is:"+fifth1);
        System.out.println("The float value as a double is:"+sixth1);
        System.out.println("The second char value as an int:"+eighth1);

        byte second2=(byte)second;// no change in apperance
        short third2=(short)third;//no change in apperance
        char fourth2=(char)fourth;//changes the number to a letter from the aski code
        int fifth2=(int)fifth;// no change in appeance
        long sixth2=(long)sixth;// drops the decimal place at the end
        float seventh2=(float) seventh;// no change in apperance although i initially thouhgt the type would round it down to a whole number
        double eighth2=(double)eighth;// changes the vallue 'A' to a 65 as a double

        System.out.println("\nThe short value as a byte is:"+second2);
        System.out.println("The char value as a short is:"+third2);
        System.out.println("The int value as an char is:"+fourth2);
        System.out.println("The long value as a int is:"+fifth2);
        System.out.println("The float value as a long is:"+sixth2);
        System.out.println("The double value as a float is:"+seventh2);
        System.out.println("The second char value as a double:"+eighth2);

        int variable1= Integer.MAX_VALUE;// type:integer, value:max value...simple enough
        int varibale2= Integer.MIN_VALUE;// type:integer, value:min value
        System.out.println("Integers max value is -> "+variable1);
        System.out.println("Integers min value is -> "+varibale2);

        System.out.println("In comparision the long has a greater storage than the int does");

        long varibaleA= Long.MAX_VALUE;// the long type has a bigger storage than 'int', both in negative and positive directions
        long variableB= Long.MIN_VALUE;
        System.out.println("Max value of long -> "+varibaleA);
        System.out.println("Min value of long -> "+variableB);

        System.out.println("Enter a number to be squared");
        Scanner input= new Scanner(System.in);
        int num= input.nextInt(); // this is taking the next integer in the input
        int x=2; //this is just the power. im going to increase the power by 1 each loop
        System.out.printf("the number entered is: %d",num);
        while(x<=4){ // until the the power is greater than 4 do this
            int y= (int) Math.pow(num, x);
            System.out.printf("\nthe number entered to the "+x+" power is: %d",y);
            x+=1;
        }
        System.out.println();// just so it goes to the nex line. im experimenting with different methods is all 

        System.out.println("Enter a nunmber to be a dividend");
        Scanner Input =new Scanner(System.in);
        double dividend = (double)Input.nextInt();
        System.out.println("Enter anumber to be a divisor");
        Scanner input1 =new Scanner(System.in);
        double divisor = (double)input1.nextInt();

        float answer1 =(float)(dividend/divisor);
        int answer2 =(int)(dividend %divisor);
        System.out.printf("The floor division is %.1f", answer1);
        System.out.printf("\nThe floor modulus is %d",answer2);

        Input.close();
        input1.close();
               
        
        
        input.close();








    }










}