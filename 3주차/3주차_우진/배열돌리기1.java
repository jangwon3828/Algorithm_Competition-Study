import java.util.Scanner;

public class 배열돌리기1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dx = {0,1,0,-1};
        int [] dy = {1,0,-1,0};

        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();

        int[][] arr = new int [N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int s = Math.min(N, M)/2;

        for(int i=0;i<R; i++) {
            for(int j=0; j<s; j++) {
                int d=0;
                int ox=j, oy=j;
                int tmp=arr[ox][oy];

                while(d<4) {
                    int nx = ox+dx[d];
                    int ny = oy+dy[d];

                    if(nx>=j && ny>=j && nx<N-j && ny<M-j) {
                        arr[ox][oy] = arr[nx][ny];
                        ox=nx;
                        oy=ny;
                    }else d++;
                }
                arr[j+1][j]=tmp;
            }
        }

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}