import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> list = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int temp = Integer.parseInt(st.nextToken());

            if(list.contains(temp)){
                bw.write("1\n");
            }
            else
                bw.write("0\n");
        }

        bw.flush();

    }
}

