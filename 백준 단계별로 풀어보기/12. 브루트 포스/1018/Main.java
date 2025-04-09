import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        char[][] board1 = new char[8][8];
        char[][] board2 = new char[8][8];
        char[][] input = new char[N][M];
        int check = 1;
        int count = 0;

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(check%2==0){
                    board1[i][j] = 'B';
                    board2[i][j] = 'W';
                }
                else{
                    board1[i][j] = 'W';
                    board2[i][j] = 'B';
                }
                check++;
            }
            check++;
        }

        for(int i=0;i<N;i++){
            String[] temp = br.readLine().split("");
            for(int j=0;j<M;j++){
                input[i][j] = temp[j].charAt(0);
            }
        }
                int minChanges = 999;

                for (int startX = 0; startX <= N - 8; startX++) {
                    for (int startY = 0; startY <= M - 8; startY++) {
                        int count1 = 0; 
                        int count2 = 0; 
                        
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                if (input[startX + i][startY + j] != board1[i][j]) {
                                    count1++;
                                }
                                if (input[startX + i][startY + j] != board2[i][j]) {
                                    count2++;
                                }
                            }
                        }

                        minChanges = Math.min(minChanges, Math.min(count1, count2));
                    }
                }
        bw.write(minChanges+"\n");
        bw.flush();
    }
}
