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
        
        for(int i=0;i<M;i++){
            int target = Integer.parseInt(br.readLine());
            int left = 0;
            int right = N-1;

            while(left<=right && !(left<0 || right>=N)){
                int mid = (left+right)/2;

                if(arr[mid]<=target){
                    left = mid +1;
                }
                else{
                    right = mid-1;
                }
            }
            int ans = left;

            left = 0;
            right = N-1; 
            while(left<=right){
                int mid = (left+right)/2;

                if(arr[mid]<target){
                    left = mid +1;
                }
                else{
                    right = mid-1;
                }
            }
            ans = ans-left;        
            bw.write(ans+"\n");    
        }
        bw.flush();
    }
}