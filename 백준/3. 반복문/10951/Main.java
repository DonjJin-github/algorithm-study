import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        while ((str = br.readLine())!=null) {
        	String[] nstr = str.split(" ");
        	
            int A = Integer.parseInt(nstr[0]);
            int B = Integer.parseInt(nstr[1]);

            bw.write(A+B+"\n");
        }

        bw.flush();
    }
}

