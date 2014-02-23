package action.noLogin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.NoLoginDao;
import daoImpl.NoLoginDaoImpl;

import form.noLogin.RegistForm;

public class CompleteAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		RegistForm regist = (RegistForm)request.getSession().getAttribute("regist");
		if(regist == null) {
			return mapping.findForward("failed");
		}
		
		if(regist.getRole().equalsIgnoreCase("一般")) {
			regist.setRole("wakai");
		} else {
			regist.setRole("admin");
		}
		NoLoginDao dao = new NoLoginDaoImpl();
		dao.addUser(regist.getUserId(), regist.getPasswd(), regist.getRole());
		request.getSession().removeAttribute("regist");
		return mapping.findForward("success");
	}

}
