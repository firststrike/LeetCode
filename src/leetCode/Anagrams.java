package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Anagrams {
	public List<String> anagrams(String[] strs) {
		List<String> strList = new LinkedList<String>();
		Map<String, List<String>> strMap = new HashMap<String, List<String>>();
		for (int i = 0; i < strs.length; i++) {
			String word = strs[i];
			String key = sort(word);
			if (strMap.containsKey(key)) {
				strMap.get(key).add(word);
			} else {
				List<String> words = new LinkedList<String>();
				words.add(word);
				strMap.put(key, words);
			}
		}
		for (Entry<String, List<String>> words : strMap.entrySet()) {
			if (words.getValue().size() > 1) {
				strList.addAll(words.getValue());
			}
		}
		return strList;
	}

	private String sort(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
}
