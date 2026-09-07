import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if(op.equals("add")){
                set.add(num);
            }
            else if(op.equals("remove")){
                set.remove(num);
            }
            else{
                if(set.contains(num))
                    bw.write("true\n");
                else
                    bw.write("false\n");
            }
        }
        bw.flush();
    }
}