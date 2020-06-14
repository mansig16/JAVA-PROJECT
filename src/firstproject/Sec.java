package firstproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;



public class Sec {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mayank?autoReconnect=true&useSSL=false","root","root");
		String insertTableSQL = "INSERT INTO tb1(id, name) VALUES(?,?)";
		
		PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
		preparedStatement.setInt(1,3);
		preparedStatement.setString(2,"NITTTR");
		preparedStatement .executeUpdate();


	}

}
