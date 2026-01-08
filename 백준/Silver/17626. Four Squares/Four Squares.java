import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] dp;
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
		System.out.println(dp[N]);
	}
	
	static void solution() {
		dp[1]=1;
		
		for(int i=2;i<=N;i++) {
			int min = Integer.MAX_VALUE;
			for(int j=1;j*j<=i;j++) {
				int temp = i-j*j;
				min = Math.min(min, dp[temp]);
			}
			dp[i] = min+1;
		}
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1];
	}

}
