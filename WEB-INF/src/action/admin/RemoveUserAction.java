package action.admin;

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
import daoImpl.AdminDaoImpl;

public class RemoveUserAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		AdminDao dao = new AdminDaoImpl();
		List<String> list = dao.getUserList();
		
		if(list == null || list.size() == 0) {
			ActionMessages message = new ActionMessages();
			message.add("noselect", new ActionMessage("errors.nouser"));
			saveMessages(request, message);
		}
		
		request.setAttribute("userList", list);
		return mapping.findForward("success");
	}

}
