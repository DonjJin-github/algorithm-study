import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split("");
        String[] b = br.readLine().split("");

        int ans = 0;
        int idx = 0;

        while (idx < N) {
            if (a[idx].equals(b[idx])) {
                idx++;
                continue;
            }
            while (idx < N && !a[idx].equals(b[idx])) {
                idx++;
            }
            ans++;
        }

        System.out.println(ans);
    }
}