import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        int ans =1;

        if(N-K<K){
            int j=0;
            while (j<N-K) {
                ans*=N-j;
                j++;
            }
            for(int i=1;i<=N-K;i++){
                ans/=i;
            }
        }
        else{
            int j=0;
            while (j<K) {
                ans*=N-j;
                j++;
            }
            for(int i=1;i<=K;i++){
                ans/=i;
            }
        }
        bw.write(ans+"\n");
        bw.flush();
    }   
}
