import java.util.Scanner;
import java.util.Stack;

public class week1_9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++) {
            System.out.println(check(sc.next()));
        }
    }

    public static String check(String s) {
        Stack<Character> stack = new Stack<>();
        for(int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);

            if(c == '(') {
                stack.push(c);
            }
            else if(c == ')') {
                if(stack.isEmpty()) {
                    return "NO";
                }
                else stack.pop();
            }
            else {
                if(stack.isEmpty()) {
                    return "YES";
                }
            }
        }
        if(stack.isEmpty()) {
            return "YES";
        }
        else return "NO";
    }
}