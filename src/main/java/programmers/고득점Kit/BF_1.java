package programmers.고득점Kit;

/**
 * 완전탐색
 * 최소직사각형
 */
public class BF_1 {
    public int solution(int[][] sizes) {
        int width = 0;
        int height = 0;
        for (int i = 0; i < sizes.length; i++) {
            width = Math.max(width, Math.max(sizes[i][0], sizes[i][1]));
            height = Math.max(height, Math.min(sizes[i][0], sizes[i][1]));
        }

        return width * height;
    }
}
