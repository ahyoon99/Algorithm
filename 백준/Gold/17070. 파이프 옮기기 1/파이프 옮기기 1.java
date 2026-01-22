import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] matrix;
	
	static int[][][] dp;
	
	static class Node{
		int x;
		int y;
		int dir;
		Node(int x, int y, int dir){
			this.x=x;
			this.y=y;
			this.dir=dir;
		}
	}
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
	}
	
	static void solution() {
		dp[0][1][0]=1;

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				// 가로 
				if(dp[i][j][0] > 0) {
					if(isValid(i, j+1, 0)) {
						dp[i][j+1][0] += dp[i][j][0];
					}
					if(isValid(i+1,j+1, 2)) {
						dp[i+1][j+1][2] += dp[i][j][0];
					}
				}
				
				// 세로
				if(dp[i][j][1]>0) {
					if(isValid(i+1, j, 1)) {
						dp[i+1][j][1] += dp[i][j][1];
					}
					if(isValid(i+1,j+1, 2)) {
						dp[i+1][j+1][2] += dp[i][j][1];
					}
				}
				
				// 대각선
				if(dp[i][j][2]>0) {
					if(isValid(i, j+1, 0)) {
						dp[i][j+1][0] += dp[i][j][2];
					}
					if(isValid(i+1,j, 1)) {
						dp[i+1][j][1] += dp[i][j][2];
					}
					if(isValid(i+1,j+1, 2)) {
						dp[i+1][j+1][2] += dp[i][j][2];
					}
				}
			}
		}
		System.out.println(dp[N-1][N-1][0]+dp[N-1][N-1][1]+dp[N-1][N-1][2]);
	}
	
	static boolean isValid(int x, int y, int dir) {
		if(dir==0) {
			if(0<=x && x<N && 0<=y-1 && y<N && matrix[x][y-1]==0 && matrix[x][y]==0) return true;
		} else if(dir==1) {
			if(0<=x-1 && x<N && 0<=y && y<N && matrix[x-1][y]==0 && matrix[x][y]==0) return true;
		} else if(dir==2) {
			if(0<=x-1 && x<N && 0<=y-1 && y<N && matrix[x-1][y-1]==0 && matrix[x-1][y]==0 && matrix[x][y-1]==0 && matrix[x][y]==0) return true;
		}
		return false;
	}

	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		
		matrix = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[N][N][3];
	}
}
