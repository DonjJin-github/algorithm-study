import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashSet<String> member = new HashSet<>();
        
        int count = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.equals("ENTER")){
                member.clear();
            }
            else if(!member.contains(str)){
                member.add(str);
                count++;
            }
            
        }
        bw.write(count+"\n");
        bw.flush();
    }
}
