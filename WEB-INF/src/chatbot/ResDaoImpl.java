package chatbot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daoImpl.DaoImpl;

public class ResDaoImpl extends DaoImpl implements ResDao {
	public List<String> getWordList() {
		List<String> list = null;
		Connection con = init();
		try {
			PreparedStatement stmt = con.prepareStatement("select wakai_word from wakai_word");
			ResultSet rs = stmt.executeQuery();
			list = new ArrayList<String>();
			while(rs.next()) {
				list.add(rs.getString("wakai_word"));
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
	
	public String randRes() {
		String str = null;
		Connection con = init();
		try {
			PreparedStatement stmt = con.prepareStatement("select wakai_word_response from wakai_response order by random() limit 1");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				str = rs.getString("wakai_word_response");
			}
		} catch (SQLException e) {
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
	
	public String randNull() {
		String str = null;
		Connection con = init();
		try {
			PreparedStatement stmt = con.prepareStatement("select wakai_word_response from wakai_null order by random() limit 1");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				str = rs.getString("wakai_word_response");
			}
		} catch (SQLException e) {
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
