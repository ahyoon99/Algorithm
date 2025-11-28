import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[][] matrix;
	static int result;
	static HashSet<Integer> scores;
	
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws IOException{
		input();
		
//		for(int score=1;score<=100;score++) {
//			int totalCnt = 0;
//			boolean visited[][] = new boolean[n][n];
//			for(int i=0;i<n;i++) {
//				for(int j=0;j<n;j++) {
//					if(!visited[i][j] && matrix[i][j]>score) {
//						bfs(i,j,score, visited);
//						totalCnt++;
//					}
//				}
//			}
//			result = Math.max(result, totalCnt);
//		}
		
		ArrayList<Integer> validValue = new ArrayList<>();
		for(int score : scores) {
			validValue.add(score);
		}
		
		Collections.sort(validValue);
		for(int k=0;k<validValue.size();k++) {
			int score = validValue.get(k);
			int totalCnt = 0;
			boolean visited[][] = new boolean[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(!visited[i][j] && matrix[i][j]>score) {
						bfs(i,j,score, visited);
						totalCnt++;
					}
				}
			}
//			System.out.println(score+" "+totalCnt);
			result = Math.max(result, totalCnt);
		}
		System.out.println(result);
		
	}
	
	static void bfs(int x, int y, int safeScore, boolean[][] visited) {
		Queue<Node> q = new ArrayDeque<>();
		
		q.add(new Node(x,y));
		visited[x][y]=true;
		
		while(!q.isEmpty()) {
			Node node= q.poll();
			x = node.x;
			y = node.y;
			for(int i=0;i<4;i++) {
				int nx= x+dx[i];
				int ny= y+dy[i];
				if(!isValid(nx, ny)) {
					continue;
				}
				if(visited[nx][ny]==false && matrix[nx][ny]>safeScore) {
					q.add(new Node(nx, ny));
					visited[nx][ny]=true;
				}
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
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
		n = Integer.parseInt(st.nextToken());
		
		scores = new HashSet<Integer>();
		matrix = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<n;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				scores.add(matrix[i][j]);
			}
		}
		
		scores.add(0);
		scores.add(100);
		
		result = Integer.MIN_VALUE;
	}
}
