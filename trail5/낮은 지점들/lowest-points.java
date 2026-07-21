import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map =  new HashMap<>();
        
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int temp = map.getOrDefault(x, Integer.MIN_VALUE);
            if(temp == Integer.MIN_VALUE){
                map.put(x,y);
            }else{
                if(y>temp){
                    continue;
                }else{
                    map.put(x,y);
                }
            }
        }

        long ans = 0L;        
        for(int x : map.values()){
            ans += (long)x;
        }

        bw.write(ans+"\n");
        bw.flush();
    }
}