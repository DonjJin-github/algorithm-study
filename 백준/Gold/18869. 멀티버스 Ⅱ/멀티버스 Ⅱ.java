import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        List<List<Integer>> arr = new ArrayList<>();
        List<List<Integer>> copyArr = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new ArrayList<>());
            copyArr.add(new ArrayList<>());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                arr.get(i).add(temp);
                copyArr.get(i).add(temp);
            }
        }

        for (int i = 0; i < M; i++) {
            Collections.sort(copyArr.get(i));
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int temp = arr.get(i).get(j);
                int newTemp = Collections.binarySearch(copyArr.get(i), temp) + 1;

                arr.get(i).set(j, newTemp);
            }
        }

        int i=0;
        int j=1;
        int ans = 0;

        while (i<M && j<M) {
            if(arr.get(i).equals(arr.get(j))){
                ans++;
            }

            if(j==M-1){
                i++;
                j = i+1;
            }else{
                j++;
            }
        }

        bw.write(ans+"\n");
        bw.flush();

    }
}
