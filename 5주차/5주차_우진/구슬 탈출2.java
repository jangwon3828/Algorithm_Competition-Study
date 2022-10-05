import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구슬 탈출2{
    private static int N, M, ex, ey;
    private static char[][] map;

    static int dx[] = { 0, 1, 0, -1 };
    static int dy[] = { 1, 0, -1, 0 };
    private static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st=new StringTokenizer(br.readLine()," ");
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map=new char[N][M];

        ex = N+1;
        ey = M+1;
        int rx = 0;
        int ry = 0;
        int bx = 0;
        int by = 0;
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < input.length; j++) {
                map[i][j]=input[j];
                if(map[i][j]=='B') {
                    bx=i;
                    by=j;
                }else if(map[i][j] =='R') {
                    rx=i;
                    ry=j;
                }else if(map[i][j] == 'O') {
                    ex=i;
                    ey=j;
                }
            }
        }

        result= Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            dfs(rx,ry,bx,by,i,0);
        }

        if(result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }

    private static void dfs(int rx, int ry, int bx, int by, int dir, int cnt) {
        if (map[rx][ry] == 'O')
        {
            if (result > cnt) result = cnt;
            return;
        }

        if(cnt== 10)
            return;


        int rCnt = 0;
        int bCnt = 0;

        int nBx = bx;
        int nBy = by;
        while(map[nBx+dx[dir]][nBy+dy[dir]] !='#')
        {
            bCnt++;
            nBx += dx[dir];
            nBy += dy[dir];

            if (map[nBx][nBy] == 'O')
            {
                return;
            }
        }

        int nRx = rx;
        int nRy = ry;

        while(map[nRx+dx[dir]][nRy+dy[dir]] !='#')
        {
            rCnt++;
            nRx += dx[dir];
            nRy += dy[dir];

            if (map[nRx][nRy] == 'O')
            {
                break;
            }
        }
        if (nRx == nBx && nRy == nBy)
        {
            if (rCnt > bCnt)
            {
                nRx -= dx[dir];
                nRy -= dy[dir];
            }
            else if (rCnt < bCnt)
            {
                nBx -= dx[dir];
                nBy -= dy[dir];
            }
        }


        for (int i = 0; i < 4; i++) {
            if (i == dir) continue;
            dfs(nRx, nRy, nBx, nBy, i, cnt+1);
        }

    }
}