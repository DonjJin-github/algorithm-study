import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        bw.write(recur(N, r, c)+"\n");
        bw.flush();

        
    }

    public static int recur(int n, int r, int c){
        if(n==0)
            return 0;
        int half = (int)Math.pow(2, n-1);
        if(r < half && c < half) return recur(n-1, r, c);
        if(r < half && c >= half) return half*half + recur(n-1, r, c-half);
        if(r >= half && c < half) return 2*half*half + recur(n-1, r-half, c);
        return 3*half*half + recur(n-1, r-half, c-half);
        
    }
}
