import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        HashMap<Integer, String> numToName = new HashMap<>();
        HashMap<String, Integer> nameToNum = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            numToName.put(i, name);
            nameToNum.put(name, i);
        }

        for (int i = 0; i < M; i++) {
            String query = br.readLine();
            if (query.charAt(0) >= '0' && query.charAt(0) <= '9') {
                int number = Integer.parseInt(query);
                bw.write(numToName.get(number)+"\n");
            } else {
                bw.write(nameToNum.get(query)+"\n");
            }
        }
        bw.flush();
    }
}
