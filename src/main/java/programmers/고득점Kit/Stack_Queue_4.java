package programmers.고득점Kit;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 스택/큐
 * 프로세스
 */
public class Stack_Queue_4 {
    class Pair {
        int priority;
        int idxLocation;

        Pair(int priority, int idxLocation) {
            this.priority = priority;
            this.idxLocation = idxLocation;
        }

        int getPriority() {
            return priority;
        }

        int getIdxLocation() {
            return idxLocation;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int priority : priorities) {
            pq.add(priority);
        }

        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Pair(priorities[i], i));
        }

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            if (p.getPriority() < pq.peek()) {
                queue.add(p);
            } else {
                pq.poll();
                answer++;
                if (p.getIdxLocation() == location) {
                    break;
                }
            }
        }

        return answer;
    }
}
