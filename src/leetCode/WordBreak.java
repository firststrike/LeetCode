package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gengyu.bi on 2014/12/17.
 */
public class WordBreak {
    int[][] canBreak;

    public boolean wordBreak(String s, Set<String> dict) {
        int length = s.length();
        canBreak = new int[length][length];
        return wordBreak(s, dict, 0, length - 1);
    }

    private boolean wordBreak(String s, Set<String> dict, int start, int end) {
        if (canBreak[start][end] > 0) return true;
        if (canBreak[start][end] < 0) return false;
        if (dict.contains(s.substring(start, end + 1))) {
            canBreak[start][end] = 1;
            return true;
        }
        for (int i = start + 1; i <= end; i++) {
            if (wordBreak(s, dict, start, i - 1) && wordBreak(s, dict, i, end)) {
                canBreak[start][end] = 1;
                return true;
            }
        }
        canBreak[start][end] = -1;
        return false;
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        Set<String> dict = new HashSet<String>();
        dict.add("abc");
        dict.add("a");
        dict.add("b");
        dict.add("cd");
        System.out.println(wordBreak.wordBreak("abcd", dict));
        System.out.println("word break");
    }
}
