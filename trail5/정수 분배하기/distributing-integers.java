import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int left = 1;
        int right = 100000;

        int ans = 0;

        while(left<=right){
            int mid = (left+right)/2;

            int sum = 0;
            for(int i=0;i<N;i++){
                sum += arr[i] / mid;
            }

            if(sum >= M){
                ans = Math.max(ans, mid);
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        bw.write(ans+"\n");
        bw.flush();
        
    }
}