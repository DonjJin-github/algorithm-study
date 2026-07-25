import java.util.*;
import java.io.*;

public class Main {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        p = new int[N+1];
        Arrays.fill(p, -1);
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            uni(u,v);
        }
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        boolean check = true;
        for(int i=1;i<K;i++){
            int v = Integer.parseInt(st.nextToken());
            if(find(u)!=find(v)){
                check = false;
                break;
            }
            u = v;
        }
        if(check)
            bw.write("1\n");
        else
            bw.write("0\n");
        bw.flush();
    }
    static int find(int x){
        if(p[x]<0)
            return x;
        return p[x] = find(p[x]);
    }
    static boolean uni(int u, int v){
        u = find(u);
        v = find(v);

        if(u == v)
            return false;
        if(p[v] < p[u]){
            int temp = u;
            u = v;
            v = temp;
        }
        if(p[u] == p[v])
            p[u]--;
        p[v] = u;
        return true;
    }
}