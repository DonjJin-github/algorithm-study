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
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
        }
        int ans = 0;
        for(int i=N;i>=0;i--){
            for(int j=0;j<=i;j++){
                if(arr[i]-arr[j] == K)
                    ans++;
            }
        }
        bw.write(ans+"\n");
        bw.flush();
    }
}