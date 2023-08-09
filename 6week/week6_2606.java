import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class week6_2606 {
    static int map[][];
    static boolean visited[];
    static int n, pair, num;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        pair = Integer.parseInt(br.readLine());
        num = 1;
        map = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i = 0; i < pair; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }
        System.out.println(dfs(1));
    }

    public static int dfs(int i) {
        visited[i] = true;
        for(int j = 1; j <= n; j++) {
            if(map[i][j] == 1 && visited[j] == false) {
                cnt ++;
                dfs(j);
            }
        }
        return cnt;
    }
}