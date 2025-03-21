import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] count = new int[26];
        int ans = 1;
        int index =0;
        int x=0;

        String str = br.readLine();
        str = str.toLowerCase();
        String[] temp = str.split("");

        for(int i=0;i<str.length();i++){
            count[temp[i].charAt(0)-'a'] +=1;
        }

        for(int i=0;i<26;i++){
            if(ans <= count[i]){
               ans = count[i];   
               index =i;
            }
                 
                            
        }

        for(int i=0;i<26;i++){
            if(ans == count[i])
                x++; 
            if(x>=2)
                break;            
        }

        if(x >=2)
            bw.write("?\n");
        else
            bw.write((index+'A'));

        bw.flush();
    }

}
