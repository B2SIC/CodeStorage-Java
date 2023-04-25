package programmers.고득점Kit;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 깊이/너비 우선 탐색(DFS/BFS)
 * 네트워크
 */
public class DFS_BFS_2 {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        // 방문 표시를 위한 배열 선언
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            visited[i] = false;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                visited[i] = true;
                queue.add(i);

                while (queue.size() >= 1) {
                    int v = queue.poll();

                    for(int k = 0; k < n; k++) {
                        if (k == v) continue;
                        if (!visited[k] && computers[v][k] == 1) {
                            visited[k] = true;
                            queue.add(k);
                        }
                    }
                }
            }
        }
        return answer;
    }
}
