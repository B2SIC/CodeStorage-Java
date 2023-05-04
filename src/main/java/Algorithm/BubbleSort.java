package Algorithm;

import java.util.Arrays;

/**
 * 버블정렬(거품정렬)
 * 시간복잡도: O(n^2)
 * 장점: 구현이 간단하고 직관적임, 별도의 메모리 공간을 필요로 하지 않음.
 * 단점: 시간복잡도가 최선, 최악, 평균 모두 O(n^2)로 비효율적
 */
public class BubbleSort {
    public static int[] sort(int[] arr) {
        int tmp;
        for (int k = arr.length - 1; k > 0; k--) {
            for (int i = 0; i < k; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 2, 7, 6, 11};
        int[] res = BubbleSort.sort(arr);
        System.out.println(Arrays.toString(res));
    }
}