import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            TreeSet<Integer> set = new TreeSet<>();
            int K = Integer.parseInt(br.readLine());
            for(int j=0;j<K;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int num = 0;
                int d = 0;
                switch(op){
                    case "I" : 
                        num = Integer.parseInt(st.nextToken());
                        set.add(num);
                        break;
                    case "D" :
                        d = Integer.parseInt(st.nextToken());
                        if(set.isEmpty()){
                            break;
                        }
                        if(d==1){
                            int temp = set.last();
                            set.remove(temp);
                        }else{
                            int temp = set.first();
                            set.remove(temp);
                        }
                        break;
                    default:
                        break;
                }
            }
            if(set.isEmpty()){
                bw.write("EMPTY\n");
            }
            else{
                bw.write(set.last()+" "+set.first()+"\n");
            }
        }
        bw.flush();    
    }
}