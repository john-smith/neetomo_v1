package chatbot;

import java.util.List;

public interface ResDao {
	public List<String> getWordList();
	
	public String randRes();
			
	public String randNull();
}
