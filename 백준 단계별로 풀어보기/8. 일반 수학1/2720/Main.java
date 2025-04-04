import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        
        for(int i=0;i<T;i++){
            String C = br.readLine();
            int money = Integer.parseInt(C);

            if(money/25>0){
                result.append(money/25+" ");
                money = money%25;
            }
            else{
                result.append(0+" ");
            }
            if(money/10>0){
                result.append(money/10+" ");
                money = money%10;
            }
            else{
                result.append(0+" ");
            }
            if(money/5>0){
                result.append(money/5+" ");
                money = money%5;
            }
            else{
                result.append(0+" ");
            }
            if(money/1>0){
                result.append(money/1+" ");
                money = 0;
            }
            else{
                result.append(0+" ");
            }
            bw.write(result.toString()+"\n");
            result.delete(0, result.length());
        }
        bw.flush();
    }
}
