import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
 
class Login extends JFrame implements ActionListener
{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*Map<Key,Value>*/
	Map<String,String> m = new HashMap<String,String>();
 JButton SUBMIT,SIGNUP;
 JPanel panel;
 JLabel label1,label2,label3,label4;
 JTextField text1;
 JPasswordField  text2;
 Font f=new Font("SANS_SERIF",Font.BOLD,15);
 Font f1=new Font("SERIF",Font.BOLD,16);
 Font f2=new Font("Times New Roman",Font.BOLD,20);
  Login()
  {
  label1 = new JLabel();
  label3= new JLabel();
  label4=new JLabel();
  label3.setText("         WELCOME TO ");
  label4.setText("PAY-ON");
  label3.setFont(f2);
  label4.setFont(f2);
  label3.setForeground(Color.BLUE);
  label4.setForeground(Color.RED);
  label1.setText("   Username:");
  label1.setFont(f);
  text1 = new JTextField(15); 
  label2 = new JLabel();
  label2.setText("   Password:");
  label2.setFont(f);
  text2 = new JPasswordField(15);
  SUBMIT=new JButton("  LOGIN");
  SIGNUP=new JButton("  SIGNUP");
  SUBMIT.setFont(f1);
  SUBMIT.setForeground(Color.red);
  SIGNUP.setFont(f1);
  SIGNUP.setForeground(Color.BLUE);
  add(text1);
  add(label2);
  add(text2);
  add(SUBMIT);
  add(SIGNUP);
  panel=new JPanel(new GridLayout(4,2,10,10));
  panel.add(label3);
  panel.add(label4);
  panel.add(label1);
  panel.add(text1);
  panel.add(label2);
  panel.add(text2);
  panel.add(SUBMIT);
  panel.add(SIGNUP);
  add(panel,BorderLayout.CENTER);
  SUBMIT.addActionListener(this);
  SIGNUP.addActionListener(this);
  setTitle("LOGIN FORM");
  }
  
 public void actionPerformed(ActionEvent ae)
 {
  if (ae.getSource() == SUBMIT )
  {
	  getUserDetails();
	  
  String value1=text1.getText();
  String value2=text2.getText();
  
  String tempPassword = m.get(value1);
  /*To check Whether password is Correct*/ 
  if(tempPassword!=null) {
  if (value2.equals(tempPassword)) 
  {
   this.setVisible(false);	  
  Recharge page=new Recharge(1);
  page.setVisible(true);
  page.setSize(500, 500);
  }
  else
  {
  JOptionPane.showMessageDialog(this,"Incorrect login or password",
  "Error",JOptionPane.ERROR_MESSAGE);}
  }
  else
  {
  JOptionPane.showMessageDialog(this,"Incorrect login or password",
  "Error",JOptionPane.ERROR_MESSAGE);
  }
  }
  
  if(ae.getSource() == SIGNUP)
  {
	  this.setVisible(false);
	  SignUpPage page=new SignUpPage();
	  page.setVisible(true);
	  page.setSize(500,500);
  }
 }
 
 public void getUserDetails()
 {
	     String line1[];  
        try {
        	FileReader fr=new FileReader("UserDetails.txt"); 
        	 BufferedReader br=new BufferedReader(fr); 
        	 
        	 String line = br.readLine();
        	 while( line != null )
        	 {
        	   // process the line
        		 line1 = line.split(",");
        		 m.put(line1[0], line1[1]);
        		 line = br.readLine();
        	 }
			fr.close();
		} catch (Exception e) {	}    
}

}
 class LoginDemo
{
  public static void main(String arg[])
  {
  try
  {
  Login frame=new Login();
  frame.setSize(400,400);
  frame.setVisible(true);
  frame.setResizable(false);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  catch(Exception e)
  {JOptionPane.showMessageDialog(null, e.getMessage());}
  }
}