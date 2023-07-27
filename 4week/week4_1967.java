import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class week4_1967 {
    static int N;
    static int result;
    static ArrayList<Node> list[];
    static boolean[] visit;
    static class Node {
        int num, cost;
        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];

        for(int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, cost));
            list[b].add(new Node(a, cost));
        }
        for(int i = 0; i < N; i++) {
            visit = new boolean[N+1];
            visit[i] = true;
            dfs(i, 0);
        }
        System.out.println(result);
    }
    public static void dfs(int number, int value) {
        for(Node node : list[number]) {
            if(!visit[node.num]) {
                visit[node.num] = true;
                dfs(node.num, value + node.cost);
            }
        }
        result = Math.max(result, value);
    }
}