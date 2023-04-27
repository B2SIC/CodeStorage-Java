package programmers.고득점Kit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 깊이/너비 우선 탐색(DFS/BFS)
 * 여행경로
 */
public class DFS_BFS_5 {
    class Ticket {
        String head;
        String tail;

        Ticket(String head, String tail) {
            this.head = head;
            this.tail = tail;
        }

        String getHead() {
            return head;
        }


        String getTail() {
            return tail;
        }
    }

    static Ticket[] t;
    static List<String> answer;
    static int ticketCnt = 0;
    static boolean find = false;

    public void dfs(Ticket currentTicket, boolean[] visited, List<String> path) {
        if (!find && ticketCnt == t.length) {
            for (String s : path) {
                answer.add(s);
            }
            find = true;
            return;
        }

        for (int i = 0; i < t.length; i++) {
            if (!visited[i] && currentTicket.getTail().equals(t[i].getHead())) {
                visited[i] = true;
                ticketCnt++;
                path.add(t[i].getTail());

                dfs(t[i], visited, path);

                visited[i] = false;
                path.remove(path.size() - 1);
                ticketCnt--;
            }


        }
    }

    public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();

        t = new Ticket[tickets.length];
        for (int i = 0; i < tickets.length; i++) {
            t[i] = new Ticket(tickets[i][0], tickets[i][1]);
        }

        // 도착지 기준 알파벳 순 정렬
        Arrays.sort(t, (s1, s2) -> s1.tail.compareTo(s2.tail));

        // DFS 파라미터 값 세팅
        boolean[] visited = new boolean[t.length];
        List<String> path = new ArrayList<>();
        path.add("ICN");
        dfs(new Ticket("", "ICN"), visited, path);

        return answer.toArray(new String[answer.size()]);
    }
}
