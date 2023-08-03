import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class week5_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] res = new int[2];
        int start = 0;
        int end = N - 1;
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);

        while(start < end) {
            int sum = arr[start] + arr[end];
            if(min > Math.abs(sum)) {
                min = Math.abs(sum);
                res[0] = arr[start];
                res[1] = arr[end];
                
                if(sum == 0) break;
            }
            if(sum < 0) start++;
            else end--;
        }
        System.out.println(res[0] + " " + res[1]);
    }
}