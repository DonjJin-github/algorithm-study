import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int num;

        Node(int num){
            this.num = num;
        }

        @Override
        public int compareTo(Node newNode){
            return Integer.compare(num,newNode.num);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Please write your code here.
        PriorityQueue<Node> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            pq.add(new Node(arr[i]));
            if((i+1)%2 != 0){
                int size = pq.size()/2;
                ArrayList<Integer> list = new ArrayList<>();
                Node cur = null;
                for(int j=0;j<=size;j++){
                    cur = pq.poll();
                    list.add(cur.num);
                }
                sb.append(cur.num+" ");
                for(int j=0;j<list.size();j++){
                    pq.add(new Node(list.get(j)));
                }
            }
        }
        System.out.println(sb.toString());
    }
}