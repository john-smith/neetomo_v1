package action.wakai;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import dao.WakaiDao;
import daoImpl.WakaiDaoImpl;

import form.wakai.AddWordForm;

public class AddResponseAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		AddWordForm add = (AddWordForm)form;
		
		WakaiDao dao = new WakaiDaoImpl();
		String str = add.getWord();
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll("\"", "&quot;");
		boolean isSuccess = dao.confirm(str);
		
		if(isSuccess) {
			request.getSession().setAttribute("addWord", add.getWord());
			return mapping.findForward("success");
		} else {
			ActionMessages message = new ActionMessages();
			message.add("badword", new ActionMessage("errors.badname", "" + str + " "));
			saveMessages(request, message);
			return mapping.findForward("failed");
		}
	}

}
