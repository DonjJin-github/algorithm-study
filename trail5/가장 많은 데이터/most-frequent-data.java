import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            String key = br.readLine();
            map.put(key, map.getOrDefault(key,0)+1);
        }        

        int ans = 0;
        for(int num : map.values()){
            ans = Math.max(ans, num);
        }

        bw.write(ans+"\n");
        bw.flush();
    }
}