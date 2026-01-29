import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] indeg;
    static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        indeg = new int[N+1];
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            graph.get(first).add(second);
            indeg[second]++;
        }

        for(int i=1;i<=N;i++){
            if(indeg[i]==0)
                queue.add(i);
        }

        while(!queue.isEmpty()){
            int ans = queue.poll();

            for(int temp : graph.get(ans)){
                indeg[temp]--;
                if(indeg[temp]==0){
                    queue.add(temp);
                }
            }
            bw.write(ans+" ");
        }

        bw.write("\n");
        bw.flush();
    }
}
