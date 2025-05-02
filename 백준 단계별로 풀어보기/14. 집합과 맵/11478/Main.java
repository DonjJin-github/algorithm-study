import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        HashSet<String> list = new HashSet<>();

        for(int i=0;i<str.length();i++){
            for(int j=0;j<str.length();j++){
                if(j+i<=str.length())
                    list.add(str.substring(j,j+i));
            }
        }
        bw.write(list.size()+"\n");
        bw.flush();
    }
}
