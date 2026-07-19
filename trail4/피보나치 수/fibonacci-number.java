import java.util.*;
import java.io.*;

public class Main {
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        memo = new int[N+1];
        
        bw.write(fib(N)+"\n");
        bw.flush();
    }
    static int fib(int N){
        if(memo[N] != 0){
            return memo[N];
        }
        if(N<=2)
            memo[N] = 1;
        else
            memo[N] = fib(N-1) + fib(N-2);

        return memo[N];
    }
}