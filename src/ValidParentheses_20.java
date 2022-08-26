

//20. Valid Parentheses   https://leetcode.com/problems/valid-parentheses/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses_20 {
    public static boolean valid;

    public static boolean isValid(String s) {
        s = s.replaceAll(" ", "");
        int length = s.length();

        s = s.replaceAll("\\{\\}", "");
        s = s.replaceAll("\\[\\]", "");
        s = s.replaceAll("\\(\\)", "");

        if (s.length() == 0) {
            valid = true;
        } else if (s.length() != length) {
            isValid(s);
        }
        return valid;
    }

    public static void main(String... args) {
        // boolean valid = isValid("[fg    ][]()cv[bv]");
        //  boolean valid = isValid("()[]{}");
        boolean valid = isValid("{{()[]}}");
        //boolean valid = isValid("{ { } [ ] [ [ [ ] ] ] }");
        System.out.println(valid);
    }
}

class Solution2 {
    public static boolean isValid(String s) {
        String isOpen = "([{";
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        LinkedList<Character> openStack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (isOpen.contains(String.valueOf(c))) {
                openStack.add(c);
                continue;
            }
            if (!openStack.isEmpty() && openStack.getLast().equals(pairs.get(c))) {
                openStack.pollLast();
            } else return false;
        }
        return openStack.isEmpty();
    }

    public static void main(String... args) {
        // boolean valid = isValid("[fg    ][]()cv[bv]");
        //  boolean valid = isValid("()[]{}");
        boolean valid = isValid("({{()[]}}())");
        //boolean valid = isValid("{ { } [ ] [ [ [ ] ] ] }");
        System.out.println(valid);
    }
}

