import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class week8_2533 {
    static int N;
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][2];
        for(int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        dp(1, -1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
    static void dp(int num, int parent) {
        dp[num][0] = 0;
        dp[num][1] = 1;

        for(int next : tree.get(num)) {
            if(next != parent) {
                dp(next, num);
                dp[num][0] += dp[next][1];
                dp[num][1] += Math.min(dp[next][0], dp[next][1]);
            }
        }
    }
}