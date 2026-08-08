import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int ans = upper(end)-lower(start);
            bw.write(ans+"\n");
        }

        bw.flush();
    }
    static int lower(int target){
        int left = 0;
        int right = N-1;

        while(left<=right){
            int mid = (left+right)/2;

            if(target>arr[mid]){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return left;
    }
    static int upper(int target){
        int left = 0;
        int right = N-1;

        while(left<=right){
            int mid = (left+right)/2;

            if(target>=arr[mid]){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return left;
    }
}