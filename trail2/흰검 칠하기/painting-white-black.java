import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        // Please write your code here.
        ArrayList<int[]> route  = new ArrayList<>();
        for(int i=0;i<200001;i++)
            route.add(new int[]{0,0,0});
        int arr[][] = new int[200001][2];
        int cur = 100000;

        for(int i=0;i<N;i++){
            String[] temp = br.readLine().split(" ");

            for(int j=0;j<Integer.parseInt(temp[0]);j++){
                if(temp[1].equals("L")){
                    if(route.get(cur)[0]==3){
                        cur--;
                        continue;
                    }
                    else{
                        route.get(cur)[0] = 1;
                        route.get(cur)[2]++;
                        if(route.get(cur)[1]>=2 && route.get(cur)[2]>=2){
                            route.get(cur)[0]=3;
                        }                     
                        cur--;   
                    }
                }
                else{
                    if(route.get(cur)[0]==3){
                        cur++;
                        continue;
                    }
                    else{
                        route.get(cur)[0] = 2;
                        route.get(cur)[1]++;
                        if(route.get(cur)[1]>=2 && route.get(cur)[2]>=2){
                            route.get(cur)[0]=3;
                        }       
                        cur++;                 
                    }
                }
            }
            if(temp[1].equals("L"))
                cur++;
            else
                cur--;
        }
        int white = 0;
        int gray = 0;
        int black = 0;

        for(int i=0;i<200001;i++){
            if(route.get(i)[0]==1){
                white++;
            }
            else if(route.get(i)[0]==2){
                black++;
            }
            else if(route.get(i)[0]==3){
                gray++;
            }
            else
                continue;
        }
        bw.write(white+" "+black+" "+gray);
        bw.flush();

    }
}