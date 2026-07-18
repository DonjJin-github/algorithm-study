import java.util.*;
import java.io.*;

public class Main {
    static int ans = Integer.MAX_VALUE;
    static int N;
    static boolean[] visit;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N];

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
    static void choose(int cur, ArrayList<Integer> list){
        if(list.size() == N-1){
            int sum = arr[cur][0];
            
            if(sum == 0)
                return;

            for(int temp : list)
                sum+=temp;

            ans = Math.min(ans, sum);
            return;
        }

        for(int i=0;i<N;i++){
            if(visit[i] || arr[cur][i] == 0)
                continue;
            
            visit[cur] = true;
            list.add(arr[cur][i]);
            choose(i, list);
            list.remove(list.size()-1);
            visit[cur] = false;
        }
    }
}