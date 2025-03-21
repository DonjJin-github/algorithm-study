import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        String[] temp1= str[0].split("");
        String[] temp2 = str[1].split("");
        int k=0;

        int[] num1 = new int[3];
        int[] num2 = new int [3];

        for(int i=2;i>=0;i--){
            num1[i] = Integer.parseInt(temp1[k]);
            num2[i] = Integer.parseInt(temp2[k]);
            k++;
        }

        for(int i=0;i<3;i++){
            if (num1[i]>num2[i]) {
                for(int j=0;j<3;j++)
                    bw.write(num1[j]+"");
                bw.write("\n");
                break;
            }
            else if(num1[i]==num2[i])
                continue;
            else{
                for(int j=0;j<3;j++)
                    bw.write(num2[j]+"");
                bw.write("\n");
                break;
            }
        }
        bw.flush();
    }
}
