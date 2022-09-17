import java.util.Scanner;

public class Main {
    //pattern print

    /*Nishant is trying to print first letter of his name using a program.
    Generate the first letter of his name.
    Given a integer n, output the following pattern of height n and width (4*n)-1
    nnnnnnnnnnnn     nnnnnn
    nnnnnn nnnnnn    nnnnnn
    nnnnnn  nnnnnn   nnnnnn
    nnnnnn   nnnnnn  nnnnnn
    nnnnnn    nnnnnn nnnnnn
    nnnnnn     nnnnnnnnnnnn
    The above pattern is of height n=6 and width 23.*/

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
        scan.close();
    }
}