import java.util.*;

public class Main {
    
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        

        int[] zeroCnt = new int[41];
        int[] oneCnt = new int[41];
        zeroCnt[0]=1;
        zeroCnt[1]=0;
        oneCnt[0]=0;
        oneCnt[1]=1;

        for(int i=2;i<=40;i++){
            zeroCnt[i]=zeroCnt[i-1]+zeroCnt[i-2];
            oneCnt[i]=oneCnt[i-1]+oneCnt[i-2];
        }

        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            System.out.println(zeroCnt[n]+" "+oneCnt[n]);
        }
    }
}
