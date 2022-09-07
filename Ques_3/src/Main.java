import java.util.Scanner;

public class Main {
    //pattern print
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t= scan.nextInt(); //no. of testcases
        while(t-->0) {
            int n = scan.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print("n");
                }
                for (int j = 0; j < 2 * n - 1; j++) {
                    if (j >= i && j < i + n)
                        System.out.print("n");
                    else
                        System.out.print(" ");
                }
                for (int j = 0; j < n; j++) {
                    System.out.print("n");
                }
                System.out.println();
            }
        }
    }
}