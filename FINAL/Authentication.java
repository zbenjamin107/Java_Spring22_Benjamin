import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

 

/*this class has one method. the method takes the name,PW, and keyword and sees if the three  match any
the file. if not then it will reset the login. if it does it will loggin */
public class Authentication {

    public void  checkLogin(String nametxt, char[] PWtxt, String keytxt) throws InvalidLoginException, FileNotFoundException{
		String PW = "";// first we gotta get the PW in correct form since it comes in an array
		for (char c : PWtxt){// for char in PW array
			PW += c;		 // add that character to the new PW
		}
		// now we have the PW, we have the info of the employee
		String info = nametxt + " " + PW + " " + keytxt;//employee info
		File f = new File("info.txt");		// open file with the info
		Scanner s = new Scanner(f);						//scan this file
		while (s.hasNextLine()){						// wile the file has a next line(each line contains "username PW keyword")
			if(s.nextLine().equals(info)){				// compare the line with our info
				s.close();								//equal? then close the scanner..
				return;									// ..and return
			}
		}
		s.close();										//if it doesnt return, throw an exception
		throw new InvalidLoginException("User info does not match!");
		
	}
}

