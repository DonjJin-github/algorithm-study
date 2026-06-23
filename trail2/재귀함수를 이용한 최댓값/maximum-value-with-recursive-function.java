import java.util.Scanner;
public class Main {
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        max(arr,0,n);
        System.out.print(ans);
    }
    static void max(int arr[], int index, int n){
        if(index == n)
            return;
        
        ans = Math.max(arr[index],ans);
        max(arr,index+1,n);
    }
}