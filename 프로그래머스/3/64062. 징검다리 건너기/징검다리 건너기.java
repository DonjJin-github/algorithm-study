import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;

        int start = 1;
        int end = 200000000;
        int mid = 0;
        
        while(start <= end){
            mid = (start+end) / 2;
            int count  = 0;
            int check = 0;
            
            for(int i=0;i<stones.length;i++){
                if(stones[i]<mid)
                    count++;
                else{
                    count = 0;
                }
                check = Math.max(count,check);
            }
            
            if(check<k)
                start = mid+1;
            else
                end = mid-1;
        }
        answer = end;
        
        return answer;
    }
}