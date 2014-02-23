package action.noLogin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import bean.noLogin.LoginBean;

import dao.NoLoginDao;
import daoImpl.NoLoginDaoImpl;
import form.noLogin.LoginForm;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LoginForm loginForm = (LoginForm)form;
		NoLoginDao dao = new NoLoginDaoImpl();
		LoginBean bean = dao.login(loginForm.getUserId(), loginForm.getPasswd());
		if(bean != null) {
			request.getSession().setAttribute("login", bean);
			return mapping.findForward("success");
		} else {
			
			ActionMessages message = new ActionMessages();
			message.add("collision", new ActionMessage("errors.collision", "USER ID", "PASSWORD"));
			saveMessages(request, message);
			return mapping.findForward("failed");
		}
		
		
	}

}
