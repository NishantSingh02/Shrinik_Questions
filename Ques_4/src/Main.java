import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt(); // no. of testcases

        while(t-->0) {
            String s = scan.next();
            String[] a = s.split("[/-]");
            int day = Integer.parseInt(a[0]);
            int month = Integer.parseInt(a[1]);
            int year = Integer.parseInt(a[2]);
            String res = dayOfTheWeek(day, month, year);
            System.out.println(res);
        }
        scan.close();
    }

    private static String dayOfTheWeek(int day, int month, int year) {
        int yr = calcYear((year-1)%400)%7;
        int m = calcMonth(month)%7;
        int d = day%7;
        int sum=0;
        if((((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))&&month>2)
            sum++;

        sum+=yr+m+d;
        return calcDay(sum%7);

    }

    private static int calcYear(int year)
    {
        if(year>=100 && year<200)
            return (int)Math.floor((year-100)/4)+year-100+5;
        else if(year>=200 && year<300)
            return (int)Math.floor((year-200)/4)+year-200+3;
        else if(year>=300 && year<400)
            return (int)Math.floor((year-300)/4)+year-300+1;
        else
            return (int)Math.floor(year/4)+year;
    }

    private static int calcMonth(int month)
    {
        return switch (month) {
            case 2, 3 -> 3;
            case 4 -> 6;
            case 5 -> 8;
            case 6 -> 11;
            case 7 -> 13;
            case 8 -> 16;
            case 9 -> 19;
            case 10 -> 21;
            case 11 -> 24;
            case 12 -> 26;
            default -> 0;
        };
    }

    private static String calcDay(int day)
    {
        return switch (day) {
            case 0 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "";
        };
    }
}