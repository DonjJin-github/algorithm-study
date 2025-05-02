import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
      

        for (int x = 0; x < T; x++) {
            String[] NK = br.readLine().split(" ");
            int N = Integer.parseInt(NK[0]);
            int K = Integer.parseInt(NK[1]);
            long ans = 1;
            if (K - N < N) {
                int j = 0;
                while (j < K-N) {
                    ans *= K - j;
                    j++;
                }
                for (int i = 1; i <= K - N; i++) {
                    ans /= i;
                }
            } else {
                int j = 0;
                while (j < N) {
                    ans *= K - j;
                    j++;
                }
                for (int i = 1; i <= N; i++) {
                    ans /= i;
                }
            }
            bw.write(ans + "\n");
        }
        
        bw.flush();
    }
}
