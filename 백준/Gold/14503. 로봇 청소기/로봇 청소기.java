import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        st = new StringTokenizer(br.readLine());

        int currentx = Integer.parseInt(st.nextToken());
        int currenty = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        int ans = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        while (true) {
            if (arr[currentx][currenty] == 0) {
                arr[currentx][currenty] = 2;
                ans++;
            } else {
                int temp = 0;
                for (int i = 0; i < 4; i++) {
                    int x = currentx + dx[i];
                    int y = currenty + dy[i];
                    if (arr[x][y] == 0)
                        temp++;
                }
                if (temp != 0) {
                    boolean dbreak = false;
                    while (!dbreak) {
                        switch (direction) {
                            case 0:
                                direction = 3;
                                if (arr[currentx+dx[3]][currenty+dy[3]] == 0) {
                                    currentx += dx[3];
                                    currenty += dy[3];
                                    dbreak = true;
                                }
                                break;
                            case 1:
                                direction = 0;
                                if (arr[currentx+dx[0]][currenty+dy[0]] == 0) {
                                    currentx += dx[0];
                                    currenty += dy[0];
                                    dbreak = true;
                                }
                                break;
                            case 2:
                                direction = 1;
                                if (arr[currentx+dx[1]][currenty+dy[1]] == 0) {
                                    currentx += dx[1];
                                    currenty += dy[1];
                                    dbreak = true;
                                }
                                break;
                            case 3:
                                direction = 2;
                                if (arr[currentx+dx[2]][currenty+dy[2]] == 0) {
                                    currentx += dx[2];
                                    currenty += dy[2];
                                    dbreak = true;
                                }
                                break;
                            default:
                                break;
                        }
                    }
                } else {
                    switch (direction) {
                        case 0:
                            if (arr[currentx + dx[2]][currenty + dy[2]] == 1) {
                                bw.write(ans + "\n");
                                bw.flush();
                                return;
                            } else {
                                currentx += dx[2];
                                currenty += dy[2];
                            }
                            break;
                        case 1:
                            if (arr[currentx + dx[3]][currenty + dy[3]] == 1) {
                                bw.write(ans + "\n");
                                bw.flush();
                                return;
                            } else {
                                currentx += dx[3];
                                currenty += dy[3];
                            }
                            break;
                        case 2:
                            if (arr[currentx + dx[0]][currenty + dy[0]] == 1) {
                                bw.write(ans + "\n");
                                bw.flush();
                                return;
                            } else {
                                currentx += dx[0];
                                currenty += dy[0];
                            }
                            break;
                        case 3:
                            if (arr[currentx + dx[1]][currenty + dy[1]] == 1) {
                                bw.write(ans + "\n");
                                bw.flush();
                                return;
                            } else {
                                currentx += dx[1];
                                currenty += dy[1];
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        }

    }
}