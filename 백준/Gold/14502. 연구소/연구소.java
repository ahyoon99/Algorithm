import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	
	static int[][] matrix;
	
	static ArrayList<Node> virus;
	static ArrayList<Node> block;
	static Node[] wallIdx;
	static int result = Integer.MIN_VALUE;
	
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
		combi(0,0);
		System.out.println(result);
	}	
	
	static void combi(int idx, int blockIdx) {
		if(idx>=wallIdx.length) {
			bfs();
			return;
		}
		else if(blockIdx>=block.size()) {
			return;
		}
		
		wallIdx[idx] = block.get(blockIdx);
		combi(idx+1, blockIdx+1);	// 선택 O
		combi(idx, blockIdx+1);		// 선택 X
	}
	
	static void bfs() {
		// 벽 세우기 
		int[][] tempMatrix = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				tempMatrix[i][j] = matrix[i][j];
			}
		}
		
		for(int i=0;i<wallIdx.length;i++) {
			Node n = wallIdx[i];
			tempMatrix[n.x][n.y]=1;
		}
		
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		
		for(int i=0;i<virus.size();i++) {
			q.add(virus.get(i));
			visited[virus.get(i).x][virus.get(i).y]=true;
		}
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			int x = n.x;
			int y = n.y;
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(isValid(nx, ny)) {
					if(tempMatrix[nx][ny]==0 && visited[nx][ny]==false) {
						q.add(new Node(nx,ny));
						visited[nx][ny]=true;
						tempMatrix[nx][ny]=2;
					}
				}
			}
		}
		
		// 안전 영역 카운트하기
		int cnt = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(tempMatrix[i][j]==0) {
					cnt++;
				}
			}
		}
		result = Math.max(result, cnt);
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
		
		virus = new ArrayList<Node>();
		block = new ArrayList<Node>();
		wallIdx = new Node[3];
		
		matrix = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<m;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				if(matrix[i][j]==0) {
					block.add(new Node(i,j));
				}
				else if(matrix[i][j]==2) {
					virus.add(new Node(i,j));
				}
			}
		}		
	}
	

}
