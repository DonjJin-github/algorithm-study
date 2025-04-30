import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int card[] = new int[N];
        HashSet<Integer> ans = new HashSet<Integer>();
        for(int i =0;i<N;i++){
            card[i] = Integer.parseInt(str[i]);
            ans.add(card[i]);
        }

        int M = Integer.parseInt(br.readLine());
        String[] str2 = br.readLine().split(" ");
        int cardcheck[] = new int[M];

        for(int i =0;i<M;i++){
            cardcheck[i] = Integer.parseInt(str2[i]);
            if(ans.contains(cardcheck[i])){
                bw.write("1 ");
            }
            else{
                bw.write("0 ");
            }
        }
        bw.write("\n");
        bw.flush();
    }
}
