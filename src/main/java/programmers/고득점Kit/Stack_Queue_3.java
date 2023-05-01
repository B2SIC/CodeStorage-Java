package programmers.고득점Kit;

import java.util.Stack;

/**
 * 스택/큐
 * 올바른 괄호
 */
public class Stack_Queue_3 {
    boolean solution(String s) {
        boolean answer = true;

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push("(");
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty()) {
            answer = false;
        }
        return answer;
    }
}
