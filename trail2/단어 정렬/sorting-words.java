import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] wordList = new String[n];
        for (int i = 0; i < n; i++) {
            wordList[i] = sc.next();
        }
        // Please write your code here.
        StringBuilder sb = new StringBuilder();
        Arrays.sort(wordList);
        for(int i=0;i<n;i++){
            sb.append(wordList[i]+"\n");
        }
        System.out.print(sb.toString());
    }
}