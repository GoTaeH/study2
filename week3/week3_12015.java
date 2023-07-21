import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class week3_12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int[] arr = new int[A];
        List<Integer> list = new ArrayList<>();
        list.add(0);

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < A; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > list.get(list.size() - 1)) {
                list.add(arr[i]);
            } else {
                int l = 0;
                int r = list.size() - 1;
                while(l < r) {
                    int mid = (l + r) / 2;
                    if(list.get(mid) >= arr[i]) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                list.set(r, arr[i]);
            }
        }
        System.out.println(list.size() - 1);
    }
}