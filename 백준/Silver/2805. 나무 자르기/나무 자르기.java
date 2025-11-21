import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        long left = 0;
        long right = arr[N - 1];
        long mid = 0;
        long ans = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            long temp = 0;

            for (int i = 0; i < N; i++) {
                if (arr[i] - mid > 0)
                    temp += (arr[i] - mid);
            }

            if (temp >= M) {
                ans = Math.max(ans,mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        bw.write(ans+"\n");
        bw.flush();
    }
}
