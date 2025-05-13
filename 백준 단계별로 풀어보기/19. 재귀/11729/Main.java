import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N  = Integer.parseInt(br.readLine());

        System.out.println((1L << N) - 1); // 2^N - 1, long 사용 안전하게

        // 너무 큰 수는 경로 출력 생략
        if (N <= 20) {
            hanoi(1, 3, N);
        }

        bw.flush();
        bw.close();
    }

    public static void hanoi(int from, int to, int n) throws IOException {
        if (n == 1) {
            bw.write(from + " " + to + "\n");
            return;
        }

        int mid = 6 - from - to;
        hanoi(from, mid, n - 1);
        bw.write(from + " " + to + "\n");
        hanoi(mid, to, n - 1);
    }
}
