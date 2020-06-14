package firstproject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class NewSwing extends JFrame{
	
	JButton btn;
	JTextField t1;
	NewSwing()
	{
		setVisible(true);
		setTitle("MyFrame");
		setResizable(true);
		setSize(500, 500);
		setLayout(null);
		btn=new JButton("Login");
		btn.setSize(50, 20);
		add(btn);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
new NewSwing();
	}

}
