import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split("");
        String ans = "None";
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0;i<str.length;i++){
            String key = str[i];
            int value = map.getOrDefault(key,0);
            map.put(key,value+1);
        }

        for(int i=0;i<str.length;i++){
            if(map.get(str[i])==1){
                ans = str[i];
                break;
            }
        }

        bw.write(ans);
        bw.flush();
    }
}