import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class week8_9576 {
    static int N, M;
    static int[] book;
    static student[] students;
    static class student {
        int a, b;
        student(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            book = new int[N + 1];
            students = new student[M + 1];
            visited = new boolean[N + 1];

            for(int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                students[i] = new student(a, b);
            }
            int result = 0;
            for(int i = 1; i <= M; i++) {
                Arrays.fill(visited, false);
                if(dfs(i)) result++;
            }
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }
    static boolean dfs(int next) {
        for(int b = students[next].a; b <= students[next].b; b++) {
            if(visited[b]) continue;
            visited[b] = true;
            if(book[b] == 0 || dfs(book[b])) {
                book[b] = next;
                return true;
            }
        }
        return false;
    }
}