package action.wakai;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.AdminDao;
import daoImpl.AdminDaoImpl;
import bean.noLogin.LoginBean;

public class RemoveAccountAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if(request.getSession().getAttribute("removeConfirm") == null) {
			return mapping.findForward("failed");
		}
		AdminDao dao = new AdminDaoImpl();
		dao.removeUser(((LoginBean)request.getSession().getAttribute("login")).getUserName());
		request.getSession().invalidate();
		return mapping.findForward("success");
	}

}
