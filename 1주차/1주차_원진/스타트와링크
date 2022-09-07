import java.util.Scanner;

public class 스타트와링크 {
    public static int n;
    public static int[][] map;
    public static boolean[] visit;
    public static int min=Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        map=new int[n][n];
        visit=new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j]=sc.nextInt();
            }
        }

        check(0,0);
        System.out.println(min);

    }

    private static void check(int idx, int count) {

        if(count==n/2){
            diff();
            return;
        }
        for (int i = idx; i < n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                check(i+1,count+1);
                visit[i]=false;
            }

        }
    }

    private static void diff() {
        int start=0;
        int link=0;

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j <n ; j++) {
                if(visit[i] && visit[j]){
                    start+=map[i][j];
                    start+=map[j][i];
                }
                if(!visit[i] && !visit[j]){
                    link+=map[i][j];
                    link+=map[j][i];
                }

            }

        }

        int re= Math.abs(start-link);
        if(re==0){
            System.out.println(0);
            System.exit(0);
        }
        min=Math.min(re,min);
    }
}
