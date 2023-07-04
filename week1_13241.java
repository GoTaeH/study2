import java.util.Scanner;

public class week1_13241 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();

        System.out.println(A * B / gcd(A, B));    
    }
    public static long gcd(long A, long B) {
        while(B != 0) {
            long r = A % B;
            A = B;
            B = r;
        }
        return A;
    }
}