import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0;
        int j = 0;
        int temp = 0;
        int ans = Integer.MAX_VALUE;

        while (i < N && j < N) {
            temp += arr[j];

            if (temp >= S) {
                ans = Math.min(ans, j - i);
                temp -= (arr[i] + arr[j]);
                i++;
            } else {
                j++;
            }
        }

        if (ans == Integer.MAX_VALUE)
            bw.write("0\n");
        else
            bw.write(ans + 1 + "\n");

        bw.flush();
        ;

    }
}
