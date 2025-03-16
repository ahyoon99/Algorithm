import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static char[][] matrix;
	static int[][] region;
	static int cnt;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String[] args) throws IOException{
		input();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(region[i][j]==0) {
					bfs(i,j);
					cnt++;
				}
			}
		}
		System.out.print((cnt-1)+" ");
		
		cnt = 1;
		region = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(matrix[i][j]=='G') {
					matrix[i][j]='R';
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(region[i][j]==0) {
					bfs(i,j);
					cnt++;
				}
			}
		}
		System.out.println(cnt-1);
	}

	static void bfs(int x, int y) {
		Queue<Node> q = new ArrayDeque<>();
		region[x][y]=cnt;
		q.add(new Node(x, y));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			x = node.x;
			y = node.y;
			
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(!isValid(nx, ny)) {
					continue;
				}
				if(matrix[nx][ny]!=matrix[x][y]) {
					continue;
				}
				if(region[nx][ny]!=0) {
					continue;
				}
				q.add(new Node(nx, ny));
				region[nx][ny]=region[x][y];
			}
		}
		
	}

	static boolean isValid(int x, int y) {
		if(0<=x && x<n && 0<=y && y<n) {
			return true;
		}
		return false;
	}
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		
		matrix = new char[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String com = st.nextToken();
			for(int j=0;j<n;j++) {
				matrix[i][j] = com.charAt(j);
			}
		}
		
		region = new int[n][n];
		cnt=1;
	}

}
