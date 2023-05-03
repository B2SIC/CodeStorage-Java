package programmers.고득점Kit;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 스택/큐
 * 다리를 지나는 트럭
 */
public class Stack_Queue_5 {
    class Pair {
        int weight;
        int remainTime;

        Pair(int weight, int remainTime) {
            this.weight = weight;
            this.remainTime = remainTime;
        }

        int getWeight() {
            return this.weight;
        }

        int getRemainTime() {
            return this.remainTime;
        }

        void moving() {
            this.remainTime--;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Pair> crossingQueue = new LinkedList<>(); // 다리를 건너는 트럭 큐
        Queue<Pair> waitingQueue = new LinkedList<>(); // 대기 트럭 큐
        for (int t : truck_weights) {
            waitingQueue.add(new Pair(t, bridge_length));
        }

        int time = 0;
        int currentWeight = 0;
        while (!crossingQueue.isEmpty() || !waitingQueue.isEmpty()) {
            // 다리를 건너는 트럭들 중 다리를 다 지나간 트럭을 제외한다.
            while (!crossingQueue.isEmpty()) {
                Pair target = crossingQueue.peek();
                if (target.getRemainTime() == 0) {
                    currentWeight -= target.getWeight();
                    crossingQueue.poll();
                } else {
                    break;
                }
            }

            // 대기 트럭들 중에서 다리를 건널 수 있는 트럭을 가져온다.
            if (!waitingQueue.isEmpty() && crossingQueue.size() < bridge_length) {
                if (currentWeight + waitingQueue.peek().getWeight() <= weight) {
                    currentWeight += waitingQueue.peek().getWeight();
                    crossingQueue.add(waitingQueue.poll());
                }
            }

            // 다리를 건너고 있는 트럭의 Status 갱신
            for (Pair p : crossingQueue) {
                p.moving();
            }

            time++;
        }

        return time;
    }
}
