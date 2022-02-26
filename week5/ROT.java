import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
public class ROT{
    public static void main(String[] args){
        
        if( args.length<3){ // if there are less than 3 arguments there is no need to run the code
            System.out.println("3 arguments are required for this program; file name, 'e' or 'd' and a ROT number ");
            return;
        }

        File fileName =new File(args[0]);// convert the file name to a file
        String string = args[1]; // string is either 'e' or 'd'(encrypt or decrypt)
        int Num = Integer.parseInt(args[2]);// Rot number 
         
        if(!(string.equals("e") || string.equals("d") )){// if the string is not 'e' or 'd', abort
            System.out.println("Invailid arguments.");            
        }

        if(!(Num==13 || Num==47)){// if number is not 13 or 47, 13 is assigned and the code will run 
            System.out.println("invalid integer. ROT number is 13");
            Num=13;
        }
    
        try{
            Scanner f = new Scanner(fileName); 
            String data= "";// data represents the writen information stored on the file 
            while( f.hasNextLine()){// as long as there is a next line convert the line and add to 'data'
                String line = f.nextLine();
                String newLine = applyRot(line, Num);
                data+=newLine;
            }
            String newName="";// name of the file if it needs to be encrypted
            if(string.equals("e")){
                newName += args[0].substring(0,args[0].length()-4)+"_encrypted.txt";
            }    
            else{// name of file if it needs to be dectrypted 
                newName+= args[0].substring(0,args[0].length()-14)+".txt";
            }
            
            try{// write data to new file
                FileWriter fileWriter = new FileWriter(newName);
                fileWriter.write(data);
                fileWriter.close();
            
            }
            catch(IOException e){
                System.out.println("there was a problem writing to the file");
            }
            f.close();
        }

        catch(FileNotFoundException e){
            System.out.println("File not foud!");
            return;
        }
    } 
    
    // this will create an 'alphabet' for each ROT number
    public static String rotCharacterSet(int length){
        String string = "";// the alphabet is just going to be added to the string
        if(length==13){
            // for each character in the askii range, add to string/alphabet         
            for(int index=65; index<=90; ++index){
                char letter = (char) index;
                string += letter;                
            }           
        }    
        
        else{// for each character in askii range add to string/alphabet        
            for(int index = 33; index<=126; index+=1){
                char letter = (char) index;  
                string+=letter;
            }
       }  

        return string;
    }

    // this is going to apply the ROT conversion and return the coded string 
    public static String applyRot(String message,int RotNum){        
        String code = ""; // the code is going to be added to the string 
        String alphabet= rotCharacterSet(RotNum);
            
        if (RotNum==13){
            message=message.toUpperCase();// converts all letters to upper case in the string
            
            int index=0;             
            for(index=0; index<message.length();++index){// fot each letter in the message
                String letter = message.substring(index,index+1); // takes the individual letter by using substring
                int alphabetIndex=(alphabet.indexOf(letter)+13)%26;// takes the index of the letter in the alphabet. in case +13 goes over 26, i use % to get the remainder
                String codeLetter=alphabet.substring(alphabetIndex,alphabetIndex+1);// get the letter by using the alphabet index 
                code+=codeLetter;// append letter to code 
            }
        }

        else{
            int index=0;
            for(index=0; index<message.length();++index){// very similar to the loop above 
                String letter = message.substring(index,index+1);// takes the individual letter 
                int alphabetIndex = (alphabet.indexOf(letter)+47)%94;// gets the index of the letter i the alphabet
                String codeLetter = alphabet.substring(alphabetIndex,alphabetIndex+1);//  gets the letter in code 
                code+=codeLetter;   // adds the letter to the code        
            }
        }    
        return code;
    }
}