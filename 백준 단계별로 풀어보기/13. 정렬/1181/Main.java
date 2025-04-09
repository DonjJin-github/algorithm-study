import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        for(int i=0;i<N;i++)
            str[i]=br.readLine();
        
        Arrays.sort(str,(a,b)->{
            if(a.length() ==b.length())
                return a.compareTo(b);
            return Integer.compare(a.length(), b.length());
        });

        for(int i=0;i<N;i++){
            if(i!=0&&str[i].equals(str[i-1]))
                continue;
            bw.write(str[i]+"\n");
        }
        
        bw.flush();
    }
}
