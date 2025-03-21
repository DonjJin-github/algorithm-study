import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int length = str.length;
        
        if(length==0)
            bw.write(length+"\n");
        else{
            if(str[0].equals(""))
                bw.write((length-1)+"\n");
            else if(str[length-1].equals(""))
                bw.write((length-1)+"\n");
            else
                bw.write(length+"\n");
        }
        bw.flush();
    }
}
