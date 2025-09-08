import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int day = Integer.parseInt(br.readLine());
            long ans = 0;
            int list[] = new int[day];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < day; j++) {
                list[j] = Integer.parseInt(st.nextToken());
            }

            int max = list[day-1];

            for (int j = day - 1; j >= 0; j--) {
                if (list[j] < max) {
                    ans += max - list[j];
                }
                else{
                    max = list[j];
                }
            }
            bw.write(ans + "\n");
        }
        bw.flush();
    }
}
