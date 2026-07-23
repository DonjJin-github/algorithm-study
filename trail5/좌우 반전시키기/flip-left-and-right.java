import java.util.*;
import java.io.*;

public class Main {
    static int N;
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

        int ans = 0;
        for(int i=1;i<N;i++){
            if(arr[i-1]==0){
                toggle(i);
                ans++;
            }
        }
        if(arr[N-1]==1)
            bw.write(ans+"\n");
        else
            bw.write("-1\n");
        bw.flush();
    }

    static void toggle(int idx){
        for(int i=idx-1;i<idx+2;i++){
            if(i>=N)
                break;
            if(arr[i] == 0)
                arr[i] = 1;
            else
                arr[i] = 0;
        }
    }
}