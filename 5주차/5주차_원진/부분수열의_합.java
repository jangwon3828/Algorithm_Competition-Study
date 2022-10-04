package baekjoon;

import java.util.*;

public class 부분수열의_합 {
    static int n;
    static int[] arr;
    static Set<Integer> set = new HashSet<>();
    static int answer = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        dfs(0, 0);
        while (true) {
            if (set.contains(answer)) {
                answer++;
            } else {
                break;
            }
        }
        System.out.println(answer);
    }

    static void dfs(int idx, int sum) {
        if (idx == n) {
            if (sum > 0)
                set.add(sum);
        } else {
            dfs(idx + 1, sum + arr[idx]);
            dfs(idx + 1, sum);
        }
    }
}
