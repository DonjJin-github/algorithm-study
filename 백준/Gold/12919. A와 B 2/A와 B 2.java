import java.io.*;
import java.util.*;

public class Main {
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String t = br.readLine();

        dfs(s,t);

        bw.write(ans + "\n");
        bw.flush();
    }

    static void dfs(String s, String t) {
        if (t.length() == s.length()) {
            if (t.equals(s))
                ans = 1;
            return;
        }

        if (t.charAt(t.length() - 1) == 'A') {
            dfs(s,t.substring(0, t.length() - 1));
        }

        if (t.charAt(0) == 'B') {
            StringBuffer sb = new StringBuffer(t);
            String reversed = sb.reverse().toString();
            dfs(s,reversed.substring(0, reversed.length() - 1));
        }
    }
}
