import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int arr[];
    static boolean isused[];
    static int ans[];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        isused = new boolean[N];
        ans = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        func(0, N, M);
        bw.flush();
        
    }
    
    static void func(int K,int N, int M)throws IOException{
        if (K == M) {
            for(int i=0;i<M;i++)
                bw.write(ans[i]+" ");
            bw.write("\n");
            return;
        }

        for(int i=0;i<N;i++){
            if(!isused[i]){
                ans[K] = arr[i];
                isused[i] = true;
                func(K+1, N, M);
                isused[i] = false;
            }
        }

    }
}
