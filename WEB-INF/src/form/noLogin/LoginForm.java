package form.noLogin;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginForm extends ActionForm {
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors error = new ActionErrors();
		
		if(userId == null || userId.equals("")) {
			error.add("id", new ActionMessage("errors.required", "USER ID"));
		}
		
		if(passwd == null || passwd.equals("")) {
			error.add("pass", new ActionMessage("errors.required", "PASSWORD"));
		}
		
		return error;
	}

	String userId;
	String passwd;
	
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
}
