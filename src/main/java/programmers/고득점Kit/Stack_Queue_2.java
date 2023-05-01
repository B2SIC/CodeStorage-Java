package programmers.고득점Kit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 스택/큐
 * 기능개발
 */
public class Stack_Queue_2 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> speed = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add(progresses[i]);
            speed.add(speeds[i]);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                int curSpeed = speed.poll();
                queue.add(queue.poll() + curSpeed);
                speed.add(curSpeed);
            }

            if (queue.peek() >= 100) {
                int cnt = 0;
                while (!queue.isEmpty() && queue.peek() >= 100) {
                    queue.poll();
                    speed.poll();
                    cnt++;
                }
                answer.add(cnt);
            }
        }

        int[] res = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            res[i] = answer.get(i);
        }
        return res;
    }
}
