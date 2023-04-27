package programmers.고득점Kit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 해시
 * 전화번호 목록
 */
public class Hash_3 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book, (s1, s2) -> {
            return s1.length() - s2.length();
        });

        Map<String, Integer> pb = new HashMap<>();
        for (String s : phone_book) {
            for (int i = 1; i <= s.length(); i++) {
                if (pb.get(s.substring(0, i)) != null) {
                    return false;
                }
            }
            pb.put(s, 1);
        }

        return answer;
    }
}
