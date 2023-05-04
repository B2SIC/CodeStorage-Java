package Algorithm;

import java.util.Arrays;

/**
 * 퀵정렬
 * 시간복잡도: 최선, 평균 O(nlogn), 최악의 경우 O(n^2)
 * 장점: 시간 복잡도가 O(nlogn)으로 다른 정렬 알고리즘 보다 빠르다.
 * 단점: 불안정 정렬, 이미 정렬된 배열에 대해서는 오히려 수행시간이 많이 걸릴 수 있다.
 */
public class QuickSort {
    public static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = start;
        int i = start + 1;
        int j = end;

        while (i <= j) {
            while (i <= end && arr[i] <= arr[pivot]) {
                i++;
            }
            while (j > start && arr[j] >= arr[pivot]) {
                j--;
            }

            if (i > j) {
                swap(arr, j, pivot);
            } else {
                swap(arr, i, j);
            }
            System.out.println(Arrays.toString(arr));
        }
        return j;
    }
    public static void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partition(arr, start, end);

        sort(arr, start, pivot - 1);
        sort(arr, pivot + 1, end);
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};
        QuickSort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
