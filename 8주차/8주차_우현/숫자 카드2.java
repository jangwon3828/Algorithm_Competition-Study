import java.io.*;
import java.util.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            int key = Integer.parseInt(st.nextToken());

            // upperBound와 lowerBound의 차이 값을 구한다.
            sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');
        }
        System.out.println(sb);
    }


    public static int lowerBound(int arr[], int key) {
        int lo = 0;
        int hi = arr.length;

        while(lo < hi) {
            int mid = (lo + hi)/2;

            //key 값이 중간 위치의 값보다 작거나 같을 경우
            //(중복 원소에 대해 왼쪽으로 탐색하도록 상계를 내린다.)
            if (key <= arr[mid]) {      //중간 값이 찾는값과 같으면 범위를 더 줄여서 제일 왼쪽에 있는 위치(lowerBound)를 찾기 위해 '<=' 수식을 사용
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static int upperBound(int arr[], int key) {
        int lo = 0;
        int hi = arr.length;
        // lo가 hi랑 같아질 때 까지 반복
        while (lo < hi) {
            int mid = (lo + hi) / 2; // 중간위치를 구한다.
            // key값이 중간 위치의 값보다 작을 경우
            if (key < arr[mid]) {
                hi = mid;
            }
            // 중복원소의 경우 else에서 처리된다.
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }

}