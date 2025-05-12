import java.io.*;

public class Main {
    static int[] memo = new int[21];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write(fibo(N)+"\n");
        bw.flush();

    }

    public static int fibo(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if(memo[n]!=0)
            return memo[n];
        return memo[n] = fibo(n - 1) + fibo(n - 2);
    }
    
}
