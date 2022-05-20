import javax.swing.*;					//required import statements
import java.awt.*;						
import java.awt.event.ActionEvent;		
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
public class addCustomer extends JFrame implements ActionListener{

    // construct a window for the 
    private JPanel centerpnl    = new JPanel(new GridLayout(7,2,5,5));
    //labels
    private JLabel fNamelbl     = new JLabel("first name");
    private JLabel lNamelbl     = new JLabel("last name");
    private JLabel phonelbl     = new JLabel("phone number");
    private JLabel DOBlbl       = new JLabel("DOB (MM/DD/YYYY)");
    private JLabel dateJoinedlbl= new JLabel("date joined (MM/DD/YYYY)");
    private JLabel IDlbl        = new JLabel("customer ID");
    //text feilds
    private JTextField fNametxt = new JTextField();
    private JTextField lNametxt = new JTextField();
    private JTextField phonetxt = new JTextField();
    private JTextField DOBtxt   = new JTextField();
    private JTextField dateJoinedtxt = new JTextField();
    private JTextField IDtxt    = new JTextField();
    //botton
    private JButton okbtn       = new JButton("OK");
    
    public addCustomer(){
        this.setTitle("Enter cutomer info");	// frame title
		this.setLocationRelativeTo(null);//location set at center
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//close frame when we exit
		setResizable(false);  //looks bad when it is resized

	    setLayout();            		// adds the buttons and text to the frame
		setListeners();					// they must be set so they can be performed 

		this.pack();//"sizes the frame so that all its contents are at or above their preferred sizes" - google. cant see buttons without it
		this.setVisible(true);
    }

    public void setLayout(){
        centerpnl.add(fNamelbl);
        centerpnl.add(fNametxt);
        centerpnl.add(lNamelbl);
        centerpnl.add(lNametxt);
        centerpnl.add(phonelbl);
        centerpnl.add(phonetxt);
        centerpnl.add(DOBlbl);
        centerpnl.add(DOBtxt);
        centerpnl.add(dateJoinedlbl);
        centerpnl.add(dateJoinedtxt);
        centerpnl.add(IDlbl);
        centerpnl.add(IDtxt);
        centerpnl.add(okbtn);
        this.getContentPane().add(centerpnl,BorderLayout.SOUTH);
    }

    public void setListeners(){
        okbtn.addActionListener(this);
    }
   
    @Override
    public void actionPerformed(ActionEvent ae){
        try{
            Date d = new Date(DOBtxt.getText());
            Date d2 = new Date(dateJoinedtxt.getText());
            Customer c = new Customer(fNametxt.getText(),lNametxt.getText(),phonetxt.getText(),d,d2,IDtxt.getText());
            
            JOptionPane.showMessageDialog(this, "Customer Created!");
            File f = new File("customers.csv");
            FileWriter fw = new FileWriter(f,true); // true makes it add content instead of deting old content
            fw.write("\n" +c.getName()+ "," + c.getPhoneNumber() + "," + c.getDOB() + "," + c.getDateJoined() + "," + c.getCustID());
            fw.close();
        }
        catch(IDNotWellFormedException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"must enter the following: First name (String), Last name (String), Phone (String), DOB (Date), Date hired (Date), ID (String)");
            reset();
        }
    
    }

    public void reset(){
        fNametxt.requestFocus();
        fNametxt.setText("");
        lNametxt.setText("");
        phonetxt.setText("");
        DOBtxt.setText("");
        dateJoinedtxt.setText("");
        IDtxt.setText("");
    }


}