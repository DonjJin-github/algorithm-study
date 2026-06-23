import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            sb.append(arr[i]+" ");
        }
        System.out.println(sb.toString());
        sb = new StringBuilder();
        for(int i=n-1;i>=0;i--){
            sb.append(arr[i]+" ");
        }
        System.out.println(sb.toString());
    }
}