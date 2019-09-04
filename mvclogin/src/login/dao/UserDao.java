package login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import login.model.User;

public class UserDao {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","bhargaba");
	}
	/**
	 * For retrive user by username and password
	 * @param username
	 * @param pass
	 * @return true if matches else false
	 */
	public boolean fetchUserByUsernameAndPassword(String username, String pass) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "select * from login where username=? and password=?";
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return false;
	}
	/**
	 * return user by username
	 * @param username
	 * @return user object if matches else null;
	 */
	public User getUserByUsername(String username) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "select * from login where username=?";
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			User user = new User();
			if(rs.next()) {
				user.setUsername(username);
				user.setName(rs.getString("name"));
				user.setSalary(rs.getInt("salary"));
				user.setAge(rs.getInt("age"));
			}
			return user;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}
	public boolean updateUser(User user) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update login set name=?, password=?,age=?,salary=? where username=?";
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getAge());
			ps.setInt(4, user.getSalary());
			ps.setString(5, user.getUsername());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return false;
	}
	
}
