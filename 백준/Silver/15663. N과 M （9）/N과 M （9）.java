import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static LinkedHashSet<String> printans = new LinkedHashSet<>();
    static int[] temp;
    static boolean[] isused;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        temp = new int[M];
        isused = new boolean[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        func( 0, N, M);
        for (String ptemp : printans) {
            bw.write(ptemp + "\n");
        }
        bw.flush();
    }

    static void func( int K, int N, int M) {
        if (K == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++)
                sb.append(temp[i] + " ");
            printans.add(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isused[i]) {
                isused[i] = true;
                temp[K] = arr[i];
                func( K + 1, N, M);
                isused[i] = false;
            }
        }
    }
}
