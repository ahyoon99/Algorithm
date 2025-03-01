import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m;
	static int r;
	static int[][] matrix;
	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws IOException{
		input();
		
		for(int i=0;i<r;i++) {
			int[][] temp = new int[n][m];
			for(int k=0;k<n;k++) {
				Arrays.fill(temp[k], -1);
			}
			int cnt = Math.min(n, m) /2;
			for(int j=0;j<cnt;j++) {
				rotate(j, j, temp);
			}
			matrix = temp.clone();
		}
		print(matrix);
	}
	
	static void rotate(int i, int j, int[][] temp) {
		int dir = 0;
		int x = i;
		int y = j;
		int nx = -1;
		int ny = -1;
		while(true) {
			nx=x+dx[dir];
			ny=y+dy[dir];
			
			if(!isValid(nx,ny)) {
				dir=(dir+1)%4;
				nx = x+dx[dir];
				ny = y+dy[dir];
			}
			if(temp[nx][ny]!=-1) {
				dir=(dir+1)%4;
				nx = x+dx[dir];
				ny = y+dy[dir];
			}
			temp[nx][ny]=matrix[x][y];
			
			if(nx==i && ny==j) {
				break;
			}
			x=nx;
			y=ny;
		}
	}
	
	static boolean isValid(int x, int y) {
		if(0<=x && x<n && 0<=y && y<m) {
			return true;
		}
		return false;
	}
	
	public static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
			
		matrix = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<m;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void print(int[][] matrix) {
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}