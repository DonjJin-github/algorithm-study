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

        int left = 0;
        int right = N - 1;
        long min = Long.MAX_VALUE;
        int ans[] = new int[2];

        while (left < right) {
            int temp = arr[left] + arr[right];

            if (min > Math.abs(temp)) {
                min = Math.abs(temp);
                ans[0] = left;
                ans[1] = right;
            }

            if (temp < 0)
                left++;
            else if (temp > 0)
                right--;
            else {
                break;
            }
        }
        bw.write(arr[ans[0]] + arr[ans[1]] + "\n");
        bw.flush();
    }
}
