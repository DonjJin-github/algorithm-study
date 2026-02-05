import java.util.*;

class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    
    public long solution(int n, int[] works) {
        long answer = 0;
        
        for(int i=0;i<works.length;i++){
            pq.add(works[i]);
        }
        
        for(int i=0;i<n;i++){
            int temp = pq.poll()-1;
            
            pq.add(temp);
        }
        
        while(!pq.isEmpty()){
            int temp = pq.poll();
            if(temp<0)
                continue;
            answer += Math.pow(temp,2);
        }
        
        return answer;
    }
}