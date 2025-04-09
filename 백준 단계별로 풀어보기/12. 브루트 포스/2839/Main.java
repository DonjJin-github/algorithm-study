import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());


        int min = 9999;

        for(int i=0;i<=1000;i++){
            for(int j=0;j<2000;j++){
                if(5*i+3*j == N)
                    min = Math.min(min,i+j);
            }
        }

        if(min==9999)
            bw.write(-1+"\n");
        else
            bw.write(min+"\n");
        
        bw.flush();
    }
}
