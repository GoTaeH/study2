import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class week4_11725 {
    static int N;
    static boolean[] visit;
    static ArrayList<Integer>[] tree;
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visit = new boolean[N + 1];
        tree = new ArrayList[N + 1];
        parent = new int[N + 1];

        for(int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        for(int i = 1; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            tree[a].add(b);
            tree[b].add(a);
        }
        dfs(1);
        for(int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }
    static void dfs(int v) {
        visit[v] = true;
        for(int i : tree[v]) {
            if(!visit[i]) {
                parent[i] = v;
                dfs(i);
            }
        }
    }
}