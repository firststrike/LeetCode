package leetCode;

import java.util.LinkedList;
import java.util.List;

public class TextJustification {
	public List<String> fullJustify(String[] words, int L) {
		if (words == null) {
			return null;
		}
		if (words.length == 0) {
			List<String> result = new LinkedList<String>();
			return result;
		}
		if (L <= 0) {
			List<String> result = new LinkedList<String>();
			result.add("");
			return result;
		}
		List<String> result = new LinkedList<String>();
		List<String> wordsList = new LinkedList<String>();
		for (int i = 0; i < words.length; i++) {
			wordsList.add(words[i]);
		}
		do {
			int count = getCount(wordsList, L);
			words = new String[count];
			for (int i = 0; i < words.length; i++) {
				words[i] = wordsList.get(0);
				wordsList.remove(0);
			}
			boolean isLastLine = false;
			if (wordsList.size() == 0) {
				isLastLine = true;
			}
			String str = getStr(words, L, isLastLine);
			result.add(str);
		} while (wordsList.size() > 0);
		return result;
	}

	/**
	 * 要截取的单词个数
	 * 
	 * @param wordsList
	 * @param L
	 * @return
	 */
	private int getCount(List<String> wordsList, int L) {
		int i = 0;
		int length = 0;
		if (wordsList.size() == 1) {
			return 1;
		}
		for (String word : wordsList) {
			i++;
			if (length + word.length() + (i - 1) > L) {
				return i - 1;
			} else {
				length += word.length();
			}
		}
		return i;
	}

	/**
	 * 将截取的单词拼装成字符串
	 * 
	 * @param words
	 * @param L
	 * @return
	 */
	private String getStr(String[] words, int L, boolean isLastLine) {
		String result = "";
		int wordsLength = 0;
		for (int i = 0; i < words.length; i++) {
			wordsLength += words[i].length();
		}
		int space = L - wordsLength;// 剩余空格个数
		if (!isLastLine) {
			for (int i = 0; i < space; i++) {
				if (words.length == 1) {
					words[0] += " ";
				} else {
					words[i % (words.length - 1)] += " ";
				}
			}
		} else {
			for (int i = 0; i < words.length - 1; i++) {
				words[i] += " ";
				space--;
			}
		}
		for (int i = 0; i < words.length; i++) {
			result += words[i];
		}
		if (isLastLine) {
			for (int i = 0; i < space; i++) {
				result += " ";
			}
		}
		return result;
	}
}
