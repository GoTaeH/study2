import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class week5_5639 {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
        void insert(int data) {
            if(this.data > data) {
                if(this.left == null) {
                    this.left = new Node(data);
                } else {
                    this.left.insert(data);
                }
            } else {
                if(this.right == null) {
                    this.right = new Node(data);
                } else {
                    this.right.insert(data);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));

        while(true) {
            String pre = br.readLine();
            if(pre == null || pre.equals(""))   break;
            int input = Integer.parseInt(pre);
            root.insert(input);
        }
        post(root);
    }
    private static void post(Node node) {
        if(node.left != null) {
            post(node.left);
        }
        if(node.right != null) {
            post(node.right);
        } System.out.println(node.data);
    }
}