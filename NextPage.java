import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;


class SignUpPage extends JFrame implements ActionListener
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Map<String,String> m1=new HashMap<>();
	JLabel label1,label2,label3,label4,label5;
	JTextField  text1,text2,text3,text4;
	Choice gender;
	 Font f=new Font("SANS_SERIF",Font.BOLD,15);
	 Font f1=new Font("SERIF",Font.BOLD,20);
	JButton SUBMIT,BACK;
	JPanel panel;
	SignUpPage()
 {
		 label1 = new JLabel();
		  label1.setText("  Username :");label1.setFont(f);
		  text1 = new JTextField(15);
		  label2 = new JLabel();
		  label2.setText("  Password :");label2.setFont(f);
		  text2 = new JPasswordField(15);
		  label3 = new JLabel();
		  label3.setText("  Mobile Number :");label3.setFont(f);
		  text3 = new JTextField(15);
		  label4 = new JLabel();
		  label4.setText("  U-Pin :");label4.setFont(f);
		  text4 = new JTextField(15);
		  label5=new JLabel("  Gender :");
		  label5.setFont(f);
		  gender =new Choice();
		  gender.add("Male");
		  gender.add("Female");
		  SUBMIT=new JButton("SUBMIT");
		  SUBMIT.setFont(f1);
		  SUBMIT.setForeground(Color.BLUE);
		  BACK=new JButton("BACK");
		  BACK.setFont(f1);
		  BACK.setForeground(Color.darkGray);
		  panel=new JPanel(new GridLayout(7,2,10,10));
		  panel.add(label1);
		  panel.add(text1);
		  panel.add(label2);
		  panel.add(text2);
		  panel.add(label3);
		  panel.add(text3);
		  panel.add(label4);
		  panel.add(text4);
		  panel.add(label5);
		  panel.add(gender);
		  panel.add(SUBMIT);
		  panel.add(BACK);
		  add(panel,BorderLayout.CENTER);
		  add(panel);
		  SUBMIT.addActionListener(this);
          BACK.addActionListener(this);
		  setTitle("Registration FORM");
		  
 setDefaultCloseOperation(javax.swing.
  WindowConstants.DISPOSE_ON_CLOSE);
  }
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		// TODO Auto-generated method stub
		boolean i=true;
		 if (ae.getSource() == SUBMIT )
		  {  
				   getUserDetails();
				   String username=text1.getText();
				   if(m1.containsKey(username))
				   {
					   JOptionPane.showMessageDialog(this,"Username Already Exsits!!TryAgain..!",
				        		  "Info",JOptionPane.INFORMATION_MESSAGE);
				   }
				   else
				   {
					   try{
		           FileWriter fw=new FileWriter("UserDetails.txt",true);    
		           fw.append(text1.getText()+","+text2.getText()+","+text3.getText()+","+text4.getText()+","+gender.getItem(gender.getSelectedIndex())+"\n");
		           fw.close();    
		          }catch(Exception e) {
		          JOptionPane.showMessageDialog(this,"SignUp Not Completed Successfully",
		        		  "Info",JOptionPane.INFORMATION_MESSAGE);i=false;this.setVisible(false);} 
				  if(i) {	     JOptionPane.showMessageDialog(this,"SignUp Completed Successfully",
		        		  "Info",JOptionPane.INFORMATION_MESSAGE);
		          this.setVisible(false);
		          Login frame=new Login();
		          frame.setSize(400,400);
		          frame.setVisible(true);
		          frame.setResizable(false);
		          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);}
			   }
		  }
		 if(ae.getSource() == BACK)
		 {
			 JOptionPane.showMessageDialog(this,"Exit?",
	        		  "Info",JOptionPane.INFORMATION_MESSAGE);
			 this.setVisible(false);
			 Login frame=new Login();
			 frame.setSize(400, 400);
			 frame.setResizable(false);
			 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 frame.setVisible(true);
		 }
		
	}
	//Function to read User Details 
	public void getUserDetails()
	 {
		 
		     String line1[]; 
	        int i;    
	        try {
	        	FileReader fr=new FileReader("UserDetails.txt"); 
	        	 BufferedReader br=new BufferedReader(fr); 
	        	 
	        	 String line = br.readLine();
	        	 while( line != null )
	        	 {
	        	   // process the line
	        		 line1 = line.split(",");
	        		 m1.put(line1[0], line1[1]);
	        		 line = br.readLine();
	        	 }
				fr.close();
			} catch (Exception e) {}    
	}
 }

class Recharge extends JFrame implements ItemListener, ActionListener 
{
	JLabel label1,label2,label3,label4,label5,label6;
	JTextField text1;
	JPanel panel;
	JButton Proceed;
	CheckboxGroup ch;
	Choice choice,choice1;
	Checkbox topup,Data,Special;
	String plan,Number,Amount;
	Font f=new Font("SANS_SERIF",Font.BOLD,15);
	Font f1=new Font("SERIF",Font.BOLD,16);
	Recharge(int i)
	{
		label1=new JLabel("  Enter mobile Number :");
		label2=new JLabel("  Select Operator :");
		choice1=new Choice();
		choice1.add("Airtel");
		choice1.add("Jio");
		choice1.add("Vodafone");
		choice1.add("Idea");
		choice1.add("BSNL");
		ch=new CheckboxGroup();
		topup=new Checkbox("Top-Up",ch,false);
        Data=new Checkbox("Data",ch,false);
	    Special=new Checkbox("Special Recharge",ch,false);
		label3=new JLabel("  Select  plan :");
		choice=new Choice();
		topup.addItemListener(this);
		Data.addItemListener(this);
		Special.addItemListener(this);
		label4=new JLabel("  Select Amount :");
		text1 = new JTextField(15);
		panel=new JPanel(new GridLayout(7,2,10,10));
		label5=new JLabel(" ");
		label6=new JLabel(" ");
		Proceed=new JButton(" PROCEED TO PAY");
		Proceed.setForeground(Color.BLUE);
		Proceed.setFont(f1);
		label1.setFont(f);
		label2.setFont(f);
		label3.setFont(f);
		label4.setFont(f);
		panel.add(label1);
		panel.add(text1);
		panel.add(label2);
		panel.add(choice1);
		panel.add(label3);
		panel.add(topup);
		panel.add(label5);
		panel.add(Data);
		panel.add(label6);
		panel.add(Special);
		panel.add(label4);
		panel.add(choice);
		panel.add(Proceed);
		add(panel,BorderLayout.CENTER);
		add(panel);
		setTitle("Info Page");
		Proceed.addActionListener(this);
	
	}
	@Override
	public void itemStateChanged(ItemEvent ie)//To listen Clicked Radiobutton 
	{
		
		 Object obj=ie.getItemSelectable (); 
		  Checkbox cb=(Checkbox) obj;
		  if (cb.getState ())
		  {
				try
				{
				if(cb.getLabel() == "Top-Up")
				{
				choice.removeAll();	
				choice.add("100-FULLTT");
				choice.add("200-FULLTT");
				choice.add("300-FULLTT");
				}
				if(cb.getLabel() == "Data")
				{
					choice.removeAll();
					choice.add("275-28GB/28D");
					choice.add("450-84GB/84D");
					choice.add("999-Unlimited Data/84D");
				}
				if(cb.getLabel() == "Special Recharge")
				{
					choice.removeAll();
					choice.add("699-200TT + 84GB/84D");
					choice.add("799-Unlimited Calls + 200GB");
					choice.add("899-Unlimited Pack/70D");
				}
				}
				catch(Exception e)
				{
					System.out.println("Error Occuured");
				}
		   }
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == Proceed)
		{
			this.setVisible(false);
			plan=choice1.getSelectedItem();
			Number=text1.getText();
			String[] s=choice.getSelectedItem().split("-");
			Amount=s[0];
			payment p=new payment(plan,Number,Amount);
		}
		
	}
	
}


	




