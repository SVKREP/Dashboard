import java.io.*;
import java.util.*;
import java.sql.*;

public class DB_Connection 
{
	int sc;
	String m;
	
	public DB_Connection(String m,int sc)
	{
		this.m = m;
		this.sc = sc;
	}
	
	public String toDB()throws Exception
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","svk@2000");
			PreparedStatement sqst=con.prepareStatement("insert into dbsc(status_code,message) values(?,?);");  
			sqst.setInt(1,sc);  
			sqst.setString(2,m);  
			sqst.executeUpdate();
			con.close();
			return "Successful Insertion";
			
		}
		catch(Exception e)
		{
			System.out.println("ERROR: "+e);			
		}
		return "unsuccessful Insertion";

	}
	
}
