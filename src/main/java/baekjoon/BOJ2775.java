package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2775 {
    static int maxFloor = 14;
    static int[][] apartment = new int[maxFloor + 1][maxFloor + 1];

    public static void simulation() {
        for (int i = 1; i <= maxFloor; i++) {
            apartment[0][i] = i;
        }

        for (int i = 1; i <= maxFloor; i++) {
            int downStairs = 0;
            for (int j = 1; j <= maxFloor; j++) {
                downStairs += apartment[i - 1][j];
                apartment[i][j] = downStairs;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        simulation();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            System.out.println(apartment[k][n]);

        }
    }
}
