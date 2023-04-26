package programmers.고득점Kit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 정렬
 * 가장 큰 수
 */
public class Sort_2 {
    public String solution(int[] numbers) {
        String answer = "";

        List<String> numbersList = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            numbersList.add(String.valueOf(numbers[i]));
        }

        // Collections.sort(numbersList, new Comparator<String>() {
        //     @Override
        //     public int compare(String s1, String s2) {
        //         if (Integer.parseInt(s1 + s2) < Integer.parseInt(s2 + s1)) {
        //             return 1;
        //         } else if (Integer.parseInt(s1 + s2) > Integer.parseInt(s2 + s1)) {
        //             return -1;
        //         } else {
        //             return 0;
        //         }
        //     }
        // });

//        Collections.sort(numbersList, (x, y) -> {
//            return -Integer.compare(Integer.parseInt(x + y), Integer.parseInt(y + x));
//        });

        numbersList.sort((x, y) -> {
            return -Integer.compare(Integer.parseInt(x + y), Integer.parseInt(y + x));
        });

        if (numbersList.get(0).equals("0")) {
            answer = "0";
        } else {
            for (String s : numbersList) {
                answer += s;
            }
        }
        return answer;
    }
}
