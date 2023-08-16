import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.List;

public class week7_1197 {
    static int result;
    static List<Node>[] list;
    static boolean[] visited;
    static class Node implements Comparable<Node> {
        int to, weight;
        public Node(int to, int weight) {
            super();
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        list = new ArrayList[V+1];
        visited = new boolean[V+1];
        for(int i = 1; i < V + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, w));
            list[b].add(new Node(a, w));
        }
        prim(1);
        System.out.println(result);
    }
    static void prim(int start) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        while(!queue.isEmpty()) {
            Node q = queue.poll();
            int node = q.to;
            int weight = q.weight;
            if(visited[node]) continue;
            visited[node] = true;
            result += weight;
            for(Node next : list[node]) {
                if(!visited[next.to]) {
                    queue.add(next);
                }
            }
        }
    }
}