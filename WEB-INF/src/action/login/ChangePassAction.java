package action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import bean.noLogin.LoginBean;

import dao.LoginDao;
import daoImpl.LoginDaoImpl;
import form.login.ChangePassForm;

public class ChangePassAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LoginDao dao = new LoginDaoImpl();
		ChangePassForm changeForm = (ChangePassForm)form;
		LoginBean bean = (LoginBean)request.getSession().getAttribute("login");
		if(!changeForm.getNewPass().equals(bean.getPasswd())) {
			dao.changePass(bean.getUserName(), changeForm.getNewPass());
			bean.setPasswd(changeForm.getNewPass());
			return mapping.findForward("success");
		} else {
			ActionMessages message = new ActionMessages();
			message.add("passmiss", new ActionMessage("errors.same"));
			saveMessages(request, message);
			return mapping.findForward("failed");
		}
	}

}
