import java.util.*;

class Solution {
    static final int INF = 20000000;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static int[] distance;
    
    public class Node implements Comparable<Node>{
        int v;
        int cost;
        
        public Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node newNode){
            return Integer.compare(cost, newNode.cost);
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        distance = new int[N+1];
        
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
            distance[i] = INF;
        }
        
        for(int i=0;i<road.length;i++){
            graph.get(road[i][0]).add(new int[]{road[i][1],road[i][2]});
            graph.get(road[i][1]).add(new int[]{road[i][0],road[i][2]});
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        distance[1] = 0;
        pq.add(new Node(1,0));
        
        while(!pq.isEmpty()){
            Node node = pq.poll();
            
            if(distance[node.v] != node.cost)
                continue;
            
            for(int[] next : graph.get(node.v)){
                int d = distance[node.v] + next[1];
                if(distance[next[0]]>d){
                    distance[next[0]] = d;
                    pq.add(new Node(next[0],d));
                }
            }
        }
        
        for(int i=1;i<=N;i++){
            if(distance[i]<=K)
                answer++;
        }

        return answer;
    }
}