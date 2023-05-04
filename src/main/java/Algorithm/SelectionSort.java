package Algorithm;

import java.util.Arrays;

/**
 * 선택정렬
 * 시간복잡도: O(n^2)
 * 장점: 단순하고 직관적임, 정렬을 위한 교환 횟수는 많아도 버블정렬에 비해 적음, 메모리 공간 별도로 필요 없음
 * 단점: 시간복잡도가 O(n^2)으로 비효율적, 중복된 값이 입력 순서와 동일하지 않은 불안정 정렬
 */
public class SelectionSort {
    public static int[] sort(int[] arr) {
        int minIdx, tmp;
        for (int i = 0; i < arr.length - 1; i++) {
            minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            // Swap
            tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 3, 6, 5, 2, 4};
        int[] res = SelectionSort.sort(arr);

        System.out.println(Arrays.toString(res));
    }
}
