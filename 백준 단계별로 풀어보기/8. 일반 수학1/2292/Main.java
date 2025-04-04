import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] num = new int [19000];
        num[0] = 1;
        int ans =0;

        for(int i=1;i<19000;i++){
            num[i] = 6*i;
        }

        for(int i=0;i<19000;i++){
            ans+=num[i];
            if(ans<N)
                continue;
            else if(N<=ans){
                bw.write(i+1+"\n");
                break;
            }
        }
        bw.flush();
    }
}