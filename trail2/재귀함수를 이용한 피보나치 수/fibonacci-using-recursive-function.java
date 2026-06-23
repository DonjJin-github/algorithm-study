import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        System.out.print(fib(n));
    }
    static int fib(int n){
        if(n == 1)
            return 1;
        if(n == 2)
            return 1;
        
        return fib(n-2) + fib(n-1);
    }
}