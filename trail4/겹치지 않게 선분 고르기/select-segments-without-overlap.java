import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<int[]> list = new ArrayList<>();
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            list.add(new int[]{l,r});
        }
        backtracking(0, new ArrayList<>());

        bw.write(max+"\n");
        bw.flush();
    }
    static void backtracking(int start, ArrayList<int[]> selected) {

        max = Math.max(max, selected.size());

        for (int i = start; i < list.size(); i++) {

            int[] cur = list.get(i);
            int l = cur[0];
            int r = cur[1];

            boolean flag = true;

            for (int[] s : selected) {
                int sl = s[0];
                int sr = s[1];

                if (!(r < sl || sr < l)) {
                    flag = false;
                    break;
                }
            }

            if (!flag) continue;

            selected.add(cur);
            backtracking(i + 1, selected);
            selected.remove(selected.size() - 1);
        }
    }
}
