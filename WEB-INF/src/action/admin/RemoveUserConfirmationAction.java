package action.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import dao.AdminDao;

import form.admin.RemoveUserForm;

public class RemoveUserConfirmationAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		RemoveUserForm form2 = (RemoveUserForm)form;
		List<String> list = new ArrayList<String>();
		if(form2.getRemoveUser() == null || form2.getRemoveUser().length == 0) {
			ActionMessages message = new ActionMessages();
			message.add("noselect", new ActionMessage("errors.noselect", "ユーザ"));
			saveMessages(request, message);
			return mapping.findForward("failed");	
		}
		for(int i = 0;i < form2.getRemoveUser().length;i++) {
			list.add(form2.getRemoveUser()[i]);
		}
		request.getSession().setAttribute("removeUserList", list);
		return mapping.findForward("success");
	}

}
