import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        System.out.print(sum(n));
    }
    static int sum(int n){
        if(n < 1){
            return 0;
        }

        return sum(n-2)+n;
    }
}