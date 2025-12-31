import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int M;
	static char[][] matrix;
	static Node me;
	static int result;
	
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
		solution(me);
		if(result==0) {
			System.out.println("TT");
		}
		else {
			System.out.println(result);
		}
	}
	
	static void solution(Node node) {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		visited[node.x][node.y]=true;
		q.add(node);
		while(!q.isEmpty()) {
			node = q.poll();
			int x = node.x;
			int y = node.y;
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(!isValid(nx, ny)) {
					continue;
				}
				if(visited[nx][ny]==false && matrix[nx][ny]!='X') {
					visited[nx][ny]=true;
					q.add(new Node(nx, ny));
					if(matrix[nx][ny]=='P') {
						result++;
					}
				}
			}
		}
	}
	
	static boolean isValid(int x, int y) {
		if(0<=x && x<N && 0<=y && y<M) {
			return true;
		}
		return false;
	}
	
	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		matrix = new char[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String com = st.nextToken();
			for(int j=0;j<M;j++) {
				matrix[i][j] = com.charAt(j);
				if(matrix[i][j]=='I') {
					me = new Node(i,j);
				}
			}
		}
		
		result=0;
	}

}
