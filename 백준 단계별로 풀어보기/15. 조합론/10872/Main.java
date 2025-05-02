import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int ans =1;
        for(int i=1;i<=N;i++)
            ans*=i;
        
        bw.write(ans+"\n");
        bw.flush();
    }
}
