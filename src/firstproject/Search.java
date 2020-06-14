package firstproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Search extends JFrame {

	private JPanel contentPane;
	JComboBox cb;  
	private JTextField textField;
	String[] name=new String[100];
	String[] ab={"abcd","xyz"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
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
	public Search() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		cb=new JComboBox<String>(ab);
		cb.setBounds(150, 150, 100, 50);
		contentPane.add(cb);
		textField = new JTextField();
		textField.setBounds(157, 73, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterId = new JLabel("Enter Id");
		lblEnterId.setBounds(39, 78, 61, 16);
		contentPane.add(lblEnterId);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				textField.setText(cb.getItemAt(cb.getSelectedIndex()).toString());
						}
		});
		btnSearch.setBounds(327, 73, 117, 29);
		contentPane.add(btnSearch);
		
	}
	
	
}
