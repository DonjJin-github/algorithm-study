import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());      
        HashMap<String, Integer> map = new HashMap<>();  
        
        int ans = 0;
        for(int i=0;i<N;i++){
            String[] temp = br.readLine().split("");
            Arrays.sort(temp);

            StringBuilder sb = new StringBuilder();
            for(int j=0;j<temp.length;j++){
                sb.append(temp[j]);
            }
            String key = sb.toString();
            int value = map.getOrDefault(key,0)+1;
            map.put(key,value);

            ans = Math.max(ans,value);
        }

        bw.write(ans+"\n");
        bw.flush();
    }
}
