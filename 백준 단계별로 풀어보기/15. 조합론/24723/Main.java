import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
 
        int ans =0;

        ans = (int)Math.pow(2,N);
        
        bw.write(ans+"\n");
        bw.flush();
    }
}
