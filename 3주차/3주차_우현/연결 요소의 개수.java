import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer>[] A;
    static boolean visited[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        A = new ArrayList[n+1];

        visited = new boolean[n+1];     //모두 false로 초기화

        for(int i=1; i<n; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        int count = 0;
        for(int i=1; i<n+1; i++) {
            if(!visited[i]) {
                count++;
                DFS(i);
            }
        }
    }

    private static void DFS(int v) {
        if(visited[v]) {
            return;
        }
        visited[v] = true;
        for(int i : A[v]) {
            if(visited[i] == false) {
                DFS(i);
            }
        }
    }
}