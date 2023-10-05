import java.util.Stack;

public class Palindrome {
    public static boolean isPalindrome(String str) {
        str = str.replaceAll("[^a-zA-Z]", "").toLowerCase();

        Stack<Character> stack = new Stack<>();
        int length = str.length();
        int halfLength = length / 2;

        for (int i = 0; i < halfLength; i++) {
            stack.push(str.charAt(i));
        }

        int startIndex = (length % 2 == 0) ? halfLength : halfLength + 1;
        for (int i = startIndex; i < length; i++) {
            char c = stack.pop();
            if (c != str.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] testCases = {
                "I did, did I?", // palindrom
                "Racecar",      // palindrom
                "hello",        // palindrom değil
                "Was it a car or a cat I saw ?", // palindrom
        };

        for (String testCase : testCases) {
            boolean result = isPalindrome(testCase);
            System.out.println(testCase + " => " + (result ? "palindrom" : "palindrom değil"));
        }
    }
}
