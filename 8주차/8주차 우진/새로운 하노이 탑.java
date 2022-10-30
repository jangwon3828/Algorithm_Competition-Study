import java.util.*;
import java.io.*;

public class 새로운 하노이 탑 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] s = new String[3];
        for (int i=0; i<3; i++) {
            int cnt = sc.nextInt();
            if (cnt > 0) {
                s[i] = sc.next();
            } else {
                s[i] = "";
            }
        }
        int[] cnt = {0, 0, 0};
        for (String str : s) {
            for (char ch : str.toCharArray()) {
                cnt[ch-'A'] += 1;
            }
        }
        HashMap<List<String>, Integer> d = new HashMap<>();
        Queue<List<String>> q = new LinkedList<>();
        q.add(Arrays.asList(s));
        d.put(List.of(s), 0);
        while (!q.isEmpty()) {
            String[] now = q.remove().toArray(new String[3]);
            for (int i=0; i<3; i++) {
                for (int j=0; j<3; j++) {
                    if (i == j) continue;
                    if (now[i].length() == 0) continue;
                    String[] next = {now[0], now[1], now[2]};
                    next[j] += next[i].charAt(next[i].length()-1);
                    next[i] = next[i].substring(0, next[i].length()-1);
                    List<String> key = List.of(next);
                    if (!d.containsKey(key)) {
                        d.put(key, d.get(Arrays.asList(now)) + 1);
                        q.add(Arrays.asList(next));
                    }
                }
            }
        }
        String[] ans = new String[3];
        for (int i=0; i<3; i++) {
            ans[i] = "";
            for (int j=0; j<cnt[i]; j++) {
                ans[i] += (char)('A'+i);
            }
        }
        System.out.println(d.get(Arrays.asList(ans)));
    }
}