import java.util.*;
class Main {
    static void rotate(int[] a) {
        int temp = a[a.length-1];
        for (int i=a.length-1; i>0; i--) {
            a[i] = a[i-1];
        }
        a[0] = temp;
    }
    public static void 컨베이어 벨트 위의 로봇(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[2*n];
        for (int i=0; i<2*n; i++) {
            a[i] = sc.nextInt();
        }
        int[] box = new int[2*n];
        int zero = 0;
        for (int t=1;; t++) {
            rotate(a);
            rotate(box);
            if (box[n-1] == 1) {
                box[n-1] = 0;
            }
            for (int i=n-2; i>=0; i--) {
                if (box[i] == 1) {
                    if (box[i+1] == 0 && a[i+1] > 0) {
                        box[i+1] = 1;
                        box[i] = 0;
                        a[i+1] -= 1;
                        if (a[i+1] == 0) {
                            zero += 1;
                        }
                    }
                }
            }
            if (box[n-1] == 1) {
                box[n-1] = 0;
            }
            if (a[0] > 0) {
                box[0] = 1;
                a[0] -= 1;
                if (a[0] == 0) {
                    zero += 1;
                }
            }
            if (zero >= k) {
                System.out.println(t);
                break;
            }
        }
    }
}