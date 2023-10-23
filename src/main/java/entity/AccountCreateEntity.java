package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.AccountVO;

public class AccountCreateEntity {
	public AccountCreateEntity() {
		
	}
	public String checkId(AccountVO vo) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	
		}catch(ClassNotFoundException e ) {
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "SCOTT";
		String pass = "TIGER";
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			String query = "select name from account where exists ( select name from account where name='"+vo.getId()+"')";
			PreparedStatement pstmt = con.prepareStatement(query); 
			ResultSet rs = pstmt.executeQuery();
			
			String name = null;
			while(rs.next())
                name=rs.getString("name").trim();

	        rs.close();
	        pstmt.close();
	        con.close();
			return name;
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("err");
			return "1234";
		}
	}
}
