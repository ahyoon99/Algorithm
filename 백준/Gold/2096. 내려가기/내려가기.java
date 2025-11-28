import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[][] matrix;
	static int[][] maxDp;
	static int[][] minDp;
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
	}
	
	static void solution() {
		for(int i=0;i<3;i++) {
			maxDp[0][i] = matrix[0][i];
			minDp[0][i] = matrix[0][i];
		}
		
		for(int i=1;i<n;i++) {
			maxDp[i][0] = Math.max(maxDp[i-1][0], maxDp[i-1][1]) + matrix[i][0];
			maxDp[i][1] = Math.max(Math.max(maxDp[i-1][0], maxDp[i-1][1]), maxDp[i-1][2]) + matrix[i][1];
			maxDp[i][2] = Math.max(maxDp[i-1][1], maxDp[i-1][2]) + matrix[i][2];		
			
			minDp[i][0] = Math.min(minDp[i-1][0], minDp[i-1][1]) + matrix[i][0];
			minDp[i][1] = Math.min(Math.min(minDp[i-1][0], minDp[i-1][1]), minDp[i-1][2]) + matrix[i][1];
			minDp[i][2] = Math.min(minDp[i-1][1], minDp[i-1][2]) + matrix[i][2];	
		}
		
		System.out.print(Math.max(Math.max(maxDp[n-1][0], maxDp[n-1][1]), maxDp[n-1][2]));
		System.out.print(" ");
		System.out.print(Math.min(Math.min(minDp[n-1][0], minDp[n-1][1]), minDp[n-1][2]));
		
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		
		matrix = new int[n][3];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<3;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		maxDp = new int[n][3];
		minDp = new int[n][3];
	}

}
