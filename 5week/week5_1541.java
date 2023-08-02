import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class week5_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), "-");
        int res = Integer.MAX_VALUE;
        while(st1.hasMoreTokens()) {
            int temp = 0;
            StringTokenizer st2 = new StringTokenizer(st1.nextToken(), "+");

            while(st2.hasMoreTokens()) {
                temp += Integer.parseInt(st2.nextToken());
            }
            if(res == Integer.MAX_VALUE) {
                res = temp;
            } else {
                res -= temp;
            }
        }
        System.out.println(res);
    }
}