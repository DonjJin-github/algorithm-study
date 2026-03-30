import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int start = 0;
        int end = 0;
        double x = w+w+1;
        
        for(int i=0;i<stations.length;i++){
            int temp = stations[i] - w - start - 1;
            end = stations[i] + w -1;
            
            start = end + 1;
            
            if(temp%x==0)
                answer +=temp/x;
            else
                answer += temp/x + 1;
        }
        
        if(end != n){
            if((n-end-1)%x == 0)
                answer += (n-end-1)/x;
            else
                answer += (n-end-1)/x + 1;
        }
                
        return answer;
    }
}