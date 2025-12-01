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

        long ans = 0;

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0) {
                    if (arr[left] == arr[right]) {
                        int count = right - left + 1;
                        ans += count * (count - 1) / 2;
                        break;
                    } else {
                        int leftVal = arr[left];
                        int rightVal = arr[right];
                        long leftCount = 0, rightCount = 0;

                        while (left < right && arr[left] == leftVal) {
                            leftCount++;
                            left++;
                        }

                        while (right >= left && arr[right] == rightVal) {
                            rightCount++;
                            right--;
                        }

                        ans += leftCount * rightCount;
                    }
                } else if (sum < 0) {
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
