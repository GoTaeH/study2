import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class week6_2206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(N-1 == 0 && M-1 == 0) {
            System.out.println(1);
            System.exit(0);
        }
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        char[][] route = new char[N][M];
        int[][] distance = new int[N][M];
        boolean[][][] visited = new boolean[2][N][M];
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                route[i][j] = s.charAt(j);
            }
        }
        queue.offer(new int[]{0, 0, 0});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if(route[nx][ny] == '1') {
                    if(now[2] == 0 && !visited[1][nx][ny]) {
                        visited[now[2]][nx][ny] = true;
                        distance[nx][ny] = distance[now[0]][now[1]] + 1;
                        queue.offer(new int[]{nx, ny, 1});
                    }
                }
                else {
                    if(!visited[now[2]][nx][ny]) {
                        visited[now[2]][nx][ny] = true;
                        distance[nx][ny] = distance[now[0]][now[1]] + 1;
                        queue.offer(new int[]{nx, ny, now[2]});
                    }
                }
                if(nx == N-1 && ny == M-1) {
                    System.out.println(distance[nx][ny] + 1);
                    System.exit(0);
                }
            }
        }
        System.out.println(-1);
    }
}