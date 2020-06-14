package firstproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Comboboxfromdatabase extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Comboboxfromdatabase frame = new Comboboxfromdatabase();
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
	public Comboboxfromdatabase() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		JComboBox jc=new JComboBox();
		try{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmayank", "root", "root");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from tbmayank");
		while(rs.next())
		{
			jc.addItem(rs.getInt(1));
		}
		st.close();
		}catch(Exception e){}
		contentPane.add(jc);
		
		setContentPane(contentPane);
		
		JButton btnTable = new JButton("Table");
		btnTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] name={"mayank"};
				 Table.main(name);
				 
			}
		});
		contentPane.add(btnTable, BorderLayout.SOUTH);
		
		
	}

}
