package action.wakai;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.WakaiDao;
import daoImpl.WakaiDaoImpl;

public class RemoveWordCompleteAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int[] list = (int[])request.getSession().getAttribute("resultId");
		if(list == null || list.length == 0) {
			return mapping.findForward("failed");
		}
		WakaiDao dao = new WakaiDaoImpl();
		for(int i = 0;i < list.length;i++) {
			dao.removeWord(list[i]);
		}
		request.getSession().removeAttribute("resultId");
		return mapping.findForward("success");
	}
}
