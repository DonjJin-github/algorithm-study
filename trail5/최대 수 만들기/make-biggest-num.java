import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, (a,b)->{
            StringBuilder sb = new StringBuilder();
            String x = sb.append(a).append(b).toString();

            sb = new StringBuilder();
            String y = sb.append(b).append(a).toString();

            return y.compareTo(x);
        });
        
        for(int i=0;i<N;i++){
            bw.write(arr[i]+"");
        }

        bw.flush();
        
    }
}