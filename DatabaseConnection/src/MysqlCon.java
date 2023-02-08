import java.sql.*;  
class MysqlCon
{  
public static void main(String args[]){  
	try{  
//	Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		//com.mysql.cj.jdbc.Driver
		Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/gitdata","root","Swadha");  
		//here gitdata is database name, root is username and password  
		Statement stmt=con.createStatement();  

		ResultSet rs=stmt.executeQuery("select * from pet");  
			while(rs.next())  
	

			System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		 
		//System.out.println("Connection done");
		con.close();  
	}
	catch(Exception e){ System.out.println(e);}
	
}  
}  