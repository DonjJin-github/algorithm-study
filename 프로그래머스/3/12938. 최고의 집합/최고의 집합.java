import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {};
        
        answer = new int[n];
        
        if(s/n == 0)
            return new int[]{-1};
        
        int a = s/n;
        int b = s%n;
        Arrays.fill(answer,a);
        
        int index = n-1;
        for(int i=0;i<b;i++){
            answer[index]++;
            index--;
        }
        
        return answer;
    }
}