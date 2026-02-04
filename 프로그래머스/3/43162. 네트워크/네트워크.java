import java.util.*;

class Solution {
    static boolean[] visit;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        Queue<Integer> q = new ArrayDeque<>();
        visit = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(visit[i])
                continue;
            
            q.add(i);
            visit[i] = true;
            answer++;
            
            while(!q.isEmpty()){
                int cur = q.poll();
                
                int idx = 0;
                for(int next : computers[cur]){
                    if(!visit[idx] && next != 0){
                        visit[idx] = true;
                        q.add(idx);
                    }
                    idx++;
                }
            }
        }
        
        return answer;
    }
}