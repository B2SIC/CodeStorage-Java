package programmers.고득점Kit;

import java.util.Arrays;

/**
 * 정렬
 * H-Index
 */
public class Sort_3 {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        int k = 0;
        boolean noIdx = false;
        for (int h = 1; h <= citations.length; h++) {
            // h번 이상 인용된 논문 최소값 찾기
            while (h > citations[k]) {
                k++;

                // h번 이상 인용된 논문이 없다면 종료
                if (k >= citations.length) {
                    return 0;
                }
            }

            // 인용 횟수 계산
            if (citations.length - k >= h) {
                answer = Math.max(answer, h);
            }
        }
        return answer;
    }
}
