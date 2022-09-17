import java.util.Scanner;

//Absolute Difference between Sum of Visible and Invisible Numbers

/*Nishant was gifted a cheap keyboard by his classmate Naman. The keyboard began to malfunction after some time. Nishant wants to know the following information about the keyboard. Help him to know that.
While writing numbers from 1 to n in an array of size n. the Keyboard malfunctions such that some of the numbers are not typed and some get typed more than once.
After finding the numbers which do not get typed. Output the absolute difference between the sum of typed numbers and sum of disappered numbers.
Note: While Calculating sum of the typed numbers each number is counted only once.*/

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t= scan.nextInt(); // no of testcases
        while(t-->0) {
            int size = scan.nextInt();
            int[] array = new int[size];
            for(int i=0;i<size;i++)
            {
                array[i]=scan.nextInt();
            }
            long res = func(array);
            System.out.println(Math.abs(res));
        }
    }

    private static long func(int[] nums)
    {
        long invisibleSum =0;
        long visibleSum=0;
        boolean flag=true;
        while(flag)
        {
            flag=false;
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]!=nums[nums[i]-1])
                {
                    int temp = nums[nums[i]-1];
                    nums[nums[i]-1] = nums[i];
                    nums[i]=temp;
                    flag=true;
                }
            }
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=i+1)
                invisibleSum+=i+1;
            else
                visibleSum+=i+1;
        }
        return invisibleSum-visibleSum;
    }
}