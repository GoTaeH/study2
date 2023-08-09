import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class week6_15652 {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        arr = new int[M];
        backTracking(0, 0);
        System.out.println(sb);
    }
    private static void backTracking(int d, int s) {
        if(d == M) {
            for(int i = 0; i <arr.length; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i = s; i < N; i++) {
            visited[i] = true;
            arr[d] = i + 1;
            backTracking(d + 1, i);
            visited[i] = false;
        }
    }
}