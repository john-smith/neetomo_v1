package hoge;


import java.util.List;

import chatbot.ResBean;
import chatbot.ResDao;
import chatbot.ResDaoImpl;
import chatbot.Response;

public class Hoge {
	public HogeBean talk(String str) {
		ResDao dao = new ResDaoImpl();
		Response res = new Response();
		
		List<String> list = dao.getWordList();
		String hoge = dao.randRes();

		List<String> in = res.createList(str, list);
		List<String> out = res.createList(hoge, list);		
		ResBean bean = res.createString(out);
		HogeBean bean2 = new HogeBean();
		if(in.size() > 0) {
			String response = res.crateRespose(bean, out, in);
			bean2.setWakai(response);
		} else {
			bean2.setWakai(dao.randNull());
		}
		
		return bean2;
	}
}
