import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static int[][] matrix;
	static int[][] distance;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static Node start;
	
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
		bfs();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(distance[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		
		q.add(start);
		distance[start.x][start.y]=0;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int x = node.x;
			int y = node.y;
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(isValid(nx, ny)) {
					if(matrix[nx][ny]==1 && distance[nx][ny]==-1) {
						q.add(new Node(nx, ny));
						distance[nx][ny]=distance[x][y]+1;
					}
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
		
		distance = new int[n][m];
		for(int i=0;i<n;i++) {
			Arrays.fill(distance[i], -1);
		}
		
		matrix = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<m;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				if(matrix[i][j] == 2) {
					start = new Node(i, j);
				}
				if(matrix[i][j]==0) {
					distance[i][j]=0;
				}
			}
		}
		
		
	}

}
