package form.noLogin;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class RegistForm extends ActionForm {
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors error = new ActionErrors();
		
		if(userId == null || userId.equals("")) {
			error.add("id", new ActionMessage("errors.required", "USER ID"));
		} else if(!(Pattern.compile("[a-zA-Z0-9]+").matcher(userId).matches())) {
			error.add("id", new ActionMessage("errors.regex", "USER ID"));
		} else if(userId.length() > 15) {
			error.add("id", new ActionMessage("errors.maxlen", "USER ID"));
		}
		
		if(passwd == null || passwd.equals("")) {
			error.add("pass", new ActionMessage("errors.required", "PASSWORD"));
		}
		
		if(passwd2 == null || passwd2.equals("")) {
			error.add("pass2", new ActionMessage("errors.required", "PASSWORD(確認)"));
		} else if(!passwd.equals(passwd2)) {
			error.add("pass", new ActionMessage("errors.badpass"));
		} else if(passwd.length() > 15) {
			error.add("pass", new ActionMessage("errors.maxlen", "PASSWORD"));
		}
		
		return error;
	}
	
	private String userId;
	private String passwd;
	private String passwd2;
	private String role;
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String getPasswd2() {
		return passwd2;
	}
	
	public void setPasswd2(String passwd2) {
		this.passwd2 = passwd2;
	}
}
