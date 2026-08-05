import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());
        
        long left = 1L;
        long right = Long.MAX_VALUE/2 - 1;

        while(left<=right){
            long mid = (left + right) / 2;

            long check = mid/3;
            check += mid/5;
            check -= mid/15;
            check = mid - check;

            if(check<N){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        bw.write(left+"\n");
        bw.flush();
    }
}