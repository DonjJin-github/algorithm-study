import java.util.*;
import java.io.*;

public class Main {
    static int p[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        p = new int[N+1];
        Arrays.fill(p,-1);

        for(int i=0;i<N-2;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            uni(u,v);
        }
        for(int i=1;i<=N;i++){
            if(p[i]<0)
                bw.write(i+" ");
        }
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
        
        if(v<u){
            int temp = u;
            u = v;
            v = temp;
        }
        p[v] = u;
        return true;            
    }
}