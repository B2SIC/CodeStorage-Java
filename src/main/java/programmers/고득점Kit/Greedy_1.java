package programmers.고득점Kit;

import java.util.Arrays;

/**
 * 탐욕법(Greedy)
 * 체육복
 */
public class Greedy_1 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] student = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            student[i] = 1;
        }
        for (int i : lost) {
            student[i] = 0;
        }

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    student[lost[i]] = 1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        Arrays.sort(reserve);

        for (int i : reserve) {
            if (i == -1) continue;

            int prev = i - 1;
            int next = i + 1;

            if (prev > 0 && student[prev] == 0) {
                student[prev] = 1;
            } else if (next <= n && student[next] == 0) {
                student[next] = 1;
            }
        }

        answer = Arrays.stream(student).filter(i -> i == 1).sum();
        return answer;
    }
}
