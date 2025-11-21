import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] arrA = new int[A];
        int[] arrB = new int[B];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++)
            arrA[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++)
            arrB[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0;i<A;i++){
            int temp = Arrays.binarySearch(arrB, arrA[i]);
            if(temp<0){
                ans.add(arrA[i]);
            }
        }

        bw.write(ans.size()+"\n");
        for(Integer result : ans){
            bw.write(result+" ");
        }

        bw.flush();

    }
}
