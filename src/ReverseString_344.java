
//  344. Reverse String  https://leetcode.com/problems/reverse-string/
// https://www.techiedelight.com/ru/in-place-vs-out-of-place-algorithms/
// Wiki:  https://en.wikipedia.org/wiki/In-place_algorithm
/*In-place algorithm is an algorithm which transforms input using no auxiliary data structure. However, a small amount of
        extra storage space is allowed for auxiliary variables. The input is usually overwritten by the output as the
        algorithm executes. An in-place algorithm updates its input sequence only through replacement or swapping of
        elements. An algorithm which is not in-place is sometimes called not-in-place or out-of-place.
   The complexity of this algorithm is in most cases O(log n)  */

public class ReverseString_344 {
    public static void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        System.out.println(s);
    }

    public static void main(String... args) {
        reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
    }
}
