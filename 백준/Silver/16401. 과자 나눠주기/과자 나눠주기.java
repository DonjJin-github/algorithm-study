import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        long[] arr = new long[L];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < L; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long ans = 0;
        long left = 1;
        long right = arr[L - 1];
        long mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            long temp = 0;

            for (int i = 0; i < L; i++) {
                temp += arr[i] / mid;
            }

            if (temp >= M) {
                ans = Math.max(ans, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        bw.write(ans + "\n");
        bw.flush();

    }
}
