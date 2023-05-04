package Algorithm;

import java.util.Arrays;

/**
 * 삽입정렬
 * 시간복잡도: 최악의 경우 O(n^2), 최선의 경우 O(n)
 * 장점: 알고리즘 단순, 원소가 이미 거의 정렬되어있을 때 매우 효율적일 수 있음
 *      안정 정렬임, 메모리 공간을 추가로 필요로 하지 않음, 버블정렬과 선택정렬에 비해 빠름
 * 단점: 평균과 최악의 시간 복잡도가 O(n^2) -> n이 클수록 비효율적
 */
public class InsertionSort {

    public static int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int prev = i - 1;
            int tmp = arr[i];
            while (prev >= 0 && arr[prev] > tmp) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = tmp;
        }
        return arr;
    }

    public static int[] sortForLoop(int[] arr) {
        int i, j, tmp;
        for (i = 1; i < arr.length; i++) {
            tmp = arr[i];
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 7, 4, 2, 3, 6, 9};
        int[] res = InsertionSort.sort(arr);
//        int[] res = InsertionSort.sortForLoop(arr);
        System.out.println(Arrays.toString(res));
    }
}
