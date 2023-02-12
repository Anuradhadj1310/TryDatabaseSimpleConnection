import java.sql.*;

import DBCon.MySqlEstablishConnection;
import dispAwt.AwtFrameEmployee;
import dispAwt.AwtJdbc;  
class MysqlCon
{  
public static void main(String args[]) throws SQLException{  
	/*try{  
//	Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		//com.mysql.cj.jdbc.Driver
		Connection con=DriverManager.getConnection(  
			//	"jdbc:mysql://localhost:3306/gitdata","root","Swadha");  
		//here gitdata is database name, root is username and password 
				"jdbc:mysql://sql12.freesqldatabase.com/sql12597176","sql12597176","ftV1rDuW74");
		Statement stmt=con.createStatement();  

		ResultSet rs=stmt.executeQuery("select * from employee");  
			while(rs.next())  
	

			System.out.println(rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+" "+rs.getInt(5));

	*/		
			//AwtFrameEmployee empObj=new AwtFrameEmployee();//this method not working for data transfer over different files
	
			//MySqlEstablishConnection sqlObj=new MySqlEstablishConnection();
	
			
//working right------------
	AwtJdbc obj= new AwtJdbc();
		//System.out.println("Connection done");
	/*	con.close();  
	}
	catch(Exception e){ System.out.println(e);}
*/	
}  
}  