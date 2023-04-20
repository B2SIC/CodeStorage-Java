package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1244 {

    public static int reverse(int x) {
        if (x == 1) return 0;
        else return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] switchStatus = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            switchStatus[i] = Integer.parseInt(st.nextToken());
        }

        int p = Integer.parseInt(br.readLine());
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            // 남자일 경우 배수 반전
            if (gender == 1) {
                for (int k = num - 1; k < n; k += num) {
                    switchStatus[k] = reverse(switchStatus[k]);
                }
            } else if (gender == 2) { // 여자의 경우 대칭 값이 같을 때 반전
                int target_s = num - 1;
                int target_e = num - 1;

                int s = target_s - 1;
                int e = target_s + 1;
                while (s >= 0 && e < n) {
                    if (switchStatus[s] != switchStatus[e]) {
                        break;
                    } else {
                        target_s = s;
                        target_e = e;
                        s--;
                        e++;
                    }
                }
                // 반전 수행
                for (int k = target_s; k <= target_e; k++) {
                    switchStatus[k] = reverse(switchStatus[k]);
                }
            }
        }
        // 20개씩 끊어서 출력하기
        int cnt = 0;
        while (cnt < n) {
            System.out.print(switchStatus[cnt] + " ");
            if ((cnt + 1) % 20 == 0) {
                System.out.println();
            }
            cnt++;
        }
    }
}
