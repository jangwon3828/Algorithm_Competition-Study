package baekjoon;
import java.util.*;

public class 가르침 {
        static boolean[] learn = new boolean[26];
        static int count(String[] words) {
            int cnt = 0;
            for (String word : words) {
                boolean ok = true;
                for (char x : word.toCharArray()) {
                    if (!learn[x-'a']) {
                        ok = false;
                        break;
                    }
                }
                if (ok) cnt += 1;
            }
            return cnt;
        }
        static int go(int index, int k, String[] words) {
            if (k < 0) return 0;
            if (index == 26) {
                return count(words);
            }
            int ans = 0;
            learn[index] = true;
            int t1 = go(index+1, k-1, words);
            learn[index] = false;
            if (ans < t1) ans = t1;
            if (index != 'a'-'a' && index != 'n'-'a' && index != 't'-'a' && index != 'i'-'a' && index != 'c'-'a') {
                t1 = go(index+1, k, words);
                if (ans < t1) ans = t1;
            }
            return ans;
        }
        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            String[] words = new String[n];
            for (int i=0; i<n; i++) {
                words[i] = sc.next();
            }
            System.out.println(go(0,m,words));
        }

}
