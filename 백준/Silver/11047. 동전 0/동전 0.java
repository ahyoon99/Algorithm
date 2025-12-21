import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int k;
	static int[] coins;
	static int result;

	public static void main(String[] args) throws IOException{
		input();
		solution();
		System.out.println(result);
	}
	
	static void solution() {
		int idx = n-1;
		while(k!=0 && idx>=0) {
			int cnt = (k/coins[idx]);
			result += cnt;
			k-=cnt*coins[idx];
			idx--;
		}
	}

	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		coins = new int[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			coins[i] = Integer.parseInt(st.nextToken());
		}
		result = 0;
	}
}
