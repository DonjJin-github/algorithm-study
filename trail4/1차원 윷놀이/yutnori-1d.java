import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int K;
    static int[] arr;
    static int[] pin;
    static int ans =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        pin = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        count(0);
        bw.write(ans+"\n");
        bw.flush();
    }
    static void count(int idx){
        if(idx == N){
            int max = 0;
            for(int temp : pin){
                if(temp>=M-1)
                    max++;
            }
            ans = Math.max(ans,max);
            return;
        }
        
        for(int j=0; j<K; j++){
            pin[j] += arr[idx];
            count(idx+1);
            pin[j] -= arr[idx];
        }
    }
}