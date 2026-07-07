import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int ordinal;
    static int count = Integer.MAX_VALUE;
    static int[] ans;
    static int[] check;
    static ArrayList<int[]> line = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ans = new int[N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ordinal = Math.max(ordinal,b);
            line.add(new int[]{a,b});
        }
        Collections.sort(line, (a,b)->{
            return Integer.compare(a[1],b[1]);
        });

        original();
        countMin(0, new ArrayList<>());
        bw.write(count+"\n");
            bw.flush();
    }
    static void countMin(int idx, ArrayList<int[]> curLine){
        if(idx == line.size()){
            check = new int[N+1];
            minLine(curLine);
            if(Arrays.equals(ans, check))
                count = Math.min(count, curLine.size());
            return;
        }
        int a = line.get(idx)[0];
        int b = line.get(idx)[1];

        curLine.add(new int[]{a,b});
        countMin(idx+1, curLine);
        curLine.remove(curLine.size()-1);

        countMin(idx+1, curLine);
    }
    static void minLine(ArrayList<int[]> lines){
        for(int i=1;i<=N;i++){
            int depth = 1;
            int cur = i;
            while(true){
                int idx = findLine(cur, depth, lines);
                if(idx ==-1){
                    break;
                }
                int[] temp = lines.get(idx);
                if(temp[0] == cur)
                    cur = temp[0]+1;
                else if(temp[0] + 1 == cur)
                    cur = temp[0];
                depth = temp[1]+1;
            }
            check[cur] = i;
        }
    }
    static void original(){
        for(int i=1;i<=N;i++){
            int depth = 1;
            int cur = i;
            while(true){
                int idx = findLine(cur, depth, line);
                if(idx ==-1){
                    break;
                }
                int[] temp = line.get(idx);
                if(temp[0] == cur)
                    cur = temp[0]+1;
                else if(temp[0] + 1 == cur)
                    cur = temp[0];
                depth = temp[1]+1;
            }
            ans[cur] = i;
        }
    }
    static int findLine(int a, int b, ArrayList<int[]> lines){
        int i = 0;
        for(int[] temp : lines){
            if(temp[1] >= b){
                if(temp[0] == a || temp[0] + 1 == a)
                    return i;
            }
            i++;
        }
        return -1;
    }
}