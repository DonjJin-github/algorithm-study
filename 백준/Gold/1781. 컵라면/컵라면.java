import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int deadLine;
        int ramen;

        Node(int deadLine, int ramen) {
            this.deadLine = deadLine;
            this.ramen = ramen;
        }

        @Override
        public int compareTo(Node newNode) {
            return Integer.compare(newNode.ramen, this.ramen);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken()); 
        }

           Arrays.sort(arr, (a, b) -> Integer.compare(b[0], a[0]));

           long ans = 0;
           int j = 0;
   
           for (int i = arr[0][0]; i > 0; i--) {
               while (j < N && arr[j][0] >= i) {
                   pq.add(new Node(arr[j][0], arr[j][1]));
                   j++;
               }
   
               if (!pq.isEmpty()) {
                   ans += pq.poll().ramen;
               }
           }
        bw.write(ans + "\n");
        bw.flush();
    }
}
