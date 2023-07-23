import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class week3_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] array = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            sum += array[i];
            
            if(i == K - 1) {
                max = sum;
            }
            if(i >= K) {
                sum -= array[i - K];
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }
}