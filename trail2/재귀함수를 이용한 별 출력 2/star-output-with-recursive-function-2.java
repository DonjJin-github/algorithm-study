import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        print(n);
        System.out.print(sb.toString());
    }
    static void print(int n){
        if(n==0)
            return;

        for(int i=0;i<n;i++){
            sb.append("* ");
        }
        sb.append("\n");
        print(n-1);
        for(int i=0;i<n;i++){
            sb.append("* ");
        }
        sb.append("\n");
    }
}