import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class week2_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] triangle = new int[N][N];
        int[][] dp = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i+1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        for(int i = 0; i < N; i++) {
            dp[N-1][i] = triangle[N-1][i];
        }
        for(int i = 2; i <= N; i++) {
            for(int j = 0; j<= N-i; j++) {
                dp[N-i][j] = Math.max(dp[N-i+1][j], dp[N-i+1][j+1]) + triangle[N-i][j];
            }
        }
        System.out.println(dp[0][0]);
    }
}