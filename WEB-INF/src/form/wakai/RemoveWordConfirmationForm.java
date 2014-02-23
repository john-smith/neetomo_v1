package form.wakai;

import org.apache.struts.action.ActionForm;

public class RemoveWordConfirmationForm extends ActionForm {
	private int[] idList;

	public int[] getIdList() {
		return idList;
	}

	public void setIdList(int[] idList) {
		this.idList = idList;
	}
}
