import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());

        ArrayList<HashSet<Integer>> group = new ArrayList<>();     // 그룹 -> 아직 초대 안 된 멤버
        ArrayList<ArrayList<Integer>> belong = new ArrayList<>();  // 사람 -> 속한 그룹(역카운터)

        for(int i=0;i<G;i++){
            group.add(new HashSet<>());
        }
        for(int i=0;i<=N;i++){
            belong.add(new ArrayList<>());
        }

        for(int i=0;i<G;i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j=0;j<num;j++){
                int temp = Integer.parseInt(st.nextToken());
                group.get(i).add(temp);
                belong.get(temp).add(i);
            }
        }

        HashSet<Integer> ans = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();

        ans.add(1);
        queue.add(1);

        // 크기 1인 그룹은 처음부터 조건 만족
        for(int i=0;i<G;i++){
            if(group.get(i).size() == 1){
                int last = group.get(i).iterator().next();
                if(ans.add(last)) queue.add(last);
            }
        }

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int g : belong.get(cur)){
                group.get(g).remove(cur);
                if(group.get(g).size() == 1){
                    int last = group.get(g).iterator().next();
                    if(ans.add(last)) queue.add(last);
                }
            }
        }

        bw.write(ans.size()+"\n");
        bw.flush();
    }
}