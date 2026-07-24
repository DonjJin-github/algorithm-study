import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        arr[0] = 0;
        for(int i=1;i<=N;i++){
            int x = Integer.parseInt(st.nextToken());
            arr[i] = arr[i-1] + x;
        }
        
        int ans = Integer.MIN_VALUE;
        for(int i=K-1;i<=N;i++){
            int a1 = arr[i];
            int a2;
            if(i-K>0)
                a2 = arr[i-K];
            else
                a2 = 0;
            
            ans = Math.max(ans, a1-a2);
        }

        bw.write(ans+"\n");
        bw.flush();
    }
}