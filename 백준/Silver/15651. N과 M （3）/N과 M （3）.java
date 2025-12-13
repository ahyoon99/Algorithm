import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	static int n;
	static int m;
	static int[] result;
	
	public static void main(String[] args) throws IOException{
		input();
		go(0);
		System.out.println(sb.toString());
	}
	
	static void go(int idx) {
		if(idx>=m) {
			for(int i=0;i<m;i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<=n;i++) {
			result[idx]=i;
			go(idx+1);
		}
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		result = new int[m];
	}

}
