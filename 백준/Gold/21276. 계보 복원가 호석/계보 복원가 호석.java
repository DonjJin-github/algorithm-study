import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static ArrayList<PriorityQueue<String>> childGraph = new ArrayList<>();
    static Map<String, Integer> map = new HashMap<>();
    static Map<String, Integer> ans = new HashMap<>();

    static int[] indeg;
    static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<String> pqTemp = new ArrayList<>();
        PriorityQueue<String> pq = new PriorityQueue<>();
        PriorityQueue<String> printName = new PriorityQueue<>();

        indeg = new int[N];
        String[] names = new String[N];

        for (int i = 0; i < N; i++) {
            String temp = st.nextToken();
            graph.add(new ArrayList<>());
            childGraph.add(new PriorityQueue<>());

            printName.add(temp);
            names[i] = temp;
            map.put(temp, i);
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String second = st.nextToken();
            String first = st.nextToken();

            graph.get(map.get(first)).add(map.get(second));
            indeg[map.get(second)]++;
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            if (indeg[i] == 0) {
                pq.add(names[i]);
                count++;
            }
        }

        bw.write(count + "\n");
        while(!pq.isEmpty()) {
            String string = pq.poll();
            pqTemp.add(string);
            bw.write(string + " ");
            
        }
        bw.write("\n");

        for (String temp : pqTemp) {
            Queue<Integer> queue = new ArrayDeque<>();

            queue.add(map.get(temp));

            while (!queue.isEmpty()) {
                int rootInt = queue.poll();
                int childCount = 0;

                for (int child : graph.get(rootInt)) {
                    indeg[child]--;
                    if (indeg[child] == 0) {
                        childCount++;
                        queue.add(child);
                        childGraph.get(rootInt).add(names[child]);
                    }
                }

                ans.put(names[rootInt], childCount);
            }
        }

        while (!printName.isEmpty()) {
            String string = printName.poll();
            bw.write(string + " " + ans.get(string) + " ");

            while(!childGraph.get(map.get(string)).isEmpty()) {
                bw.write(childGraph.get(map.get(string)).poll() + " ");

            }
            bw.write("\n");
        }

        bw.flush();
    }
}
