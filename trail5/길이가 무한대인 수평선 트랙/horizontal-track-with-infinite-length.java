import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long T = Long.parseLong(st.nextToken());

        long[] pos = new long[N];
        long[] speed = new long[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            pos[i] = Long.parseLong(st.nextToken());
            speed[i] = Long.parseLong(st.nextToken());
        }

        int answer = 0;
        long front = Long.MAX_VALUE;
        for (int i = N - 1; i >= 0; i--) {

            long end = pos[i] + speed[i] * T;

            if (end < front) {
                answer++;
                front = end;
            }
        }

        System.out.println(answer);
    }
}