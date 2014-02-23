package hoge;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import chatbot.ResBean;
import chatbot.ResDao;
import chatbot.ResDaoImpl;
import chatbot.Response;

public class HogeAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String str = (String)request.getParameter("message");
		ResDao dao = new ResDaoImpl();
		Response res = new Response();

		List<String> list = dao.getWordList();
		String hoge = dao.randRes();

		List<String> in = res.createList(str, list);
		List<String> out = res.createList(hoge, list);
		ResBean bean = res.createString(out);
		String res2;
		if(in.size() > 0) {
			res2 = res.crateRespose(bean, out, in);
		} else {
			res2 = dao.randNull();
		}

		res2 = res2.replaceAll("&amp;", "&");
		res2 = res2.replaceAll("&gt;", ">");
		res2 = res2.replaceAll("&lt;", "<");
		res2 = res2.replaceAll("&quot;", "\"");

		request.setAttribute("res", res2);

		return mapping.findForward("success");
	}

}
