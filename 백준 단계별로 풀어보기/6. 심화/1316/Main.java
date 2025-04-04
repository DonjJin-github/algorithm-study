import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        int count =N;
        

        for(int i=0;i<N;i++){
            str[i] = br.readLine();
            int[] alp = new int[26];
            Arrays.fill(alp,200);
            String[] str2 = str[i].split("");

            for(int j=0;j<str[i].length();j++){
                if(alp[str2[j].charAt(0)-'a']!=200){
                    if(alp[str2[j].charAt(0)-'a']==j-1){
                        alp[str2[j].charAt(0)-'a']=j;
                        continue;
                    }
                    else{
                        count--;
                        break;
                    }
                }
                else if(alp[str2[j].charAt(0)-'a']==200)
                    alp[str2[j].charAt(0)-'a'] = j;
                
            }
        }

        bw.write(count+"\n");
        bw.flush();

    }
}
