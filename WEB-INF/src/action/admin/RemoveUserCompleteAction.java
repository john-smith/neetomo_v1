package action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.AdminDao;
import daoImpl.AdminDaoImpl;

public class RemoveUserCompleteAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<String> list = (List<String>)request.getSession().getAttribute("removeUserList");
		if(list == null || list.size() == 0) {
			return mapping.findForward("failed");
		}
		AdminDao dao = new AdminDaoImpl();
		for(String str : list) {
			dao.removeUser(str);
		}
		request.getSession().removeAttribute("removeUserList");
		return mapping.findForward("success");
	}

}
