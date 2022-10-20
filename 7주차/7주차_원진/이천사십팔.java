package baekjoon;
import java.util.*;
public class 이천사십팔 {


        static int[] dx = {0,0,1,-1};
        static int[] dy = {1,-1,0,0};
        static final int LIMIT = 5;
        static int[] gen(int k) {
            int[] a = new int[LIMIT];
            for (int i=0; i<LIMIT; i++) {
                a[i] = (k&3);
                k >>= 2;
            }
            return a;
        }
        static int check(int[][] a, int[] dirs) {
            int n = a.length;
            int[][] d = new int[n][n];
            boolean[][] merged = new boolean[n][n];
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    d[i][j] = a[i][j];
                }
            }
            // 0: down, 1: up, 2: left, 3: right
            for (int dir : dirs) {
                boolean ok = false;
                for (int i=0; i<n; i++) {
                    for (int j=0; j<n; j++) {
                        merged[i][j] = false;
                    }
                }
                while (true) {
                    ok = false;
                    if (dir == 0) {
                        for (int i=n-2; i>=0; i--) {
                            for (int j=0; j<n; j++) {
                                if (d[i][j] == 0) continue;
                                if (d[i+1][j] == 0) {
                                    d[i+1][j] = d[i][j];
                                    merged[i+1][j] = merged[i][j];
                                    d[i][j] = 0;
                                    ok = true;
                                } else if (d[i+1][j] == d[i][j]) {
                                    if (merged[i][j] == false && merged[i+1][j] == false) {
                                        d[i+1][j] *= 2;
                                        merged[i+1][j] = true;
                                        d[i][j] = 0;
                                        ok = true;
                                    }
                                }
                            }
                        }
                    } else if (dir == 1) {
                        for (int i=1; i<n; i++) {
                            for (int j=0; j<n; j++) {
                                if (d[i][j] == 0) continue;
                                if (d[i-1][j] == 0) {
                                    d[i-1][j] = d[i][j];
                                    merged[i-1][j] = merged[i][j];
                                    d[i][j] = 0;
                                    ok = true;
                                } else if (d[i-1][j] == d[i][j]) {
                                    if (merged[i][j] == false && merged[i-1][j] == false) {
                                        d[i-1][j] *= 2;
                                        merged[i-1][j] = true;
                                        d[i][j] = 0;
                                        ok = true;
                                    }
                                }
                            }
                        }
                    } else if (dir == 2) {
                        for (int j=1; j<n; j++) {
                            for (int i=0; i<n; i++) {
                                if (d[i][j] == 0) continue;
                                if (d[i][j-1] == 0) {
                                    d[i][j-1] = d[i][j];
                                    merged[i][j-1] = merged[i][j];
                                    d[i][j] = 0;
                                    ok = true;
                                } else if (d[i][j-1] == d[i][j]) {
                                    if (merged[i][j] == false && merged[i][j-1] == false) {
                                        d[i][j-1] *= 2;
                                        merged[i][j-1] = true;
                                        d[i][j] = 0;
                                        ok = true;
                                    }
                                }
                            }
                        }
                    } else if (dir == 3) {
                        for (int j=n-2; j>=0; j--) {
                            for (int i=0; i<n; i++) {
                                if (d[i][j] == 0) continue;
                                if (d[i][j+1] == 0) {
                                    d[i][j+1] = d[i][j];
                                    merged[i][j+1] = merged[i][j];
                                    d[i][j] = 0;
                                    ok = true;
                                } else if (d[i][j+1] == d[i][j]) {
                                    if (merged[i][j] == false && merged[i][j+1] == false) {
                                        d[i][j+1] *= 2;
                                        merged[i][j+1] = true;
                                        d[i][j] = 0;
                                        ok = true;
                                    }
                                }
                            }
                        }
                    }
                    if (ok == false) break;
                }
            }
            int ans = 0;
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (ans < d[i][j]) {
                        ans = d[i][j];
                    }
                }
            }
            return ans;
        }
        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            int ans = 0;
            for (int k=0; k<(1<<(LIMIT*2)); k++) {
                int[] dir = gen(k);
                int cur = check(a, dir);
                if (ans < cur) ans = cur;
            }
            System.out.println(ans);
        }

}
