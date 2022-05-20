import java.io.File;
import java.io.FileWriter;
import java.util.Random;
/*this class is to genereate usernames passwords and keywords. it generates them in another file as well
  encrypted */
public class userInfo {
    public static void main(String[] args) {
        int times = 0;
        String encypheredData = "";
        String data = "";
        String userName;
        String password;
        String keyWord;
        /*creating user name, pw, and keyword 26 times and adding to date to be writen to a file. another
        file will be written to containing the original keyword */
        while(times<=25){
            userName = generateRandomWord();//random word
            password = generateRandomWord();
            keyWord = generateRandomWord();
            data += userName + " " + password + " " + keyWord + "\n";         // for the keyword file. original key, new line

            String encipheredKeyWord = Encipher.applyRot(keyWord,14);           // enypher the key word
            String cipherAlphabet = Encipher.generateCipherAlphabet(encipheredKeyWord); // create the cypher aphabet from  the encyphered key word
            String encipheredUserName = Encipher.encipher(cipherAlphabet, userName);    // encypher username and pw from the alphabet  
            String encipheredPassword = Encipher.encipher(cipherAlphabet, password);      

            encypheredData += encipheredUserName + " " + encipheredPassword + " " + encipheredKeyWord + "\n";// this will be stored in another file. each line represent an employees info
            times+=1;
        }
        File f = new File("encryptedInfo.txt");      //file name for employee info
        File f1 = new File("info.txt"); // file for keyword names
        try{
            FileWriter wr = new FileWriter(f);
            wr.write(encypheredData);       // encyphered data to the user txt
            FileWriter fw = new FileWriter(f1);
            fw.write(data);                 // keywords to KeyWordstxt
            
            wr.close();                     //close 
            fw.close();
        }
        catch(Exception e){                 // catches any exception. print statement blames it on write to file exception
            System.out.println("problem writing to the file");
        }
        
    }
   
    

    /*creates random word */
    static String generateRandomWord() {
        int wordLength = 6;     // all words are 6 in length
        Random r = new Random(); 
        StringBuilder sb = new StringBuilder(wordLength);
        for(int i = 0; i < wordLength; i++) { // For each letter in the word
            char tmp = (char) ( 'A' + r.nextInt('Z' - 'A')); // Generate a letter between a and z
            sb.append(tmp); // Add it to the String
        }
        return sb.toString();// return the word
    }

}
