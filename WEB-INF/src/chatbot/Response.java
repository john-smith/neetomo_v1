package chatbot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Response {
	public List<String> createList(String str, List<String> wordList) {
		String posStr = "dummy";
		int pos;
		List<String> list = new ArrayList<String>();

		while(!posStr.equals("")) {
			pos = str.length();
			posStr = "";
			for(String tmp : wordList) {
				int hoge = str.indexOf(tmp);
				if(hoge >= 0 && hoge < pos) {
					pos = hoge;
					posStr = tmp;
				} else if(hoge == pos) {
					if(posStr.length() < tmp.length()) {
						pos = hoge;
						posStr = tmp;
					}
				}
			}
			if(str.indexOf(posStr) != 0) {
				list.add(" " + str.substring(0, str.indexOf(posStr)));
			}
			list.add(posStr);
			str = str.substring(str.indexOf(posStr) + posStr.length());
		}

		for(int i = 0;i < list.size();i++) {
			if(list.get(i).length() == 0) {
				list.remove(i);
			}
		}

		for(int i = 0;i < list.size() - 1;i++) {
			if(list.get(i).charAt(0) != ' ') {
				String tmp = list.get(i);
				while(((i + 1) < list.size()) && (list.get(i + 1).charAt(0) != ' ')) {
					tmp += list.get(i + 1);
					list.remove(i + 1);
				}
				list.remove(i);
				list.add(i, tmp);
			}
		}
		return list;
	}

	public ResBean createString(List<String> list) {
		int varNum = 0;
		String result = "";
		for(String tmp : list) {
			if(tmp.charAt(0) == ' ') {
				result += tmp.substring(1);
			} else {
				result += "@" + ++varNum;
			}
		}
		ResBean bean = new ResBean();
		bean.setRes(result);
		bean.setVarNum(varNum);

		return bean;
	}

	public List<String> getNList(List<String> source) {
		List<String> list = new ArrayList<String>();
		for(String tmp : source) {
			if(tmp.charAt(0) != ' ') {
				list.add(tmp);
			}
		}

		return list;
	}

	public String crateRespose(ResBean res, List<String> orig, List<String> input) {
		orig = getNList(orig);
		input = getNList(input);
		int replace = res.getVarNum() < input.size() ? res.getVarNum() : input.size();
		Random rand = new Random();
		int source = rand.nextInt(input.size()), dest = rand.nextInt(orig.size());
		List<Integer> randSource = new ArrayList<Integer>(), randDest = new ArrayList<Integer>();
		for(int i = 0;i < replace;i++) {
			while(randSource.contains(source)) {
				source = rand.nextInt(input.size());
			}
			while(randDest.contains(dest)) {
				dest = rand.nextInt(orig.size());
			}
			randSource.add(source);
			randDest.add(dest);

			orig.remove(dest);
			orig.add(dest, input.get(source));
		}
		String result = res.getRes();
		for(int i = 0;i < res.getVarNum();i++) {
			result = result.replaceFirst("@" + (i + 1), orig.get(i));
		}

		return result;
	}
}
