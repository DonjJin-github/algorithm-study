import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long S = Long.parseLong(br.readLine());

        long left = 1;
        long right = 2000000000L;
        long mid = 0;
        while(left<=right){
            mid = (right+left)/2;

            long sum = (mid*(mid+1))/2;

            if(sum<=S){
                left = mid +1;
            }
            else{
                right = mid-1;
            }
        }

        bw.write(left-1+"\n");
        bw.flush();
        
    }
}