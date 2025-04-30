import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashSet<String> remain = new HashSet<String>();

        for(int i = 0;i<N;i++){
            String[] str = br.readLine().split(" ");
            if(str[1].equals("enter"))
                remain.add(str[0]);
            else if(remain.contains(str[0])&&str[1].equals("leave"))
                remain.remove(str[0]);
            
        }
        String[] ans = new String[remain.size()];
        int k=0;
        for (String temp : remain) {
            ans[k] = temp;
            k++;
        }
        Arrays.sort(ans,Collections.reverseOrder());
        for(int i=0;i<ans.length;i++){
            bw.write(ans[i]+"\n");
        }
        bw.flush();
    }
}
