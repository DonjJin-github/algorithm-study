import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int x = Integer.parseInt(st.nextToken());
            map.put(x, map.getOrDefault(x,0)+1);
        }


        ArrayList<int[]> list = new ArrayList<>();
        for(int temp : map.keySet()){
            list.add(new int[]{temp, map.get(temp)});
        }

        Collections.sort(list, (a,b)->{
            if(b[1]==a[1])
                return Integer.compare(b[0], a[0]);
            return Integer.compare(b[1], a[1]);
        });

        int idx = 0;
        while(idx < K){
            bw.write(list.get(idx)[0]+" ");
            idx++;
        }

        bw.flush();
    }
}