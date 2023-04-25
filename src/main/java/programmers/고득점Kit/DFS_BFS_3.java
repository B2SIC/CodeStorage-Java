package programmers.고득점Kit;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 깊이/너비 우선 탐색(DFS/BFS)
 * 게임 맵 최단거리
 */
public class DFS_BFS_3 {
    class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int getX() {
            return x;
        }
        int getY() {
            return y;
        }
    }

    public int solution(int[][] maps) {
        int answer = 0;

        int n = maps.length;
        int m = maps[0].length;
        int[][] distance = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distance[i][j] = 0;
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Pair curPos = new Pair(0, 0);
        Queue<Pair> queue = new LinkedList<>();
        queue.add(curPos);
        distance[0][0] = 1;
        while (!queue.isEmpty()) {
            Pair v = queue.poll();

            for(int k = 0; k < 4; k++) {
                int nx = v.getX() + dx[k];
                int ny = v.getY() + dy[k];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (maps[nx][ny] == 1 && distance[nx][ny] == 0) {
                    distance[nx][ny] = distance[v.getX()][v.getY()] + 1;
                    queue.add(new Pair(nx, ny));
                }

            }
        }

        answer = distance[n - 1][m - 1];
        if (answer == 0) {
            answer = -1;
        }
        return answer;
    }

}
