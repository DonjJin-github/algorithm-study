import java.io.*;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = -1;
        int index1 = 0;
        int index2 = 0;

        for(int i=0;i<9;i++){
            String[] str = br.readLine().split(" ");
            for(int j=0;j<9;j++){
                int x =Integer.parseInt(str[j]);
                if(max != Math.max(max,x)){
                    max = Math.max(max,x);
                    index1 = i+1;
                    index2 = j+1;
                }
            }
        }

        bw.write(max+"\n"+index1+" "+index2);
        bw.flush();
    }
}
