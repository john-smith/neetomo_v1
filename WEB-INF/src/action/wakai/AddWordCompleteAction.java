package action.wakai;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.WakaiDao;
import daoImpl.WakaiDaoImpl;

public class AddWordCompleteAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String str = (String)request.getSession().getAttribute("addWord");
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll("\"", "&quot;");
		if(str == null) {
			return mapping.findForward("failed");
		}
		
		WakaiDao dao = new WakaiDaoImpl();
		dao.addWord(str);
		request.getSession().removeAttribute("addWord");
		return mapping.findForward("success");
	}
}
