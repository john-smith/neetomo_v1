package dao;

import java.util.List;

import bean.noLogin.WordBean;

public interface WakaiDao {
	public boolean confirm(String word);
	
	public boolean addWord(String word);
	
	public List<WordBean> getWordList(String searchWord);
	
	public void removeWord(int id);
	
	public boolean addResponse(String response);
			
	public List<WordBean> getResponseList(String searchResponse);
	
	public void removeResponse(int id);
}
