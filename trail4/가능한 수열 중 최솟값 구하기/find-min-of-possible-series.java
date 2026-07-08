import java.util.*;
import java.io.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        findNum(new ArrayList<>());
    }
    static void findNum(ArrayList<Integer> list){
        if(list.size() == N){
            StringBuilder sb = new StringBuilder();
            for(int temp : list)
                sb.append(temp);
            System.out.println(sb);
            System.exit(0);
            return;
        }

        for(int i=4;i<=6;i++){
            int size = list.size();

            if(isBad(list, i))
                continue;
            
            list.add(i);
            findNum(list);
            list.remove(list.size()-1);
        }
    }
    static boolean isBad(ArrayList<Integer> list, int next) {
        list.add(next);

        int size = list.size();

        for (int len = 1; len <= size / 2; len++) {
            boolean same = true;

            for (int i = 0; i < len; i++) {
                if (list.get(size - 2 * len + i) != list.get(size - len + i)) {
                    same = false;
                    break;
                }
            }

            if (same) {
                list.remove(size - 1);
                return true;
            }
        }

        list.remove(size - 1);
        return false;
    }
}