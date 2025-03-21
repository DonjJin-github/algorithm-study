import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int k=N-1;
        int t=N-1;
        for(int i=0;i<N;i++){
            for(int j=0;j<k;j++)
                bw.write(" ");
            for(int j=0;j<2*i+1;j++)
                bw.write("*");
            bw.write("\n");
            k--;
        }

        for(int i=N-1;i>=0;i--){
            for(int j=t;j<N;j++)
                bw.write(" ");
            for(int j=2*i-1;j>0;j--)
                bw.write("*");
            bw.write("\n");
            t--;
        }

        bw.flush();
    }
}
