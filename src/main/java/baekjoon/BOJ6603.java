package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ6603 {

    static ArrayList<Integer> arr;
    static int[] p;

    public static void dfs(int depth, int start) {
        if (depth == 6) {
            for (int i : p) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < arr.size(); i++) {
            p[depth] = arr.get(i);
            dfs(depth + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }

            arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            p = new int[6];
            dfs(0, 0);
            System.out.println();
        }
    }
}
