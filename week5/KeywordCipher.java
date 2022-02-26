import java.io.FileWriter;
import java.io.IOException;
public class KeywordCipher{

    public static void main(String[] args){//arguments: (str) meassage, (str) keyword, (str)filename
        String message =args[0].toUpperCase();// all the letters in the message will be capitol 
        String word = args[1].toUpperCase();// word to make keyword
        String fileName= args[2];// filename
        String keyWord= PrepareKeyWord(word);// begin calling functions
        String Calphabet= generateCipherAlphabet(keyWord);
        String coded = encipher(Calphabet,message);
        String decoded = decipher(Calphabet,coded);        
        System.out.println("The coded message is-> "+coded);// print statements
        System.out.println("The decoded message is-> "+decoded);
        try{// write to files
            FileWriter fileWriter= new FileWriter(fileName);
            fileWriter.write(coded);
            fileWriter.close();
        }
        catch(IOException ioe){// except error
            System.out.println("There was a problem with the IO.");
        }
    }

    public static String PrepareKeyWord(String keyWord){
        int index = 0;
        String newKeyWord = "";
        for(index = 0; index<keyWord.length();++index){// loops through the word letter by letter
            String letter = keyWord.substring(index,index+1);
            int times = 0;
            int fails=0;
            for(times=0;times<index;++times){// for each letter, another loop test if the same letter is already in the word
                String newLetter = keyWord.substring(times,times+1);
                if( newLetter.equals(letter)){// test to see if the letters match. if the letters match then there is another
                    fails+=1;// fails just means there is a duplicate
                }
            }
            if (fails<=0){// if there are no fails add the letter to the new word
                newKeyWord+=letter;              
            }            
        }
        return newKeyWord;// return the new word
    }


    public static String generateCipherAlphabet(String KeyWord){
        String oldAlphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabet= "";
        alphabet+= KeyWord;// first letters in the alphabet is the key word 
        int index = 0; 
       
        for(index=0; index<oldAlphabet.length();++index){// goes through the alphabet letter by letter
            String letter = oldAlphabet.substring(index,index+1);
            int fails=0; 
            int times=0;
            for(times=0;times<alphabet.length();++times){// loops through the new alphabet and sees if the there is another same letter already present 
                String newLetter = alphabet.substring(times, times+1);
                if (newLetter.equals(letter)){// does the letter = the other 
                    fails+=1;// there is a another already 
                }
            }
            if (fails<=0){// if there are no other letters that are the same as this one 
                alphabet+=letter;//...add to new alphabet
            }        
        }
        return alphabet; // return alphabet 
    }
    public static String encipher(String alphabet, String message){// enciphers the message 
        String oldAlphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String newMessage = "";
        int index=0;
        int times = 1;
        for(index=0;index<message.length();++index){// loops through the message letter by letter 
            String letter = message.substring(index,index+1);
            if (times%6==0){// every 6th time add a space
                newMessage+=" ";
                index-=1;// since no letter was printed at this index we subtract one to cancle the plus one
            }
            else if(letter.equals(" ")){// if there is a space just move over it 
                
                continue;
            }
            else{// if there are no curve balls, encipher the message. 
                int indexOfLetter = oldAlphabet.indexOf(letter);
                String newLetter = alphabet.substring(indexOfLetter,indexOfLetter+1);
                newMessage+=newLetter;// append letter for letter to the new message
            }
            times+=1;
        }
        return newMessage ;// return the message 
    }
    public static String decipher(String alphabet, String message){// decipher the enciphered code 
        String oldAlphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int index = 0;
        String newMessage="";
        for (index=0;index<message.length();++index){// loops through the message letter by letter
            String letter = message.substring(index,index+1);
            String newLetter = "";
            if (letter.equals(" ")){
                newLetter=" ";  // if there is a space, replace it              
            }
            else{
                int indexOfLetter = alphabet.indexOf(letter);
                newLetter+=oldAlphabet.substring(indexOfLetter,indexOfLetter+1);// add the letter to the new letter                 
            }
        newMessage+=newLetter;// add the letter to the message 
        }
        
        return newMessage;// return the message
    }

}