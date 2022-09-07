import java.util.*;

public class 퇴사 {
    static int a;
    static int ans=Integer.MIN_VALUE;
    static int arr[][];

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        a=sc.nextInt();
        arr=new int[a][2];
        for (int i = 0; i < a; i++) {
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }
        go(0,0);
        System.out.println(ans);
    }

    public static void go(int day,int sum) {
        if(day==a){
            ans= Math.max(ans,sum);
            return;
        }
        else if(day>=a)return;
        go(arr[day][0]+day,sum+arr[day][1]);
        go(day+1,sum);

    }
}