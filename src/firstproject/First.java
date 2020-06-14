package firstproject;

import java.sql.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class First {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
Class.forName("com.mysql.jdbc.Driver");//specifying driver
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmayank?autoReconnect=true&useSSL=false","root","root");
Statement st=con.createStatement();//Specify the connection for statement
ResultSet rst=st.executeQuery("select * from tbmayank");

while(rst.next())
{
System.out.print(rst.getInt("id"));
System.out.println(" "+rst.getString("name"));

}

	}

}
