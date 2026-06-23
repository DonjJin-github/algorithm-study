import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            nums[i] = sc.nextInt();
        }
        // Please write your code here.
        Arrays.sort(nums);
        
        int ans = Integer.MIN_VALUE;
        int maxIndex = 2*n-1;
        for(int i=0;i<n;i++){
            ans = Math.max(ans, nums[i]+nums[maxIndex]);
            maxIndex--;
        }
        System.out.print(ans);
    }
}