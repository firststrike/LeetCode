package leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by gengyu.bi on 2014/12/19.
 */
public class IntegerToRoman {
    public static Map<Integer, String> map;

    static {
        map = new HashMap<Integer, String>();
        map.put(1, "IV");
        map.put(10, "XL");
        map.put(100, "CD");
        map.put(1000, "M");
    }

    public String intToRoman(int num) {
        Stack<String> stack = new Stack<String>();
        int sign = 1;
        while (num > 0) {
            int n = num % 10;
            if (n == 0) {
                sign *= 10;
                num /= 10;
                continue;
            }
            StringBuffer sb = new StringBuffer("");
            String rom = map.get(sign);
            if (n <= 3) {
                for (int i = 0; i < n; i++) {
                    sb.append(rom.charAt(0));
                }
            }
            if (n == 4) {
                sb.append(rom.charAt(0));
                sb.append(rom.charAt(1));
            }
            if (n <= 8 && n >= 5) {
                sb.append(rom.charAt(1));
                for (int i = 6; i <= n; i++) {
                    sb.append(rom.charAt(0));
                }
            }
            if (n == 9) {
                sb.append(rom.charAt(0));
                sb.append(map.get(sign * 10).charAt(0));
            }
            stack.push(sb.toString());
            sign *= 10;
            num /= 10;
        }
        StringBuffer sb = new StringBuffer("");
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

}
