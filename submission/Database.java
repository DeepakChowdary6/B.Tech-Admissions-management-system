package submission;
//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
//import com.mysql.jdbc.PreparedStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;


public class Database {
	ResultSet checkResult;

static Connection con;
	public Database() {
	
	}


public static Connection connect() throws Exception {
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
	      throw new Exception("Driver not found");
	}
	String Url="jdbc:mysql://localhost:3306/swing?verifyServerCertificate=false&useSSL=true";
	 con= DriverManager.getConnection(Url, "root", "root");
	System.out.println("Connected "+con);return con;
}

 public void disconnect(){
	if(con!=null) 
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Can't close connection");
		}
	}
	
	
}
public int checkAdmin(String username,String password) throws SQLException {
	String check="select * from admin where username=? and password=?";
	PreparedStatement checkStmt=con.prepareStatement(check);int col=1;
	checkStmt.setString(col++,username);
	checkStmt.setString(col++,password);
	checkResult=checkStmt.executeQuery();
	
	if(checkResult.next())
	 return checkResult.getInt("id");
	else return 0;
}
public ResultSet afterlogin(int x) throws SQLException{
	String info="select * from people where id=?";
	PreparedStatement infoStmt=con.prepareStatement(info);
	infoStmt.setInt(1,x);
	checkResult=infoStmt.executeQuery();
	checkResult.next();
	
	return checkResult;
	
}


public ResultSet getAdmininfo(int y) throws SQLException {
	String info="select * from admin where id=?";
	PreparedStatement AinfoStmt=con.prepareStatement(info);
	AinfoStmt.setInt(1,y);
	checkResult=AinfoStmt.executeQuery();
	checkResult.next();
	
	return checkResult;
	
	// TODO Auto-generated method stub
	
}

	
}

