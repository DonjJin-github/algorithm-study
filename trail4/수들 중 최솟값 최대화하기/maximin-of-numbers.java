import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static boolean[] visit;
    static int[][] arr;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        visit = new boolean[N];
        arr = new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        choose(0, new ArrayList<>());
        bw.write(ans+"\n");
        bw.flush();
    }
    static void choose(int x, ArrayList<Integer> list){
        if(list.size() == N){
            int min = Integer.MAX_VALUE;
            for(int temp : list)
                min = Math.min(min, temp);
            ans = Math.max(ans, min);
            return;
        }

        for(int i=x;i<N;i++){
            for(int j=0;j<N;j++){
                if(visit[j])
                    continue;
                visit[j] = true;
                list.add(arr[i][j]);
                choose(i+1, list);
                visit[j] = false;
                list.remove(list.size()-1);
            }
        }
    }

}
