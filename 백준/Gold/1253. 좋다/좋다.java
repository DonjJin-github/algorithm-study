import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int ans = 0;

        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N - 1;

            while (true) {
                if (left == i)
                    left++;
                if (right == i)
                    right--;

                if (left >= right)
                    break;

                int sum = arr[left] + arr[right];

                if (sum == arr[i]) {
                    ans++;
                    break;
                } else if (sum < arr[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        bw.write(ans + "\n");
        bw.flush();
    }
}
