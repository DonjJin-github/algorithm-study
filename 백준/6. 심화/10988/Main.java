import java.io.*;

public class Main {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str1 = br.readLine().split("");
        String[] str2 = new String[str1.length];
        int temp = str1.length-1;
        int ans = 1;
        for(int i=0;i<str1.length;i++){
            str2[i]=str1[temp];
            temp--;
        }

        for(int i=0;i<str1.length;i++){
            if(str1[i].equals(str2[i]))
                continue;
            else{
                ans = 0;
                break; 
            }
        }
        bw.write(ans+"\n");
        bw.flush();
            

    }
}
