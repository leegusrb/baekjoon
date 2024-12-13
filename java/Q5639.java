package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Node {
    int e;
    Node parent = null, left = null, right = null;

    Node (int e) {
        this.e = e;
    }

    void insert(int e) {
        if (e < this.e) {
            if (this.left == null)
                this.left = new Node(e);
            else
                this.left.insert(e);
        }
        else {
            if (this.right == null)
                this.right = new Node(e);
            else
                this.right.insert(e);
        }
    }
}

public class Q5639 {
    static Node root;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        root = new Node(0);

        while (true) {
            String str = br.readLine();
            if (str == null || str.equals(""))
                break;
            Integer e = Integer.parseInt(str);
            root.insert(e);
        }

        postOrder(root.right);

        bw.flush();
        bw.close();
        br.close();
    }

    static void postOrder(Node N) throws Exception {
        if (N == null)
            return;
        postOrder(N.left);
        postOrder(N.right);
        bw.write(String.valueOf(N.e) + "\n");
    }
}
