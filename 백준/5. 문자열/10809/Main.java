import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int[] loc = new int[26];

        for(int i=0;i<str.length();i++){
            int k = str.charAt(i)-97;
            if(loc[k]==0)
                loc[k]=i+1;
            else if(loc[k]<i+1)
                continue;
        }

        for(int i=0;i<26;i++)
            bw.write((loc[i]-1)+" ");


        bw.write("\n");
        bw.flush();
    }
}
