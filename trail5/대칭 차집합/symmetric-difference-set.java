import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int NA = Integer.parseInt(st.nextToken());
        int NB = Integer.parseInt(st.nextToken());

        HashSet<Integer> setA = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<NA;i++){
            setA.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());

        int count = 0;
        for(int i=0;i<NB;i++){
            int num = Integer.parseInt(st.nextToken());

            if(setA.contains(num)){
                count++;
            }
        }

        bw.write(NA+NB-(count*2)+"\n");
        bw.flush();
    }
}