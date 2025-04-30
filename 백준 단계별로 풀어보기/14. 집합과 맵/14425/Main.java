import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int count = 0;
        String[] str = new String[N];
        String[] checkstr = new String[M];

        HashSet <String> ans = new HashSet<>();
        
        for(int i=0;i<N;i++){
            str[i] = br.readLine();
            ans.add(str[i]);
        }

        for(int i=0;i<M;i++){
            checkstr[i] = br.readLine();
            if(ans.contains(checkstr[i])){
                count++;
            }
        }
        bw.write(count+"\n");
        bw.flush();
    }
}
