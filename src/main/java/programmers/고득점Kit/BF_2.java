package programmers.고득점Kit;

import java.util.ArrayList;
import java.util.List;

/**
 * 완전탐색
 * 모의고사
 */
public class BF_2 {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();

        int[] x1 = {1, 2, 3, 4, 5};
        int[] x2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] x3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == x1[i % x1.length]) {
                scores[0]++;
            }
            if (answers[i] == x2[i % x2.length]) {
                scores[1]++;
            }
            if (answers[i] == x3[i % x3.length]) {
                scores[2]++;
            }
        }

        int maxCount = Math.max(scores[0], Math.max(scores[1], scores[2]));
        if (maxCount == scores[0]) {
            answer.add(1);
        }
        if (maxCount == scores[1]) {
            answer.add(2);
        }
        if (maxCount == scores[2]) {
            answer.add(3);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
