import java.io.*;
import java.util.*;

public class Main {
    static class node {
        String lc;
        String rc;

        node(String lc, String rc) {
            this.lc = lc;
            this.rc = rc;
        }
    }

    static node[] tree;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        tree = new node[26];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String lc = st.nextToken();
            String rc = st.nextToken();

            int idx = parent.charAt(0) - 'A';

            tree[idx] = new node(lc, rc);
        }
        preorder('A');
        bw.write("\n");
        
        inorder('A');
        bw.write("\n");
        
        postorder('A');
        bw.write("\n");

        bw.flush();
    }

    static void preorder(char root)throws IOException {
        if (root == '.')
            return;

        int idx = root - 'A';
        bw.write(root);
        preorder(tree[idx].lc.charAt(0));
        preorder(tree[idx].rc.charAt(0));
    }

    static void inorder(char root)throws IOException  {
        if (root == '.')
            return;

        int idx = root - 'A';
        inorder(tree[idx].lc.charAt(0));
        bw.write(root);
        inorder(tree[idx].rc.charAt(0));
    }

    static void postorder(char root)throws IOException {
        if (root == '.')
            return;

        int idx = root - 'A';
        postorder(tree[idx].lc.charAt(0));
        postorder(tree[idx].rc.charAt(0));
        bw.write(root);
    }

}