import java.util.*;

class Solution {
    static final int INF = 200000;
    static int[] distance;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    
    static class Node implements Comparable<Node>{
        int v;
        int cost;
        
        public Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node newNode){
            return Integer.compare(this.cost, newNode.cost);
        }
    }
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        distance = new int[n+1];
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
            distance[i] = INF;
        }
        
        for(int i=0;i<roads.length;i++){
            int u = roads[i][0];
            int v = roads[i][1];
            
            graph.get(u).add(new int[]{v,1});
            graph.get(v).add(new int[]{u,1});
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        distance[destination] = 0;
        pq.add(new Node(destination,0));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(distance[cur.v] != cur.cost)
                continue;
            
            for(int[] next : graph.get(cur.v)){
                int d = next[1] + cur.cost;
                if(distance[next[0]]>d){
                    distance[next[0]] = d;
                    pq.add(new Node(next[0],d));
                }
            }
        }
        
        int[] answer = new int[sources.length];
        for(int i=0;i<sources.length;i++){
            if(distance[sources[i]]==INF)
                answer[i] = -1;
            else
                answer[i] = distance[sources[i]];
        }
        
        
        
        return answer;
    }
}