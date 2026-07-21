import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> m1 = new HashMap<>();
        HashMap<Integer, Integer> m2 = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[N];
        for(int i=0;i<N;i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] arr2 = new int[N];
        for(int i=0;i<N;i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] arr3 = new int[N];
        for(int i=0;i<N;i++){
            arr3[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] arr4 = new int[N];
        for(int i=0;i<N;i++){
            arr4[i] = Integer.parseInt(st.nextToken());
        }
        
        //A+B배열
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int x = arr2[j]+arr1[i];
                m1.put(x, m1.getOrDefault(x,0)+1);
            }
        }
        
        // C베열 + D배열      
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int x = arr4[j]+arr3[i];
                m2.put(x, m2.getOrDefault(x,0)+1);
            }
        }

        int answer = 0;
        for(int temp : m1.keySet()){
            int x = 0 - temp;

            answer += m1.get(temp) * m2.getOrDefault(x,0);
        }

        bw.write(answer+"\n");
        bw.flush();

    }
}