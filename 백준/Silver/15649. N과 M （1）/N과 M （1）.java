import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int[] result;
    static boolean[] used;
    static public void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        result = new int[m];
        used = new boolean[n+1];
        
        
        go(0);
    }

    static void go(int idx){
        if(idx>=m){
            for(int i=0;i<m;i++){
                System.out.print(result[i]+" ");
            }
            System.out.println();

            return;
        }
        for(int i=1;i<=n;i++){
            if(used[i]==false){
                result[idx]=i;
                used[i]=true;
                go(idx+1);
                result[idx]=0;
                used[i]=false;
            }
        }
    }
}
