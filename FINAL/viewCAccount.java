import javax.swing.*;
import java.awt.*;						
import java.awt.event.ActionEvent;		
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class viewCAccount extends JFrame implements ActionListener{
    private static ArrayList<checkingAccount> CAccount = new ArrayList<checkingAccount>();
    int thisaccount = 1;// used as an index later to tell where in the array we are. for later
    // panel
    private JPanel centerpnl        = new JPanel(new GridLayout(6,6,15,5));
    
    JComboBox<String> checkingCombo = new JComboBox<String>();
    // labels
    private JLabel MNamelbl         = new JLabel("Manager Name");
    private JLabel CNamelbl         = new JLabel("Customer name");
    private JLabel dateCreatedlbl   = new JLabel("Date created");
    private JLabel accntlbl         = new JLabel("Account number");
    private JLabel balancelbl       = new JLabel("Balance");
    private JLabel feelbl           = new JLabel("Monthly fee");
    // txt fields
    private JTextField MNametxt         = new JTextField();
    private JTextField CNametxt         = new JTextField();
    private JTextField dateCreatedtxt   = new JTextField();
    private JTextField accnttxt         = new JTextField();
    private JTextField balancetxt       = new JTextField();
    private JTextField feetxt           = new JTextField();

    viewCAccount(){
        this.setTitle("Customers");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);// dont close the system, just 'close' the window
        setLocationRelativeTo(null);
        setResizable(false);                // please, do not allow people to resize. it looks terrible

        addComponents();    // add the buttons and txt
        registerListeners();

        loadAccounts();   // loads accounts into an array  
        fillDropDown();  // fills the drop down box  

        
        pack(); 
        setVisible(true);

        populateFields();   // fill the text fields with current employee. Do this last
    }
    

    //add each lable and txt to the panel in the order it appears
    void addComponents(){
        centerpnl.add(CNamelbl);
        centerpnl.add(CNametxt);
        centerpnl.add(MNamelbl);
        centerpnl.add(MNametxt);
        centerpnl.add(dateCreatedlbl);
        centerpnl.add(dateCreatedtxt);
        centerpnl.add(accntlbl);
        centerpnl.add(accnttxt);
        centerpnl.add(balancelbl);
        centerpnl.add(balancetxt);
        centerpnl.add(feelbl);
        centerpnl.add(feetxt);

        this.getContentPane().add(centerpnl, BorderLayout.CENTER);// adds panle to frame
        this.getContentPane().add(checkingCombo, BorderLayout.NORTH);// the drop down box will be on top of the panel
    
    }

    //'activates' the listeners so they know when  to create an action event
    void registerListeners(){
        checkingCombo.addActionListener(this);
    }

    /*to load the accounts we must add all the accouts to an array. to do that we take the name of the customer 
    and scann cusomers.cvs and find their info, make a customer and use it to create an account. we also take the 
    name of the employee and find their info in employees.cvs and create an employee to create our account */
    static void loadAccounts(){
        File f = new File("checking_accounts_real.csv");
        try{
            Scanner s = new Scanner(f);
            s.nextLine();               // since the first line is is not an account it must be skipped
            while( s.hasNext() ){
                String[] row    = s.nextLine().split(",");//new line. from that line...
                String Cname    = row[0];                       // name of customer
                
                File f1 = new File("customers.csv");  // trying to scann the customer file to create a customer   
                Scanner s1 = new Scanner(f1);
                s1.nextLine();                                  // skip the first line because it just has heading
                Customer c = new Customer();
                while(s1.hasNext()){                            // while the file has a line to scan
                    String[] line = s1.nextLine().split(",");// scann the line and split at the comma
                    if(line[0].equals(Cname)){                  // if the name mathches then create a customer from their info 
                        String[] Cnames = line[0].split(" ");
                        try{                                            // try creating a customer
                            c = new Customer(Cnames[0],Cnames[1],line[1],new Date(line[2]),new Date(line[3]),line[4]);
                        }
                        catch(Exception e){                            // just in case an error comes up
                            System.out.println("no worky my friend");
                        } 
                    }
                }
                // now try to create an employee from that line
                String Ename = row[1];                                // from the first scanner get the employee name
                File f2 = new File("employees.csv");        // file to scann from 
                Scanner s2 = new Scanner(f2);                        // scann that file
                s2.nextLine();                                       // first line is like a heading
                Employee e1 = new Employee();
                while(s2.hasNext()){
                    String[] line = s2.nextLine().split(",");  // next line
                    if(line[0].equals(Ename)){                        // if the name matches
                        String[] Enames = Ename.split(" ");     // create an employee from their info
                        e1 = new Employee(Enames[0],Enames[1],line[1],new Date(line[2]),new Date(line[3]), Integer.parseInt(line[4]),line[5]);
                    }
                }
                
                checkingAccount ca = new checkingAccount(c,e1,new Date(row[2]),Integer.parseInt(row[3]), Double.parseDouble(row[4]), Double.parseDouble(row[5]));
                CAccount.add(ca);                                   // add account to checking account
                s2.close();
                s1.close();                                         // close the scanner that scanned customers  
            }
            s.close();                                              // close the scanner
                                                     
        }catch(Exception e){                                        //in case of an emergency
            System.err.println("problem reading from the file");
        }
    }

    /*used in the action class to write and update */
    public static ArrayList<checkingAccount> getCheckingAccounts(){
        loadAccounts();
        return CAccount;
    }

    // fills the drop down with names 
    public void fillDropDown(){
        for(checkingAccount a: CAccount){// account in savings
            checkingCombo.addItem(a.getCustomer().getName() + ", " + a.getManager().getName());// add the first and last name to the drop down
        }   // i realized i had to add the manager name here. getselectedindex in action performed will
            // return the first result with the same customer name, but there are multiple accounts for
            // one customer so i have to be specific and add the manager name so it shows the info for 
            // the correct account. if i dont you will see the same account info for one customer no matter
            // which account you tap on and that is whatever account comes first in the list for that customer
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // we know the only action event is savings combo
        thisaccount = checkingCombo.getSelectedIndex();
        populateFields();
    }

    // fills the text with the information
    void populateFields(){
        checkingAccount a = CAccount.get(thisaccount);
        MNametxt.setText(a.getManager().getName());
        CNametxt.setText(a.getCustomer().getName());
        dateCreatedtxt.setText(a.getDateCreated() + "");
        accnttxt.setText(a.getAccountNumber() + "");
        balancetxt.setText(a.getBalance() + "");
        feetxt.setText(a.getMonthlyFee() + "");
    }
    



}
