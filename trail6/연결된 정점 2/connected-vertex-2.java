import java.util.*;
import java.io.*;

public class Main {
    static int[][] p = new int[100001][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<100001;i++){
            p[i][0] = -1;
            p[i][1] = 1;
        }
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            uni(u,v);
            bw.write(p[find(u)][1]+"\n");
        }
        bw.flush();
    }
    static int find(int x){
        if(p[x][0]<0)
            return x;
        int root = find(p[x][0]);
        p[x][0] = root;
        p[x][1] = p[root][1];
        return root;
    }

    static boolean uni(int u, int v){
        u = find(u);
        v = find(v);

        if(u==v){
            return false;
        }

        if(p[v][0]<p[u][0]){
            int temp = p[u][0];
            p[u][0] = p[v][0];
            p[v][0]  = temp;
        }

        if(p[u][0] == p[v][0])
            p[u][0]--;
        
        p[v][0] = u;
        p[u][1] += p[v][1];

        return true;
    }
}
