import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int count = 0;

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        HashSet<String> list = new HashSet<>();
        HashSet<String> list2 = new HashSet<>();

        for(int i =0;i<N;i++){
            list.add(br.readLine());
        }
        for(int i=0;i<M;i++){
            String temp = br.readLine();
            if(list.contains(temp)){
                list2.add(temp);
                count++;
            }
        }
        String[] arr = new String[list2.size()];
        int j=0;
        for (String string : list2) {
            arr[j] = string;
            j++;
        }
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]+"\n");
        }
        bw.write(count+"\n"+sb);
        bw.flush();
    }
}
