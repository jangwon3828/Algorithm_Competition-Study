import java.util.*;

public class 4 연산 {
    final static long limit = 1000000000L;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();
        long t = sc.nextLong();
        Queue<Long> q = new LinkedList<>();
        Queue<String> qs = new LinkedList<>();
        HashSet<Long> check = new HashSet<>();
        q.add(s);
        qs.add("");
        check.add(s);
        while (!q.isEmpty()) {
            long x = q.remove();
            String str = qs.remove();
            if (x == t) {
                if (str.length() == 0) {
                    str = "0";
                }
                System.out.println(str);
                System.exit(0);
            }
            if (0 <= x * x && x * x <= limit && !check.contains(x * x)) {
                q.add(x * x);
                qs.add(str + "*");
                check.add(x * x);
            }
            if (0 <= x + x && x + x <= limit && !check.contains(x + x)) {
                q.add(x + x);
                qs.add(str + "+");
                check.add(x + x);
            }
            if (0 <= x - x && x - x <= limit && !check.contains(x - x)) {
                q.add(x - x);
                qs.add(str + "-");
                check.add(x - x);
            }
            if (x != 0 && 0 <= x / x && x / x <= limit && !check.contains(x / x)) {
                q.add(x / x);
                qs.add(str + "/");
                check.add(x / x);
            }
        }
        System.out.println(-1);
    }