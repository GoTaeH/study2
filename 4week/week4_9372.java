import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class week4_9372 {
    private static int N, M;
    private static ArrayList<Integer>[] flight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            flight = new ArrayList[N+1];

            for(int i = 0; i <= N; i++) {
                flight[i] = new ArrayList<>();
            }

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                flight[a].add(b);
                flight[b].add(a);

            }
            sb.append((N-1) + "\n");
        }
        System.out.println(sb);
    }
}