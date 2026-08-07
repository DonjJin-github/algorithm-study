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
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int target = Integer.parseInt(st.nextToken());
            int left = 0;
            int right = N-1;

            int ans = -1;
            while(left<=right){
                int mid = (left+right)/2;

                if(arr[mid] == target){
                    ans = mid+1;
                }
                if(target>arr[mid]){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
            bw.write(ans+"\n");
        }
        bw.flush();
    }
}