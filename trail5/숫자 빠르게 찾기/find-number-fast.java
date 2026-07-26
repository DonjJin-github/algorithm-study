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
            int mid = 0;
            while(left<=right){
                mid = (left+right)/2;
                if(target == arr[mid])
                    break;
                if(target>arr[mid]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
            if(target == arr[mid])
                bw.write(mid+1+"\n");
            else
                bw.write("-1\n");
        }
        bw.flush();
    }
}