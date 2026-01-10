import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
	}
	
	static void solution() {
		if(N<=1) {
			System.out.println("0");
			return;
		}
		
		dp[2][0]=1;
		
		for(int i=3;i<=N;i++) {
			// i에 포함되어 있는 2, 5 개수 계산하기
			int cnt1 = calculateNum(i, 2);
			int cnt2 = calculateNum(i, 5);
			
			dp[i][0] = dp[i-1][0]+cnt1;
			dp[i][1] = dp[i-1][1]+cnt2;
		}
		System.out.println(Math.min(dp[N][0], dp[N][1]));
	}
	
	static int calculateNum(int num, int div) {
		int cnt = 0;
		while(true) {
			if(num%div!=0) {
				break;
			}else {
				cnt++;
				num /= div;
			}
		}
		return cnt;
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1][2];
	}
}
