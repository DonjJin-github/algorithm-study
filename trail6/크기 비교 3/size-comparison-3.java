import java.util.*;
import java.io.*;

public class Main {
    static int[] indeg;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        indeg = new int[N+1];
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            indeg[v]++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=1;i<=N;i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            bw.write(cur+" ");

            for(int next : graph.get(cur)){
                indeg[next]--;
                if(indeg[next]==0){
                    q.add(next);
                }
            }
        }
        bw.flush();
    }
}
