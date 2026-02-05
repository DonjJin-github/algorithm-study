import java.util.*;

class Solution {
    static int[] distance;
    static boolean[] visit;
    
    static int comp(String a, String b){
        int count = 0;
        
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i))
                count++;
        }
        
        return count;
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        distance = new int[words.length];
        visit = new boolean[words.length];
        Arrays.fill(distance, -1);
        Queue<Integer> q = new ArrayDeque<>();
        
        int targetIdx=-1;
        for(int i=0; i<words.length; i++){
            if(comp(begin, words[i])==1){
                q.add(i);
                visit[i] = true;
                distance[i] = 1;
            }
            if(target.equals(words[i]))
                targetIdx= i;
        }
        
        if(targetIdx == -1)
            return answer;
        
        
        while(!q.isEmpty()){
            int cur = q.poll();
        
            for(int i=0; i < words.length; i++){
                if(visit[i])
                    continue;
                
                if(comp(words[cur], words[i]) == 1){
                    visit[i] = true;
                    distance[i] = distance[cur] + 1;
                    q.add(i);
                }
            }
        }
        
        if(distance[targetIdx] == -1)
            answer = 0;
        else
            answer = distance[targetIdx];
        
        return answer;
    }
}