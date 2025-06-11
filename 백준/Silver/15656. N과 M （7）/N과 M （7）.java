import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int[] print;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        print = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        func(0, N, M);
        bw.flush();
    }

    static void func(int K, int N, int M)throws IOException {
        if (K == M) {
            for(int i=0;i<M;i++)
                bw.write(print[i]+" ");
            bw.write("\n");
            return;
        }

        for(int i=0;i<N;i++){
                print[K] = arr[i];
                func(K+1, N, M);
        }
    }
}
