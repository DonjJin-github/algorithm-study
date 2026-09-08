import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int num = 0;

            switch(op){
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    set.add(num);
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    set.remove(num);
                    break;
                case "find":
                    num = Integer.parseInt(st.nextToken());
                    if(set.contains(num))
                        bw.write("true\n");
                    else
                        bw.write("false\n");
                    break;
                case "lower_bound":
                    num = Integer.parseInt(st.nextToken());
                    if(set.ceiling(num)==null)
                        bw.write("None\n");
                    else
                        bw.write(set.ceiling(num)+"\n");
                    break;
                case "upper_bound":
                    num = Integer.parseInt(st.nextToken());
                    if(set.higher(num)==null)
                        bw.write("None\n");
                    else                    
                        bw.write(set.higher(num)+"\n");
                    break;
                case "largest":
                    if(set.isEmpty())
                        bw.write("None\n");
                    else
                        bw.write(set.last()+"\n");
                    break;
                case "smallest":
                    if(set.isEmpty())
                        bw.write("None\n");
                    else
                        bw.write(set.first()+"\n");
                    break;
                default : 
                    break;
            }
        }
        bw.flush();
    }
}