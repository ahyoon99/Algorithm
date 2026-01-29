import java.util.*;
import java.io.*;

public class Main {
	static int C;
	static int N;
	static Node[] info;
	
	static int[] dp;
	
	static class Node{
		int cost;
		int cnt;
		
		Node(int cost, int cnt){
			this.cost = cost;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
	}
	
	static void solution() {
		dp[0] = 0;
		 
		for(int i=0;i<N;i++) {
			Node node = info[i];
			for(int j=1; node.cnt*j<dp.length; j++) {
				dp[node.cnt*j] = Math.min(dp[node.cnt*j], node.cost*j);
			}
		}
		
		for(int i=1;i<dp.length;i++) {
			for(int j=0;j<info.length;j++) {
				Node next = info[j];
				if(i+next.cnt >= dp.length) {
					continue;
				}
				dp[i+next.cnt]= Math.min(dp[i+next.cnt], dp[i]+next.cost); 
			}
		}
		
		// C명 이상인 경우 중에서 최소 비용 찾기 
		int result = Integer.MAX_VALUE;
		for(int i=C;i<dp.length;i++) {
			result = Math.min(result, dp[i]);
		}
		System.out.println(result);
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		info = new Node[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int cost = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			info[i] = new Node(cost, cnt);
		}
		
		dp = new int[C + 101];
		Arrays.fill(dp, 1000000);
	}

}
