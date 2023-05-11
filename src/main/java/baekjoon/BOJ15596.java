package baekjoon;

public class BOJ15596 {
    public long sum(int[] a) {
        long res = 0;
        for (int elem : a) {
            res += elem;
        }
        return res;
    }
}
