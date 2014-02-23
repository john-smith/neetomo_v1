package bean.noLogin;

import java.io.Serializable;

public class WordBean implements Serializable{
	String word;
	int id;
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
