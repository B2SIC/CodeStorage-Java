import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 예제: BufferedReader, StringTokenizer
        // 참고로 BufferedReader 가 Scanner 보다 빠르다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String getInput = br.readLine();
        System.out.println(getInput);

        // 입력 값이 공백으로 구분될 경우: StringTokenizer 가 BufferedReader 보다 빠를 수 있다.
        // StringTokenizer 를 사용
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        System.out.println("A = " + A);
        System.out.println("B = " + B);

        // BufferedReader 를 사용해 String[] 타입으로 받아오기
        String[] input2 = br.readLine().split(" ");
        System.out.println("input2 = " + Arrays.toString(input2));

        // 출력 예제: StringBuilder, BufferedWriter
        // StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        sb.append("b");
        sb.append("c");
        System.out.println(sb);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "testString";
        bw.write(str);
        bw.newLine();
        // BufferedWriter 는 버퍼를 잡아놓기 때문에 flush()와 close()를 반드시 호출해야한다.
        bw.flush();
        bw.close(); // close()를 호출하면 출력 스트림을 닫아버린다.
    }
}
