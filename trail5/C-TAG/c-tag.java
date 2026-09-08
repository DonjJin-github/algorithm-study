import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static String[] A;
    static String[] B;
    static HashSet<String> ans = new HashSet<>();
    static HashSet<String> check = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new String[N];
        B = new String[N];

        for(int i=0;i<N;i++){
            A[i] = br.readLine();
        }

        for(int i=0;i<N;i++){
            B[i] = br.readLine();
        }
        dfs(0, new ArrayList<>());

        bw.write(ans.size()+"\n");
        bw.flush();
    }
    static void dfs(int idx, ArrayList<Integer> list){
        if(list.size()==3){
            int count = 0;
            check = new HashSet<>();
            check(list);
            for(int i=0;i<N;i++){
                StringBuilder sb = new StringBuilder();
                for(int temp : list){
                    sb.append(A[i].charAt(temp));
                }
                if(!check.contains(sb.toString())){
                    count++;
                }
            }
            if(count==N){
                StringBuilder sb = new StringBuilder();
                for(int temp : list){
                    sb.append(temp);
                }
                ans.add(sb.toString());
            }
            return;
        }

        for (int i = idx; i < M; i++) {
            list.add(i);
            dfs(i + 1, list);
            list.remove(list.size() - 1);
        }
    }
    static void check(ArrayList<Integer> list){
        for(int i=0;i<N;i++){
            StringBuilder sb = new StringBuilder();
            for(int temp : list){
                sb.append(B[i].charAt(temp));
            }
            check.add(sb.toString());
        }
    }
}