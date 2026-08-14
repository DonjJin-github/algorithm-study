import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] indeg;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        indeg = new int[n+1];
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            indeg[v]++;
        }

        Queue<Integer> q = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int cur = q.poll();
            list.add(cur);

            for(int next : graph.get(cur)){
                indeg[next]--;
                if(indeg[next] == 0){
                    q.add(next);
                }
            }
        }

        if(list.size()!=n)
            bw.write(-1+"\n");
        else{
            for(int print : list)
                bw.write(print+" ");
        }
        bw.flush();
    }
}