import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> treemap = new TreeMap<>();

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            if(op.equals("add")){
                int k = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                treemap.put(k,v);
            }
            else if(op.equals("remove")){
                int k = Integer.parseInt(st.nextToken());
                treemap.remove(k);
            }
            else if(op.equals("find")){
                int k = Integer.parseInt(st.nextToken());
                int find = treemap.getOrDefault(k, 0);
                if(find==0)
                    bw.write("None\n");
                else
                    bw.write(find+"\n");
            }
            else{
                if(treemap.size()==0){
                    bw.write("None\n");
                }
                else{
                    Iterator<Map.Entry<Integer, Integer>> it = treemap.entrySet().iterator();

                    while (it.hasNext()) {
                        Map.Entry<Integer, Integer> entry = it.next();
                        bw.write(entry.getValue()+" ");
                    }
                    bw.write("\n");
                }
            }
        }
        bw.flush();
    }
}