import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> {
            double ratioA = (double) a[1] / a[0];
            double ratioB = (double) b[1] / b[0];

            return Double.compare(ratioB, ratioA);
        });

        double ans = 0;
        int weight = 0;

        for (int i = 0; i < N; i++) {
            int itemWeight = arr[i][0];
            int itemValue = arr[i][1];

            if (weight + itemWeight <= M) {
                weight += itemWeight;
                ans += itemValue;
            }
            else {
                int remain = M - weight;

                ans += (double) remain * itemValue / itemWeight;
                weight = M;

                break;
            }
        }

        bw.write(String.format("%.3f", ans));
        bw.flush();
    }
}
