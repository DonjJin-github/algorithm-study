import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] com = new int[4];
    static int ans;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            com[i] = Integer.parseInt(st.nextToken());
        }
        ans =arr[0];
        func(1,N);
        bw.write(max+"\n"+min+"\n");
        bw.flush();

    }

    static void func(int K, int N) {
        if (K == N) {
            max = Math.max(max, ans);
            min = Math.min(min, ans);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (com[i] != 0) {
                int prevans = ans;
                com[i]--;
                switch (i) {
                    case 0:
                        ans += arr[K];
                        break;
                    case 1:
                        ans -= arr[K];
                        break;
                    case 2:
                        ans *= arr[K];
                        break;
                    case 3:
                        if (ans < 0)
                            ans = -((-ans) / arr[K]);
                        else
                            ans = ans / arr[K];
                        break;
                }
                func(K + 1, N);
                ans = prevans;
                com[i]++;
            }
        }
    }
}