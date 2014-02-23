package action.wakai;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import bean.noLogin.WordBean;

import form.wakai.RemoveWordConfirmationForm;

public class RemoveWordConfirmationAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		RemoveWordConfirmationForm form2 = (RemoveWordConfirmationForm)form;
		request.getSession().setAttribute("resultId", form2.getIdList());
		List<String> resultList = new ArrayList<String>();
		List<WordBean> sourceList = (List<WordBean>)request.getSession().getAttribute("wordList");
		
		if(form2.getIdList() == null || form2.getIdList().length == 0) {
			ActionMessages message = new ActionMessages();
			message.add("noselect", new ActionMessage("errors.noword", "単語"));
			saveMessages(request, message);
			return mapping.findForward("failed");
			
		} else {
			for(WordBean bean : sourceList) {
				for(int i = 0;i < form2.getIdList().length;i++) {
					if(bean.getId() == form2.getIdList()[i]) {
						resultList.add(bean.getWord());
					}
				}
			}
		}	
		request.getSession().setAttribute("removeWordList", resultList);
		
		return mapping.findForward("success");
	}

}
