import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static int[] matrix;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		matrix = new int[n+1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1;i<n+1;i++) {
			matrix[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<n+1;i++) {
			matrix[i]+=matrix[i-1];
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			System.out.println(matrix[end]-matrix[start-1]);
		}
	}
}