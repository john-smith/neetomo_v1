package action.wakai;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.WakaiDao;
import daoImpl.WakaiDaoImpl;

import bean.noLogin.WordBean;

import form.wakai.RemoveWordForm;

public class RemoveResponseAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		RemoveWordForm rm = (RemoveWordForm)form;
		String str = rm.getWord();
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll("\"", "&quot;");
		
		WakaiDao dao = new WakaiDaoImpl();
		List<WordBean> list = dao.getResponseList(str);
		List<WordBean> list2 = new ArrayList<WordBean>();
		
		
		request.getSession().setAttribute("wordList", list);
		return mapping.findForward("success");
	}

}
