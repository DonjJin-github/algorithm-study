import java.util.*;
import java.io.*;

public class Main {
    static String[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        a = br.readLine().split("");
        String[] b = br.readLine().split("");

        int ans = 0;
        for(int i = N-1; i>=0; i--){
            if(!a[i].equals(b[i])){
                toggle(i);
                ans++;
            }
        }

        bw.write(ans+"\n");
        bw.flush();
        
    }
    static void toggle(int idx){
        for(int i=idx; i>=0; i--){
            if(a[i].equals("G"))
                a[i] = "H";
            else
                a[i] = "G";
        }
    }
}