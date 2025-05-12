import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long ans = fact(N);
        
        bw.write(ans+"\n");
        bw.flush();
    }
    public static long fact(long a){
        if(a == 0)
            return 1;
        
        return a*fact(a-1);
    }
}
