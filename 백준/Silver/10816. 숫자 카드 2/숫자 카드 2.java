import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] strcard = br.readLine().split(" ");
        HashMap<Integer, Integer> list = new HashMap<>();

        int M = Integer.parseInt(br.readLine());
        String[] strcheck = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            list.put(Integer.parseInt(strcard[i]), list.getOrDefault(Integer.parseInt(strcard[i]), 0) + 1);
        }
        for (int i = 0; i < M; i++) {
            if (list.get(Integer.parseInt(strcheck[i])) == null)
                bw.write("0 ");
            else
                bw.write(list.get(Integer.parseInt(strcheck[i])) + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
