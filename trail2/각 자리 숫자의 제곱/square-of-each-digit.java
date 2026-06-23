import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        System.out.print(sum(n));
    }
    static int sum(int n){
        if(n == 0)
            return 0;

        int temp = (n%10) * (n%10);
        return temp + sum(n/10);
    }
}