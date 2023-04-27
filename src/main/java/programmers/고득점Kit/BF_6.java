package programmers.고득점Kit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 완전탐색
 * 전력망을 둘로 나누기
 */
public class BF_6 {
    public int getTopCount(int n, List<Integer>[] graph) {
        int cnt = 0;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                queue.add(i);
                visited[i] = true;

                while (queue.size() > 0) {
                    int v = queue.poll();
                    cnt++;

                    for (int k : graph[v]) {
                        if (!visited[k]) {
                            visited[k] = true;
                            queue.add(k);
                        }
                    }
                }
                return Math.abs(cnt - (n - cnt));
            }
        }
        return 0;
    }

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < wires.length; i++) {
            graph[wires[i][0]].add(wires[i][1]);
            graph[wires[i][1]].add(wires[i][0]);
        }

        for (int i = 0; i < wires.length; i++) {
            // 끊기
            graph[wires[i][0]].remove(Integer.valueOf(wires[i][1]));
            graph[wires[i][1]].remove(Integer.valueOf(wires[i][0]));

            answer = Math.min(answer, getTopCount(n, graph));

            // 원복
            graph[wires[i][0]].add(wires[i][1]);
            graph[wires[i][1]].add(wires[i][0]);
        }

        return answer;
    }
}
