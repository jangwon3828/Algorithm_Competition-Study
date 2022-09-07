import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 부등호 {

    static int n;
    static char[] arr;
    static ArrayList<String> ans=new ArrayList<>();
    static boolean[] check=new boolean[10];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new char[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().charAt(0);
        }
        go(0,"");
        Collections.sort(ans);
        int m=ans.size();
        System.out.println(ans.get(m-1));
        System.out.println(ans.get(0));

    }

    public static boolean ok(String num) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == '<') {
                if (num.charAt(i) > num.charAt(i + 1)) return false;
            } else if (arr[i] == '>') {
                if (num.charAt(i) < num.charAt(i + 1)) return false;
            }
        }
        return true;
    }
    static void go(int index,String num){
        if(index==n+1){
            if(ok(num)){
                ans.add(num);
            }
        }
        for (int i = 0; i <=9; i++) {
            if(check[i])continue;
            check[i]=true;
            go(index+1,num+Integer.toString(i));
            check[i]=false;

        }
    }
}
