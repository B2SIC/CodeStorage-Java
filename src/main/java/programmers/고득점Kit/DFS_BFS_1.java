package programmers.고득점Kit;

/**
 * 깊이/너비 우선 탐색(DFS/BFS)
 * 타겟 넘버
 */
public class DFS_BFS_1 {
    int res = 0;

    public void dfs(int[] numbers, int target, int depth, int start, int value) {
        if (depth == numbers.length){
            if (value == target) {
                res++;
            }
            return;
        }

        dfs(numbers, target, depth + 1, start + 1, value + numbers[start]);
        dfs(numbers, target, depth + 1, start + 1, value - numbers[start]);
    }

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0, 0);
        return res;
    }
}
