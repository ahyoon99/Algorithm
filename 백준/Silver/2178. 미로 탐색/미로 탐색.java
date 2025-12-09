import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	
	static int[][] matrix;
	static int[][] distance;
	
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
		solution(0, 0);
		System.out.println(distance[n-1][m-1]);
	}
	
	static void solution(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		
		q.add(new Node(x, y));
		visited[x][y]=true;
		distance[x][y]=1;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			x = node.x;
			y = node.y;
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(isValid(nx, ny) && matrix[nx][ny]==1 && visited[nx][ny]==false) {
					q.add(new Node(nx, ny));
					visited[nx][ny]=true;
					distance[nx][ny]=distance[x][y]+1;
				}
			}
		}
	}
	
	static boolean isValid(int x, int y) {
		if(0<=x && x<n && 0<=y && y<m) {
			return true;
		}
		return false;
	}
	
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
	
		matrix = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String com = st.nextToken();
			for(int j=0;j<m;j++) {
				matrix[i][j] = com.charAt(j)-'0';
			}
		}
		
		distance = new int[n][m];
	}

}
