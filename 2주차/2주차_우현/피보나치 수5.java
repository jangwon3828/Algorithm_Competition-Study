import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(function(N));

    }

    public static int function(int N) {
        if(N==0) return 0;
        if(N==1) return 1;

        return function(N-1) + function(N-2);
    }
}