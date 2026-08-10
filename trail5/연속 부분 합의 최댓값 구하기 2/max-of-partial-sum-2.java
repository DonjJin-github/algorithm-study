import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int temp = 0;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            temp += arr[i];
            ans = Math.max(ans,temp);
            if(temp<0){
                temp = 0;
            }
        }
        bw.write(ans+"\n");
        bw.flush();
    }
}