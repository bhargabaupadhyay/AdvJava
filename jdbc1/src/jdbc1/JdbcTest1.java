package jdbc1;

import java.sql.*;
class JdbcTest1
{
	public static void main(String[] args) 
	{
		try{

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","bhargaba");
			System.out.println("conection Established");
			System.out.println(cn);
		}
		catch(ClassNotFoundException c)
		{
			System.out.println("invalid class name");
		}
		catch(SQLException  s)
		{
            System.out.println("invalid ");
		}
	}
}