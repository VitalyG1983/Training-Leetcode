import java.util.HashMap;
import java.util.Map;

// 13. Roman to Integer; https://leetcode.com/problems/roman-to-integer/

public class RomanToInteger_13 {
    public static int romanToInt(String s) {
        Map<String, Integer> romanToInt = new HashMap<>();
        romanToInt.put("I", 1);
        romanToInt.put("V", 5);
        romanToInt.put("X", 10);
        romanToInt.put("L", 50);
        romanToInt.put("C", 100);
        romanToInt.put("D", 500);
        romanToInt.put("M", 1000);
        romanToInt.put("CM", 900);
        romanToInt.put("CD", 400);
        romanToInt.put("XL", 40);
        romanToInt.put("XC", 90);
        romanToInt.put("IV", 4);
        romanToInt.put("IX", 9);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            Integer num = null;
            if (i + 2 <= s.length()) {
                num = romanToInt.get(s.substring(i, i + 2));
            }
            if (num != null) {
                result += num;
                i += 1;
            } else {
                result += romanToInt.get(s.substring(i, i + 1));
            }
        }
        return result;

    }

    public static void main(String... args) {
       //  int number = romanToInt("MCMXCIV");  //1994
        int number = romanToInt("MCDXCIII");   //1493
        System.out.println(number);
    }
}
