import java.util.*;

class Solution {

    static PriorityQueue<Integer> min = new PriorityQueue<>();
    static PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        int count = 0;
        
        for (int i = 0; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);

            String op = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if(op.equals("I")){
                min.add(num);
                max.add(num);
                count++;
            }
            else{
                if(num == 1 && !max.isEmpty()){
                    if(min.contains(max.peek()))
                        max.poll();
                    else
                        min.poll();
                }
                else if(num == -1 && !min.isEmpty()){
                    if(max.contains(min.peek()))
                        min.poll();
                    else
                        max.poll();
                }
            }
        }
        
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        while(!max.isEmpty()){
            set.add(max.poll());
        }
        
        while(!min.isEmpty()){
            int temp = min.poll();
            
            if(set.contains(temp)){
                list.add(temp);
                continue;
            }
        }
        
        Collections.sort(list);
        if(list.size()!=0)
            answer = new int[]{list.get(list.size()-1), list.get(0)};
        
        
        return answer;
    }
}
