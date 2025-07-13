import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] nums;
	static int[] dp;
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
	}

	static void solution() {
		// 자기 자신이 포함되므로 모두 1로 초기화 
		Arrays.fill(dp, 1);
		
		int max = 1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(nums[j]<nums[i]) {
					dp[i] = Math.max(dp[i],  dp[j]+1);	// 더 긴 수열을 만들 수 있는지 확인 
				}
			}
			max = Math.max(max, dp[i]);	// 전체 중 가장 긴 수열 길이 업데이트 
		}
		
		System.out.println(max);
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		
		nums = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			nums[i] = Integer.parseInt(st.nextToken()); 
		}
		
		dp = new int[n];
	}

}
