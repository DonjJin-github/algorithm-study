import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String t = sc.next();
        String[] words = new String[n];
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
            if(t.length()>words[i].length())
                continue;
            if(t.equals(words[i].substring(0,t.length())))
                list.add(words[i]);
        }
        Collections.sort(list);
        System.out.print(list.get(k-1));
    }
}