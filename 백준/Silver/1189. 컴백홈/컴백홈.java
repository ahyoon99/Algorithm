import java.util.*;
import java.io.*;

public class Main {
	static int r;
	static int c;
	static int k;
	static char[][] matrix;
	static boolean[][] visited;
	static int result;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException{
		input();
		solution();
	}
	
	static void solution() {
		// (r-1, 0) -> (0, c-1)
		visited[r-1][0]=true;
		go(r-1, 0, 1);
		System.out.println(result);
		
	}
	
	static void go(int x, int y, int distance) {
		if(x==0 && y==c-1) {
			if(distance==k) {
				result++;
			}
			return;
		}
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(isValid(nx, ny) && visited[nx][ny]==false && matrix[nx][ny]!='T') {
				visited[nx][ny]=true;
				go(nx, ny, distance+1);
				visited[nx][ny]=false;
			}
		}
	}
	
	static boolean isValid(int x, int y) {
		if(0<=x && x<r && 0<=y && y<c) {
			return true;
		}
		return false;
	}

	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		matrix = new char[r][c];
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String com = st.nextToken();
			for(int j=0;j<c;j++) {
				matrix[i][j] = com.charAt(j);
			}
		}

		visited = new boolean[r][c];
		result=0;
	}
}
