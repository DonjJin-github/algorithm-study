import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0;i<N; i++){
            for(int j=i; j<N-1; j++){
                bw.write(" ");
            }
            for(int k=i;k>=0;k--){
                bw.write("*");
            }
            bw.write("\n");

        }
        bw.flush();
    }
    
}
