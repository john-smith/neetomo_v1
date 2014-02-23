package form.admin;

import org.apache.struts.action.ActionForm;

public class RemoveUserForm extends ActionForm {
	String[] removeUser;

	public String[] getRemoveUser() {
		return removeUser;
	}

	public void setRemoveUser(String[] removeUser) {
		this.removeUser = removeUser;
	}
}
