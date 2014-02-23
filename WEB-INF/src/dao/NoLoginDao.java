package dao;

import bean.noLogin.LoginBean;

public interface NoLoginDao {
	public LoginBean login(String userName, String passwd);
	
	public boolean regist(String userName);
	
	public boolean addUser(String userName, String passwd, String role);
}
