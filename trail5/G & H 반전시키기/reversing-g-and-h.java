import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] arr1 = br.readLine().split("");        
        String[] arr2 = br.readLine().split("");

        int ans = 0;
        int idx = 0;

        while(idx<N){
            if(arr1[idx].equals(arr2[idx])){
                idx++;
            }else{
                if(idx==0 || arr1[idx-1].equals(arr2[idx-1]))
                    ans++;
                idx++;
            }
        }
        
        bw.write(ans+"\n");
        bw.flush();
    }
}