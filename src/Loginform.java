import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class Loginform extends Frame implements ActionListener
{ Label l1=new Label("Sender User ID");
  Label l2=new Label("password");
  Label l3=new Label(" ");
  Label l4=new Label("Receiver");
  TextField t1=new TextField();
  TextField t2=new TextField();
  TextField t4=new TextField();
  Button b= new Button("Submit");
  public Loginform()
  { add(l1);
    add(t1);
    add(l2);
    add(t2);
    add(l4);
    add(t4);
    add(b);
    add(l3);
    l1.setBounds(20,55,100,30);
    t1.setBounds(180,55,200,20);
    l2.setBounds(20,95,70,20);
    t2.setBounds(180,95,200,20);
    l4.setBounds(20,145,70,20);
    t4.setBounds(180,145,200,20);
    b.setBounds(410,200,70,20);
    b.addActionListener(this);
    t2.setEchoChar('*');
    addWindowListener(new mwa());
  }
  public void actionPerformed(ActionEvent e)
  { l3.setText("Scanning.......");
  String sender=t1.getText();
  String receiver=t4.getText();
  String password=t2.getText();
  boolean result=DiskSpaceDetail.ReceiveStringFromApplet(sender,password,receiver);
  if(result==true)
  {
	  l3.setText("Message Sent"); 
  }
  else
  {
	  l3.setText("Failed to send Mesage "); 
  }
  
  
  
  }
  public static void main(String s[])
  { Loginform l=new Loginform();
    l.setSize(new Dimension(600,600));
    l.setTitle("Login");
    l.setVisible(true);
  }
}
class mwa extends WindowAdapter
{ public mwa(){}
  public void windowClosing(WindowEvent e)
  { System.exit(0);
  }
}