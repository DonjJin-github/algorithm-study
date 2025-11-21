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

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int i = 0;
        int j = 0;
        int ans = Integer.MAX_VALUE;

        while (i < N && j<N) {
            if (M <= arr[j] - arr[i]){
                ans = Math.min(ans, arr[j] - arr[i]);
                i++;
            }else{
                j++;
            }
        }

        bw.write(ans+"\n");
        bw.flush();

    }
}
