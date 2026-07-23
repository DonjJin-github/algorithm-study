import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split("");
        String[] b = br.readLine().split("");

        int ans = 0;
        int count = 0;
        int idx = 0;
        while(idx<N){
            if(a[idx].equals(b[idx])){
                idx++;
                continue;
            }
            for(int j=idx;j<N;j++){
                if(a[j].equals(b[j]) && a[idx]!=a[j]){
                    idx = j;
                    break;
                }
            }
            ans++;
        }
        bw.write(ans+"\n");
        bw.flush();
        
    }
}