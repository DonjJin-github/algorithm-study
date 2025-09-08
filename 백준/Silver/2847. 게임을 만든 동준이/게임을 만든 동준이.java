import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];
        int temp=0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N-1; i > 0; i--) {
            if (score[i] <= score[i - 1]) {
                temp = score[i - 1] - score[i] + 1;
                score[i-1] = score[i-1]-temp;
                count+=temp;
            }
        }

        bw.write(count + "\n");
        bw.flush();

    }
}
