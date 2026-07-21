import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split("");
        String ans = "None";
        HashMap<String, int[]> map = new HashMap<>();

        for(int i=0;i<str.length;i++){
            String key = str[i];
            int[] value = map.getOrDefault(key,new int[]{i,0});
            map.put(key,new int[]{i, value[1]+1});
        }

        ArrayList<int[]> list = new ArrayList<>();
        for(String key : map.keySet()){
            int cur[] = map.get(key);
            list.add(new int[]{cur[0], cur[1]});
        }

        Collections.sort(list,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        for(int i=0;i<list.size();i++){
            int cur[] = list.get(i);
            if(cur[1]==1){
                ans = str[cur[0]];
                break;
            }
        }

        bw.write(ans);
        bw.flush();
    }
}