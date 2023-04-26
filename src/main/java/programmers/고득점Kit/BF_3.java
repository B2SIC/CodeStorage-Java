package programmers.고득점Kit;

import java.util.HashSet;
import java.util.Set;

/**
 * 완전탐색
 * 소수 찾기
 */
public class BF_3 {
    static Set<Integer> answer;
    static int[] numberArray;
    static int n;

    public boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int k = 2; k <= (int) Math.sqrt(num); k++) {
            if (num % k == 0) {
                return false;
            }
        }
        return true;
    }

    public void dfs(int maxDepth, int depth, int[] p, boolean[] visited) {
        if (depth == maxDepth) {
            String makeNumber = "";
            for (int pn : p) {
                makeNumber += String.valueOf(pn);
            }

            int getNumber = Integer.parseInt(makeNumber);
            if (isPrime(getNumber)) {
                answer.add(Integer.parseInt(makeNumber));
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                p[depth] = numberArray[i];
                dfs(maxDepth, depth + 1, p, visited);
                visited[i] = false;
            }
        }

    }

    public int solution(String numbers) {
        answer = new HashSet<>();
        n = numbers.length();

        numberArray = new int[n];
        for (int i = 0; i < n; i++) {
            numberArray[i] = numbers.charAt(i) - '0';
        }

        for (int i = 1; i <= n; i++) {
            int[] p = new int[i];
            boolean[] visited = new boolean[n];
            dfs(i, 0, p, visited);
        }

        return answer.size();
    }
}
