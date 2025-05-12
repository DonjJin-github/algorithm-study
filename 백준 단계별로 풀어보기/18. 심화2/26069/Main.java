import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashSet<String> dance = new HashSet<>();
        dance.add("ChongChong");

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String person1 = st.nextToken();
            String person2 = st.nextToken();
            
            if(dance.contains(person1)){
                dance.add(person2);
            }
            else if(dance.contains(person2)){
                dance.add(person1);
            }
        }

        bw.write(dance.size()+"\n");
        bw.flush();
    }
}
