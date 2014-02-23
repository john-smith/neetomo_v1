package action.noLogin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import dao.NoLoginDao;
import daoImpl.NoLoginDaoImpl;

import form.noLogin.RegistForm;

public class RegistAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		RegistForm regist = (RegistForm)form;
		
		NoLoginDao dao = new NoLoginDaoImpl();
		boolean isSuccess = dao.regist(regist.getUserId());
		if(isSuccess) {
			request.getSession().setAttribute("regist", regist);
			return mapping.findForward("success");
		} else {
			ActionMessages message = new ActionMessages();
			message.add("badname", new ActionMessage("errors.badname", "USER ID : " + regist.getUserId() + " "));
			saveMessages(request, message);
			return mapping.findForward("failed");
		}
	}

}
