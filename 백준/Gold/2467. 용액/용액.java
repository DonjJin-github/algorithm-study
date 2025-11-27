import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0, right = N - 1;
        int minAbs = Integer.MAX_VALUE;
        int ansLeft = 0, ansRight = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            int absSum = Math.abs(sum);

            if (absSum < minAbs) {
                minAbs = absSum;
                ansLeft = left;
                ansRight = right;
            }

            if (sum < 0)
                left++;
            else if (sum > 0)
                right--;
            else
                break;
        }

        int first = arr[ansLeft];
        int second = arr[ansRight];
        if (first > second) {
            int tmp = first;
            first = second;
            second = tmp;
        }

        bw.write(first + " " + second + "\n");
        bw.flush();

    }
}
