import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        boolean[] visit = new boolean[N+11];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{N, 0});
        visit[N] = true;
        
        int ans = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            if(cur[0] == 1){
                ans = cur[1];
                break;
            }
            for(int i=1;i<=4;i++){
                int next = op(cur[0],i);

                if(next==cur[0] || next>=N+10)
                    continue;
                if(visit[next])
                    continue;
                visit[next] = true;
                q.add(new int[]{next, cur[1]+1});
            }
        }
        bw.write(ans+"\n");
        bw.flush();
    }
    static int op(int num, int i){
        if(i==1)
            num -= 1;
        else if(i==2)
            num += 1;
        else if(i==3 && num%2==0)
            num = num/2;
        else if(i==4 && num%3==0)
            num = num/3;
        
        return num;
    }
}