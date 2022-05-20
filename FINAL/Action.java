import javax.swing.*;					//required import statements
import java.awt.*;						
import java.awt.event.ActionEvent;		
import java.awt.event.ActionListener;
//import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class Action extends JFrame implements ActionListener{
    //constructing the layout of the option pannle
    //private ButtonGroup bg        = new ButtonGroup(); i now realize what this does but i already built in a reset/clear method...my way is more fun
    private JLabel label                = new JLabel("What would you like to do?(choose one)");
    private JRadioButton addcheckAccnt  = new JRadioButton("Add checking account");
    private JRadioButton addsavingsAccnt= new JRadioButton("Add savings account");
    private JRadioButton addCust        = new JRadioButton("Add new customer");
    private JRadioButton viewSAccnt     = new JRadioButton("View savings account");
    private JRadioButton viewCAccnt     = new JRadioButton("View checking account");
    private JRadioButton updatebtn      = new JRadioButton("Update Accounts");
    private JRadioButton writebtn       = new JRadioButton("Write accoutns to a file");   

    private JPanel centerpnl        = new JPanel(new GridLayout(8,1,5,5));

    Action(){ 
        this.setTitle("Login Form");	// frame title
		this.setLocationRelativeTo(null);//location set at center
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

        addComponents();
        setListeners();

        pack();
		setVisible(true);
    }
    // add each button to the center panel
    private void addComponents(){
        centerpnl.add(label);
        centerpnl.add(addcheckAccnt);
        centerpnl.add(addsavingsAccnt);
        centerpnl.add(addCust);
        centerpnl.add(viewSAccnt);
        centerpnl.add(viewCAccnt);
        centerpnl.add(updatebtn);
        centerpnl.add(writebtn);

        getContentPane().add(centerpnl,BorderLayout.CENTER);
    }
    // register each button to create an action event that happens in this class
    private void setListeners(){
        addcheckAccnt.addActionListener(this);
        addsavingsAccnt.addActionListener(this);
        addCust.addActionListener(this);
        viewSAccnt.addActionListener(this);
        viewCAccnt.addActionListener(this);
        writebtn.addActionListener(this);
        updatebtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == addcheckAccnt){
            new addCheckingAccount();
            reset();
        }

        if (ae.getSource() == addsavingsAccnt){
            new addSavingsAccount();
            reset();
        }

        else if (ae.getSource() == addCust){
            new addCustomer();
            reset();
        }

        else if (ae.getSource() == viewSAccnt){
            new viewSAccount();
            reset();
        }

        else if (ae.getSource() == viewCAccnt){
            new viewCAccount();
            reset();
        }

        else if (ae.getSource() == writebtn){
            ArrayList<checkingAccount> Caccounts = viewCAccount.getCheckingAccounts();   // get the array from the checking account class using the method i created
            ArrayList<savingsAccount> Saccounts = viewSAccount.getSavingsAccounts();    // get the array from the savings account class using a method that i created
            write(Caccounts,1);
            write((Saccounts));
            reset();
            JOptionPane.showMessageDialog(this,"Accounts writen");
        }

        else if (ae.getSource() == updatebtn){
            update();
            reset();
            JOptionPane.showMessageDialog(this,"Accouts updated");
        }
        
    }

    public void reset(){
        addcheckAccnt.setSelected(false);
        addsavingsAccnt.setSelected(false);
        addCust.setSelected(false);
        viewSAccnt.setSelected(false);
        viewCAccnt.setSelected(false);
        writebtn.setSelected(false);
        updatebtn.setSelected(false);
    }

    /*update takes savings and checking account file and updates each account in that file. update
      then calls write() which will write the accounts  to a file  */
    public void update(){
        ArrayList<checkingAccount> Caccounts = viewCAccount.getCheckingAccounts();   // get the array from the checking account class using the method i created
        ArrayList<savingsAccount> Saccounts = viewSAccount.getSavingsAccounts();    // get the array from the savings account class using a method that i created
        
        for (checkingAccount a : Caccounts){// for account in checking accounts, update. update is an abstract method. means that each account class has one 
            a.update();
            
        }
        write(Caccounts,1);
        for (savingsAccount a : Saccounts){// for account in  savings account, update
            a.update();
        }

        write((Saccounts));
    }

    /*write will accept a an array go through it and create accounts from each lines info. then it
    will write over the old info the updated version */
    public void write(ArrayList<checkingAccount> a, int x){// account can be savings or checking

        try{// initiate eacch file with the heading
            FileWriter fw = new FileWriter("savings accounts.txt");                    // create filewriter with invoice as name
            fw.write("customer,employee,date_created,account_number,balance,yearly_deposit_percentage,withdrawal_limit_percentage,withdrawal_count");
            FileWriter fw1 = new FileWriter( "checking_accounts.txt"); 
            fw1.write("customer,employee,date_created,account_number,balance,monthly_fee");
            fw.close();
            fw1.close();
        }
        catch(Exception e){}

        for (Account accnt : a){    // for account in array
            try{
                accnt.write();      
            }
            catch( IOException ioe){
                JOptionPane.showMessageDialog(this,"problem with the input or output");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this,"exception writing to the file");
            }
        }
    }

    public void write(ArrayList<savingsAccount> a){// account can be savings or checking
        for (Account accnt : a){    // for account in array
            try{
                accnt.write();      
            }
            catch( IOException ioe){
                JOptionPane.showMessageDialog(this,"problem with the input or output");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this,"exception writing to the file");
            }
        }
    }


}
