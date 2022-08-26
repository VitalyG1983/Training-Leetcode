
//9. Palindrome Number   https://leetcode.com/problems/palindrome-number/

/*The first idea that comes to mind is to convert the number into string, and check if the string is a palindrome,
        but this would require extra non-constant space for creating the string which is not allowed by the problem description.
               Second idea would be reverting the number itself, and then compare the number with original number,
        if they are the same, then the number is a palindrome. However, if the reversed number is larger than
        int.MAX, we will hit integer overflow problem.
              Following the thoughts based on the second idea, to avoid the overflow issue of the reverted number,
        what if we only revert half of the int number? After all, the reverse of the last half of the palindrome
        should be the same as the first half of the number, if the number is a palindrome. For example, if the input
        is 1221, if we can revert the last part of the number "1221" from "21" to "12", and compare it with the first
        half of the number "12", since 12 is the same as 12, we know that the number is a palindrome.*/

public class PalindromeNumber_9 {
    public static boolean isPalindrome(int x) {
        int testNumber = x;
        int countDigits = 0;

        while (testNumber > 0) {
            testNumber /= 10;
            countDigits++;
        }

        // or we can use function to count length digits of number x: int length = (int) (Math.log10(x) + 1);
        int length = (int) (Math.log10(x) + 1);

        int halfDigits = countDigits / 2;
        // int endHalfNumber = (int) (x % Math.pow(10, halfDigits));  // not work for x = 1001 - because endHalfNumber will be=1, not=01

        int reversedEndHalfNumber = 0;
        int tempCountDigits = countDigits;
        testNumber = x;
        while (tempCountDigits > halfDigits) {
            reversedEndHalfNumber = reversedEndHalfNumber * 10 + testNumber % 10;
            testNumber /= 10;
            tempCountDigits--;
        }

        int firstHalfNumber = x;
        tempCountDigits = countDigits % 2 == 0 ? countDigits : countDigits - 1;
        while (tempCountDigits > halfDigits) {
            firstHalfNumber = firstHalfNumber / 10;
            tempCountDigits--;
        }

        return firstHalfNumber == reversedEndHalfNumber;
    }

    public static void main(String... args) {
        //boolean valid = isPalindrome(2332);
        //boolean valid = isPalindrome(1001);
        boolean valid = isPalindrome(123454321);
        System.out.println(valid);
    }
}

class PalindromeNumber_ {
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        StringBuilder invert = new StringBuilder();
        for (int i = s.length(); i > 0; i--) {
            invert.append(s.substring(i - 1, i));
        }

        return s.equals(invert.toString());
    }


    public static void main(String... args) {
        boolean valid = isPalindrome(2332);
        System.out.println(valid);
    }
}
