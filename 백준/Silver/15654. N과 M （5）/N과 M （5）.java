import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int m;
	static int[] num;
	static int[] result;
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
	}
	
	static void solution() {
		Arrays.sort(num);
		boolean[] used = new boolean[n];
		go(0, used);
		System.out.println(sb.toString());
	}
	
	static void go(int resultIdx, boolean[] used) {
		if(resultIdx>=m) {
			for(int i=0;i<m;i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!used[i]) {
				result[resultIdx] = num[i];
				used[i] = true;
				go(resultIdx+1, used);
				result[resultIdx]=0;
				used[i]=false;
			}
		}
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		num = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		result = new int[m];
	}

}
