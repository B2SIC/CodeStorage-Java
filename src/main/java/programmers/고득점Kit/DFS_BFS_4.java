package programmers.고득점Kit;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 깊이/너비 우선 탐색(DFS/BFS)
 * 단어 변환
 */
public class DFS_BFS_4 {
    class Pair {
        String value;
        int level;

        Pair(String value, int level) {
            this.value = value;
            this.level = level;
        }

        int getLevel() {
            return this.level;
        }
    }

    public int convertCounter(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        if (!Arrays.asList(words).contains(target)) {
            return answer;
        }

        boolean[] used = new boolean[words.length];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(begin, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            String value = p.value;
            int level = p.level;

            if (value.equals(target)) {
                answer = level;
                break;
            }

            for (int i = 0; i < words.length; i++) {
                if (value.equals(words[i])) continue;
                if (!used[i] && convertCounter(value, words[i]) == 1) {
                    queue.add(new Pair(words[i], level + 1));
                    used[i] = true;
                }
            }
        }

        return answer;
    }
}
