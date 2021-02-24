import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.*;


public class payment extends JFrame implements ActionListener  {
	 Frame f,f1;
	 Button b,b1;
	 TextField t11,t12,t13,t14,t2;
	 String s,p,a;
	 public void actionPerformed(ActionEvent e)
	 { 
	  if(e.getSource()==b)
	  {	  
		if(t2.getText()!="" && t11.getText()!="" & t12.getText()!="" && t13.getText()!="" && t14.getText()!="") {
	   f.setVisible(false);
	   f1= new JFrame("Thank you");
	   Font myFont1 = new Font("SERIF",Font.BOLD,20);
	   Font myFont2= new Font("Times New Roman",Font.ITALIC,18);
	   Font myFont = new Font("SANS-SERIF",Font.BOLD,13);
	   Label l00=new Label("THANK YOU...");
	   Label l0=new Label("SUCCESS!!!");
	   Label num=new Label("Number :");Label plan=new Label("Operator :");Label amount=new Label("Paid :");
	   Label num1=new Label(s);Label plan1=new Label(p);Label amount1=new Label(a);
	   l0.setForeground(Color.BLUE);
	   l0.setFont(myFont1);
	   l0.setBounds(160, 20, 150, 50);
	   l00.setFont(myFont2);
	   l00.setForeground(Color.BLUE);
	   l00.setBounds(145,330,120,100);
	   num.setBounds(100, 100, 100, 70);num1.setBounds(200, 100, 100, 70);
	   plan.setBounds(100, 175, 100, 70);plan1.setBounds(200, 175, 100, 70);
	   amount.setBounds(100, 260, 100, 50);amount1.setBounds(200, 260, 100, 50);
	   num.setFont(myFont);num1.setFont(myFont);plan.setFont(myFont);plan1.setFont(myFont);amount.setFont(myFont);amount1.setFont(myFont);
	   b1 = new Button("EXIT");
	   b1.setForeground(Color.RED);
	   b1.setBounds(350,410,60,30);
	   b1.addActionListener(this);
	   f1.add(l0);f1.add(num);f1.add(num1);f1.add(plan);f1.add(plan1);f1.add(amount);f1.add(amount1);
	   f1.add(l00);
	   f1.add(b1);
	   f1.setSize(440,490);
	   f1.setBackground(Color.white);
	   f1.setLayout(null);
	   f1.setVisible(true);}
	  else
	  {
		  JOptionPane.showMessageDialog(this,"Please Provide Valid Details",
				  "Error",JOptionPane.ERROR_MESSAGE);
	  }
	  }
	  else
	  {
	   f1.setVisible(false);
	   Login frame=new Login();
	   frame.setSize(400,400);
	   frame.setVisible(true);
	   frame.setResizable(false);
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  }
	 }
	     payment(String plan1,String num,String amount)  
	        {  
	    	 this.p=plan1;
	    	 this.s=num;
	    	 this.a=amount;
	        f= new JFrame("Payment");
	        f.setBackground(Color.WHITE);
	        Font myFont1 = new Font("Times New Roman",Font.PLAIN,14);
	        Label l1=new Label("Card number"); 
	        Label l0=new Label("Pay-mode"); 
	        l0.setFont(myFont1);
	        l0.setBounds(70,60,90,60);
	        Choice ch=new Choice();
	        ch.add("Credit");
	        ch.add("Debit");
	        ch.setBounds(170,80,80,20);
	     l1.setBounds(70,110,90,60);
	     l1.setFont(myFont1);
	     t11=new TextField(4);t11.setText("");
	     t12=new TextField(4);t12.setText("");
	     t13=new TextField(4);t13.setText("");
	     t14=new TextField(4);t14.setText("");
	     t11.setBounds(170,130,40,20);
	     t12.setBounds(220,130,40,20);
	     t13.setBounds(270,130,40,20);
	     t14.setBounds(320,130,40,20);
	     Label l2=new Label("CVV");  
	     l2.setBounds(70,170,90,60);
	     l2.setFont(myFont1);
	     t2=new TextField();t2.setText("");
	     t2.setEchoChar('*');
	     t2.setBounds(170,190,30,20);
	     b =new Button("PAY");
	     b.setBounds(170,270,60,30);
	     b.addActionListener(this);
	     f.add(l0);
	     f.add(ch);
	        f.add(l1);
	        f.add(t11);
	        f.add(t12);
	        f.add(t13);
	        f.add(t14);
	        f.add(l2);  
	        f.add(t2);  
	        f.add(b);
	        f.setSize(400,400);    
	        f.setLayout(null);    
	        f.setVisible(true);    
	        }  

}
