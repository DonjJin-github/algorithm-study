import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int V = Integer.parseInt(br.readLine());

        int ans=0;

        for(int i =0; i<N;i++){
            int A = Integer.parseInt(str[i]);

            if(A==V)
                ans++;
        }
        bw.write(ans+"\n");
        bw.flush();
    }
}
