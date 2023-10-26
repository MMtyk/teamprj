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
	public int addAccount() {
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			String query = "select max(idnum) idnum from account";
			PreparedStatement pstmt = con.prepareStatement(query); 
			ResultSet rs = pstmt.executeQuery();
			int idnum = 0;
			while(rs.next())
                idnum = rs.getInt("idnum") + 1;
			
	        rs.close();
	        pstmt.close();
	        query = "insert into account(idnum) values("+idnum+")";
	        PreparedStatement pstmt2 = con.prepareStatement(query); 
	        pstmt2.executeUpdate();	
			pstmt2.close();
	        con.close();
	        return idnum;
		}catch(SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public void Back1(AccountVO vo) {
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			String query = "delete account where idnum="+ vo.getIdNum();
			PreparedStatement pstmt = con.prepareStatement(query); 

			pstmt.executeUpdate();
			
	        pstmt.close();
	        con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String Back2(AccountVO vo) {
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			String query = "select id from account where idnum="+vo.getIdNum();
			PreparedStatement pstmt = con.prepareStatement(query); 
			ResultSet rs = pstmt.executeQuery();
			String id = null;
			while(rs.next())
                id=rs.getString("id").trim();
			query = "update account set id='' where idnum="+vo.getIdNum();
			pstmt = con.prepareStatement(query); 
			pstmt.executeUpdate();
	        pstmt.close();
	        con.close();
	        return id;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public String Back3(AccountVO vo) {
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			String query = "select username from account where idnum="+vo.getIdNum();
			PreparedStatement pstmt = con.prepareStatement(query); 
			ResultSet rs = pstmt.executeQuery();
			String nick = null;
			while(rs.next())
                nick=rs.getString("username").trim();
			System.out.println(nick);
			query = "update account set username='' where idnum="+vo.getIdNum();
			pstmt = con.prepareStatement(query); 
			pstmt.executeUpdate();
	        pstmt.close();
	        con.close();
	        return nick;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String next1(AccountVO vo) {
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			String query = "select id from account where id='"+vo.getId()+"'";
			PreparedStatement pstmt = con.prepareStatement(query); 
			ResultSet rs = pstmt.executeQuery();
			String id = null;
			while(rs.next())
                id=rs.getString("id").trim();
			if(id == null) {
				query = "update account set id='"+vo.getId()+"' where idnum="+vo.getIdNum();
				pstmt = con.prepareStatement(query);
				pstmt.executeUpdate();
			}
	        rs.close();
	        pstmt.close();
	        con.close();
			return id;
		}catch(SQLException e) {
			e.printStackTrace();
			return "1234";
		}
	}
		
	public String next2(AccountVO vo) {
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			String query = "select username from account where username='"+vo.getNick()+"'";
			PreparedStatement pstmt = con.prepareStatement(query); 
			ResultSet rs = pstmt.executeQuery();
			String nick = null;
			while(rs.next())
				nick=rs.getString("username").trim();
			if(nick == null) {
				query = "update account set username='"+vo.getNick()+"' where idnum="+vo.getIdNum();
				pstmt = con.prepareStatement(query);
				pstmt.executeUpdate();
			}
	        rs.close();
	        pstmt.close();
	        con.close();
			return nick;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return "1234";
		}
	}
	
	public void next3(AccountVO vo) {
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			String query = "update account set password='"+vo.getPasswd()+"' where idnum=" + vo.getIdNum();
			PreparedStatement pstmt = con.prepareStatement(query); 
			pstmt.executeUpdate();
	        pstmt.close();
	        con.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String next4(AccountVO vo) {
		try {
			Connection con = DriverManager.getConnection(url,user,pass);
			String query = "select password from account where idnum=" + vo.getIdNum();
			PreparedStatement pstmt = con.prepareStatement(query); 
			ResultSet rs = pstmt.executeQuery();
			String passwd = null;
			while(rs.next())
				passwd=rs.getString("password").trim();
			rs.close();
	        pstmt.close();
	        con.close();
			return passwd;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
