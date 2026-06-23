import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();
        // Please write your code here.
        String str1[] = word1.split("");
        String str2[] = word2.split("");

        Arrays.sort(str1);
        Arrays.sort(str2);
        if(Arrays.equals(str1,str2))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}