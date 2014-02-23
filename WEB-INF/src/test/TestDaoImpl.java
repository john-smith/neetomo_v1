package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import daoImpl.DaoImpl;
import dataConnection.CreateConnection;

public class TestDaoImpl extends DaoImpl implements TestDao {
	public void addNull(String word) {
		Connection con = init();

		try {
			PreparedStatement stmt = con.prepareStatement("insert into wakai_null (wakai_word_response) values (?)");
			stmt.setString(1, word);
			stmt.executeUpdate();
			stmt.close();
			
		} catch (SQLException e) {
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.getErrorCode();
			}
		}
	}

	public void createTable(List<String> word) {
		Connection con = init();
		try {
			for(String str : word) {
				PreparedStatement stmt = con.prepareStatement(str);
				stmt.executeUpdate();
				stmt.close();
			}
		} catch (SQLException e) {
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
