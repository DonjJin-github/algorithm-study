import java.util.*;

class Solution {
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static boolean[] visit;
    
    static class Node implements Comparable<Node>{
        int v;
        int cost;
        
        public Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node newNode){
            return Integer.compare(cost,newNode.cost);
        }
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        visit = new boolean[n];
        
        for(int i=0;i<costs.length;i++){
            graph.get(costs[i][0]).add(new int[]{costs[i][1],costs[i][2]});
            graph.get(costs[i][1]).add(new int[]{costs[i][0],costs[i][2]});
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        visit[0] = true;
        for(int[] temp : graph.get(0)){
            pq.add(new Node(temp[0],temp[1]));
        }
        
        while(!pq.isEmpty()){
            Node node = pq.poll();
            
            if(visit[node.v])
                continue;
            
            visit[node.v] = true;
            answer += node.cost;
            
            for(int[] next: graph.get(node.v)){
                if(visit[next[0]])
                    continue;
                
                pq.add(new Node(next[0],next[1]));
            }
        }
        
        return answer;
    }
}