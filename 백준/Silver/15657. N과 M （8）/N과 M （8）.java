import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int m;
	static int[] nums;
	static int[] result;
	
	public static void main(String[] args) throws IOException{
		input();
		Arrays.sort(nums);
		solution(0, 0);
		System.out.println(sb.toString());
	}
	
	static void solution(int numIdx, int resultIdx) {
		if(resultIdx>=m) {
			for(int i=0;i<m;i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=numIdx;i<n;i++) {
			result[resultIdx]=nums[i];
			solution(i, resultIdx+1);
		}
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		nums = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		result = new int[m];
	}

}
