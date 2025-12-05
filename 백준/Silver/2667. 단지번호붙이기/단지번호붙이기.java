import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[][] matrix;
	static int[][] townNum;
	
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
		int num = 0;
		ArrayList<Integer> townCnt = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(townNum[i][j]==-1 && matrix[i][j]==1) {
					townCnt.add(bfs(i, j, num));
					num++;
				}
			}
		}
		
		Collections.sort(townCnt);
		
		sb.append(num);
		sb.append("\n");
		for(int i=0;i<townCnt.size();i++) {
			sb.append(townCnt.get(i));
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static int bfs(int x, int y, int num) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		townNum[x][y]=num;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			x = node.x;
			y = node.y;
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(isValid(nx, ny) && townNum[nx][ny]==-1 && matrix[nx][ny]==1){
					cnt++;
					q.add(new Node(nx, ny));
					townNum[nx][ny]=num;
				}
			}
		}
		return cnt;
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
		
		matrix = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String com = st.nextToken();
			for(int j=0;j<n;j++) {
				matrix[i][j] = com.charAt(j)-'0';
			}
		}

		townNum = new int[n][n];
		for(int i=0;i<n;i++) {
			Arrays.fill(townNum[i], -1);
		}
	}

}
