import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();

        for(int i=1;i<=N;i++){
            String key = br.readLine();
            map1.put(key, String.valueOf(i));
            map2.put(String.valueOf(i), key);
        }

        for(int i=0;i<M;i++){
            String key = br.readLine();
            String temp  = map1.getOrDefault(key, "0");
            if(temp.equals("0")){
                bw.write(map2.get(key)+"\n");
            }else{
                bw.write(temp+"\n");
            }
        }

        bw.flush();
    }
}
