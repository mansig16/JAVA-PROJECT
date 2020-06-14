package firstproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Boolean status;
	String role;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login1 frame = new Login1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(140, 61, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(140, 113, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				status=false;
				
				String name,password;
				name=textField.getText();
				password=textField_1.getText();
				
				if(name.equals(""))
				{
					JOptionPane.showMessageDialog(Login1.this, "Sorry, Username Cannot be blank","Login Error!", JOptionPane.ERROR_MESSAGE);
					
				}else if(password.equals(""))
				{
					JOptionPane.showMessageDialog(Login1.this, "Sorry, Password cannot be blank","Login Error!", JOptionPane.ERROR_MESSAGE);
				}else{
					
					try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try {
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mayank?autoReconnect=true&useSSL=false","root","root");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try {
						ps = con.prepareStatement("select * from librarian where name=? and password=?");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						ps.setString(1,name);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						ps.setString(2,password);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try {
						rs = ps.executeQuery();
						status=rs.next();
						if(status){
						role = rs.getString("role");}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
						
						
					try {
						con.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				if(status)
				{
					
					
					if(role.equals("admin"))
					Profile1.main(new String[]{});
					else
						Profile2.main(new String[]{});
				}
				else
				{
					JOptionPane.showMessageDialog(Login1.this, "Sorry, username/password donot exist","Login Error!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnLogin.setBounds(154, 194, 117, 29);
		contentPane.add(btnLogin);
	}
}
