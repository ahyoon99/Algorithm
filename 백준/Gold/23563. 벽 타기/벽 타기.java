import java.util.*;
import java.io.*;

public class Main {
	static int H;
	static int W;
	static char[][] matrix;
	static boolean[][] isNearBlock;
	static Node S;
	static Node E;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int time;
		Node(int x, int y, int time){
			this.x=x;
			this.y=y;
			this.time=time;
		}
		
		@Override
		public int compareTo(Node next) {
			return Integer.compare(this.time, next.time);
		}
	}
	
	public static void main(String[] args) throws IOException {
		input();
		solution();
	}
	
	static void solution() {
		int[][] times = new int[H][W];
		for(int i=0;i<times.length;i++) {
			Arrays.fill(times[i], Integer.MAX_VALUE);
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(S);
		times[S.x][S.y] = 0;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int x = n.x;
			int y = n.y;
			int time = n.time;
			
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(!isValid(nx, ny)) {
					continue;
				}
				
				int nextTime = -1;
				if(matrix[nx][ny]!='#') {	// 다음 칸이 벽이 아닌 경우
					if(isNearBlock[x][y] && isNearBlock[nx][ny]) {	// 다음 칸이 벽에 인접한 칸일 경우, 이동 시간 update
						nextTime = time;
					}
					else {			// 다음 칸이 벽에 인접하지 않을 칸일 경우, 이동 시간 update
						nextTime = time+1;
					}
					
					if(times[nx][ny] <= nextTime) {	// 다음 칸의 기존 이동 소유 시간이 더 작을 경우 
						continue;
					}
					times[nx][ny]=nextTime;
					pq.add(new Node(nx, ny, nextTime));
				}
			}
		}
		System.out.println(times[E.x][E.y]);
	}
	
	static boolean isValid(int x, int y) {
		if(0<=x && x<H && 0<=y && y<W) return true;
		return false;
	}

	static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		matrix = new char[H][W];
		
		for(int i=0;i<H;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String com = st.nextToken();
			for(int j=0;j<W;j++) {
				matrix[i][j] = com.charAt(j);
				if(matrix[i][j] == 'S') {
					S = new Node(i,j,0);
				}
				else if(matrix[i][j] == 'E') {
					E = new Node(i,j,-1);
				}
			}
		}
		
		isNearBlock = new boolean[H][W];
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				for(int k=0;k<4;k++) {
					int nx = i+dx[k];
					int ny = j+dy[k];
					if(isValid(nx, ny) && matrix[nx][ny]=='#') {
						isNearBlock[i][j]=true;
					}
				}
			}
		}
	}
}
