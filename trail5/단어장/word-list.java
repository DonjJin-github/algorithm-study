import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> map = new TreeMap<>();

        for(int i=0;i<N;i++){
            String key = br.readLine();
            int count = map.getOrDefault(key, 0);

            map.put(key, count+1);
        }     

        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry<String, Integer> entry = it.next();
            bw.write(entry.getKey()+" "+entry.getValue()+"\n");
        }   
        bw.flush();
    }
}