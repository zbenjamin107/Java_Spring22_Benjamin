import javax.swing.*;					//required import statements
import java.awt.*;						
import java.awt.event.ActionEvent;		
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class Login extends JFrame implements ActionListener{

	//constructing the the login form
	private JPanel centerpnl	    = new JPanel(new GridLayout(4, 2, 5, 5));
	private JLabel userlbl		    = new JLabel("Username");
	private JLabel PWlbl		    = new JLabel("Password");
    private JLabel keylbl           = new JLabel("Key Word");
	public  JTextField nametxt	    = new JTextField();
	public  JPasswordField PWtxt    = new JPasswordField();
    public  JTextField keytxt       = new JTextField();
	private JCheckBox showPWtxt	    = new JCheckBox("Show Password");

	private JPanel southpnl         = new JPanel(new FlowLayout());
	private JButton loginbtn        = new JButton("Login");
	private JButton resetbtn        = new JButton("Reset");

	public Login(){
		// inherited methods
		//this.setLayout(new BorderLayout());  JFrame layout manager
		this.setTitle("Login Form");	// frame title
		this.setLocationRelativeTo(null);//location set at center
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//hide frame when we exit
		setResizable(false);  //looks bad when it is resized

	    setLayout();            		// adds the buttons and text to the frame
        PWtxt.setEchoChar('*'); 		// specify which password character to use
        showPWtxt.setSelected(false);// checkbox begins unselected, which means PW is visable at first	
		setListeners();					// they must be set so they can be performed 

		this.pack();//"sizes the frame so that all its contents are at or above their preferred sizes" - google. cant see buttons without it
		this.setVisible(true);		//make the frame visible
	}

	public void setLayout(){
		centerpnl.add(userlbl);// order added makes a difference in the layout
		centerpnl.add(nametxt);
		centerpnl.add(PWlbl);
		centerpnl.add(PWtxt);
        centerpnl.add(keylbl);
        centerpnl.add(keytxt);
		centerpnl.add(showPWtxt);
		this.getContentPane().add(centerpnl, BorderLayout.CENTER);// adds panle to frame

		southpnl.add(loginbtn);
		southpnl.add(resetbtn);
		this.getContentPane().add(southpnl, BorderLayout.SOUTH);// adds panle to south side of frame
	}

	public void setListeners(){
        //action events happen in this class and the listeners trigger action performed 
		loginbtn.addActionListener(this);	
        resetbtn.addActionListener(this);	
		showPWtxt.addActionListener(this);	
	}

	
	public void actionPerformed(ActionEvent ae) {
		if( ae.getSource() == loginbtn ){   // if action event signaled by login button
			ActionForLogin();               //action for login
		}

		else if( ae.getSource() == resetbtn )// if action event in reset
			reset();                         // then reste

		else if( ae.getSource() == showPWtxt ){ // action event is check box for password
			if( showPWtxt.isSelected() )	    // if  box is already selected
            PWtxt.setEchoChar( (char)0 );      // hide password. PW was visable at first
			else PWtxt.setEchoChar('*');  //make password visable
		}
	}

	public void reset(){
		nametxt.setText("");	//set text to nothing(clear)
		nametxt.requestFocus();	//puts the curser on the name text feild
		PWtxt.setText("");	//det password txt to nothing(clear)
        keytxt.setText("");  // clean up the keyword text
	}

    public void ActionForLogin(){
        // create an instance of the Authentication class
			Authentication auth = new Authentication();

			// use try/catch to authenticate
			try{
				auth.checkLogin(nametxt.getText(), PWtxt.getPassword(), this.keytxt.getText() );
				JOptionPane.showMessageDialog(this, "Logging in");
				new Action();	// once the employee has been loged in, they can choose what they want to do
			}
			catch (InvalidLoginException ivle){ 	
				JOptionPane.showMessageDialog(this, ivle.getMessage());
				reset();
			}
			
            catch(FileNotFoundException e){
                System.out.println("file not found");
            }
            
    }

}