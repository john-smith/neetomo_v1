package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Dao;
import daoImpl.DaoImpl;

public class SetData {
	static Dao dao = new DaoImpl();
	static Connection con;

	static String path = "WEB-INF/dic/";
	static String dicPath = "dic_old.csv";
	static String response = "wakaiMail.txt";
	static String nullData = "null.txt";

	//テーブルが存在する時はwakai2.sql、存在しないときはwakai.sqlを使用してください。
	//static String tablePath = "WEB-INF/wakaibase/wakai2.sql";
	static String tablePath = "WEB-INF/wakaibase/wakai.sql";

	public static void main(String[] args) throws Exception {
		con = dao.init();
		//テーブル作成
		System.out.println("テーブル作るよ");
		createTable(tablePath);

		//ユーザ作成
		System.out.println("ユーザ作るよ");
		createUser();

		//単語作成
		System.out.println("単語作るよ");
		createWord(path + dicPath);

		//応答文生成
		System.out.println("応答文作るよ");
		createResponse(path + response);

		//ぬる生成
		System.out.println("ヌル作るよ");
		createNullData(path + nullData);

		con.close();
	}

	static void createTable(String tablePath) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(tablePath), "UTF8"));
		List<String> list = new ArrayList<String>();
		String word = br.readLine();

		StringBuffer sb = new StringBuffer("");
		while(word != null) {
			if(word.length() != 0) {
				sb.append(word);
				if(word.charAt(word.length() - 1) == ';') {
					String str = sb.toString();
					str = str.replace(";", "");
					list.add(str);
					sb = new StringBuffer("");
				}
			}
			word = br.readLine();
		}

		for(String str : list) {
			PreparedStatement stmt = con.prepareStatement(str);
			stmt.executeUpdate();
			stmt.close();
		}
	}

	static void createUser() throws SQLException{
		PreparedStatement stmt;
		for(int i = 0;i < 50;i++) {
			stmt =  con.prepareStatement("insert into wakai_user (wakai_login_name, wakai_login_passwd, wakai_role) values ('user" + i  + "', 'user', 'wakai')");
			stmt.executeUpdate();
			stmt.close();
		}

		stmt =  con.prepareStatement("insert into wakai_user (wakai_login_name, wakai_login_passwd, wakai_role) values ('admin', 'omoide5432', 'admin')");
		stmt.executeUpdate();
		stmt.close();
	}

	static void createWord(String wordPath) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(wordPath), "UTF8"));
		PreparedStatement stmt;
		String word = br.readLine();

		while(word != null) {
			String[] hoge = word.split(",");
			if(hoge[2].equals("名詞")) {
				stmt = con.prepareStatement("insert into wakai_word (wakai_word) values(?)");
				stmt.setString(1, word.split(",")[0]);
				stmt.executeUpdate();
				stmt.close();
			}
			word = br.readLine();
		}
	}

	static void createResponse(String responsePath) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(responsePath), "UTF8"));
		List<String> list = new ArrayList<String>();
		String word = br.readLine();

		while(word != null) {
			list.add(word);
			word = br.readLine();
		}

		PreparedStatement stmt;

		for(String a : list) {
			stmt = con.prepareStatement("insert into wakai_response (wakai_word_response) values(?)");
			stmt.setString(1, a);
			stmt.executeUpdate();
			stmt.close();
		}
	}

	static void createNullData(String nullPath) throws Exception, FileNotFoundException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nullPath), "UTF8"));
		PreparedStatement stmt;
		String word = br.readLine();

		while(word != null) {
			stmt = con.prepareStatement("insert into wakai_null (wakai_word_response) values(?)");
			stmt.setString(1, word);
			stmt.executeUpdate();
			stmt.close();
			word = br.readLine();
		}
	}
}
