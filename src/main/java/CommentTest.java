import java.sql.*;
public class CommentTest {
    public CommentTest() {}
    public static void main(String args[]) {	
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
		/*
		Statement stmt = con.createStatement();		
		String query = "SELECT * FROM tb_comment";			
		*/
		
		String query = "SELECT pwd FROM account where name='asdf'";
		PreparedStatement pstmt = con.prepareStatement(query); 
		
		ResultSet rs = pstmt.executeQuery();
		
		//ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()){
                    String name=rs.getString("pwd").trim();
                    System.out.println("pwd= " + name);
		}
		
        rs.close();		
        //stmt.close();		
        pstmt.close();
        con.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}    
   }   
}