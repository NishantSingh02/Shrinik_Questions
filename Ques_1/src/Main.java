import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*Special Matrix
* Nishant wants to access a particular row of the special matrix. Help him by output that row.
The special matrix is generated as:
Given number of rows m, number of cols n and rowNumber k.
Generate a m x n matrix by filling m*n numbers in matrix in reverse order in a spiral form.
Output the kth row of the generated matrix*/

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt(); // no. of testcases
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();
        ArrayList<Integer> rowNumber = new ArrayList<>();
        while(t-->0) {
            rows.add(scan.nextInt()); //no. of rows
            cols.add(scan.nextInt());  //no. of cols
            rowNumber.add(scan.nextInt());  // row Number to output the row
        }
        for(int i=0;i<rows.size();i++)
        {
            int[][] res = func(rows.get(i), cols.get(i));
            System.out.println(Arrays.toString(res[rowNumber.get(i) - 1]));
        }
        scan.close();
    }

    private static int[][] func(int m,int n)
    {
        int[][] a = new int[m][n];

        int nextNum=m*n;  //nextNum is the number to be filled
        int i=0;
        int j=0;
        while(i<m&&j<n&&a[i][j]==0){

            //left -> right
            while(j<n&&a[i][j]==0)
                a[i][j++]=nextNum--;
            j--;
            i++;
            //top -> bottom
            while(i<m&&a[i][j]==0)
                a[i++][j]=nextNum--;
            i--;
            j--;
            //right -> left
            while(j>-1&&a[i][j]==0)
                a[i][j--]=nextNum--;
            i--;
            j++;

            // bottom -> top
            while(i>-1&&a[i][j]==0)
                a[i--][j]=nextNum--;
            i++;
            j++;
        }

        return a;
    }
}