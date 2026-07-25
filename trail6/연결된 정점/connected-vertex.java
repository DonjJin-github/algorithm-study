import java.util.*;
import java.io.*;

public class Main {
    static int[][] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        p = new int[N+1][2];
        for(int i=0;i<=N;i++){
            p[i][0] = -1;
            p[i][1] = 1;
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if(op.equals("x")){
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                uni(u,v);
            }else{
                int u = Integer.parseInt(st.nextToken());
                int root = find(u);
                bw.write(p[root][1]+"\n");
            }
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

        if(u==v)
            return false;
        
        if(p[v][0]<p[u][0]){
            int temp = u;
            u = v;
            v = temp;
        }
        if(p[v][0] == p[u][0])
            p[u][0]--;
        p[v][0] = u;
        p[u][1] = p[v][1] + p[u][1];
        return true;
    }
}