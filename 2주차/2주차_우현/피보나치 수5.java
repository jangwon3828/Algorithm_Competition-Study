<<<<<<< HEAD
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
=======
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
>>>>>>> 3d310144038cc2177dad2724a9ed737a8fc365ea
}