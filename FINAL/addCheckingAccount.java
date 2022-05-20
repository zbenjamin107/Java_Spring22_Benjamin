import javax.swing.*;					//required import statements
import java.awt.*;						
import java.awt.event.ActionEvent;		
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
public class addCheckingAccount extends JFrame implements ActionListener{
    // construct a window for the 
    private JPanel centerpnl    = new JPanel(new GridLayout(7,2,5,5));
    //labels
    JLabel CNamelbl             = new JLabel("Customer Name");
    JLabel ENamelbl             = new JLabel("Employee name");
    JLabel dateCreatedlbl       = new JLabel("Date created");
    JLabel accntNumlbl          = new JLabel("account number");
    JLabel balancelbl           = new JLabel("Balance");
    JLabel feelbl               = new JLabel("Montly fee");
    // text fields
    JTextField CNametxt         = new JTextField();
    JTextField ENametxt         = new JTextField();
    JTextField dateCreatedtxt   = new JTextField();
    JTextField accntNumtxt      = new JTextField();
    JTextField balancetxt       = new JTextField();
    JTextField feetxt           = new JTextField();

    JButton okbtn       = new JButton("OK");

    addCheckingAccount(){
        this.setTitle("checking account");	// frame title
		this.setLocationRelativeTo(null);//location set at center
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//close frame when we exit
		setResizable(false);  //looks bad when it is resized

	    setLayout();            		// adds the buttons and text to the frame
		setListeners();					// they must be set so they can be performed 

		this.pack();//"sizes the frame so that all its contents are at or above their preferred sizes" - google. cant see buttons without it
		this.setVisible(true);
    }
    
    // add buttons to the panel
    public void setLayout(){
        centerpnl.add(CNamelbl);
        centerpnl.add(CNametxt);
        centerpnl.add(ENamelbl);
        centerpnl.add(ENametxt);
        centerpnl.add(dateCreatedlbl);
        centerpnl.add(dateCreatedtxt);
        centerpnl.add(accntNumlbl);
        centerpnl.add(accntNumtxt);
        centerpnl.add(balancelbl);
        centerpnl.add(balancetxt);
        centerpnl.add(feelbl);
        centerpnl.add(feetxt);
        centerpnl.add(okbtn);
        this.getContentPane().add(centerpnl,BorderLayout.SOUTH);
    }
    // 'activate' listeners
    public void setListeners(){
        okbtn.addActionListener(this);
    }

    @Override
    /*going to read from customers to get the info of the cutomer name entered, then read from employees
    to get the info from the employee name entered, create the account from the given information */
    public void actionPerformed(ActionEvent ae){
        try{
            // find the info of the custmer 
            File f1 = new File("customers.csv");   // open the file with the info
            Scanner s1 = new Scanner(f1);               
            s1.nextLine();                                  //skip the first line
            Customer c1 = new Customer();                   // create the variable
            while(s1.hasNext()){                            // read line for line and try to find the name that mathces
                String[] line = s1.nextLine().split(",");// info is divided by commas
                String[] CNames = line[0].split(" ");   // first and last name seperated by a space
                if(line[0].equals(CNametxt.getText())){        // if the first and last name match...create a customer from the info on that line
                    c1 = new Customer(CNames[0],CNames[1],line[1],new Date(line[2]),new Date(line[3]), line[4]);
                }
            }
            // find the info of the employee
            File f2 = new File("employees.csv");// open and scann the file
            Scanner s2 = new Scanner(f2);
            s2.nextLine();                               // skip the first line
            Employee e = new Employee();                 // create the variable
            while(s2.hasNext()){
                String[]line = s2.nextLine().split(",");// info seperated by a comma
                String[] ENames = line[0].split(" ");   // names are seperted by a space
                if (line[0].equals(ENametxt.getText())){       // if the name mathces then take the info from that line and create a customer
                    e = new Employee(ENames[0],ENames[1], line[1], new Date(line[2]), new Date(line[3]), Integer.parseInt(line[4]),line[5]);
                } 
            }
            // now create the account 
            checkingAccount a = new checkingAccount(c1,e,new Date(dateCreatedtxt.getText()), Integer.parseInt(accntNumtxt.getText()), Double.parseDouble(balancetxt.getText()), Double.parseDouble(feetxt.getText()));
            File f3 = new File("checking_accounts_real.csv");// file that will be writen to
            FileWriter fw = new FileWriter(f3,true);           // add info; dont delete old info
            fw.write("\n" + a.getCustomer().getName() + "," + a.getManager().getName() + "," + a.getDateCreated() + "," + a.getAccountNumber() + "," + a.getBalance() + "," + a.getMonthlyFee());

            JOptionPane.showMessageDialog(this, "Account created!");// account created
            s1.close();
            s2.close();
            fw.close();
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"must enter the following: Existing customer name (String), Existing Employee name (String), date crated (Date), Account number (int), balance (double), monthly fee (double)");
            
        }
    }

    // resets/cleats the text blocks
    void reset(){
        CNametxt.requestFocus();
        CNametxt.setText("");
        ENametxt.setText("");
        dateCreatedtxt.setText("");
        accntNumtxt.setText("");
        balancetxt.setText("");
        feetxt.setText("");
    }

}
