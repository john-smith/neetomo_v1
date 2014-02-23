package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.LoginDao;

public class LoginDaoImpl extends DaoImpl implements LoginDao {
	public void changePass(String userName, String newPass) {
		Connection con = init();
		
		try {
			PreparedStatement stmt = con.prepareStatement("update wakai_user set wakai_login_passwd=? where wakai_login_name=?");
			stmt.setString(1, newPass);
			stmt.setString(2, userName);
			stmt.executeUpdate();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
