import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class week8_1005 {
    static int N, K;
    static int[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            time = new int[N + 1];

            ArrayList<Integer>[] list = new ArrayList[N];
            int[] link = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                list[i] = new ArrayList<>();
                time[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                list[X-1].add(Y-1);
                link[Y-1]++;
            }
            int W = Integer.parseInt(br.readLine());
            System.out.print(topological(link, list, W) + "\n");
        }
    }
    public static int topological(int[] link, ArrayList<Integer>[] list, int W) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] res = new int[N + 1];
        for(int i = 0; i < N; i++) {
            if(link[i] == 0) {
                res[i] = time[i];
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int i : list[node]) {
                res[i] = Math.max(res[i], res[node] + time[i]);
                link[i]--;
                if(link[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        return res[W - 1];
    }
}