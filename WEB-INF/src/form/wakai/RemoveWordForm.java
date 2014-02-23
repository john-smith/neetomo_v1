package form.wakai;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class RemoveWordForm extends ActionForm {
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors error = new ActionErrors();
		if(word == null || word.equals("")) {
			error.add("wordError", new ActionMessage("errors.required", "単語"));
		}
		return error;
	}

	private String word;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
}
