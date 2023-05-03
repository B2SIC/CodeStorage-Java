package programmers.고득점Kit;

import java.util.Stack;

/**
 * 스택/큐
 * 주식가격
 */
public class Stack_Queue_6 {
    // 반복문을 이용한 풀이
    public int[] solution1(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if (prices[i] > prices[j]) break;
            }
        }
        return answer;
    }

    // Stack을 이용한 풀이
    public int[] solution2(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            stack.push(prices[i]);
        }

        for (int i = prices.length - 1; i >= 0; i--) {
            int v = stack.pop();

            if (i == prices.length - 1) {
                continue;
            }

            int cnt = 0;
            for (int j = i + 1; j < prices.length; j++) {
                cnt++;

                if (v > prices[j]) break;
            }
            answer[i] = cnt;
        }

        return answer;
    }
}
