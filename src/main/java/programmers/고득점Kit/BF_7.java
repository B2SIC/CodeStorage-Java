package programmers.고득점Kit;

/**
 * 완전탐색
 * 모음사전
 */
public class BF_7 {
    static String[] moum = {"A", "E", "I", "O", "U"};
    static final int maxLength = 5;
    int answer = 0;
    int cnt = 0;

    public void dfs(String p, String word) {
        if (p.equals(word)) {
            answer = cnt;
            return;
        }
        if (p.length() == maxLength) {
            return;
        } else {
            for (int i = 0; i < maxLength; i++) {
                cnt++;
                dfs(p + moum[i], word);
            }
        }
    }

    public int solution(String word) {
        dfs("", word);
        return answer;
    }
}
