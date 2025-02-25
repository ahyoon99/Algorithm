import java.util.*;
import java.io.*;

public class Main {
	static int m;
	static int n;
	static int k;
	static int[][] matrix;
	static boolean[][] visited;
	static ArrayList<Integer> sizeList;
	
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
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(!visited[i][j] && matrix[i][j]==0) {
					sizeList.add(bfs(i,j));
				}
			}
		}

		System.out.println(sizeList.size());
		Collections.sort(sizeList);
		for(int size : sizeList) {
			System.out.print(size+" ");
		}
		System.out.println();
	}
	
	static int bfs(int x, int y) {
		int size = 0;
		
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(x,y));
		visited[x][y]=true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			x = node.x;
			y = node.y;
			size++;
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(isValid(nx, ny) && matrix[nx][ny]==0 && visited[nx][ny]==false) {
					q.add(new Node(nx, ny));
					visited[nx][ny]=true;
				}
			}
		}
		return size;
	}
	
	static boolean isValid(int x, int y) {
		if(0<=x && x<m && 0<=y && y<n) {
			return true;
		}
		return false;
	}
	
	public static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		matrix = new int[m][n];
		
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int j=y1;j<y2;j++) {
				for(int l=x1;l<x2;l++) {
					matrix[j][l]=-1;
				}
			}
		}
		
		visited = new boolean[m][n];
		sizeList = new ArrayList<>();
	}
}
