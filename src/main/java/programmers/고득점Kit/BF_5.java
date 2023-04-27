package programmers.고득점Kit;

/**
 * 완전탐색
 * 피로도
 */
public class BF_5 {
    static int result;

    public void dfs(int[][] dungeons, int depth, int k, boolean[] visited) {
        if (depth == dungeons.length) {
            result = Math.max(result, depth);
            return;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) { // 선택하지 않은 던전이면서 최소 피로도 이상인 경우
                visited[i] = true;
                dfs(dungeons, depth + 1, k - dungeons[i][1], visited);
                visited[i] = false;
            }
        }
        result = Math.max(result, depth);
    }

    public int solution(int k, int[][] dungeons) {
        result = 0;

        boolean[] visited = new boolean[dungeons.length];
        dfs(dungeons, 0, k, visited);

        return result;
    }
}
