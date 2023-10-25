package service;

import java.sql.*;
import vo.AccountVO;

public class LoginImpl implements ILogin {
	public LoginImpl() {
		
	}

	public String checkPass(AccountVO vo) {
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
			String query = "SELECT password FROM account where id='" + vo.getId() + "'";
			PreparedStatement pstmt = con.prepareStatement(query); 
			ResultSet rs = pstmt.executeQuery();
					
			String pwd = null;
			while(rs.next())
                pwd=rs.getString("password").trim();

	        rs.close();
	        pstmt.close();
	        con.close();
			return pwd;
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("err");
			return "1234";
		}
	}
}
