import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] matrix;
	static int result;
	static int n1;
	static int n2;
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
		System.out.println(n1 + " " +n2);
	}

	static void solution() {
		int startIdx = 0;
		int endIdx = n-1;
		while(startIdx<endIdx) {
			int temp = Math.abs(matrix[startIdx]+matrix[endIdx]);
			if(result>temp) {
				result = temp;
				n1 = matrix[startIdx];
				n2 = matrix[endIdx];
			}
			
			if(startIdx+1<=endIdx && startIdx<=endIdx-1) {
				if(Math.abs(matrix[startIdx+1]+matrix[endIdx]) < Math.abs(matrix[startIdx]+matrix[endIdx-1])) {
					startIdx++;
				}
				else {
					endIdx--;
				}
			}
			else if(startIdx+1<=endIdx) {
				startIdx++;
			}
			else if(startIdx<=endIdx-1) {
				endIdx--;
			}
		}
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		
		matrix = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			matrix[i] = Integer.parseInt(st.nextToken());
		}
		result = Integer.MAX_VALUE;
		n1 = -1;
		n2 = -1;
	}
}
