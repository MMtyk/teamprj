import java.sql.*;
public class CommentAdd {    
    public CommentAdd() {}
    public static void main(String args[]) {	
	try {
		Class.forName("oracle.jdbc.OracleDriver");	
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
		String query = "insert into tb_comment(id, content, name) " +
		               "values(1,'abc', 'abc')";
		
		int i= stmt.executeUpdate(query);			
        System.out.println(i+"���� �߰��Ǿ����ϴ�.");
		stmt.close();
		*/
		
		String query = "insert into tb_comment(id, content, name) " +
	               "values(?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(query); 
		pstmt.setInt(1, 2); 
		pstmt.setString(2, "ddd");
		pstmt.setString(3, "ddd");
		pstmt.executeUpdate();	
		pstmt.close();
	
		con.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}    
  }
}