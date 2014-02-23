package form.login;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ChangePassForm extends ActionForm {
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors error = new ActionErrors();
		if(newPass == null || newPass.equals("")) {
			error.add("new", new ActionMessage("errors.required", "新しいパスワード"));
		}
		
		else if(newPass2 == null || newPass2.equals("")) {
			error.add("new2", new ActionMessage("errors.required", "新しいパスワード(確認)"));
		} else if(!newPass.equals(newPass2)) {
			error.add("new", new ActionMessage("errors.badpass"));
		} else if(newPass.length() > 15) {
			error.add("new", new ActionMessage("errors.maxlen", "新しいパスワード"));
		}
		
		return error;
	}

	String newPass;
	String newPass2;

	public String getNewPass() {
		return newPass;
	}
	
	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}
	
	public String getNewPass2() {
		return newPass2;
	}
	
	public void setNewPass2(String newPass2) {
		this.newPass2 = newPass2;
	}
}
