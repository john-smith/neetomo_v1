package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AdminDao;

public class AdminDaoImpl extends DaoImpl implements AdminDao {
	public List<String> getUserList() {
		Connection con = init();
		List<String> list = new ArrayList<String>();
		try {
			PreparedStatement stmt = con.prepareStatement("select wakai_login_name from wakai_user where wakai_role='wakai'");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("wakai_login_name"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		
	}
	
	public void removeUser(String userName) {
		Connection con = init();
		
		try {
			PreparedStatement stmt = con.prepareStatement("delete from wakai_user where wakai_login_name=?");
			stmt.setString(1, userName);
			stmt.executeUpdate();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
