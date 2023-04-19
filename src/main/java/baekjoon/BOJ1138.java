package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] line = new int[n];
        int[] res = new int[line.length];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            line[i] = Integer.parseInt(st.nextToken());
            res[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            int t = line[i] + 1;
            int findIdx = -1;
            while (t > 0) {
                findIdx++;
                if (res[findIdx] == 0) {
                    t--;
                }
            }
            res[findIdx] = i + 1;
        }
        for (int elem : res) {
            System.out.print(elem + " ");
        }
    }
}
