import java.util.*;
import java.io.*;

public class Main{
	static int N, K;
	static int[] coins;
	static int[] dp;
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
	}
	
	static void solution() {
		dp[0]=1;
		for(int i=0;i<N;i++) {
			for(int j=coins[i];j<=K;j++) {
				dp[j] += dp[j-coins[i]];
			}
		}
		System.out.println(dp[K]);
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		coins = new int[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			coins[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[K+1];
	}

}
