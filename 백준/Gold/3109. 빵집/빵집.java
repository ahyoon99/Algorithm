import java.util.*;
import java.io.*;

public class Main {
	static int r;
	static int c;
	static char[][] matrix;
	static boolean[][] visited;

	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	static int[] dx = {-1,0,1};
	static int[] dy = {1,1,1};
	
	static int result;
	
	public static void main(String[] args) throws IOException {
		input();
		
		for(int i=0;i<r;i++) {	// 시작점 (0,0) ~ (r-1,0)
			if(go(i,0)) {
				result++;
			}
		}
		System.out.println(result);
	}

	static boolean go(int x, int y) {		
		for(int i=0;i<3;i++) {
			// i==0 : 오른쪽 위 대각선으로 연결
			// i==1 : 오른쪽으로 연결
			// i==2 : 오른쪽 아래 대각선으로 연결
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(!isValid(nx, ny)) {
				continue;
			}
			if(matrix[nx][ny]=='.' && visited[nx][ny]==false) {
				visited[nx][ny]=true;
				if(ny == c-1) {	// 빵집에 도달한 경우 
					return true;
				}
				if(go(x+dx[i], y+dy[i])) {
					return true;
				}
			}
		}
		return false;
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
		
		matrix = new char[r][c];
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String com = st.nextToken();
			for(int j=0;j<c;j++) {
				matrix[i][j] = com.charAt(j);
			}
		}
		visited = new boolean[r][c];
		result = 0;
	}

}
