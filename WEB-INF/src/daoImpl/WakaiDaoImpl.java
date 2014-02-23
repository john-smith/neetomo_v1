package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.WakaiDao;

import bean.noLogin.WordBean;

public class WakaiDaoImpl extends DaoImpl implements WakaiDao {
	public boolean confirm(String word) {
		Connection con = init();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from wakai_word where wakai_word=?");
			stmt.setString(1, word);
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

	public boolean addWord(String word) {
		Connection con = init();

		try {
			PreparedStatement stmt = con.prepareStatement("insert into wakai_word (wakai_word) values (?)");
			stmt.setString(1, word);
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

	public List<WordBean> getWordList(String searchWord) {
		Connection con = init();
		List<WordBean> list = new ArrayList<WordBean>();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from wakai_word where wakai_word like ?");
			stmt.setString(1, "%" + searchWord + "%");
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				WordBean bean = new WordBean();
				bean.setId(rs.getInt("wakai_id"));
				String str = rs.getString("wakai_word");
				str = str.replaceAll("&amp;", "&");
				str = str.replaceAll("&gt;", ">");
				str = str.replaceAll("&lt;", "<");
				str = str.replaceAll("&quot;", "\"");
				bean.setWord(str);
				list.add(bean);
			}
			rs.close();
			stmt.close();


		} catch (SQLException e) {
		} finally {
			try {
				con.close();

			} catch (SQLException e) {
			}
			return list;
		}
	}

	public void removeWord(int id) {
		Connection con = init();

		try {
			PreparedStatement stmt = con.prepareStatement("delete from wakai_word where wakai_id=?");
			stmt.setInt(1, id);
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

	public boolean addResponse(String response) {
		Connection con = init();

		try {
			PreparedStatement stmt = con.prepareStatement("insert into wakai_response (wakai_word_response) values (?)");
			stmt.setString(1, response);
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

	public List<WordBean> getResponseList(String searchResponse) {
		Connection con = init();
		List<WordBean> list = new ArrayList<WordBean>();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from wakai_response where wakai_word_response like ?");
			stmt.setString(1, "%" + searchResponse + "%");
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				WordBean bean = new WordBean();
				bean.setId(rs.getInt("wakai_id"));
				String str = rs.getString("wakai_word_response");
				str = str.replaceAll("&amp;", "&");
				str = str.replaceAll("&gt;", ">");
				str = str.replaceAll("&lt;", "<");
				str = str.replaceAll("&quot;", "\"");
				bean.setWord(str);
				list.add(bean);
			}
			rs.close();
			stmt.close();


		} catch (SQLException e) {
		} finally {
			try {
				con.close();

			} catch (SQLException e) {
			}
			return list;
		}
	}

	public void removeResponse(int id) {
		Connection con = init();

		try {
			PreparedStatement stmt = con.prepareStatement("delete from wakai_response where wakai_id=?");
			stmt.setInt(1, id);
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
