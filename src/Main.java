import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt(); //no. of testcases
        while(t-->0) {
            int n = scan.nextInt();  //length of number
            int k = scan.nextInt();  //Absolute difference between consecutive digits
            ArrayList<Integer> list = new ArrayList<>();
            int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
            generate(nums, n, 0, k, 0, list);
            System.out.println(list);
        }
        scan.close();
    }
    private static void generate(int[] nums,int n,int temp,int k,int i,ArrayList<Integer> list)
    {
        if(i==n){
            list.add(temp);
            return;
        }
        for(int x:nums)
        {
            if(temp>0){
                if(Math.abs(temp%10-x)==k)
                    generate(nums,n,temp*10+x,k,i+1,list);
            }
            else{
                if(x!=0)
                    generate(nums,n,temp*10+x,k,i+1,list);
            }
        }
    }
}