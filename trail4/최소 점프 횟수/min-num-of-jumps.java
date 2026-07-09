import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int ans = Integer.MAX_VALUE;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        jump(0,0);
        if(ans == Integer.MAX_VALUE)
            bw.write(-1+"\n");
        else
            bw.write(ans + "\n");
        bw.flush();
    }
    static void jump(int idx, int count){
        if(idx >= N-1){
            if(idx == N-1)
                ans = Math.min(ans,count);
            return;
        }

        for(int i=1;i<=arr[idx];i++){
            int next = idx + i;
            count++;
            jump(next, count);
            count--;
        }
    }
}