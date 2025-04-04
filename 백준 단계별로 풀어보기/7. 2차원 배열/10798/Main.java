import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = new String[5];
        char[][] array = new char[5][15];
        
        for(int i=0;i<5;i++){
            str[i] = br.readLine();
            for(int j=0;j<str[i].length();j++)
                array[i][j] = str[i].charAt(j);
        }

        for(int i=0;i<15;i++){
            for(int j=0;j<5;j++){
                if(array[j][i]!='\0')
                    bw.write(array[j][i]);
            }
        }

        


        bw.write("\n");
        bw.flush();
    }
}
