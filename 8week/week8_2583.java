import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class week8_2583 {
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static int M, N, K;
    static int cnt = 0;
    static int[][] graph;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new int[M][N];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int x = y1; x < y2; x++) {
                for(int y = x1; y < x2; y++) {
                    graph[x][y] = 1;
                }
            }
        }
        list = new ArrayList<Integer>();
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(graph[i][j] == 0) {
                    cnt = 0;
                    dfs(i, j);
                    list.add(cnt);
                }
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for(Integer i : list) {
            System.out.print(i + " ");
        }
    }
    public static void dfs(int x, int y) {
        graph[x][y] = 1;
        cnt++;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0 <= nx && 0 <= ny && nx < M && ny < N) {
                if(graph[nx][ny] == 0) {
                    dfs(nx, ny);
                }
            }
        }
    }
}