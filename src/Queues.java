import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Queues {
    public static boolean isPalindrome(String str) {
        str = str.replaceAll("[^a-zA-Z]", "").toLowerCase();

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
            queue.offer(c);
        }

        while (!stack.isEmpty() && !queue.isEmpty()) {
            char stackChar = stack.pop();
            char queueChar = queue.poll();

            if (stackChar != queueChar) {
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
