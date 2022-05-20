public class Encipher {
    /*takes a key word and makes sure there is no duplicate  letters */
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


    //=====ENCIPHER======
    /*takes the key word and creates an alphabet */
    public static String generateCipherAlphabet(String KeyWord){
        String oldAlphabet= "ABCDEFGHIJKLMNOPQRSTUVWXYZz";
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
            if (fails==0){// if there are no other letters that are the same as this one 
                alphabet+=letter;//...add to new alphabet
            }        
        }
        return alphabet; // return alphabet 
    }

    /*takes the alphabet and a meassage to encipher and codes it */
    public static String encipher(String alphabet, String message){// enciphers the message 
        String oldAlphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZz";
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

    /*takes the alhpabet and coded message and decodes it */
    public static String decipher(String alphabet, String message){// decipher the enciphered code 
        String oldAlphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZz";
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


    //=====ROT=====
    /*takes the length the rot character set needs to be and produces a set of rot characters */
    public static String rotCharacterSet(int length){
        String string = "";// the alphabet is just going to be added to the string
        if(length==13){
            // for each character in the askii range, add to string/alphabet         
            for(int index=65; index<=90; ++index){
                char letter = (char) index;
                string += letter;                
            }           
        }    
        
        else{// for each character in askii range add to string/alphabet...rot47        
            for(int index = 33; index<=126; index+=1){
                char letter = (char) index;  
                string+=letter;
            }
       }  

        return string;
    }

    /* this is going to apply the ROT conversion and return the coded string */
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
