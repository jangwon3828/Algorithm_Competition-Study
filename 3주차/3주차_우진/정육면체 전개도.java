import java.util.*;

public class 정육면체 전개도 {
    static String[][] cubes = {
            {"0010","1111","0010"},
            {"0100","1111","1000"},
            {"0010","1111","0100"},
            {"0001","1111","1000"},
            {"0001","1111","0100"},
            {"11100","00111"},
            {"1100","0111","0010"},
            {"1100","0111","0001"},
            {"0010","1110","0011"},
            {"0001","1111","0001"},
            {"1100","0110","0011"}
    };
    static String[] mirror(String[] b) {
        String[] ans = new String[b.length];
        for (int i=0; i<b.length; i++) {
            ans[i] = new StringBuilder(b[i]).reverse().toString();
        }
        return ans;
    }
    static String[] rotate(String[] b) {
        String[] ans = new String[b[0].length()];
        for (int j=0; j<b[0].length(); j++) {
            StringBuilder sb = new StringBuilder();
            for (int i=(int)b.length-1; i>=0; i--) {
                sb.append(b[i].charAt(j));
            }
            ans[j] = sb.toString();
        }
        return ans;
    }
    static boolean check(int[][] a, String[] b, int x, int y) {
        int n = a.length;
        for (int i=0; i<b.length; i++) {
            for (int j=0; j<b[0].length(); j++) {
                int nx = x+i;
                int ny = y+j;
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (b[i].charAt(j) == '0') {
                        if (a[nx][ny] == 1) return false;
                    } else if (b[i].charAt(j) == '1') {
                        if (a[nx][ny] == 0) return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 3;
        while (t-- > 0) {
            int n = 6;
            int[][] a = new int[n][n];
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            boolean ans = false;
            for (String[] c : cubes) {
                String[] cube = new String[c.length];
                System.arraycopy(c, 0, cube, 0, c.length);
                for (int mir=0; mir<2; mir++) {
                    for (int rot=0; rot<4; rot++) {
                        for (int i=0; i<n; i++) {
                            for (int j=0; j<n; j++) {
                                ans |= check(a, cube, i, j);
                            }
                        }
                        cube = rotate(cube);
                    }
                    cube = mirror(cube);
                }
            }
            System.out.println(ans ? "yes" : "no");
        }
    }
}