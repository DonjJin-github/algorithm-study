import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr ;
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr= new int [N+1]; 
        func(0,N,M);
        bw.flush();
        
    }
    static void func(int K, int N, int M)throws IOException{
        if(K==M){
            for(int i=0;i<M;i++){
                bw.write(arr[i]+" ");
            }
            bw.write("\n");
            return;
        }

        for(int i=1;i<=N;i++){
            if(K>0&&arr[K-1]>i)
                continue;
            arr[K] = i;
            func(K+1, N, M);
        }
    }
}
