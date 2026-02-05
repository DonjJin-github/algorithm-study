import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a,b)->{
            return Integer.compare(a[1],b[1]);
        });
    
        
        int pastStart = routes[0][0];
        int pastEnd = routes[0][1];
        
        int check = routes[0][1];
        answer++;
        
        for(int i=1;i<routes.length;i++){
            int start = routes[i][0];
            int end = routes[i][1];
        
            if(pastEnd >= start){
                if(check < start){
                    check = end;
                    answer++;
                }
            }
            else{
                if(check<start){
                    check = end;
                    answer++;
                }
            }
        }
        
        return answer;
    }
}