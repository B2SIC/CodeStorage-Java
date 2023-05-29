package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1927 {
    static int top = 1;
    static int[] heap;

    public static void swap(int x, int y) {
        int tmp = heap[x];
        heap[x] = heap[y];
        heap[y] = tmp;
    }

    public static void input(int elem) {
        int i = top;
        heap[top++] = elem;

        while (i != 1) {
            if (heap[i] < heap[i / 2]) {
                swap(i / 2, i);
                i = i / 2;
            } else {
                break;
            }
        }
    }
    public static int delete() {
        if (top == 1) {
            return 0;
        } else {
            int res = heap[1];

            top--;
            int i = 1;
            heap[i] = heap[top];
            heap[top] = 0;

            while (i * 2 < top) {
                if (i * 2 + 1 < top) {
                    if (heap[i] < heap[i * 2] && heap[i] < heap[i * 2 + 1]) {
                        break;
                    }
                    if (heap[i * 2] < heap[i * 2 + 1]) {
                        swap(i, i * 2);
                        i = i * 2;
                    } else {
                        swap(i, i * 2 + 1);
                        i = i * 2 + 1;
                    }
                } else {
                    if (heap[i] < heap[i * 2]) {
                        break;
                    }
                    swap(i, i * 2);
                    i = i * 2;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        heap = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                // 배열에서 가장 작은 값 출력 후 제거
                int res = delete();
                System.out.println(res);
            } else if (x > 0){
                // 배열에 추가
                input(x);
            }
        }
    }
}
