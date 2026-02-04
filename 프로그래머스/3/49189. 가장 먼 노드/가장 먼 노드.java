import java.util.*;

class Solution {
    static final int INF = 200000;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static int[] distance;
    
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
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        distance = new int[n+1];
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
            distance[i] = INF;
        }
        
        for(int i=0;i<edge.length;i++){
            graph.get(edge[i][0]).add(new int[]{edge[i][1],1});
            graph.get(edge[i][1]).add(new int[]{edge[i][0],1});
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[1] = 0;
        pq.add(new Node(1,0));
        
        int max =0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            
            if(node.cost != distance[node.v])
                continue;
            
            for(int[] next : graph.get(node.v)){
                int d = distance[node.v] + next[1];
                if(distance[next[0]]>d){
                    distance[next[0]]=d;
                    max = Math.max(d,max);
                    pq.add(new Node(next[0],d));
                }
            }
        }

        for(int i=n;i>0;i--){
            if(distance[i] == max)
                answer++;
        }
        
        return answer;
    }
}