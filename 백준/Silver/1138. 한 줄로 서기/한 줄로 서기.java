import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] leftCnt;
	static int[] result;

	public static void main(String[] args) throws IOException{
		input();
		solution();
	}
	
	static void solution() {
		for(int height=0;height<n;height++) {
			int count = 0;
			for(int i=0;i<n;i++) {
				if(result[i] == -1) {
					if(count == leftCnt[height]) {
						result[i] = height + 1;
						break;
					}
					count++;
				}
			}
		}
		
		// 결과 출력 
		for(int i=0;i<n;i++) {
			System.out.print(result[i]+" ");
		}
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		
		leftCnt = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			leftCnt[i] = Integer.parseInt(st.nextToken());
		}
		
		result = new int[n];
		Arrays.fill(result, -1);
	}
}
