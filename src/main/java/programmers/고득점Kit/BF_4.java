package programmers.고득점Kit;

/**
 * 완전탐색
 * 카펫
 */
public class BF_4 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for (int i = 1; i <= (int) Math.sqrt(yellow); i++) {
            int width = 0;
            int height = 0;
            if (yellow % i == 0) {
                width = yellow / i;
                height = i;

                if (((width + 2) * (height + 2)) - (width * height) == brown) {
                    answer[0] = width + 2;
                    answer[1] = height + 2;
                }
            }
        }
        return answer;
    }
}
