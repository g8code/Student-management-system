import java.io.*;
import java.sql.*;

public class insertintodatabase 
{
	public static void insert(String rollno,String name,String m1,String m2,String m3) 
	{	   	
	 try
	  {
		DAO db=new DAO();
		Connection conn=db.getConnection();
		
		int ma1=Integer.parseInt(m1);
		int ma2=Integer.parseInt(m2);
		int ma3=Integer.parseInt(m3);
		
	     float percentage=((ma1+ma2+ma3)*100)/300;

	   	   
	    String insertQuery = "insert into records values(?,?,?,?,?,?)";
	    PreparedStatement   preparedStatement ;
		
	    preparedStatement = conn.prepareStatement(insertQuery);
	    preparedStatement.setString(1,rollno+"");
	    preparedStatement.setString(2,name);
	    preparedStatement.setString(3,m1+"");
	    preparedStatement.setString(4,m2+"");
	    preparedStatement.setString(5,m3+"");
	    preparedStatement.setString(6,percentage+"");
			
	    preparedStatement.executeUpdate();
	    System.out.println("Data  Successfully Inserted !!!");
	 }
	 catch(Exception e)
	 {
		 System.out.println(e);
	 }
  }
}
