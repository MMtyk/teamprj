package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.AccountVO;

public class AccountCreateEntity {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "SCOTT";
		String pass = "TIGER";
	public AccountCreateEntity() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	
		}catch(ClassNotFoundException e ) {
			e.printStackTrace();
		}
	}
	public void addAccount() {
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			String query = "select max(idnum) idnum from account";
			PreparedStatement pstmt = con.prepareStatement(query); 
			ResultSet rs = pstmt.executeQuery();
			int idnum = 0;
			while(rs.next())
                idnum = rs.getInt("idnum") + 1;
			
			System.out.println(idnum);
	        rs.close();
	        pstmt.close();
	        query = "insert into account(idnum) values("+idnum+")";
	        System.out.println(5);
	        PreparedStatement pstmt2 = con.prepareStatement(query); 
	        System.out.println(6);
	        pstmt2.executeUpdate();	
	        System.out.println(7);
			pstmt2.close();
	        con.close();
	        System.out.println(9);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public String checkId(AccountVO vo) {
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			String query = "select id from account where id='"+vo.getId()+"'";
			PreparedStatement pstmt = con.prepareStatement(query); 
			ResultSet rs = pstmt.executeQuery();
			String id = null;
			while(rs.next())
                id=rs.getString("id").trim();

	        rs.close();
	        pstmt.close();
	        con.close();
			return id;
		}catch(SQLException e) {
			e.printStackTrace();
			return "1234";
		}
	}
		
	public String checkNick(AccountVO vo) {
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			String query = "select username from account where username='"+vo.getNick()+"'";
			PreparedStatement pstmt = con.prepareStatement(query); 
			ResultSet rs = pstmt.executeQuery();
			String nick = null;
			while(rs.next())
				nick=rs.getString("username").trim();
			
	        rs.close();
	        pstmt.close();
	        con.close();
			return nick;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return "1234";
		}
	}
}
