package dao;

import java.util.List;

public interface AdminDao {
	public List<String> getUserList();
	
	public void removeUser(String userName);
}
