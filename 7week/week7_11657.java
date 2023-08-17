import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Bus {
    int start, end, weight;
    public Bus(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}
public class week7_11657 {
    static int N, M;
    static final int INF = 100000000;
    static ArrayList<Bus> bus = new ArrayList<>();
    static long[] dist;

    public static boolean bellman() {
        boolean cycle = false;
        dist[1] = 0;
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j < M; j++) {
                int s = bus.get(j).start;
                int e = bus.get(j).end;
                int w = bus.get(j).weight;
                if(dist[s] != INF && dist[s] + w < dist[e]) {
                    dist[e] = dist[s] + w;
                    if(i == N) cycle = true;
                }
            }
        }
        return cycle;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new long[N + 1];
        Arrays.fill(dist, INF);
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            bus.add(new Bus(A, B, C));
        }
        StringBuilder sb = new StringBuilder();
        if(bellman()) {
            sb.append(-1 + "\n");
        } else {
            for(int i = 2; i <= N; i++) {
                sb.append(dist[i] == INF ? -1 : dist[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}