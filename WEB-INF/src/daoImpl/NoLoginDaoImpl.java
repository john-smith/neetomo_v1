package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.noLogin.LoginBean;

import dao.NoLoginDao;

public class NoLoginDaoImpl extends DaoImpl implements NoLoginDao {
	public LoginBean login(String userName, String passwd) {
		Connection con = init();
		LoginBean loginBean = null;
		
		try {
			PreparedStatement stmt = con.prepareStatement("select * from wakai_user where wakai_login_name=?");
			stmt.setString(1, userName);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("wakai_login_passwd").equals(passwd)) {
					loginBean = new LoginBean();
					loginBean.setUserName(userName);
					loginBean.setPasswd(passwd);
					loginBean.setRole(rs.getString("wakai_role"));
					break;
				}
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return loginBean;
		}
	}
	
	public boolean regist(String userName) {
		Connection con = init();
		
		try {
			PreparedStatement stmt = con.prepareStatement("select * from wakai_user where wakai_login_name=?");
			stmt.setString(1, userName);
			ResultSet rs = stmt.executeQuery();
			boolean result = true;
			if(rs.next()) {
				result = false;
			}
			
			rs.close();
			stmt.close();
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean addUser(String userName, String passwd, String role) {
		Connection con = init();
		
		try {
			PreparedStatement stmt = con.prepareStatement("insert into wakai_user(wakai_login_name, wakai_login_passwd, wakai_role) values ( ?, ?, ? )");
			stmt.setString(1, userName);
			stmt.setString(2, passwd);
			stmt.setString(3, role);
			stmt.executeUpdate();
			
			stmt.close();
			
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.getErrorCode();
			}
		}
	}
}
