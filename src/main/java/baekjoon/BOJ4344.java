package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int c = Integer.parseInt(br.readLine());
        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int[] scores = new int[n];
            int sum = 0;
            for (int j = 0; j < n; j++) {
                scores[j] = Integer.parseInt(st.nextToken());
                sum += scores[j];
            }

            double avg = (double) sum / n;
            int cnt = 0;
            for (int score : scores) {
                if (score > avg) {
                    cnt++;
                }
            }
            double rate = (double) cnt / n;
            System.out.println(String.format("%.3f%%", rate * 100));
        }
    }
}
