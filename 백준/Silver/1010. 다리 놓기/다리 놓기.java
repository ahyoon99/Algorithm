import java.math.BigInteger;
import java.util.*;

public class Main {
    // 방법 1
    // static public void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int t = sc.nextInt();
    //     for(int testcase=0;testcase<t;testcase++){
    //         int n = sc.nextInt();
    //         int m = sc.nextInt();
    //         BigInteger result = new BigInteger("1");

    //         for(long i=n+1;i<=m;i++){
    //             BigInteger temp = BigInteger.valueOf(i);
    //             result = result.multiply(temp);
    //         }

    //         for(long i=1;i<=(m-n);i++){
    //             BigInteger temp = BigInteger.valueOf(i);
    //             result = result.divide(temp);
    //         }
            
    //         System.out.println(result);
    //     }
    // }

    // 방법 2 : DP
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] result = new int[30][30];

        for(int i=0;i<30;i++){
            Arrays.fill(result[i],-1);
        }

        for(int i=0;i<30;i++){
            result[1][i]=i;
            result[i][i]=1;
            result[0][i]=0;
            result[i][0]=0;
        }

        
        // for(int i=0;i<30;i++){
        //     for(int j=0;j<30;j++){
        //         System.out.print(result[i][j]+" ");
        //     }
        //     System.out.println();
        // }    

        for(int i=0;i<30;i++){
            for(int j=0;j<30;j++){
                if(result[i][j]!=-1){
                    continue;
                }
                result[i][j]=result[i-1][j-1]+result[i][j-1];
            }
        }


        // System.out.println("======================");

        // for(int i=0;i<30;i++){
        //     for(int j=0;j<30;j++){
        //         System.out.print(result[i][j]+" ");
        //     }
        //     System.out.println();
        // }        
        
        for(int testcase=0;testcase<t;testcase++){ 
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(result[n][m]);
        }
    }
}
