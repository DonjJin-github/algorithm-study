import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if(op.equals("add")){
                int k = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                map.put(k, v);
            }else if(op.equals("find")){
                int k = Integer.parseInt(st.nextToken());
                int temp  = map.getOrDefault(k,0);
                if(temp == 0)
                    bw.write("None\n");
                else
                    bw.write(temp+"\n");
            }else{
                int k = Integer.parseInt(st.nextToken());
                map.remove(k);
            }
        }

        bw.flush();
    }
}