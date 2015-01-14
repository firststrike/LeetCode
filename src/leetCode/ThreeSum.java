package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gengyu.bi on 2014/12/19.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null || num.length < 3) {
            return result;
        }
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i] == num[i - 1]) continue;
            int m = i + 1;
            int n = num.length - 1;
            while (m < n) {
                int sum = num[i] + num[m] + num[n];
                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[m]);
                    list.add(num[n]);
                    result.add(list);
                    do {
                        m++;
                    } while (m < n && num[m] == num[m - 1]);
                    do {
                        n--;
                    } while (m < n && num[n] == num[n + 1]);
                } else if (sum < 0) m++;
                else n--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        threeSum.threeSum(new int[]{1, -1, -1, 0});
        System.out.println("3Sum");
    }
}
