import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class week8_6086 {
    static int[][] pipe, flow;
    public static int pipeName(char c) {
        if('A' <= c && c <= 'Z') return c - 65;
        else if('a' <= c && c <= 'z') return c - 71;
        return 0;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        pipe = new int[52][52];
        flow = new int[52][52];

        int N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = pipeName(st.nextToken().charAt(0));
            int end = pipeName(st.nextToken().charAt(0));
            int weight = Integer.parseInt(st.nextToken());

            pipe[start][end] += weight;
            pipe[end][start] += weight;
        }
        int total = 0;
        int source = 0;
        int sink = 25;
        while(true) {
            int[] parent = new int[52];
            Queue<Integer> queue = new PriorityQueue();
            for(int i = 0; i < 52; i++) {
                parent[i] = -1;
            }
            parent[source] = source;
            queue.add(source);

            while(!queue.isEmpty() && parent[sink] == -1) {
                int a = queue.poll();
                for(int b = 0; b < 52; b++) {
                    if(pipe[a][b] - flow[a][b] > 0 && parent[b] == -1) {
                        queue.add(b);
                        parent[b] = a;
                    }
                }
            }
            if(parent[sink] == -1) break;
            int amount = Integer.MAX_VALUE;
            for(int i = sink; i != source; i = parent[i]) {
                amount = Math.min(pipe[parent[i]][i] - flow[parent[i]][i], amount);
            }
            for(int i = sink; i != source; i = parent[i]) {
                flow[parent[i]][i] += amount;
                flow[i][parent[i]] -= amount;
            }
            total += amount;
        }
        System.out.println(total);
    }
}